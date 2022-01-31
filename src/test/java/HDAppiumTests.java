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
        caps.setCapability("deviceName", "ce011821cbf838ec0c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 300);
    }

    @Test
    public void logIntoAppAsHomeDeliveryTech() throws InterruptedException, MalformedURLException {
        commonTests.signIntoINVision(wait, driver, "MSP");
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
        invisionLoaded = true;
    }

    @Test (priority = 1)
    public void loadTruck() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
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
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

    @Test(priority = 2)
    public void boxSearch() throws InterruptedException, MalformedURLException {
        //String RTIDToUseForReturn = commonTests.getGeneratedRTID();
        //boxSearchOrderNumber = CommonTests.orderNumberForReturns;
        //boxSearchSKU = CommonTests.skusForReturns[0];
       /* if(boxSearchOrderNumber == null)
            boxSearchOrderNumber = JOptionPane.showInputDialog("ENTER ORDER NUMBER");
        if(boxSearchSKU == null)
            boxSearchSKU = JOptionPane.showInputDialog("ENTER SKU");*/
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
        String boxSearchLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView"))).getText();
        System.out.println("Box Search header : "+boxSearchLabel);
        Assert.assertTrue(boxSearchLabel.equals("Box Search"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        //TODO - PUT IN WHAT YOU ARE TRYING TO VALIDATE HERE
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

    @Test(priority = 3)
    public void allMarketQrcode() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.ImageView[@content-desc=\"Scan QR code\"]"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String headerText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        System.out.println("All market QRcode header : "+headerText);
        Assert.assertTrue(headerText.equals("All Market Returns QR Codes"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

    @Test(priority = 4)
    public void history() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_history_img"))).click();
        String historyLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("History header : "+historyLabel);
        Assert.assertTrue(historyLabel.equals("History"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

   @Test(priority = 7)
    public void reportDamage() throws InterruptedException, MalformedURLException {
       if(!invisionLoaded)
           commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/report_damage_img"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/damage_selection"))).click();
        String reportDmgLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
               "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Report Damage header : "+reportDmgLabel);
        Assert.assertTrue(reportDmgLabel.equals("Report Damage"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

    @Test(priority = 8)
    public void returnsModule() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_returns_img"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        MobileElement rqPopup=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout");
        Assert.assertTrue(rqPopup.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/dialog_open_return_queue_no_button"))).click();
        String returnHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]"))).getText();
        System.out.println("Returns header : "+returnHeader);
        Assert.assertTrue(returnHeader.equals("Returns"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));

    }

    @Test(priority = 6)
    public void marketDashboard() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_leadership_view_img"))).click();
        String dateToday= driver.findElementById(packageName + ":id/dm_date_txt").getText();
        String marketHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard Market header : "+marketHeader);
        Assert.assertTrue(marketHeader.equals("Market"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/route_txt_btn"))).click();
        String routeHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard Route header : "+routeHeader);
        Assert.assertTrue(routeHeader.equals("Route"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_txt_btn"))).click();
        String boxHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard Box header : "+boxHeader);
        Assert.assertTrue(boxHeader.equals("Box"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/user_txt_btn"))).click();
        String userHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard User header : "+userHeader);
        Assert.assertTrue(userHeader.equals("User"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));

    }

    @Test(priority = 5)
    public void loadtruckException() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_exception_img"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String exceptionLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Load Truck Exception header : "+exceptionLabel);
        Assert.assertTrue(exceptionLabel.equals("Load Truck Exception"));
        String footerText=driver.findElementById(packageName + ":id/dept_img").getText();
        Assert.assertTrue(footerText.equals("Route"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));
    }

    @Test(priority = 9)
    public void logOut() throws InterruptedException, MalformedURLException {
        if(!invisionLoaded)
            commonTests.signIntoINVision(wait, driver, "DEN");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String logoutText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/btn_yes"))).click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
