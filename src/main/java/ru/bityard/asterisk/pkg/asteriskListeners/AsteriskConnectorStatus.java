package ru.bityard.asterisk.pkg.asteriskListeners;

import ru.bityard.asterisk.pkg.AsteriskEventPublisher;

public interface AsteriskConnectorStatus {
    void setState(boolean status);
    boolean getState();
    void setAuthId(String authId);
    String getAuthID();
    void setStatusCause(String statusCause);
    String getStatusCause();
    AsteriskEventPublisher getAsteriskEventPublisher();

}
