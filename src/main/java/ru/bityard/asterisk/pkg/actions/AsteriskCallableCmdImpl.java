package ru.bityard.asterisk.pkg.actions;

import ru.bityard.asterisk.pkg.AsteriskConnector;
import ru.bityard.asterisk.pkg.EventAnnouncement;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.concurrent.Callable;

public class AsteriskCallableCmdImpl implements AsteriskCallableCmd, Callable, EventAnnouncement {

    private String actionId;
    private StringBuilder request;
    private AsteriskConnector asteriskConnector;
    private volatile AmiObject amiObject;

    @Override
    public AmiObject call() throws Exception {

        asteriskConnector.executeCmd(request.toString());

        while (amiObject == null) {
//            Ждем пока не прийдет ответ
        }

        return amiObject;
    }

    @Override
    public synchronized void publicEvent(AmiObject amiObject) {
        if (amiObject.getActionID() != null && !amiObject.getActionID().isEmpty() && amiObject.getActionID().equals(actionId))
            this.amiObject = amiObject;
    }

    @Override
    public AsteriskCallableCmdImpl command(AsteriskConnector asteriskConnector, String command) {
        this.asteriskConnector = asteriskConnector;
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
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: CoreShowChannels\r\n");
        request.append("\r\n");
        return this;
    }

}

