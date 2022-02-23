import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HDAppiumTests {

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
        wait = new WebDriverWait(driver, 500);
    }

    @Test
    public void logIntoAppAsHomeDeliveryTech() throws InterruptedException, MalformedURLException {
        commonTests.signIntoINVision(wait, driver, "MSP");
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
        invisionLoaded = true;
    }

    @Test(priority = 1)
    public void HDSanity() throws InterruptedException, MalformedURLException {

        new LoadTruck().ClickNBack(wait, driver ,packageName);
        new BoxSearch().ClickNBack(wait, driver, packageName);
        new AllMarketQR().ClickNBack(wait, driver, packageName);
        new History().ClickNBack(wait, driver, packageName);
        new LTException().ClickNBack(wait, driver, packageName);
        new MarketDashBoard().ClickNBack(wait, driver, packageName);
        new ReportDmg().ClickNBack(wait, driver, packageName);
        new Returns().ClickNBack(wait, driver, packageName);



        /*if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_load_truck_img"))).click();
        String loadTruckLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Load Truck header : "+loadTruckLabel);
        Assert.assertTrue(loadTruckLabel.equals("Load Truck"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));*/
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
            commonTests.signIntoINVision(wait, driver, "DEN");
    }

    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException {
        if (!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();

    }
}
