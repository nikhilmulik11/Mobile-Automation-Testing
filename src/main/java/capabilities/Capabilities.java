package capabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Capabilities {

    public static AppiumDriver<MobileElement> setupCapabilities() {
        AppiumDriver<MobileElement> driver = null;
        try {
            System.out.println("Initializing capabilities");
            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel4");
            cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            cap.setCapability(MobileCapabilityType.NO_RESET, false);
        //   cap.setCapability(MobileCapabilityType.APP, "C:/Users/Admin/Desktop/Mobile_Automation/Mobile_Automation_Testing/src/main/resources/applications/amazon.apk");

          //Youtube
          //  cap.setCapability("appPackage", "com.google.android.youtube");
          //  cap.setCapability("appActivity", "com.google.android.youtube.HomeActivity");

            // Amazon
              cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
              cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AppiumDriver<MobileElement>(url, cap);
            System.out.println("Application Started..");

        } catch (Exception ex) {
            System.out.println("cause is:" + ex.getCause());
            System.out.println("message is :" + ex.getMessage());
            ex.printStackTrace();
        }
        return driver;
    }
}


