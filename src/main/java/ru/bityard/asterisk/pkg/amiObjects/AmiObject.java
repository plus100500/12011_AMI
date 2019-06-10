package ru.bityard.asterisk.pkg.amiObjects;

import java.util.List;

public abstract class AmiObject {
    private String actionID;
    private List<String> unresolve;

    public List<String> getUnresolve() {
        return unresolve;
    }

    public void setUnresolve(List<String> unresolve) {
        this.unresolve = unresolve;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    @Override
    public String toString() {
        return "AmiObject{" +
                "actionID='" + actionID + '\'' +
                ", unresolve=" + unresolve +
                '}';
    }
}
