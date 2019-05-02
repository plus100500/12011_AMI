package ru.bityard.asterisk.amiObjects.event;

import ru.bityard.asterisk.amiObjects.AmiObject;

import java.util.LinkedList;

public class Hangup extends AmiObject {
    private String privilege;
    private String channel;
    private String channelState;
    private String channelStateDesc;
    private String callerIDNum;
    private String callerIDName;
    private String connectedLineNum;
    private String connectedLineName;
    private String language;
    private String accountCode;
    private String context;
    private String exten;
    private String priority;
    private String uniqueid;
    private String linkedid;
    private String cause;
    private String causeTxt;
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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelState() {
        return channelState;
    }

    public void setChannelState(String channelState) {
        this.channelState = channelState;
    }

    public String getChannelStateDesc() {
        return channelStateDesc;
    }

    public void setChannelStateDesc(String channelStateDesc) {
        this.channelStateDesc = channelStateDesc;
    }

    public String getCallerIDNum() {
        return callerIDNum;
    }

    public void setCallerIDNum(String callerIDNum) {
        this.callerIDNum = callerIDNum;
    }

    public String getCallerIDName() {
        return callerIDName;
    }

    public void setCallerIDName(String callerIDName) {
        this.callerIDName = callerIDName;
    }

    public String getConnectedLineNum() {
        return connectedLineNum;
    }

    public void setConnectedLineNum(String connectedLineNum) {
        this.connectedLineNum = connectedLineNum;
    }

    public String getConnectedLineName() {
        return connectedLineName;
    }

    public void setConnectedLineName(String connectedLineName) {
        this.connectedLineName = connectedLineName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getExten() {
        return exten;
    }

    public void setExten(String exten) {
        this.exten = exten;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getLinkedid() {
        return linkedid;
    }

    public void setLinkedid(String linkedid) {
        this.linkedid = linkedid;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCauseTxt() {
        return causeTxt;
    }

    public void setCauseTxt(String causeTxt) {
        this.causeTxt = causeTxt;
    }

    @Override
    public String toString() {
        return "Hangup{" +
                "privilege='" + privilege + '\'' +
                ", channel='" + channel + '\'' +
                ", channelState='" + channelState + '\'' +
                ", channelStateDesc='" + channelStateDesc + '\'' +
                ", callerIDNum='" + callerIDNum + '\'' +
                ", callerIDName='" + callerIDName + '\'' +
                ", connectedLineNum='" + connectedLineNum + '\'' +
                ", connectedLineName='" + connectedLineName + '\'' +
                ", language='" + language + '\'' +
                ", accountCode='" + accountCode + '\'' +
                ", context='" + context + '\'' +
                ", exten='" + exten + '\'' +
                ", priority='" + priority + '\'' +
                ", uniqueid='" + uniqueid + '\'' +
                ", linkedid='" + linkedid + '\'' +
                ", cause='" + cause + '\'' +
                ", causeTxt='" + causeTxt + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
