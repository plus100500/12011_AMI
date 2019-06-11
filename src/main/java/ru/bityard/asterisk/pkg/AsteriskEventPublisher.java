package ru.bityard.asterisk.pkg;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public interface AsteriskEventPublisher {
    void addListener(AsteriskEventListener toAdd);
    void removeListener(AsteriskEventListener toRemove);
    void publicEvent(AmiObject amiObject);
}
