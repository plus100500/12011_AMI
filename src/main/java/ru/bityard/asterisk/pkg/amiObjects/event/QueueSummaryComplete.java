package ru.bityard.asterisk.pkg.amiObjects.event;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public class QueueSummaryComplete extends AmiObject {

    private String listItems;

    public String getListItems() {
        return listItems;
    }

    public void setListItems(String listItems) {
        this.listItems = listItems;
    }

    @Override
    public String toString() {
        return "QueueSummaryComplete{" +
                " listItems='" + listItems + '\'' +
                "} " + super.toString();
    }
}
