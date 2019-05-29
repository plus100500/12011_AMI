package ru.bityard.asterisk.pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

@Component
public class EventAnnouncementImpl implements EventAnnouncement {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void publicEvent(AmiObject amiObject) {
        // do nothing
    }
}
