package ru.bityard.asterisk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.bityard.asterisk.pkg.AsteriskConnector;
import ru.bityard.asterisk.pkg.AsteriskConnectorImpl;
import ru.bityard.asterisk.pkg.AsteriskEventPublisher;
import ru.bityard.asterisk.pkg.actions.AsteriskCallableCmd;
import ru.bityard.asterisk.pkg.actions.AsteriskCallableCmdImpl;
import ru.bityard.asterisk.pkg.actions.AsteriskCmd;
import ru.bityard.asterisk.pkg.actions.AsteriskCmdImpl;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.net.SocketException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class AsteriskConnection {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final static Object monitorAsteriskConnection = new Object();

    private AsteriskConnector asteriskConnector;

    private AsteriskCmd asteriskCmd;

//    private Map<String,Object> objectMap;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private ThreadPoolTaskExecutor threadPoolTaskExecutorForFuture;

    public AsteriskConnection(String serverIP, int portAmi, String userAmi, String passAmi, String events) {
        threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(1);
        threadPoolTaskExecutor.setKeepAliveSeconds(1);
        threadPoolTaskExecutor.initialize();

        threadPoolTaskExecutorForFuture = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutorForFuture.setKeepAliveSeconds(1);
        threadPoolTaskExecutorForFuture.initialize();

        asteriskCmd = new AsteriskCmdImpl();

        asteriskConnector = new AsteriskConnectorImpl(serverIP, portAmi, userAmi, passAmi, events, asteriskCmd, threadPoolTaskExecutor);
//        asteriskConnector.connect();

        CheckConnect checkConnect = new CheckConnect();
        Thread threadCheckConnect = new Thread(checkConnect);
        threadCheckConnect.start();
        try {
            threadCheckConnect.join();
        }catch (InterruptedException ie) {
            log.error(ie.getMessage());
        }
    }

    class CheckConnect implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                        checkConnect();
                        Thread.sleep(5000);

                } catch (InterruptedException ie) {
                    log.error(ie.getMessage());
                }
            }
        }
    }


    public boolean checkConnect() {
        synchronized (monitorAsteriskConnection) {
//        log.debug("CHECKCONNECT. AsteriskConnector object is {}", asteriskConnector);
            try {
                boolean result = asteriskConnector.getStatus();
                if (result) asteriskConnector.executeCmd("OPTIONS\r\n\r\n");
                return result;
            } catch (SocketException se) {
                log.warn(se.getMessage());
                log.warn("Trying to connect...");
                asteriskConnector.connect();
            }
            return false;
        }
    }

    public AsteriskEventPublisher getAsteriskEventPublisher() {
        return asteriskConnector.getAsteriskEventPublisher();
    }

    public void connect() {
        this.checkConnect();
    }

    public void makeCallFromQueue(String phoneNumber, String queueNum, String phoneName) {
        execute(asteriskCmd.makeCallFromQueue(asteriskConnector, queueNum, phoneNumber, phoneName));
    }

    public void makeCall(String phoneNumber, String phoneName, String timeout, String context, String channelContext, String exten) {
        execute(asteriskCmd.makeCall(asteriskConnector, exten, phoneNumber, phoneName, context, channelContext, timeout));
    }

    public void makeCallFromExten(String phoneNumber, String phoneName, String exten) {
        execute(asteriskCmd.makeCallFromExten(asteriskConnector, exten, phoneNumber, phoneName));
    }

    public void close() {
        if (asteriskConnector != null) asteriskConnector.close();
        asteriskConnector = null;
        asteriskCmd = null;
        if (threadPoolTaskExecutorForFuture != null) threadPoolTaskExecutorForFuture.shutdown();
        if (threadPoolTaskExecutor != null) threadPoolTaskExecutor.shutdown();
        threadPoolTaskExecutorForFuture = null;
        threadPoolTaskExecutor = null;
    }


    private synchronized void execute(Runnable task) {
        if (checkConnect())
            threadPoolTaskExecutor.submit(task);

    }

    public void queueSummary(String queueNum) {
        this.queueSummary(queueNum, false);
    }

    public Future<List<AmiObject>> queueSummary(String queueNum, boolean needAnswer) {
        if (needAnswer) {
            AsteriskCallableCmd asteriskCallableCmd = new AsteriskCallableCmdImpl();
            return execute((Callable) asteriskCallableCmd.queueSummary(asteriskConnector, queueNum));
        } else {
            execute(asteriskCmd.queueSummary(asteriskConnector, queueNum));
        }
        return null;
    }


    public void command(String command) {
        this.command(command, false);
    }

    public Future<List<AmiObject>> command(String command, boolean needAnswer) {
        if (needAnswer) {
            AsteriskCallableCmd asteriskCallableCmd = new AsteriskCallableCmdImpl();
            return execute((Callable) asteriskCallableCmd.command(asteriskConnector, command));
        } else {
            execute(asteriskCmd.command(asteriskConnector, command));
            return null;
        }
    }

    public Future<List<AmiObject>> coreShowChannels(boolean needAnswer) {
        if (needAnswer) {
            AsteriskCallableCmd asteriskCallableCmd = new AsteriskCallableCmdImpl();
            return execute((Callable) asteriskCallableCmd.coreShowChannels(asteriskConnector));
        } else {
            execute(asteriskCmd.coreShowChannels(asteriskConnector));
        }
        return null;
    }

    // подготовка для вызова нити, которая вернет ответ в виде объекта
    private synchronized Future<List<AmiObject>> execute(Callable task) {
        if (checkConnect()) {
            Future result = threadPoolTaskExecutorForFuture.submit(task);
//            log.info("Future<List<AmiObject>> hashcode is {}",result.hashCode());
            return result;
        }
        return null;
    }
}
