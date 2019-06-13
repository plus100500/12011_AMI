package ru.bityard.asterisk.pkg.actions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.bityard.asterisk.pkg.AsteriskConnector;

@Component
public class AsteriskCmdImpl implements AsteriskCmd, Runnable {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
//        log.debug("AsteriskCmd Thread Runnable {}",this);
    }

    @Override
    public AsteriskCmdImpl makeCallFromQueue(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName) {
        String timeout = "30000";
        String context = "from-internal";
        String channelContext = "from-queue";
        makeCall(asteriskConnector, exten, phoneNumber, phoneName, context, channelContext, timeout);
        return this;
    }

    @Override
    public AsteriskCmdImpl makeCallFromExten(AsteriskConnector asteriskConnector, String exten, String phoneNumber, String phoneName) {
        String timeout = "30000";
        String context = "from-internal";
        makeCall(asteriskConnector, exten, phoneNumber, phoneName, context, null, timeout);
        return this;
    }

    @Override
    public AsteriskCmdImpl makeCall(AsteriskConnector asteriskConnector, String exten, String phoneNumber
            , String phoneName, String context, String channelContext, String timeout) {
        StringBuilder request = new StringBuilder();
        request.append("Action: Originate\r\n");
        request.append("ActionID: ".concat(asteriskConnector.getActionIdNum()).concat("\r\n"));
        request.append("Exten: ".concat(phoneNumber).concat("\r\n"));
        if (channelContext != null) {
            request.append("Channel: Local/".concat(exten).concat("@").concat(channelContext).concat("/n").concat("\r\n"));
        } else {
            request.append("Channel: Local/".concat(exten).concat("\r\n"));
        }
        request.append("Context: ".concat(context).concat("\r\n"));
        request.append("Priority: 1".concat("\r\n"));
        request.append("Timeout: ".concat(timeout).concat("\r\n"));
        request.append("Async: true".concat("\r\n"));
        request.append("Callerid: \"".concat(phoneName).concat("\" <").concat(phoneNumber).concat(">\r\n"));
        request.append("Variable: sipaddheader=call-info:\\;answer-after=0".concat("\r\n"));
        request.append("\r\n");

//        log.debug("\r\nAMI request is \r\n{}", request.toString());
        asteriskConnector.executeCmd(request.toString());
        return this;
    }

    public AsteriskCmdImpl getAgents(AsteriskConnector asteriskConnector, String queueNum) {
        StringBuilder request = new StringBuilder();
        request.append("Action: Qeues\r\n");
        request.append("ActionID: ".concat(asteriskConnector.getActionIdNum()).concat("\r\n"));
//        request.append("")
        return this;
    }

    @Override
    public AsteriskCmdImpl queueSummary(AsteriskConnector asteriskConnector, String queueNum) {
        StringBuilder request = new StringBuilder();
        request.append("ActionID: ".concat(asteriskConnector.getActionIdNum()).concat("\r\n"));
        request.append("Action: QueueSummary\r\n");
        request.append("Queue: ".concat(queueNum).concat("\r\n"));
        request.append("\r\n");
        asteriskConnector.executeCmd(request.toString());
        return queueSummary(asteriskConnector,request);
    }

    @Override
    public AsteriskCmdImpl queueSummary(AsteriskConnector asteriskConnector, StringBuilder request) {
        asteriskConnector.executeCmd(request.toString());
        return this;
    }

    @Override
    public AsteriskCmdImpl command(AsteriskConnector asteriskConnector, String command) {
        StringBuilder request = new StringBuilder();
        request.append("ActionID: ".concat(asteriskConnector.getActionIdNum()).concat("\r\n"));
        request.append("Action: Command\r\n");
        request.append("Command: ".concat(command).concat("\r\n"));
        request.append("\r\n");
        asteriskConnector.executeCmd(request.toString());
        return this;
    }

    @Override
    public AsteriskCmdImpl coreShowChannels(AsteriskConnector asteriskConnector, StringBuilder request) {
        asteriskConnector.executeCmd(request.toString());
        return this;
    }

    @Override
    public AsteriskCmdImpl coreShowChannels(AsteriskConnector asteriskConnector) {
        StringBuilder request = new StringBuilder();
        String actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: CoreShowChannels\r\n");
        request.append("\r\n");
        return coreShowChannels(asteriskConnector,request);
    }

    @Override
    public AsteriskCmdImpl executeCmd(AsteriskConnector asteriskConnector, String request) {
        asteriskConnector.executeCmd(request);
        return this;
    }
}