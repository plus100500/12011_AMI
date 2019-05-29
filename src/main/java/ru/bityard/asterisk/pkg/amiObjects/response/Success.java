package ru.bityard.asterisk.pkg.amiObjects.response;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.LinkedList;

public class Success extends AmiObject {
    private String actionID;
    private String message;
    private String eventList;
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if (super.getUnresolve() == null) super.setUnresolve(new LinkedList<>());
        super.getUnresolve().add(line);
    }


    @Override
    public String toString() {
        return "Success{" +
                "actionID='" + actionID + '\'' +
                ", message='" + message + '\'' +
                ", eventList='" + eventList + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEventList() {
        return eventList;
    }

    public void setEventList(String eventList) {
        this.eventList = eventList;
    }
}
