import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.bityard.asterisk.AsteriskConnection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
            properties.load(new FileReader("/home/well/Dropbox/12_Java/12011_AMI/src/test/config/config.conf"));

            asteriskConnection.connect(
                    properties.getProperty("server"),
                    Integer.valueOf(properties.getProperty("portAmi")),
                    properties.getProperty("userAmi"),
                    properties.getProperty("passAmi"),
                    properties.getProperty("events")
            );
            asteriskConnection.makeCallFromQueue(
                    properties.getProperty("testPhoneNumber"),
                    properties.getProperty("queue"),
                    properties.getProperty("testPhoneName")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
