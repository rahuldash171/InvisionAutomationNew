import KH_Pages.*;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KHAppiumTests {
    /*
    @author : Nikita Gopathi
     */

    //declare needed constants
    private final String packageName = "com.sleepnumber.invision.stage";
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public CommonTests commonTests;
    private String boxSearchOrderNumber, boxSearchSKU;
    private boolean invisionLoaded;
    private String khPersona = "keyholdersn2021@gmail.com";
    private String khUser ="KHAutomationUser";

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
        wait = new WebDriverWait(driver, 300);
    }

    /**
     * Logging into Key Holder persona and checking Persona label
     */
    @Test(priority = 0)
    public void logIntoAppAsKHTech() throws InterruptedException, MalformedURLException {
        commonTests.signIntoINVision(wait, driver, "PVD", khPersona,khUser);
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        Assert.assertTrue(khLabel.equals("Keyholder"));
        invisionLoaded = true;
    }

    @Test(priority = 1 , enabled = false)
    public void KHSanity() throws InterruptedException, MalformedURLException
    {
        new ReceiveRecovery_KH().ClickNBack(wait, driver ,packageName);
        new Pick_KH().ClickNBack(wait, driver ,packageName);
        new InventoryAudit_KH().ClickNBack(wait, driver ,packageName);
        new BoxSearch_KH().ClickNBack(wait, driver, packageName);
        new LoadTruck_KH().ClickNBack(wait, driver ,packageName);
        new Returns_KH().ClickNBack(wait, driver, packageName);
        new ReportDamage_KH().ClickNBack(wait, driver, packageName);
        new History_KH().ClickNBack(wait, driver, packageName);
        new LoadTruckException_KH().ClickNBack(wait, driver, packageName);
        new MarketDashboard_KH().ClickNBack(wait, driver, packageName);
        new AllMarketReturnsQRCodes_KH().ClickNBack(wait, driver, packageName);
        new Feedback_KH().ClickNBack(wait, driver, packageName);
    }

    @Test(priority = 2 , dependsOnMethods = "logIntoAppAsKHTech" ,enabled = false)
    public void BoxSearchModule()
    {
        new BoxSearch_KH().ManualEntryboxTest_OrderSKU(wait,driver,packageName);
        new BoxSearch_KH().ManualEntryboxTest_RTID(wait,driver,packageName);
        new BoxSearch_KH().EmptyEntries(wait,driver,packageName);
        new BoxSearch_KH().InvalidEntries(wait,driver,packageName);
        new BoxSearch_KH().Flashbutton(wait,driver,packageName);
        new BoxSearch_KH().ScanGun(wait,driver,packageName);
    }

    @Test(priority = 3,dependsOnMethods = "logIntoAppAsKHTech")
    public void LoadTruckException()
    {
        new LoadTruckException_KH().ManualEntryboxTest_OrderSKU(wait,driver,packageName);
        new LoadTruckException_KH().EmptyEntries(wait,driver,packageName);
        new LoadTruckException_KH().InvalidEntries(wait,driver,packageName);
        new LoadTruckException_KH().ScanGun(wait,driver,packageName);
        new LoadTruckException_KH().Flashbutton(wait,driver,packageName);
        new LoadTruckException_KH().FAQ(wait,driver,packageName);
    }

    /**
     * Logging out of app
     */
    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException {
        if (!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "PVD", khPersona,khUser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        System.out.println(logoutText);
        Assert.assertEquals(logoutText,"SIGN OUT?");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();
        driver.quit();

    }
}
