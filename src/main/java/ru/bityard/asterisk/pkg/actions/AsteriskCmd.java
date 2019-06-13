package ru.bityard.asterisk.pkg.actions;


import ru.bityard.asterisk.pkg.AsteriskConnector;

public interface AsteriskCmd {
    AsteriskCmdImpl makeCallFromQueue(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName);
    AsteriskCmdImpl queueSummary(AsteriskConnector asteriskConnector, String queueNum);
    AsteriskCmdImpl queueSummary(AsteriskConnector asteriskConnector, StringBuilder request);
    AsteriskCmdImpl makeCall(AsteriskConnector asteriskConnector, String exten, String phoneNumber
            , String phoneName, String context, String channelContext, String timeout);
    AsteriskCmdImpl command(AsteriskConnector asteriskConnector, String command);
    AsteriskCmdImpl makeCallFromExten(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName);
    AsteriskCmdImpl coreShowChannels(AsteriskConnector asteriskConnector, StringBuilder request);
    AsteriskCmdImpl coreShowChannels(AsteriskConnector asteriskConnector);
    AsteriskCmdImpl executeCmd(AsteriskConnector asteriskConnector, String request);
}
