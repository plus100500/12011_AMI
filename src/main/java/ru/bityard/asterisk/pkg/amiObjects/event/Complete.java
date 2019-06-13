package ru.bityard.asterisk.pkg.amiObjects.event;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public class Complete extends AmiObject {

    private String listItems;

    public String getListItems() {
        return listItems;
    }

    public void setListItems(String listItems) {
        this.listItems = listItems;
    }


    @Override
    public String toString() {
        return "Complete{" +
                "listItems='" + listItems + '\'' +
                "} " + super.toString();
    }
}
