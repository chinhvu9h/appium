import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class TestBase {
    static AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup() {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sdk_gphone_x86");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            URL url = new URL("http://192.168.1.100:4723/wd/hub") ;

            driver = new AppiumDriver<MobileElement>(url, caps);
            driver.get("https://www.youtube.com/");
            driver.get("http://appium.io/");


            System.out.println("Before class");
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void sampleTest() {
        System.out.println("Inside test");

    }

    @AfterTest
    public void teardown() {
        System.out.println("After class");
    }
}
