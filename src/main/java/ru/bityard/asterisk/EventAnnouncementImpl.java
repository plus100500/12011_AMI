package ru.bityard.asterisk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.amiObjects.AmiObject;

@Component
public class EventAnnouncementImpl implements EventAnnouncement {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void publicEvent(AmiObject amiObject) {
//        log.debug("New amiObject {}", amiObject);
    }

}
