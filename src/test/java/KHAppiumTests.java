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
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class KHAppiumTests {

    //declare needed constants
    private final String packageName = "com.sleepnumber.invision.stage";

    //declare needed variables
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public CommonTests commonTests;
    private String boxSearchOrderNumber, boxSearchSKU;
    private boolean invisionLoaded;

    //launch emulator with desired capabilities
    @BeforeTest
    public void setup() throws MalformedURLException {
        commonTests = new CommonTests();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SM-G996U1");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 300);
    }

    @Test
    public void logIntoAppAsKHTech() throws InterruptedException, MalformedURLException {
        commonTests.signIntoINVisionS21(wait, driver, "PVD");
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        Assert.assertTrue(khLabel.equals("Keyholder"));
        //System.out.println("On KH home page");
        invisionLoaded = true;
    }

    @Test(priority = 1)
    public void KHSanity() throws InterruptedException, MalformedURLException {
        Thread.sleep(5000);
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
        //new AllMarketReturnsQRCodes_KH().ClickNBack(wait, driver, packageName);

    }

    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException {
        if (!invisionLoaded)
            commonTests.signIntoINVisionS21(wait, driver, "PVD");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();

    }
}
