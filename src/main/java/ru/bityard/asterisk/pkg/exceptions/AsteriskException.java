package ru.bityard.asterisk.pkg.exceptions;

public class AsteriskException extends Throwable {
    private String message;

    public AsteriskException(String message) {
        this.message = "\r\n".concat(message);
    }

    public AsteriskException() {
    }

    public void addMessage(String message) {
        this.message = this.message.concat("\r\n".concat(message));
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "\r\n".concat(message);
    }
}
