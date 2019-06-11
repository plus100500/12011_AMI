package ru.bityard.asterisk.pkg.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bityard.asterisk.pkg.AsteriskConnector;
import ru.bityard.asterisk.pkg.AsteriskEventListener;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AsteriskCallableCmdImpl implements AsteriskCallableCmd, Callable, AsteriskEventListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private String actionId;
    private StringBuilder request;
    private AsteriskConnector asteriskConnector;
    private List<AmiObject> amiObjects = new ArrayList<>();
    private boolean listen;

    @Override
    public List<AmiObject> call() throws Exception {

        asteriskConnector.executeCmd(request.toString());

        while (listen) {
//            Ждем пока не получим все объекты
        }
        asteriskConnector.getAsteriskEventPublisher().removeListener(this);
        return amiObjects;
    }

    @Override
    public void publicEvent(AmiObject amiObject) {
        if (amiObject.getActionID() != null && !amiObject.getActionID().isEmpty() && amiObject.getActionID().equals(actionId)) {
            amiObjects.add(amiObject);
            log.info("Catch object is {}",amiObject);
            if (amiObject.getEventList().toLowerCase().equals("Complete")) listen = false;
        }
    }

    @Override
    public AsteriskCallableCmdImpl command(AsteriskConnector asteriskConnector, String command) {
        this.asteriskConnector = asteriskConnector;
        asteriskConnector.getAsteriskEventPublisher().addListener(this);
        listen = true;
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: Command\r\n");
        request.append("Command: ".concat(command).concat("\r\n"));
        request.append("\r\n");
        return this;
    }

    @Override
    public AsteriskCallableCmdImpl coreShowChannels(AsteriskConnector asteriskConnector) {
        this.asteriskConnector = asteriskConnector;
        asteriskConnector.getAsteriskEventPublisher().addListener(this);
        listen = true;
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: CoreShowChannels\r\n");
        request.append("\r\n");
        return this;
    }

}

