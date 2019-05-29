package ru.bityard.asterisk.pkg.amiObjects.event;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public class QueueSummaryComplete extends AmiObject {
    private String actionID;
    private String eventList;
    private String listItems;

    public String getActionID() {
        return actionID;
    }

    public void setActionID(String actionID) {
        this.actionID = actionID;
    }

    public String getEventList() {
        return eventList;
    }

    public void setEventList(String eventList) {
        this.eventList = eventList;
    }

    public String getListItems() {
        return listItems;
    }

    public void setListItems(String listItems) {
        this.listItems = listItems;
    }

    @Override
    public String toString() {
        return "QueueSummaryComplete{" +
                "actionID='" + actionID + '\'' +
                ", eventList='" + eventList + '\'' +
                ", listItems='" + listItems + '\'' +
                "} " + super.toString();
    }
}
