package ru.bityard.asterisk.aspects;

public interface AsteriskConnectorStatus {
    void setState(boolean status);
    boolean getState();
    void setAuthId(String authId);
    String getAuthID();
    void setStatusCause(String statusCause);
    String getStatusCause();

}
