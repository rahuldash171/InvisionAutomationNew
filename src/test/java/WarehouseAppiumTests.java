import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WarehouseAppiumTests {

    //declare needed variables
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    private String orderNumb,skuNumb;

    //launch emulator with desired capabilities
    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ce011821cbf838ec0c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.sleepnumber.invision.dev");
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
        new CommonTests().signIntoINVision(wait, driver, "SJC");
    }

    @Test(priority = 0)
    public void logIntoAppAsHomeDeliveryTech() {
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/warehouse_persona_label"))).getText();
        Assert.assertTrue(hdLabel.equals("Warehousing"));
    }

    @Test
    public void testInboundReceipts() {
        driver.findElementById("com.sleepnumber.invision.dev:id/inbound_btn").click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        String inboundLabel= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.TextView"))).getText();
        Assert.assertTrue(inboundLabel.equals("Select Pro/BOL No."));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
             "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.TextView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/ds_download_btn"))).click();
        String signShortbttn= driver.findElementById("com.sleepnumber.invision.dev:id/loadBtn").getText();
        Assert.assertTrue(signShortbttn.equals("SIGN SHORT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ImageView"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "(//android.widget.ImageView[@content-desc=\"Info\"])[1]"))).click();
        MobileElement infoBoxDetails= driver.findElementById("com.sleepnumber.invision.dev:id/popup_element");
        Assert.assertTrue(infoBoxDetails.isDisplayed());
         orderNumb = driver.findElementById("com.sleepnumber.invision.dev:id/bpm_order").getText();
         skuNumb = driver.findElementById("com.sleepnumber.invision.dev:id/bpm_sku").getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/bpm_ok_btn"))).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 2)
    public void boxSearch()
    {
        //new CommonTests().signIntoINVision(wait, driver, "DEN");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/box_search_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/problem_reading_barcode"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/pw_input_orderNum"))).sendKeys(orderNumb);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/pw_input_skuNum"))).sendKeys(skuNumb);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/btn_theiaverify"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/info_ok_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 3)
    public void ReceiveHD(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/returns_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String receiveHDHeader = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        Assert.assertTrue(receiveHDHeader.equals("Receive HD"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/img_back"))).click();
    }

    @Test(priority = 4)
    public void ReturnToADC(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/returns_ADC"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String textADCPopUp = driver.findElementById("com.sleepnumber.invision.dev:id/txt_header").getText();
        Assert.assertTrue(textADCPopUp.equals("Returns Truck Arriving Today"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView"))).click();
        String footerText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
        Assert.assertTrue(footerText.equals("Returns Lane"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"click to slide the drawer up\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/img_back"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/img_back"))).click();
    }

    @Test(priority = 5)
    public void InventoryCheck(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/inventory_check_btn"))).click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        String boxHead= driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Box\"]/android.widget.TextView").getText();
        Assert.assertTrue(boxHead.equals("BOX"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Order\"]"))).click();
        String orderHead= driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Order\"]/android.widget.TextView").getText();
        Assert.assertTrue(orderHead.equals("ORDER"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 6)
    public void Pick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/pickbtn"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String pickHead= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        Assert.assertTrue(pickHead.equals("Pick for Recovery"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/img_back"))).click();
    }

    @Test(priority = 7)
    public void History(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/history_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String skuTab= driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"SKU\"]/android.widget.TextView").getText();
        Assert.assertTrue(skuTab.equals("SKU"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"BOL\"]"))).click();
        String bolTab = driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"BOL\"]/android.widget.TextView").getText();
        Assert.assertTrue(bolTab.equals("BOL"));
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/tutorial_btn"))).click();
        MobileElement historyFAQ = driver.findElementById("com.sleepnumber.invision.dev:id/popup_element");
        Assert.assertTrue(historyFAQ.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/faq_ok_btn"))).click();*/
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 8)
    public void ReportDamage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/report_damage_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/tutorial_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/tutorial_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 9)
    public void InboundReceiptException(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/exception_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        MobileElement exceptionFAQ = driver.findElementById("com.sleepnumber.invision.dev:id/popup_element");
        Assert.assertTrue(exceptionFAQ.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/close_dialog_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();


    }
    @Test(priority = 10)
    public void Tutorial(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/tutorial_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();


    }
    @Test(priority = 11)
    public void InventoryAudit(){
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inventory Audit\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String recoveryTab = driver.findElementById("com.sleepnumber.invision.dev:id/txt_cycle").getText();
        Assert.assertTrue(recoveryTab.equals("Held for Recovery"));
        String adcTab = driver.findElementById("com.sleepnumber.invision.dev:id/txt_ship").getText();
        Assert.assertTrue(adcTab.equals("Ship To ADC Lane"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/txt_cycle"))).click();
        String headerTab = driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Inventory Audit\"]/android.widget.TextView").getText();
        Assert.assertTrue(headerTab.equals("INVENTORY AUDIT"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
        String scrollElement1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inventory Audit\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/txt_ship"))).click();
        String headADC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Ship To ADC Lane\"]/android.widget.TextView"))).getText();
        //String headADC = driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Ship To ADC Lane\"]/android.widget.TextView").getText();
        Assert.assertTrue(headADC.equals("SHIP TO ADC LANE"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/loadBtn"))).click();
        MobileElement missingBox = driver.findElementById("com.sleepnumber.invision.dev:id/popup_element");
        Assert.assertTrue(missingBox.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/sv_btnCancel"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
    }

    @Test(priority = 12)
    public void logOut(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/action_home"))).click();
        String logoutText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        Assert.assertTrue(logoutText.equals("SIGN OUT?"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.sleepnumber.invision.dev:id/btn_yes"))).click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
