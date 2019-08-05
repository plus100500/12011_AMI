package ru.bityard.asterisk.pkg;

import ru.bityard.asterisk.pkg.actions.AsteriskCmd;

import java.net.SocketException;
import java.util.concurrent.ThreadPoolExecutor;

public interface AsteriskConnector {

    boolean getStatus() throws SocketException;

    String getActionIdNum();

    void executeCmd(String request);

    void connect();

    void close();

    AsteriskEventPublisher getAsteriskEventPublisher();

    void setAsteriskEventPublisher(AsteriskEventPublisher asteriskEventPublisher);

    AsteriskCmd getAsteriskCmd();

    ThreadPoolExecutor getThreadPoolExecutor();
}
