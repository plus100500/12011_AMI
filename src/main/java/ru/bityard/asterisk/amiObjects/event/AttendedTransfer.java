package ru.bityard.asterisk.amiObjects.event;

import ru.bityard.asterisk.amiObjects.AmiObject;

import java.util.LinkedList;

public class AttendedTransfer extends AmiObject {

    private String privilege;
    private String result;
    private String origTransfererChannel;
    private String origTransfererChannelState;
    private String origTransfererChannelStateDesc;
    private String origTransfererCallerIDNum;
    private String origTransfererCallerIDName;
    private String origTransfererConnectedLineNum;
    private String origTransfererConnectedLineName;
    private String origTransfererLanguage;
    private String origTransfererAccountCode;
    private String origTransfererContext;
    private String origTransfererExten;
    private String origTransfererPriority;
    private String origTransfererUniqueid;
    private String origTransfererLinkedid;
    private String origBridgeUniqueid;
    private String origBridgeType;
    private String origBridgeTechnology;
    private String origBridgeCreator;
    private String origBridgeName;
    private String origBridgeNumChannels;
    private String origBridgeVideoSourceMode;
    private String secondTransfererChannel;
    private String secondTransfererChannelState;
    private String secondTransfererChannelStateDesc;
    private String secondTransfererCallerIDNum;
    private String secondTransfererCallerIDName;
    private String secondTransfererConnectedLineNum;
    private String secondTransfererConnectedLineName;
    private String secondTransfererLanguage;
    private String secondTransfererAccountCode;
    private String secondTransfererContext;
    private String secondTransfererExten;
    private String secondTransfererPriority;
    private String secondTransfererUniqueid;
    private String secondTransfererLinkedid;
    private String secondBridgeUniqueid;
    private String secondBridgeType;
    private String secondBridgeTechnology;
    private String secondBridgeCreator;
    private String secondBridgeName;
    private String secondBridgeNumChannels;
    private String secondBridgeVideoSourceMode;
    private String transfereeChannel;
    private String transfereeChannelState;
    private String transfereeChannelStateDesc;
    private String transfereeCallerIDNum;
    private String transfereeCallerIDName;
    private String transfereeConnectedLineNum;
    private String transfereeConnectedLineName;
    private String transfereeLanguage;
    private String transfereeAccountCode;
    private String transfereeContext;
    private String transfereeExten;
    private String transfereePriority;
    private String transfereeUniqueid;
    private String transfereeLinkedid;
    private String transferTargetChannel;
    private String transferTargetChannelState;
    private String transferTargetChannelStateDesc;
    private String transferTargetCallerIDNum;
    private String transferTargetCallerIDName;
    private String transferTargetConnectedLineNum;
    private String transferTargetConnectedLineName;
    private String transferTargetLanguage;
    private String transferTargetAccountCode;
    private String transferTargetContext;
    private String transferTargetExten;
    private String transferTargetPriority;
    private String transferTargetUniqueid;
    private String transferTargetLinkedid;
    private String isExternal;
    private String destType;
    private String destBridgeUniqueid;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOrigTransfererChannel() {
        return origTransfererChannel;
    }

    public void setOrigTransfererChannel(String origTransfererChannel) {
        this.origTransfererChannel = origTransfererChannel;
    }

    public String getOrigTransfererChannelState() {
        return origTransfererChannelState;
    }

    public void setOrigTransfererChannelState(String origTransfererChannelState) {
        this.origTransfererChannelState = origTransfererChannelState;
    }

    public String getOrigTransfererChannelStateDesc() {
        return origTransfererChannelStateDesc;
    }

    public void setOrigTransfererChannelStateDesc(String origTransfererChannelStateDesc) {
        this.origTransfererChannelStateDesc = origTransfererChannelStateDesc;
    }

    public String getOrigTransfererCallerIDNum() {
        return origTransfererCallerIDNum;
    }

    public void setOrigTransfererCallerIDNum(String origTransfererCallerIDNum) {
        this.origTransfererCallerIDNum = origTransfererCallerIDNum;
    }

    public String getOrigTransfererCallerIDName() {
        return origTransfererCallerIDName;
    }

    public void setOrigTransfererCallerIDName(String origTransfererCallerIDName) {
        this.origTransfererCallerIDName = origTransfererCallerIDName;
    }

    public String getOrigTransfererConnectedLineNum() {
        return origTransfererConnectedLineNum;
    }

    public void setOrigTransfererConnectedLineNum(String origTransfererConnectedLineNum) {
        this.origTransfererConnectedLineNum = origTransfererConnectedLineNum;
    }

    public String getOrigTransfererConnectedLineName() {
        return origTransfererConnectedLineName;
    }

    public void setOrigTransfererConnectedLineName(String origTransfererConnectedLineName) {
        this.origTransfererConnectedLineName = origTransfererConnectedLineName;
    }

    public String getOrigTransfererLanguage() {
        return origTransfererLanguage;
    }

    public void setOrigTransfererLanguage(String origTransfererLanguage) {
        this.origTransfererLanguage = origTransfererLanguage;
    }

    public String getOrigTransfererAccountCode() {
        return origTransfererAccountCode;
    }

    public void setOrigTransfererAccountCode(String origTransfererAccountCode) {
        this.origTransfererAccountCode = origTransfererAccountCode;
    }

    public String getOrigTransfererContext() {
        return origTransfererContext;
    }

    public void setOrigTransfererContext(String origTransfererContext) {
        this.origTransfererContext = origTransfererContext;
    }

    public String getOrigTransfererExten() {
        return origTransfererExten;
    }

    public void setOrigTransfererExten(String origTransfererExten) {
        this.origTransfererExten = origTransfererExten;
    }

    public String getOrigTransfererPriority() {
        return origTransfererPriority;
    }

    public void setOrigTransfererPriority(String origTransfererPriority) {
        this.origTransfererPriority = origTransfererPriority;
    }

    public String getOrigTransfererUniqueid() {
        return origTransfererUniqueid;
    }

    public void setOrigTransfererUniqueid(String origTransfererUniqueid) {
        this.origTransfererUniqueid = origTransfererUniqueid;
    }

    public String getOrigTransfererLinkedid() {
        return origTransfererLinkedid;
    }

    public void setOrigTransfererLinkedid(String origTransfererLinkedid) {
        this.origTransfererLinkedid = origTransfererLinkedid;
    }

    public String getOrigBridgeUniqueid() {
        return origBridgeUniqueid;
    }

    public void setOrigBridgeUniqueid(String origBridgeUniqueid) {
        this.origBridgeUniqueid = origBridgeUniqueid;
    }

    public String getOrigBridgeType() {
        return origBridgeType;
    }

    public void setOrigBridgeType(String origBridgeType) {
        this.origBridgeType = origBridgeType;
    }

    public String getOrigBridgeTechnology() {
        return origBridgeTechnology;
    }

    public void setOrigBridgeTechnology(String origBridgeTechnology) {
        this.origBridgeTechnology = origBridgeTechnology;
    }

    public String getOrigBridgeCreator() {
        return origBridgeCreator;
    }

    public void setOrigBridgeCreator(String origBridgeCreator) {
        this.origBridgeCreator = origBridgeCreator;
    }

    public String getOrigBridgeName() {
        return origBridgeName;
    }

    public void setOrigBridgeName(String origBridgeName) {
        this.origBridgeName = origBridgeName;
    }

    public String getOrigBridgeNumChannels() {
        return origBridgeNumChannels;
    }

    public void setOrigBridgeNumChannels(String origBridgeNumChannels) {
        this.origBridgeNumChannels = origBridgeNumChannels;
    }

    public String getOrigBridgeVideoSourceMode() {
        return origBridgeVideoSourceMode;
    }

    public void setOrigBridgeVideoSourceMode(String origBridgeVideoSourceMode) {
        this.origBridgeVideoSourceMode = origBridgeVideoSourceMode;
    }

    public String getSecondTransfererChannel() {
        return secondTransfererChannel;
    }

    public void setSecondTransfererChannel(String secondTransfererChannel) {
        this.secondTransfererChannel = secondTransfererChannel;
    }

    public String getSecondTransfererChannelState() {
        return secondTransfererChannelState;
    }

    public void setSecondTransfererChannelState(String secondTransfererChannelState) {
        this.secondTransfererChannelState = secondTransfererChannelState;
    }

    public String getSecondTransfererChannelStateDesc() {
        return secondTransfererChannelStateDesc;
    }

    public void setSecondTransfererChannelStateDesc(String secondTransfererChannelStateDesc) {
        this.secondTransfererChannelStateDesc = secondTransfererChannelStateDesc;
    }

    public String getSecondTransfererCallerIDNum() {
        return secondTransfererCallerIDNum;
    }

    public void setSecondTransfererCallerIDNum(String secondTransfererCallerIDNum) {
        this.secondTransfererCallerIDNum = secondTransfererCallerIDNum;
    }

    public String getSecondTransfererCallerIDName() {
        return secondTransfererCallerIDName;
    }

    public void setSecondTransfererCallerIDName(String secondTransfererCallerIDName) {
        this.secondTransfererCallerIDName = secondTransfererCallerIDName;
    }

    public String getSecondTransfererConnectedLineNum() {
        return secondTransfererConnectedLineNum;
    }

    public void setSecondTransfererConnectedLineNum(String secondTransfererConnectedLineNum) {
        this.secondTransfererConnectedLineNum = secondTransfererConnectedLineNum;
    }

    public String getSecondTransfererConnectedLineName() {
        return secondTransfererConnectedLineName;
    }

    public void setSecondTransfererConnectedLineName(String secondTransfererConnectedLineName) {
        this.secondTransfererConnectedLineName = secondTransfererConnectedLineName;
    }

    public String getSecondTransfererLanguage() {
        return secondTransfererLanguage;
    }

    public void setSecondTransfererLanguage(String secondTransfererLanguage) {
        this.secondTransfererLanguage = secondTransfererLanguage;
    }

    public String getSecondTransfererAccountCode() {
        return secondTransfererAccountCode;
    }

    public void setSecondTransfererAccountCode(String secondTransfererAccountCode) {
        this.secondTransfererAccountCode = secondTransfererAccountCode;
    }

    public String getSecondTransfererContext() {
        return secondTransfererContext;
    }

    public void setSecondTransfererContext(String secondTransfererContext) {
        this.secondTransfererContext = secondTransfererContext;
    }

    public String getSecondTransfererExten() {
        return secondTransfererExten;
    }

    public void setSecondTransfererExten(String secondTransfererExten) {
        this.secondTransfererExten = secondTransfererExten;
    }

    public String getSecondTransfererPriority() {
        return secondTransfererPriority;
    }

    public void setSecondTransfererPriority(String secondTransfererPriority) {
        this.secondTransfererPriority = secondTransfererPriority;
    }

    public String getSecondTransfererUniqueid() {
        return secondTransfererUniqueid;
    }

    public void setSecondTransfererUniqueid(String secondTransfererUniqueid) {
        this.secondTransfererUniqueid = secondTransfererUniqueid;
    }

    public String getSecondTransfererLinkedid() {
        return secondTransfererLinkedid;
    }

    public void setSecondTransfererLinkedid(String secondTransfererLinkedid) {
        this.secondTransfererLinkedid = secondTransfererLinkedid;
    }

    public String getSecondBridgeUniqueid() {
        return secondBridgeUniqueid;
    }

    public void setSecondBridgeUniqueid(String secondBridgeUniqueid) {
        this.secondBridgeUniqueid = secondBridgeUniqueid;
    }

    public String getSecondBridgeType() {
        return secondBridgeType;
    }

    public void setSecondBridgeType(String secondBridgeType) {
        this.secondBridgeType = secondBridgeType;
    }

    public String getSecondBridgeTechnology() {
        return secondBridgeTechnology;
    }

    public void setSecondBridgeTechnology(String secondBridgeTechnology) {
        this.secondBridgeTechnology = secondBridgeTechnology;
    }

    public String getSecondBridgeCreator() {
        return secondBridgeCreator;
    }

    public void setSecondBridgeCreator(String secondBridgeCreator) {
        this.secondBridgeCreator = secondBridgeCreator;
    }

    public String getSecondBridgeName() {
        return secondBridgeName;
    }

    public void setSecondBridgeName(String secondBridgeName) {
        this.secondBridgeName = secondBridgeName;
    }

    public String getSecondBridgeNumChannels() {
        return secondBridgeNumChannels;
    }

    public void setSecondBridgeNumChannels(String secondBridgeNumChannels) {
        this.secondBridgeNumChannels = secondBridgeNumChannels;
    }

    public String getSecondBridgeVideoSourceMode() {
        return secondBridgeVideoSourceMode;
    }

    public void setSecondBridgeVideoSourceMode(String secondBridgeVideoSourceMode) {
        this.secondBridgeVideoSourceMode = secondBridgeVideoSourceMode;
    }

    public String getTransfereeChannel() {
        return transfereeChannel;
    }

    public void setTransfereeChannel(String transfereeChannel) {
        this.transfereeChannel = transfereeChannel;
    }

    public String getTransfereeChannelState() {
        return transfereeChannelState;
    }

    public void setTransfereeChannelState(String transfereeChannelState) {
        this.transfereeChannelState = transfereeChannelState;
    }

    public String getTransfereeChannelStateDesc() {
        return transfereeChannelStateDesc;
    }

    public void setTransfereeChannelStateDesc(String transfereeChannelStateDesc) {
        this.transfereeChannelStateDesc = transfereeChannelStateDesc;
    }

    public String getTransfereeCallerIDNum() {
        return transfereeCallerIDNum;
    }

    public void setTransfereeCallerIDNum(String transfereeCallerIDNum) {
        this.transfereeCallerIDNum = transfereeCallerIDNum;
    }

    public String getTransfereeCallerIDName() {
        return transfereeCallerIDName;
    }

    public void setTransfereeCallerIDName(String transfereeCallerIDName) {
        this.transfereeCallerIDName = transfereeCallerIDName;
    }

    public String getTransfereeConnectedLineNum() {
        return transfereeConnectedLineNum;
    }

    public void setTransfereeConnectedLineNum(String transfereeConnectedLineNum) {
        this.transfereeConnectedLineNum = transfereeConnectedLineNum;
    }

    public String getTransfereeConnectedLineName() {
        return transfereeConnectedLineName;
    }

    public void setTransfereeConnectedLineName(String transfereeConnectedLineName) {
        this.transfereeConnectedLineName = transfereeConnectedLineName;
    }

    public String getTransfereeLanguage() {
        return transfereeLanguage;
    }

    public void setTransfereeLanguage(String transfereeLanguage) {
        this.transfereeLanguage = transfereeLanguage;
    }

    public String getTransfereeAccountCode() {
        return transfereeAccountCode;
    }

    public void setTransfereeAccountCode(String transfereeAccountCode) {
        this.transfereeAccountCode = transfereeAccountCode;
    }

    public String getTransfereeContext() {
        return transfereeContext;
    }

    public void setTransfereeContext(String transfereeContext) {
        this.transfereeContext = transfereeContext;
    }

    public String getTransfereeExten() {
        return transfereeExten;
    }

    public void setTransfereeExten(String transfereeExten) {
        this.transfereeExten = transfereeExten;
    }

    public String getTransfereePriority() {
        return transfereePriority;
    }

    public void setTransfereePriority(String transfereePriority) {
        this.transfereePriority = transfereePriority;
    }

    public String getTransfereeUniqueid() {
        return transfereeUniqueid;
    }

    public void setTransfereeUniqueid(String transfereeUniqueid) {
        this.transfereeUniqueid = transfereeUniqueid;
    }

    public String getTransfereeLinkedid() {
        return transfereeLinkedid;
    }

    public void setTransfereeLinkedid(String transfereeLinkedid) {
        this.transfereeLinkedid = transfereeLinkedid;
    }

    public String getTransferTargetChannel() {
        return transferTargetChannel;
    }

    public void setTransferTargetChannel(String transferTargetChannel) {
        this.transferTargetChannel = transferTargetChannel;
    }

    public String getTransferTargetChannelState() {
        return transferTargetChannelState;
    }

    public void setTransferTargetChannelState(String transferTargetChannelState) {
        this.transferTargetChannelState = transferTargetChannelState;
    }

    public String getTransferTargetChannelStateDesc() {
        return transferTargetChannelStateDesc;
    }

    public void setTransferTargetChannelStateDesc(String transferTargetChannelStateDesc) {
        this.transferTargetChannelStateDesc = transferTargetChannelStateDesc;
    }

    public String getTransferTargetCallerIDNum() {
        return transferTargetCallerIDNum;
    }

    public void setTransferTargetCallerIDNum(String transferTargetCallerIDNum) {
        this.transferTargetCallerIDNum = transferTargetCallerIDNum;
    }

    public String getTransferTargetCallerIDName() {
        return transferTargetCallerIDName;
    }

    public void setTransferTargetCallerIDName(String transferTargetCallerIDName) {
        this.transferTargetCallerIDName = transferTargetCallerIDName;
    }

    public String getTransferTargetConnectedLineNum() {
        return transferTargetConnectedLineNum;
    }

    public void setTransferTargetConnectedLineNum(String transferTargetConnectedLineNum) {
        this.transferTargetConnectedLineNum = transferTargetConnectedLineNum;
    }

    public String getTransferTargetConnectedLineName() {
        return transferTargetConnectedLineName;
    }

    public void setTransferTargetConnectedLineName(String transferTargetConnectedLineName) {
        this.transferTargetConnectedLineName = transferTargetConnectedLineName;
    }

    public String getTransferTargetLanguage() {
        return transferTargetLanguage;
    }

    public void setTransferTargetLanguage(String transferTargetLanguage) {
        this.transferTargetLanguage = transferTargetLanguage;
    }

    public String getTransferTargetAccountCode() {
        return transferTargetAccountCode;
    }

    public void setTransferTargetAccountCode(String transferTargetAccountCode) {
        this.transferTargetAccountCode = transferTargetAccountCode;
    }

    public String getTransferTargetContext() {
        return transferTargetContext;
    }

    public void setTransferTargetContext(String transferTargetContext) {
        this.transferTargetContext = transferTargetContext;
    }

    public String getTransferTargetExten() {
        return transferTargetExten;
    }

    public void setTransferTargetExten(String transferTargetExten) {
        this.transferTargetExten = transferTargetExten;
    }

    public String getTransferTargetPriority() {
        return transferTargetPriority;
    }

    public void setTransferTargetPriority(String transferTargetPriority) {
        this.transferTargetPriority = transferTargetPriority;
    }

    public String getTransferTargetUniqueid() {
        return transferTargetUniqueid;
    }

    public void setTransferTargetUniqueid(String transferTargetUniqueid) {
        this.transferTargetUniqueid = transferTargetUniqueid;
    }

    public String getTransferTargetLinkedid() {
        return transferTargetLinkedid;
    }

    public void setTransferTargetLinkedid(String transferTargetLinkedid) {
        this.transferTargetLinkedid = transferTargetLinkedid;
    }

    public String getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(String isExternal) {
        this.isExternal = isExternal;
    }

    public String getDestType() {
        return destType;
    }

    public void setDestType(String destType) {
        this.destType = destType;
    }

    public String getDestBridgeUniqueid() {
        return destBridgeUniqueid;
    }

    public void setDestBridgeUniqueid(String destBridgeUniqueid) {
        this.destBridgeUniqueid = destBridgeUniqueid;
    }

    @Override
    public String toString() {
        return "AttendedTransfer{" +
                "privilege='" + privilege + '\'' +
                ", result='" + result + '\'' +
                ", origTransfererChannel='" + origTransfererChannel + '\'' +
                ", origTransfererChannelState='" + origTransfererChannelState + '\'' +
                ", origTransfererChannelStateDesc='" + origTransfererChannelStateDesc + '\'' +
                ", origTransfererCallerIDNum='" + origTransfererCallerIDNum + '\'' +
                ", origTransfererCallerIDName='" + origTransfererCallerIDName + '\'' +
                ", origTransfererConnectedLineNum='" + origTransfererConnectedLineNum + '\'' +
                ", origTransfererConnectedLineName='" + origTransfererConnectedLineName + '\'' +
                ", origTransfererLanguage='" + origTransfererLanguage + '\'' +
                ", origTransfererAccountCode='" + origTransfererAccountCode + '\'' +
                ", origTransfererContext='" + origTransfererContext + '\'' +
                ", origTransfererExten='" + origTransfererExten + '\'' +
                ", origTransfererPriority='" + origTransfererPriority + '\'' +
                ", origTransfererUniqueid='" + origTransfererUniqueid + '\'' +
                ", origTransfererLinkedid='" + origTransfererLinkedid + '\'' +
                ", origBridgeUniqueid='" + origBridgeUniqueid + '\'' +
                ", origBridgeType='" + origBridgeType + '\'' +
                ", origBridgeTechnology='" + origBridgeTechnology + '\'' +
                ", origBridgeCreator='" + origBridgeCreator + '\'' +
                ", origBridgeName='" + origBridgeName + '\'' +
                ", origBridgeNumChannels='" + origBridgeNumChannels + '\'' +
                ", origBridgeVideoSourceMode='" + origBridgeVideoSourceMode + '\'' +
                ", secondTransfererChannel='" + secondTransfererChannel + '\'' +
                ", secondTransfererChannelState='" + secondTransfererChannelState + '\'' +
                ", secondTransfererChannelStateDesc='" + secondTransfererChannelStateDesc + '\'' +
                ", secondTransfererCallerIDNum='" + secondTransfererCallerIDNum + '\'' +
                ", secondTransfererCallerIDName='" + secondTransfererCallerIDName + '\'' +
                ", secondTransfererConnectedLineNum='" + secondTransfererConnectedLineNum + '\'' +
                ", secondTransfererConnectedLineName='" + secondTransfererConnectedLineName + '\'' +
                ", secondTransfererLanguage='" + secondTransfererLanguage + '\'' +
                ", secondTransfererAccountCode='" + secondTransfererAccountCode + '\'' +
                ", secondTransfererContext='" + secondTransfererContext + '\'' +
                ", secondTransfererExten='" + secondTransfererExten + '\'' +
                ", secondTransfererPriority='" + secondTransfererPriority + '\'' +
                ", secondTransfererUniqueid='" + secondTransfererUniqueid + '\'' +
                ", secondTransfererLinkedid='" + secondTransfererLinkedid + '\'' +
                ", secondBridgeUniqueid='" + secondBridgeUniqueid + '\'' +
                ", secondBridgeType='" + secondBridgeType + '\'' +
                ", secondBridgeTechnology='" + secondBridgeTechnology + '\'' +
                ", secondBridgeCreator='" + secondBridgeCreator + '\'' +
                ", secondBridgeName='" + secondBridgeName + '\'' +
                ", secondBridgeNumChannels='" + secondBridgeNumChannels + '\'' +
                ", secondBridgeVideoSourceMode='" + secondBridgeVideoSourceMode + '\'' +
                ", transfereeChannel='" + transfereeChannel + '\'' +
                ", transfereeChannelState='" + transfereeChannelState + '\'' +
                ", transfereeChannelStateDesc='" + transfereeChannelStateDesc + '\'' +
                ", transfereeCallerIDNum='" + transfereeCallerIDNum + '\'' +
                ", transfereeCallerIDName='" + transfereeCallerIDName + '\'' +
                ", transfereeConnectedLineNum='" + transfereeConnectedLineNum + '\'' +
                ", transfereeConnectedLineName='" + transfereeConnectedLineName + '\'' +
                ", transfereeLanguage='" + transfereeLanguage + '\'' +
                ", transfereeAccountCode='" + transfereeAccountCode + '\'' +
                ", transfereeContext='" + transfereeContext + '\'' +
                ", transfereeExten='" + transfereeExten + '\'' +
                ", transfereePriority='" + transfereePriority + '\'' +
                ", transfereeUniqueid='" + transfereeUniqueid + '\'' +
                ", transfereeLinkedid='" + transfereeLinkedid + '\'' +
                ", transferTargetChannel='" + transferTargetChannel + '\'' +
                ", transferTargetChannelState='" + transferTargetChannelState + '\'' +
                ", transferTargetChannelStateDesc='" + transferTargetChannelStateDesc + '\'' +
                ", transferTargetCallerIDNum='" + transferTargetCallerIDNum + '\'' +
                ", transferTargetCallerIDName='" + transferTargetCallerIDName + '\'' +
                ", transferTargetConnectedLineNum='" + transferTargetConnectedLineNum + '\'' +
                ", transferTargetConnectedLineName='" + transferTargetConnectedLineName + '\'' +
                ", transferTargetLanguage='" + transferTargetLanguage + '\'' +
                ", transferTargetAccountCode='" + transferTargetAccountCode + '\'' +
                ", transferTargetContext='" + transferTargetContext + '\'' +
                ", transferTargetExten='" + transferTargetExten + '\'' +
                ", transferTargetPriority='" + transferTargetPriority + '\'' +
                ", transferTargetUniqueid='" + transferTargetUniqueid + '\'' +
                ", transferTargetLinkedid='" + transferTargetLinkedid + '\'' +
                ", isExternal='" + isExternal + '\'' +
                ", destType='" + destType + '\'' +
                ", destBridgeUniqueid='" + destBridgeUniqueid + '\'' +
                ", line='" + line + '\'' +
                "} " + super.toString();
    }
}
