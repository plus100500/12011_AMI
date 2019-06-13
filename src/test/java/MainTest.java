import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bityard.asterisk.AsteriskConnection;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@ContextConfiguration({
        "classpath:spring-app.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

    @Autowired
    private AsteriskConnection asteriskConnection;

    @Test
    public void mainTest() {

        Properties properties = new Properties();
        try {
            properties.load(new FileReader("/home/wellpc/Dropbox/12_Java/12011_AMI/src/test/config/config.conf"));

            asteriskConnection.connect(
                    properties.getProperty("server"),
                    Integer.valueOf(properties.getProperty("portAmi")),
                    properties.getProperty("userAmi"),
                    properties.getProperty("passAmi"),
                    properties.getProperty("events")
            );

//            printList(asteriskConnection.queueSummary("001",true));

//            asteriskConnection.makeCallFromQueue(
//                    properties.getProperty("testPhoneNumber"),
//                    properties.getProperty("testQueueNum"),
//                    properties.getProperty("testPhoneName")
//            );


//            printList(asteriskConnection.coreShowChannels(true));

            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                ++i;
                if (i == 10) {
                    check1();
                    check2();
                    i = 0;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printList(Future<List<AmiObject>> amiObjectFuture) {
        List<AmiObject> amiObjects = null;
        if (amiObjectFuture != null) {
            try {
                amiObjects = amiObjectFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            for (AmiObject amiObject : amiObjects) {
                System.out.println(amiObject.toString());
            }
        }
    }


    public void check1() {
        printList(asteriskConnection.queueSummary("001",true));
    }


    public void check2() {
        printList(asteriskConnection.coreShowChannels(true));
    }
}
