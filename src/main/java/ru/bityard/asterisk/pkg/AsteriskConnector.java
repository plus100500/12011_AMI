package ru.bityard.asterisk.pkg;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.bityard.asterisk.pkg.actions.AsteriskCmd;

import java.net.SocketException;

public interface AsteriskConnector extends Runnable {

    boolean getStatus() throws SocketException;
    String getActionIdNum();
    void executeCmd(String request);
    void connect();
    void close();
    AsteriskEventPublisher getAsteriskEventPublisher();
    void setAsteriskEventPublisher(AsteriskEventPublisher asteriskEventPublisher);
    AsteriskCmd getAsteriskCmd();
    ThreadPoolTaskExecutor getThreadPoolTaskExecutor();
    void run();
}
