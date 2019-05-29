package ru.bityard.asterisk.pkg;

import org.springframework.context.ApplicationEvent;

public class AsteriskActionEvent extends ApplicationEvent {

    private String message;

    public AsteriskActionEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[source = " + getSource() + ", message = " + message + "]";
    }

}
