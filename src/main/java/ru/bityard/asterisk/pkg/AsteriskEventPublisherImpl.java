package ru.bityard.asterisk.pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class AsteriskEventPublisherImpl implements AsteriskEventPublisher {

    private final static Object monitor = new Object();

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private List<AsteriskEventListener> listeners = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void addListener(AsteriskEventListener toAdd) {
        synchronized (listeners) {
//            log.info("Add listener - {} : {}",toAdd,toAdd.hashCode());
            listeners.add(toAdd);
        }
    }

    @Override
    public void removeListener(AsteriskEventListener toRemove) {
        synchronized (listeners) {
//            log.info("Remove listener - {} : {}",toRemove,toRemove.hashCode());
            listeners.remove(toRemove);
        }
    }

    public void publicEvent(AmiObject amiObject) {
        synchronized (listeners) {
            if (listeners != null && !listeners.isEmpty()) {
                for (AsteriskEventListener asteriskEventListener : listeners) {
                    if (asteriskEventListener != null) {
                        asteriskEventListener.publicEvent(amiObject);
                    }
                }
            }
//            Iterator<AsteriskEventListener> iterator = listeners.iterator();
//            while (iterator.hasNext())
//                synchronized (iterator) {
//                    AsteriskEventListener asteriskEventListener = iterator.next();
//                    if (asteriskEventListener != null) {
//                        asteriskEventListener.publicEvent(amiObject);
//                    }
//                }
        }
    }
}

