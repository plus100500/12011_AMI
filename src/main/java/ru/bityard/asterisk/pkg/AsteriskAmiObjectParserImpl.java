package ru.bityard.asterisk.pkg;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public class AsteriskAmiObjectParserImpl implements AsteriskAmiObjectParser {

    private AmiObject amiObject;

    private AsteriskEventPublisher asteriskEventPublisher;

    private AsteriskUtil asteriskUtil;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public AsteriskAmiObjectParserImpl(AsteriskEventPublisher asteriskEventPublisher) {
        this.asteriskEventPublisher = asteriskEventPublisher;
        asteriskUtil = new AsteriskUtil();
    }

    @Override
    public void parseStr(String str) {

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
                    asteriskEventPublisher.publicEvent(amiObject);
                    amiObject = null;
                }
            }


        }

    }
}

