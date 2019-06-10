import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bityard.asterisk.AsteriskConnection;
import ru.bityard.asterisk.pkg.amiObjects.AmiObject;
import ru.bityard.asterisk.pkg.amiObjects.response.CoreShowChannel;

import java.io.FileReader;
import java.io.IOException;
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

            asteriskConnection.queueSummary("001");

            asteriskConnection.makeCallFromQueue(
                    properties.getProperty("testPhoneNumber"),
                    properties.getProperty("testQueueNum"),
                    properties.getProperty("testPhoneName")
            );

            AmiObject amiObject = null;
            Future<AmiObject> amiObjectFuture = asteriskConnection.coreShowChannels(true);
            if (amiObjectFuture != null) {
                try {
                    amiObject = amiObjectFuture.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(((CoreShowChannel) amiObject).toString());
            }

                Thread thread = new Thread();
                thread.start();
                while (!thread.isInterrupted()) {
                    // do nothing
                }


            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
