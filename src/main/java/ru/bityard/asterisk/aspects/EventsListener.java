package ru.bityard.asterisk.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.amiObjects.AmiObject;
import ru.bityard.asterisk.amiObjects.response.Error;
import ru.bityard.asterisk.amiObjects.response.Success;

@Aspect
@Component
public class EventsListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AsteriskConnectorStatus asteriskConnectorStatus;

    @Pointcut("execution(* ru.bityard.asterisk.EventAnnouncement.publicEvent(..)) && args(amiObject)")
    public void publicEvent(AmiObject amiObject) {
    }


    @After("publicEvent(amiObject)")
    public void authorizeEvent(AmiObject amiObject) {
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
