import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HD_Pages.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HDAppiumTests {

    //declare needed constants
    private final String packageName = "com.sleepnumber.invision.stage";
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public CommonTests commonTests;
    private String boxSearchOrderNumber, boxSearchSKU;
    private boolean invisionLoaded;
    private String hdPersona = "homedeliverysn2021@gmail.com";
    private String hdUser ="HDAutomationUser";

    //Launch emulator with desired capabilities
    @BeforeTest
    public void setup() throws MalformedURLException {
        commonTests = new CommonTests();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ce011821cbf838ec0c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 500);
    }

    /**
     * Logging into Home Delivery persona and checking Persona label
     */
    @Test(priority = 0)
    public void logIntoAppAsHomeDeliveryTech() throws InterruptedException, MalformedURLException {
        commonTests.signIntoINVision(wait, driver, "DEN",hdPersona,hdUser);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /* ---Delay Routes popup code --*/
            try
            {
               if(driver.findElementById(packageName+":id/popup_element").isDisplayed())
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName+":id/btn_back"))).click();
               else
               {
                   System.out.println("No Routes available");
               }

            }   // try
            catch (Exception e)
            {
                System.out.println("Exception "+e);
            }   // catch
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
        invisionLoaded = true;
    }

    @Test(priority = 1)
    public void HDSanity() {

        new LoadTruck().ClickNBack(wait, driver ,packageName);
        new BoxSearch().ClickNBack(wait, driver, packageName);
        new Returns().ClickNBack(wait, driver, packageName);
        new AllMarketQR().ClickNBack(wait, driver, packageName);
        new ReportDamage().ClickNBack(wait, driver, packageName);
        new ReportWrong().ClickNBack(wait, driver, packageName);
        new ReportMissing().ClickNBack(wait, driver, packageName);
        new History().ClickNBack(wait, driver, packageName);
        new MarketDashBoard().ClickNBack(wait, driver, packageName);
        new LTException().ClickNBack(wait, driver, packageName);
        new Feedback().ClickNBack(wait, driver, packageName);
    }

    /**
     * Logging out of app
     */
    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        System.out.println("Logout successful:"+ logoutText);
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();
        driver.quit();
    }
}
