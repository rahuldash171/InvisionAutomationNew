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

    //Launch emulator with desired capabilities
    @BeforeTest
    public void setup() throws MalformedURLException {
        commonTests = new CommonTests();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SM-G996U1");
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
        commonTests.signIntoINVisionS21(wait, driver, "DEN",hdPersona);
        /*
         *Below code will work only if there are any delayed routes for the day
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/popup_element")));
        Boolean popUp = driver.findElementById(packageName + ":id/popup_element").isDisplayed();
        if(popUp)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_back"))).click();

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

    @Test(priority = 2,enabled = false)
    public void boxSearch() throws InterruptedException, MalformedURLException {
        //String RTIDToUseForReturn = commonTests.getGeneratedRTID();
        //boxSearchOrderNumber = CommonTests.orderNumberForReturns;
        //boxSearchSKU = CommonTests.skusForReturns[0];
       /* if(boxSearchOrderNumber == null)
            boxSearchOrderNumber = JOptionPane.showInputDialog("ENTER ORDER NUMBER");
        if(boxSearchSKU == null)
            boxSearchSKU = JOptionPane.showInputDialog("ENTER SKU");*/
        if (!invisionLoaded)
            commonTests.signIntoINVisionS21(wait, driver, "DEN", hdPersona);
    }

    /**
     * Logging out of app
     */
    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException {
        if (!invisionLoaded)
            commonTests.signIntoINVisionS21(wait, driver, "DEN",hdPersona);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();
    }
}
