package ru.bityard.asterisk.pkg.amiObjects.response;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.LinkedList;

public class Follows extends AmiObject {
    private String privilege;
    private String actionID;
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if (super.getUnresolve() == null) super.setUnresolve(new LinkedList<>());
        super.getUnresolve().add(line);
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }


    @Override
    public String toString() {
        return "Follows{" +
                "privilege='" + privilege + '\'' +
                ", actionID='" + actionID + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
