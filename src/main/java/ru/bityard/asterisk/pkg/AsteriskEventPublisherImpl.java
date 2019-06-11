package ru.bityard.asterisk.pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.ArrayList;
import java.util.List;

@Component
public class AsteriskEventPublisherImpl implements AsteriskEventPublisher {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<AsteriskEventListener> listeners = new ArrayList<>();

    @Override
    public void addListener(AsteriskEventListener toAdd) {
        listeners.add(toAdd);
    }

    @Override
    public void removeListener(AsteriskEventListener toRemove) {
        listeners.remove(toRemove);
    }

    public void publicEvent(AmiObject amiObject) {
        if (!listeners.isEmpty()) {
            for (AsteriskEventListener asteriskEventListener : listeners) {
                if (asteriskEventListener != null) {
                    asteriskEventListener.publicEvent(amiObject);
                }
            }
        }
    }
}
