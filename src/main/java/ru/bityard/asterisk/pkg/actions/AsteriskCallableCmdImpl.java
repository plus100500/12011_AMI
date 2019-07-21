package ru.bityard.asterisk.pkg.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bityard.asterisk.pkg.AsteriskConnector;
import ru.bityard.asterisk.pkg.AsteriskEventListener;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;
import ru.bityard.asterisk.pkg.amiObjects.event.Complete;
import ru.bityard.asterisk.pkg.amiObjects.response.Error;
import ru.bityard.asterisk.pkg.amiObjects.response.Follows;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsteriskCallableCmdImpl implements AsteriskCallableCmd, Callable, AsteriskEventListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private String actionId;
    private StringBuilder request;
    private AsteriskConnector asteriskConnector;
    private List<AmiObject> amiObjects = new ArrayList<>();
    private AtomicBoolean listen = new AtomicBoolean();

    @Override
    public List<AmiObject> call() throws Exception {

//        log.info("AsteriskCallableCmdImpl {}", Thread.currentThread().getName());

//        asteriskConnector.executeCmd(request.toString());
        asteriskConnector.getThreadPoolTaskExecutor().submit(asteriskConnector.getAsteriskCmd().executeCmd(asteriskConnector, request.toString()));
        Calendar start = Calendar.getInstance();
        while (listen.get() & checkTimout(start,10)) {
            try {
                synchronized (this) {
                    wait(100);
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
//            log.info("AsteriskCallableCmdImpl {}", Thread.currentThread().getName());
//            Ждем пока не получим все объекты
//            log.info("While listen is {}",listen);
        }
//        log.info("All objects are received - {}",listen);
        asteriskConnector.getAsteriskEventPublisher().removeListener(this);
        return amiObjects;
    }

    private boolean checkTimout(Calendar start, int waitSeconds) {
        return (Calendar.getInstance().getTimeInMillis() - (waitSeconds * 1000L)) < start.getTimeInMillis();
    }

    @Override
    public void publicEvent(AmiObject amiObject) {
        if (amiObject.getActionID() != null && !amiObject.getActionID().isEmpty() && amiObject.getActionID().equals(actionId)) {
            amiObjects.add(amiObject);
//            log.info("Catch object is {}", amiObject);
            if ((amiObject instanceof Complete) || (amiObject instanceof Follows)) listen.set(false);
            if (amiObject instanceof Error) {
                log.warn("\r\n\r\nCan't execute AMI request for request: \r\n{}Response is {}\r\n", request, ((Error) amiObject).getMessage());
                listen.set(false);
            }
//            log.info("listen is {}",listen);
        }
    }

    @Override
    public AsteriskCallableCmdImpl command(AsteriskConnector asteriskConnector, String command) {
        this.asteriskConnector = asteriskConnector;
        asteriskConnector.getAsteriskEventPublisher().addListener(this);
        listen.set(true);
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: Command\r\n");
        request.append("Command: ".concat(command).concat("\r\n"));
        request.append("\r\n");
        return this;
    }

    @Override
    public AsteriskCallableCmdImpl coreShowChannels(AsteriskConnector asteriskConnector) {
        this.asteriskConnector = asteriskConnector;
        asteriskConnector.getAsteriskEventPublisher().addListener(this);
        listen.set(true);
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: CoreShowChannels\r\n");
        request.append("\r\n");
        return this;
    }

    @Override
    public AsteriskCallableCmdImpl queueSummary(AsteriskConnector asteriskConnector, String queueNum) {
        this.asteriskConnector = asteriskConnector;
        asteriskConnector.getAsteriskEventPublisher().addListener(this);
        listen.set(true);
        request = new StringBuilder();
        actionId = asteriskConnector.getActionIdNum();
        request.append("ActionID: ".concat(actionId).concat("\r\n"));
        request.append("Action: QueueSummary\r\n");
        request.append("Queue: ".concat(queueNum).concat("\r\n"));
        request.append("\r\n");
        return this;
    }
}

