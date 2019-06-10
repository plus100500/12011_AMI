package ru.bityard.asterisk.pkg.amiObjects.response;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public class QueueSummaryComplete extends AmiObject {

    private String eventList;
    private String listItems;


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

                ", eventList='" + eventList + '\'' +
                ", listItems='" + listItems + '\'' +
                "} " + super.toString();
    }
}
