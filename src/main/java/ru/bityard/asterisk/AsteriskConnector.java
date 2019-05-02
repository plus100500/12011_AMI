package ru.bityard.asterisk;

import java.net.SocketException;

public interface AsteriskConnector {

    boolean getStatus() throws SocketException;
    String getActionIdNum();
    void executeCmd(String request);
    void connect();
    void close();
    void setParameters(String serverIP, int portAmi, String userAmi, String passAmi, String events);
}
