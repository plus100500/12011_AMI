package ru.bityard.asterisk.pkg.amiObjects.event;

import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.util.LinkedList;

public class DialBegin extends AmiObject {
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
    private String destChannel;
    private String destChannelState;
    private String destChannelStateDesc;
    private String destCallerIDNum;
    private String destCallerIDName;
    private String destConnectedLineNum;
    private String destConnectedLineName;
    private String destLanguage;
    private String destAccountCode;
    private String destContext;
    private String destExten;
    private String destPriority;
    private String destUniqueid;
    private String destLinkedid;
    private String dialString;
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

    public String getDestChannel() {
        return destChannel;
    }

    public void setDestChannel(String destChannel) {
        this.destChannel = destChannel;
    }

    public String getDestChannelState() {
        return destChannelState;
    }

    public void setDestChannelState(String destChannelState) {
        this.destChannelState = destChannelState;
    }

    public String getDestChannelStateDesc() {
        return destChannelStateDesc;
    }

    public void setDestChannelStateDesc(String destChannelStateDesc) {
        this.destChannelStateDesc = destChannelStateDesc;
    }

    public String getDestCallerIDNum() {
        return destCallerIDNum;
    }

    public void setDestCallerIDNum(String destCallerIDNum) {
        this.destCallerIDNum = destCallerIDNum;
    }

    public String getDestCallerIDName() {
        return destCallerIDName;
    }

    public void setDestCallerIDName(String destCallerIDName) {
        this.destCallerIDName = destCallerIDName;
    }

    public String getDestConnectedLineNum() {
        return destConnectedLineNum;
    }

    public void setDestConnectedLineNum(String destConnectedLineNum) {
        this.destConnectedLineNum = destConnectedLineNum;
    }

    public String getDestConnectedLineName() {
        return destConnectedLineName;
    }

    public void setDestConnectedLineName(String destConnectedLineName) {
        this.destConnectedLineName = destConnectedLineName;
    }

    public String getDestLanguage() {
        return destLanguage;
    }

    public void setDestLanguage(String destLanguage) {
        this.destLanguage = destLanguage;
    }

    public String getDestAccountCode() {
        return destAccountCode;
    }

    public void setDestAccountCode(String destAccountCode) {
        this.destAccountCode = destAccountCode;
    }

    public String getDestContext() {
        return destContext;
    }

    public void setDestContext(String destContext) {
        this.destContext = destContext;
    }

    public String getDestExten() {
        return destExten;
    }

    public void setDestExten(String destExten) {
        this.destExten = destExten;
    }

    public String getDestPriority() {
        return destPriority;
    }

    public void setDestPriority(String destPriority) {
        this.destPriority = destPriority;
    }

    public String getDestUniqueid() {
        return destUniqueid;
    }

    public void setDestUniqueid(String destUniqueid) {
        this.destUniqueid = destUniqueid;
    }

    public String getDestLinkedid() {
        return destLinkedid;
    }

    public void setDestLinkedid(String destLinkedid) {
        this.destLinkedid = destLinkedid;
    }

    public String getDialString() {
        return dialString;
    }

    public void setDialString(String dialString) {
        this.dialString = dialString;
    }

    @Override
    public String toString() {
        return "DialBegin{" +
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
                ", destChannel='" + destChannel + '\'' +
                ", destChannelState='" + destChannelState + '\'' +
                ", destChannelStateDesc='" + destChannelStateDesc + '\'' +
                ", destCallerIDNum='" + destCallerIDNum + '\'' +
                ", destCallerIDName='" + destCallerIDName + '\'' +
                ", destConnectedLineNum='" + destConnectedLineNum + '\'' +
                ", destConnectedLineName='" + destConnectedLineName + '\'' +
                ", destLanguage='" + destLanguage + '\'' +
                ", destAccountCode='" + destAccountCode + '\'' +
                ", destContext='" + destContext + '\'' +
                ", destExten='" + destExten + '\'' +
                ", destPriority='" + destPriority + '\'' +
                ", destUniqueid='" + destUniqueid + '\'' +
                ", destLinkedid='" + destLinkedid + '\'' +
                ", dialString='" + dialString + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
