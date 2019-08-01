import org.junit.Test;
import ru.bityard.asterisk.AsteriskConnection;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainTest {

    private AsteriskConnection asteriskConnection;

    @Test
    public void mainTest() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("/home/wellpc/Dropbox/12_Java/12011_AMI/src/test/config/config.conf"));

            asteriskConnection = new AsteriskConnection(
                    properties.getProperty("server"),
                    Integer.valueOf(properties.getProperty("portAmi")),
                    properties.getProperty("userAmi"),
                    properties.getProperty("passAmi"),
                    properties.getProperty("events")
            );
            Thread thread = new Thread(asteriskConnection);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

//            asteriskConnection.checkConnect();
//            printList(asteriskConnection.queueSummary("001",true));

//            asteriskConnection.makeCallFromQueue(
//                    properties.getProperty("testPhoneNumber"),
//                    properties.getProperty("testQueueNum"),
//                    properties.getProperty("testPhoneName")
//            );


//            printList(asteriskConnection.coreShowChannels(true));

            List<Thread> threadList = new ArrayList<>();

//            printList(asteriskConnection.command("database show BLACKLIST", true));
//            printList(asteriskConnection.coreShowChannels(true));

//            int i = 0;
//            while(i<100) {
//                printList(asteriskConnection.queueSummary("001", true));
//                printList(asteriskConnection.coreShowChannels(true));
//                printList(asteriskConnection.queueSummary("001", true));
//                printList(asteriskConnection.coreShowChannels(true));
//                ++i;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void printList(Future<List<AmiObject>> amiObjectFuture) {

        List<AmiObject> amiObjects = null;
        if (amiObjectFuture != null) {
            try {
                System.out.println(amiObjectFuture.hashCode());
                while (!amiObjectFuture.isDone()) {
                    synchronized (this) {
                        this.wait(100);
                    }
                }

                amiObjects = amiObjectFuture.get(3500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }

            if (amiObjects != null) {
                for (AmiObject amiObject : amiObjects) {
                    System.out.println(amiObject.toString());
                }
            } else {
                System.out.println("AmiObjects is null");
            }
        }
    }
}
