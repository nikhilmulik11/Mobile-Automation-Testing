package stepDefinations;

import capabilities.Capabilities;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;


public class steps {

    public void scroll() {
        Dimension size = steps.driver.manage().window().getSize();
        Point midPoint = new Point((int)(size.width*0.5), (int)(size.height * 0.5));
        int bottom = midPoint.x + (int) (midPoint.x *0.75);
        int top = midPoint.x - (int) (midPoint.x * 0.75);
        Point Start = new Point(midPoint.x, bottom);
        Point End = new Point(midPoint.x, top);
        swipe (Start, End, Duration.ofMillis(100));}

        public void swipe(Point start, Point end, Duration duration) {
            PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(input, 0);
            swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
            swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            (steps.driver).perform(ImmutableList.of(swipe));
        }




//        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        var start = new Point(568, 1891);
//        var end = new Point (547, 451);
//        var swipe = new Sequence(finger, 1);
//  //      swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
//                PointerInput.Origin.viewport(), end.getX(), end.getY()));
// //       swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(swipe));




    private static final Logger log = LogManager.getLogger(steps.class);
    static AppiumDriver<MobileElement> driver;
    @Given("User launches amazon application")
    public void user_launches_amazon_application() throws InterruptedException {
         driver = Capabilities.setupCapabilities();
         Thread.sleep(3000);
         log.info("Launching amazon application");
//        MobileElement notification = driver.findElementByXPath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_button']");
//         if(notification.isDisplayed()){
//             notification.click();
//             log.info("Notification is accepted");
//         }else {
//             log.info("Notification is not present");
//         }
    }
    @And("User clicks on Skip_Sign_in")
    public void userClicksOnSkip_Sign_in() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/skip_sign_in_button']")));
        MobileElement one = driver.findElementByXPath("//*[@resource-id='com.amazon.mShop.android.shopping:id/skip_sign_in_button']");
        one.click();
        log.info("We have skipped sign-in");
    }
    @When("User enter {string} in the search bar")
    public void user_enter_in_the_search_bar(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_search_hint_view']")));
        MobileElement search = driver.findElementByXPath("//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_search_hint_view']");
        search.click();

        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")));
        MobileElement search1 = driver.findElementByXPath("//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']");
        search1.sendKeys("iPhone15 pro max");
    }

    @When("User clicks on search button")
    public void user_clicks_on_search_button() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Search_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_action_bar_search_icon']")));
        MobileElement button = driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/chrome_action_bar_search_icon']");
        button.click();
        log.info("We have clicked on Search Button");
    }
    @Then("User should see a list of search results related to {string}")
    public void user_should_see_a_list_of_search_results_related_to(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='iphone 15 pro max']")));
        MobileElement display = driver.findElementByXPath("//android.widget.Button[@text='iphone 15 pro max']");
        display.isDisplayed();
    }
    @And("User taps on the first search result")
    public void the_user_taps_on_the_first_search_result() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='iphone 15 pro max']")));
        MobileElement tap = driver.findElementByXPath("//android.widget.Button[@text='iphone 15 pro max']");
        tap.click();
    }

    @And("User clicks on Add to cart")
    public void user_clicks_on_add_to_cart() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Button[@text=\"Add to cart\"])[1]")));
        MobileElement cart = driver.findElementByXPath("(//android.widget.Button[@text=\"Add to cart\"])[1]");
        scroll();
        if (cart.isDisplayed()) {
            cart.click();
        }else{
            MobileElement element2 = driver.findElementByXPath("(//android.widget.TextView[@text='See options'])[2]");
            element2.click();
            MobileElement element3 = driver.findElementByXPath("//android.view.View[@content-desc='See All Buying Options']");
            element3.click();
        }
    }
    @Then("User clicks on View shopping cart")
    public void user_clicks_on_view_shopping_cart() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/bottom_tab_button_icon'])[3]")));
        MobileElement Shopping_cart = driver.findElementByXPath("(//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/bottom_tab_button_icon'])[3]");
        Shopping_cart.click();
    }

// Amazon Medicare feature steps

    @Given("User launches application")
    public void user_launches_application() throws InterruptedException {
            driver = Capabilities.setupCapabilities();
            Thread.sleep(3000);
            log.info("Launching amazon application");
    }
    @And("User selects location")
    public void user_selects_location() {
        WebDriverWait wait = new WebDriverWait(driver, 17);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.amazon.mShop.android.shopping:id/chrome_search_hint_view']")));
        MobileElement two = driver.findElementById("com.amazon.mShop.android.shopping:id/glow_subnav_label");
        two.click();
        log.info("location is clicked");
    }
    @And("User enters zipcode")
    public void user_enters_zipcode() {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Enter a US zip code']")));
        MobileElement three = driver.findElementByXPath("//android.widget.TextView[@text='Enter a US zip code']");
        three.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Enter a US zip code']")));
        MobileElement four = driver.findElementByXPath("//android.widget.EditText[@text='Enter a US zip code']");
        four.sendKeys("20024");
        log.info("entered pin 20024");
    }
    @And("User clicks on Apply")
    public void user_clicks_on_apply() {
        WebDriverWait wait = new WebDriverWait(driver, 17);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Apply']")));
        MobileElement five = driver.findElementByXPath("//android.widget.TextView[@text='Apply']");
        five.click();
        log.info("location is applied");
    }
    @And("User clicks on MedicalCare")
    public void user_clicks_on_medical_care() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Medical Care']")));
        MobileElement Medical_Care = driver.findElementByXPath("//android.widget.TextView[@text='Medical Care']");
        Medical_Care.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView)[3]")));
        MobileElement clinic = driver.findElementByXPath("(//android.widget.ImageView)[3]");
        clinic.click();
    }
    @And("User clicks treatment")
    public void user_clicks_treatment() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sign in for the best experience\"]")));
        MobileElement treatment = driver.findElementByXPath("//android.widget.TextView[@text=\"Sign in for the best experience\"]");
        treatment.click();
//        String ScrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Dandruff\"))";
//        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(ScrollElement)));
//        driver.findElement(MobileBy.AndroidUIAutomator(ScrollElement)).click();
    }
    @And("User selects the city")
    public void user_selects_the_city() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='input-loader']")));
        MobileElement arrow = driver.findElementByXPath("//*[@resource-id='input-loader']");
        arrow.click();

        String ScrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Washington\"))";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(ScrollElement)));
        driver.findElement(MobileBy.AndroidUIAutomator(ScrollElement)).click();

    }
    @And("User selects the message")
    public void user_selects_the_message() {
        for (int i = 0; i < 1; i++) {
            scroll();
            // Optionally, you can add a delay between swipes if needed
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Message Only']")));
        MobileElement Message_Only = driver.findElementByXPath("//android.widget.TextView[@text='Message Only']");
        Message_Only.click();
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView)[1]")));
        MobileElement alpha = driver.findElementByXPath("(//android.widget.TextView)[1]");
        alpha.click();
    }
    @And("User clicks on GetStarted")
    public void user_clicks_on_get_started() {
        for (int i = 0; i < 1; i++) {
            scroll();
            // Optionally, you can add a delay between swipes if needed
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text='Get started']")));
        MobileElement Message_Only = driver.findElementByXPath("//android.widget.Button[@text='Get started']");
        Message_Only.click();
    }
    @Then("User verify presence of Sign_in_Page")
    public void user_verify_presence_of_sign_in_page() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Sign up\"]")));
        MobileElement Sign_in = driver.findElementByXPath("//android.view.View[@content-desc=\"Sign up\"]");
        Sign_in.isDisplayed();
    }

// Youtube

    @And("User clicks on Allow")
    public void userClicksOnAllow() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.permissioncontroller:id/permission_allow_button")));
        MobileElement Allow = driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        Allow.click();
    }

    @And("User clicked on Search")
    public void userClickedOnSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Search']")));
        MobileElement Search = driver.findElementByXPath("//android.widget.ImageView[@content-desc='Search']");
        Search.click();
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.youtube:id/search_edit_text")));
        MobileElement Search2 = driver.findElementById("com.google.android.youtube:id/search_edit_text");
        Search2.click();
        Search2.sendKeys("testing automation");
    }

    @And("User click on mobile_automation")
    public void userClickOnMobile_automation() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='testing automation']")));
        MobileElement mobile_automation = driver.findElementByXPath("//android.widget.TextView[@text='testing automation']");
        mobile_automation.click();
    }

    @And("User clicks on short")
    public void userClicksOnShort() {
        for (int i = 0; i < 2; i++) {
            scroll();
            // Optionally, you can add a delay between swipes if needed
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Visit site\"]")));
        MobileElement inShort = driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Visit site\"]");
        inShort.isDisplayed();
        Point x = new Point(900, 500);
        Point y = new Point(72, 500);
        for (int i = 0; i < 3; i++) {
            swipe(x, y, Duration.ofSeconds(1));
            // Optionally, you can add a delay between swipes if needed
            try {
                Thread.sleep(1000); // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
