package ru.bityard.asterisk.pkg.asteriskListeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.AsteriskEventListener;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;
import ru.bityard.asterisk.pkg.amiObjects.response.Error;
import ru.bityard.asterisk.pkg.amiObjects.response.Success;

import javax.annotation.PostConstruct;

@Component
public class AsteriskEventListenerImpl implements AsteriskEventListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsteriskConnectorStatus asteriskConnectorStatus;

    @PostConstruct
    public void init() {
        asteriskConnectorStatus.getAsteriskEventPublisher().addListener(this);
    }

    @Override
    public void publicEvent(AmiObject amiObject) {
        switch (amiObject.getClass().getSimpleName()) {
            case "Success": {
                Success success = (Success) amiObject;
                if (asteriskConnectorStatus.getAuthID().equals(success.getActionID())) {
                    asteriskConnectorStatus.setState(true);
                    asteriskConnectorStatus.setStatusCause(success.getMessage());
                    log.info(success.getMessage());
                }
            }
            break;
            case "Error": {
                Error error = (Error) amiObject;
                if (asteriskConnectorStatus.getAuthID().equals(error.getActionID())) {
                    asteriskConnectorStatus.setState(false);
                    asteriskConnectorStatus.setStatusCause(error.getMessage());
                    log.info(error.getMessage());
                }
            }
            break;
        }
    }
}
