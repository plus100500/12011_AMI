package ru.bityard.asterisk.pkg.amiObjects.event;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.LinkedList;

public class CoreShowChannel extends AmiObject {

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
    private String application;
    private String applicationData;
    private String duration;
    private String bridgeId;

    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        if (super.getUnresolve() == null) super.setUnresolve(new LinkedList<>());
        super.getUnresolve().add(line);
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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getApplicationData() {
        return applicationData;
    }

    public void setApplicationData(String applicationData) {
        this.applicationData = applicationData;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBridgeId() {
        return bridgeId;
    }

    public void setBridgeId(String bridgeId) {
        this.bridgeId = bridgeId;
    }

    @Override
    public String toString() {
        return "CoreShowChannel{" +
                "channel='" + channel + '\'' +
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
                ", application='" + application + '\'' +
                ", applicationData='" + applicationData + '\'' +
                ", duration='" + duration + '\'' +
                ", bridgeId='" + bridgeId + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
