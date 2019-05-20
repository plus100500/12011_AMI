package ru.bityard.asterisk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.actions.AsteriskCmd;

import java.net.SocketException;

@Component
public class AsteriskConnection implements ApplicationContextAware {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private ApplicationContext applicationContext;

    private final static Object monitorAsteriskConnection = new Object();

    @Autowired
    private AsteriskConnector asteriskConnector;

    @Autowired
    private AsteriskCmd asteriskCmd;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public boolean checkConnect() {
        synchronized (monitorAsteriskConnection) {
//        log.debug("CHECKCONNECT. AsteriskConnector object is {}", asteriskConnector);
            try {
                return asteriskConnector.getStatus();
            } catch (SocketException se) {
                log.warn(se.getMessage());
                log.warn("Trying to connect...");
                asteriskConnector.connect();
            }
            return false;
        }
    }

    public void connect(String serverIP, int portAmi, String userAmi, String passAmi, String events) {
        threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        threadPoolTaskExecutor.setKeepAliveSeconds(1);
        threadPoolTaskExecutor.initialize();

        asteriskConnector.setParameters(serverIP, portAmi, userAmi, passAmi, events);
        this.checkConnect();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
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

    public void queueSummary(String queueNum) {
        execute(asteriskCmd.queueSummary(asteriskConnector, queueNum));
    }

    public void command(String command) {
        execute(asteriskCmd.command(asteriskConnector, command));
    }

    private synchronized void execute(Runnable task) {
        if (checkConnect())
            threadPoolTaskExecutor.submit(task);

    }
}
