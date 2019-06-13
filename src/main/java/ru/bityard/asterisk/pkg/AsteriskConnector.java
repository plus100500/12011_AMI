package ru.bityard.asterisk.pkg;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.bityard.asterisk.pkg.actions.AsteriskCmd;

import java.net.SocketException;

public interface AsteriskConnector {

    boolean getStatus() throws SocketException;
    String getActionIdNum();
    void executeCmd(String request);
    void connect();
    void close();
    void setParameters(String serverIP, int portAmi, String userAmi, String passAmi, String events);
    AsteriskEventPublisher getAsteriskEventPublisher();
    void setAsteriskEventPublisher(AsteriskEventPublisher asteriskEventPublisher);
    AsteriskCmd getAsteriskCmd();
    ThreadPoolTaskExecutor getThreadPoolTaskExecutor();
}
