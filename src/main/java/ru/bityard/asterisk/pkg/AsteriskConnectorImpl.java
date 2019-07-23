package ru.bityard.asterisk.pkg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.bityard.asterisk.pkg.actions.AsteriskCmd;
import ru.bityard.asterisk.pkg.asteriskListeners.AsteriskConnectorStatus;
import ru.bityard.asterisk.pkg.asteriskListeners.AsteriskEventListenerImpl;

import java.io.*;
import java.net.*;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsteriskConnectorImpl implements AsteriskConnector, AsteriskConnectorStatus {

    private final static Object monitorAsteriskConnection = new Object();

    private String userAmi;
    private String passAmi;
    private String events;
    private String serverIP;
    private Integer portAmi;

    private AtomicBoolean state;
    private String statusCause;
    private String authID;


    private AsteriskAmiObjectParser asteriskAmiObjectParser;
    private AsteriskEventPublisher asteriskEventPublisher;
    private AsteriskCmd asteriskCmd;
    private AsteriskEventListener asteriskEventListener;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Socket socket;
    int timeoutInMs = 10 * 1000;
    private String amiVersion;

    @Override
    public AsteriskEventPublisher getAsteriskEventPublisher() {
        return this.asteriskEventPublisher;
    }

    @Override
    public void setAsteriskEventPublisher(AsteriskEventPublisher asteriskEventPublisher) {
        this.asteriskEventPublisher = asteriskEventPublisher;
    }

    @Override
    public void setState(boolean state) {
        this.state.set(state);
    }

    @Override
    public boolean getState() {
        return state.get();
    }

    @Override
    public void setAuthId(String authId) {
        this.authID = authId;
    }


    @Override
    public String getAuthID() {
        return authID;
    }

    @Override
    public void setStatusCause(String statusCause) {
        this.statusCause = statusCause;
    }

    @Override
    public String getStatusCause() {
        return statusCause;
    }

    public AsteriskConnectorImpl(String serverIP, int portAmi, String userAmi, String passAmi, String events, AsteriskCmd asteriskCmd, ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.userAmi = userAmi;
        this.passAmi = passAmi;
        this.events = events;
        this.serverIP = serverIP;
        this.portAmi = portAmi;
        state = new AtomicBoolean(false);
        this.statusCause = null;
        this.asteriskCmd = asteriskCmd;

        asteriskEventPublisher = new AsteriskEventPublisherImpl();

        asteriskEventListener = new AsteriskEventListenerImpl(this);
        asteriskEventPublisher.addListener(asteriskEventListener);

        asteriskAmiObjectParser = new AsteriskAmiObjectParserImpl(asteriskEventPublisher);

        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @Override
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() {
        return threadPoolTaskExecutor;
    }

    @Override
    public synchronized void connect() {
        synchronized (monitorAsteriskConnection) {
            if (isCorrect()) {
                try {
                    if (socket != null) socket.close();

                    InetAddress inetAddress = InetAddress.getByName(serverIP);
                    SocketAddress socketAddress = new InetSocketAddress(inetAddress, portAmi);
                    socket = new Socket();
                    socket.setKeepAlive(true);
                    socket.connect(socketAddress, timeoutInMs);

                    ReadMsg readMsg = new ReadMsg(socket.getInputStream());
                    Thread threadReadMsg = new Thread(readMsg);
                    threadReadMsg.start();

                    authID = getActionIdNum();

                    StringBuilder request = new StringBuilder();
                    request.append("Action: Login\r\n");
                    request.append("ActionID: ".concat(authID).concat("\r\n"));
                    request.append("Username: ".concat(userAmi).concat("\r\n"));
                    request.append("Secret: ".concat(passAmi).concat("\r\n"));
                    request.append("Events: ".concat(events).concat("\r\n"));
                    request.append("\r\n");

                    executeCmd(request.toString());

                } catch (SocketTimeoutException ste) {
                    log.error("Timed out waiting for the socket.");
                    ste.printStackTrace();
                } catch (Exception e) {
                    log.error(e.toString());
                    e.printStackTrace();
                }
            }

            long start = Calendar.getInstance().getTimeInMillis();
            while (timer(start)) {
                try {
                    synchronized (this) {
                        wait(100);
                    }
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }
                // waiting login
            }
        }
    }

    private boolean timer(long start) {
        return (Calendar.getInstance().getTimeInMillis() - start) / 1000 <= 3 && !state.get();
    }

    private boolean isCorrect() {
        StringBuilder result = new StringBuilder();
        result = result.append("serverIP = ").append(this.serverIP).append("\r\n");
        result = result.append("portAmi = ").append(String.valueOf(this.portAmi)).append("\r\n");
        result = result.append("userAmi = ").append(this.userAmi).append("\r\n");
        result = result.append("passAmi = ").append(this.passAmi).append("\r\n");
        result = result.append("events = ").append(this.events).append("\r\n");
        int i = 0;
        if (this.serverIP != null && !this.serverIP.isEmpty()) ++i;
        if (this.portAmi != null) ++i;
        if (this.userAmi != null && !this.userAmi.isEmpty()) ++i;
        if (this.passAmi != null && !this.passAmi.isEmpty()) ++i;
        if (this.events != null) ++i;
        if (i < 5) {
            log.warn("{}", result);
            return false;
        } else {
            return true;
        }
    }


    private synchronized BufferedReader setAmiVersion(BufferedReader bufferedReader) {
        String str;
        try {
            while ((str = bufferedReader.readLine()) != null) {
//                log.debug(str);
                if (!str.isEmpty()) {
                    if (str.toLowerCase().startsWith("asterisk call manager")) {
                        amiVersion = str.replaceAll("^[\\D\\.]+", "");
                        log.info("AMI version is {}", amiVersion);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            log.error(e.toString());
        }

        return bufferedReader;
    }

    class ReadMsg implements Runnable {

        private InputStream inputStream;

        public ReadMsg(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {

            String str;

            try {
                DataInputStream in = new DataInputStream(new BufferedInputStream(inputStream));
                while (true) {
                    str = in.readLine();
                    if (str != null) {
//                        log.debug("AsteriskConnectorImpl. Str is {}", str);
                        asteriskAmiObjectParser.parseStr(str);
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            log.error(e.getMessage());
                        }
                    }
                }
            } catch (IOException e) {
                log.error(e.toString());
            }
        }
    }

    @Override
    public boolean getStatus() throws SocketException {
        synchronized (monitorAsteriskConnection) {
            if (socket == null) {
                throw new SocketException("Socket is null");
            } else {
                if (!socket.isConnected()) {
                    throw new SocketException("Socket is Not connected");
                }
                if (!socket.getKeepAlive()) {
                    throw new SocketException("Socket is Not keep alive");
                }
                if (!socket.isBound()) {
                    throw new SocketException("Socket is Not bound");
                }
                if (socket.isClosed()) {
                    throw new SocketException("Socket is Not closed");
                }
                if (!state.get()) {
                    throw new SocketException("Ami interface is not connected");
                }
            }
            return state.get();
        }
    }

    @Override
    public synchronized void executeCmd(String request) {
        try {
            // write text to the socket
//            log.debug("Executing cmd {}", request);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(request);
            bufferedWriter.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            closeSocket();
        }
    }

    @Override
    public void close() {

        StringBuilder request = new StringBuilder();
        request.append("Action: Logoff\r\n");
        request.append("\r\n");
        executeCmd(request.toString());
        closeSocket();

    }

    private void closeSocket() {
        try {
            socket.getInputStream().close();
            socket.getOutputStream().close();
            socket.close();
        } catch (IOException e) {
            log.warn(e.getMessage());
        } finally {
            Thread.currentThread().interrupt();
        }
    }

    public String getActionIdNum() {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((1000 - 1) + 1) + 1;

        return String.valueOf(randomNum);
    }

    @Override
    public AsteriskCmd getAsteriskCmd() {
        return asteriskCmd;
    }

}
