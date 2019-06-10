package ru.bityard.asterisk.pkg.actions;

import ru.bityard.asterisk.pkg.AsteriskConnector;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

public interface AsteriskCallableCmd {
    AmiObject call() throws Exception;
    AsteriskCallableCmd command(AsteriskConnector asteriskConnector, String command);
    AsteriskCallableCmdImpl coreShowChannels(AsteriskConnector asteriskConnector);
}
