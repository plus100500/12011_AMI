package ru.bityard.asterisk.pkg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

@Component
public class AsteriskConnectorListenerImpl implements AsteriskConnectorListener {

    private AmiObject amiObject;

    @Autowired
    private EventAnnouncement eventAnnouncement;

    @Autowired
    private AsteriskUtil asteriskUtil;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(String str) {

//        log.info("Action is {}", str);

        // тестирование
        if (str != null) {
            if (amiObject == null) {
//                if ((str.toLowerCase().startsWith("amiObject: ")) || (str.toLowerCase().startsWith("response: "))) {
                amiObject = asteriskUtil.getObject(str);
//                }
            } else {
//                log.debug("AmiObject is {}", amiObject);
                if (!str.isEmpty()) {
                    asteriskUtil.parseEvent(str, amiObject);
                } else {
                    // Когда приходит пустая строка, значит все строки события DialBegin получены
                    eventAnnouncement.publicEvent(amiObject);
                    amiObject = null;
                }
            }


        }

    }
}

