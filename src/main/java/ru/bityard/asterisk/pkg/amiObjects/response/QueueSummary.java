package ru.bityard.asterisk.pkg.amiObjects.response;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.LinkedList;

public class QueueSummary extends AmiObject {

    private String queue;
    private String loggedIn;
    private String available;
    private String callers;
    private String holdTime;
    private String talkTime;
    private String longestHoldTime;
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if (super.getUnresolve() == null) super.setUnresolve(new LinkedList<>());
        super.getUnresolve().add(line);
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getCallers() {
        return callers;
    }

    public void setCallers(String callers) {
        this.callers = callers;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public String getLongestHoldTime() {
        return longestHoldTime;
    }

    public void setLongestHoldTime(String longestHoldTime) {
        this.longestHoldTime = longestHoldTime;
    }


    @Override
    public String toString() {
        return "QueueSummary{" +
                "queue='" + queue + '\'' +
                ", loggedIn='" + loggedIn + '\'' +
                ", available='" + available + '\'' +
                ", callers='" + callers + '\'' +
                ", holdTime='" + holdTime + '\'' +
                ", talkTime='" + talkTime + '\'' +
                ", longestHoldTime='" + longestHoldTime + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
