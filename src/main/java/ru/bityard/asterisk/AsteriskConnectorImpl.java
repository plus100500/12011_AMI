package ru.bityard.asterisk;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;
import java.util.Random;

@Component
public class AsteriskConnectorImpl implements AsteriskConnector, Runnable {

    private final static Object monitorAsteriskConnection = new Object();

    private String userAmi;
    private String passAmi;
    private String events;
    private String serverIP;
    private Integer portAmi;

@Autowired
    private AsteriskConnectorListener asteriskConnectorActionListener;

    private Thread thread;

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Socket socket;
    int timeoutInMs = 10 * 1000;
    private String amiVersion;

    @Override
    public void run() {

        StringBuilder request = new StringBuilder();
        request.append("Action: Login\r\n");
        request.append("ActionID: ".concat(getActionIdNum()).concat("\r\n"));
        request.append("Username: ".concat(userAmi).concat("\r\n"));
        request.append("Secret: ".concat(passAmi).concat("\r\n"));
        request.append("Events: ".concat(events).concat("\r\n"));
        request.append("\r\n");

        listenSocket(setAmiVersion(execute(request.toString())));

    }

    public void setParameters(String serverIP, int portAmi, String userAmi, String passAmi, String events) {
        this.serverIP = serverIP;
        this.portAmi = portAmi;
        this.userAmi = userAmi;
        this.passAmi = passAmi;
        this.events = events;
    }



    @Override
    public synchronized void connect() {
        if (isCorrect()) {
            try {
                InetAddress inetAddress = InetAddress.getByName(serverIP);
                SocketAddress socketAddress = new InetSocketAddress(inetAddress, portAmi);
                socket = new Socket();
                socket.connect(socketAddress, timeoutInMs);
                socket.setKeepAlive(true);
                thread = new Thread(this);
                thread.start();

            } catch (SocketTimeoutException ste) {
                log.error("Timed out waiting for the socket.");
                ste.printStackTrace();
            } catch (Exception e) {
                log.error(e.toString());
                e.printStackTrace();
            }
        }
    }

//    @Scheduled(fixedRate = 5000)
//    private void checkConnect() {
//        if (!getStatus()) {
//            log.warn("Socket is disconnected!");
//            log.warn("Trying to reconnect...");
//            connect();
//        }
//    }

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
        if (i < 5 ) {
            log.warn("{}",result);
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

    public void listenSocket(BufferedReader bufferedReader) {
        String str;

        try {
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
//                    log.debug("AsteriskConnectorImpl. Str is {}",str);
                    asteriskConnectorActionListener.onApplicationEvent(str);
                }
            }
        } catch (IOException e) {
            log.error(e.toString());
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
                socket.getKeepAlive();
                if (!socket.isBound()) {
                    throw new SocketException("Socket is Not bound");
                }
                if (socket.isClosed()) {
                    throw new SocketException("Socket is Not closed");
                }
            }
            return true;
        }
    }

    private synchronized BufferedReader execute(String request) {
        BufferedReader bufferedReader = null;
        try {
//            // write text to the socket
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write(request);
//            bufferedWriter.flush();

//            log.debug("Execute request {}",request);
            executeCmd(request);

            // read text from the socket
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
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
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {

            StringBuilder request = new StringBuilder();
            request.append("Action: Logoff\r\n");
            request.append("\r\n");
            executeCmd(request.toString());
            socket.close();
        } catch (IOException e) {
            log.warn(e.getMessage());
        } finally {
            thread.interrupt();
        }
    }

    public String getActionIdNum() {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((1000 - 1) + 1) + 1;

        return String.valueOf(randomNum);
    }
}
