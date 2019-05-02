package ru.bityard.asterisk.amiObjects.response;


import ru.bityard.asterisk.amiObjects.AmiObject;

public class Error extends AmiObject {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                "} " + super.toString();
    }
}
