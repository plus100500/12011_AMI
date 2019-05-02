package ru.bityard.asterisk.actions;


import ru.bityard.asterisk.AsteriskConnector;

public interface AsteriskCmd {
    AsteriskCmdImpl makeCallFromQueue(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName);
    AsteriskCmdImpl queueSummary(AsteriskConnector asteriskConnector, String queueNum);
    AsteriskCmdImpl makeCall(AsteriskConnector asteriskConnector, String exten, String phoneNumber
            , String phoneName, String context, String channelContext, String timeout);
    AsteriskCmdImpl command(AsteriskConnector asteriskConnector, String command);
    AsteriskCmdImpl makeCallFromExten(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName);
}
