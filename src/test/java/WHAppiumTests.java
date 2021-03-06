import WH_Pages.*;
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

public class WHAppiumTests {
        /*
        @author : Rahul Dash, Nikita Gopathi
         */
    //declare needed constants
    private final String packageName = "com.sleepnumber.invision.stage";
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public CommonTests commonTests;
    private String orderNumb,skuNumb;
    private boolean invisionLoaded;
    private String whPersona = "warehouseddcsn2021@gmail.com";
    private String whUser ="WHAutomationUser";

    //Launch emulator with desired capabilities
    @BeforeTest
    public void setup() throws MalformedURLException {
        commonTests = new CommonTests();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "SM-G996U1");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logging into Warehouse persona and checking Persona label
     */
    @Test(priority = 0)
    public void logIntoAppAsWarehouseTech() throws InterruptedException, MalformedURLException{
        commonTests.signIntoINVisionS21(wait,driver,"SJC",whPersona,whUser);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        /*--Inventory Audit required popup code */
        try
        {
            if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName+":id/label_inventory_audit"))).isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + "btn_no_go_back"))).click();
                System.out.println("Inventory Audit popup is displayed and closed");
            }
        }
        catch (Exception p)
        {
            System.out.println("No Inventory Audit popup Available");
        }

        /*--Release Notes popup code */
        try
        {
            while(driver.findElementById(packageName+":id/btn_next").isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/btn_next"))).click();
            }
        }
        catch (Exception p)
        {
            System.out.println("No Release Notes Available");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(whLabel.trim().equals("Warehouse"));
        invisionLoaded = true;
    }


    @Test(priority = 1, enabled = false)
    public void WHSanity() throws InterruptedException, MalformedURLException {

        new InboundReceipts_WH().ClickNBack(wait, driver ,packageName);
        new BoxSearch_WH().ClickNBack(wait, driver ,packageName);
        new ReceiveHD_WH().ClickNBack(wait, driver ,packageName);
        new ReturnToADC_WH().ClickNBack(wait, driver, packageName);
        new InventoryCheck_WH().ClickNBack(wait, driver ,packageName);
        new Pick_WH().ClickNBack(wait, driver, packageName);
        new History_WH().ClickNBack(wait, driver, packageName);
        new ReportDamage_WH().ClickNBack(wait, driver, packageName);
        new InboundReceiptException_WH().ClickNBack(wait, driver, packageName);
        new Tutorial_WH().ClickNBack(wait, driver, packageName);
        new InventoryAudit_WH().ClickNBack(wait, driver, packageName);
        new Feedback_WH().ClickNBack(wait, driver, packageName);
    }

    @Test(priority = 2, enabled = false)
    public void WHBoxSearch() throws InterruptedException, MalformedURLException {

        new BoxSearch_WH().ClickNBack(wait, driver ,packageName);
        new BoxSearch_WH().enterBSTile(wait, driver ,packageName);
        new BoxSearch_WH().flashOnOff(wait, driver ,packageName);
        new BoxSearch_WH().scanGunOnOff(wait, driver ,packageName);
        //validating invalid and valid - Order and SKU
        new BoxSearch_WH().manualEntry(wait, driver ,packageName);
        new BoxSearch_WH().enterOrderSKU(wait, driver ,packageName,"84784777777","355426");
        new BoxSearch_WH().validateEnterBarcodes(wait, driver ,packageName);

        new BoxSearch_WH().enterOrderSKU(wait, driver ,packageName,"95013152741","122025");
        new BoxSearch_WH().prodDetails(wait, driver ,packageName);

        //validating invalid and valid - RTID
        new BoxSearch_WH().manualEntry(wait, driver ,packageName);
        new BoxSearch_WH().enterRTID(wait, driver ,packageName,"343298888");
        new BoxSearch_WH().validateEnterBarcodes(wait, driver ,packageName);
        new BoxSearch_WH().enterRTID(wait, driver ,packageName,"R88879750");
        new BoxSearch_WH().prodDetails(wait, driver ,packageName);

        new BoxSearch_WH().backToWHHome(wait, driver ,packageName);
    }

    @Test(priority = 3,dependsOnMethods = "logIntoAppAsWarehouseTech", enabled = false)
    public void InboundReceiptException()
    {
        new InboundReceiptException_WH().ManualEntryboxTest_OrderSKU(wait,driver,packageName);
        new InboundReceiptException_WH().EmptyEntries(wait,driver,packageName);
        new InboundReceiptException_WH().InvalidEntries(wait,driver,packageName);
        new InboundReceiptException_WH().ScanGun(wait,driver,packageName);
        new InboundReceiptException_WH().Flashbutton(wait,driver,packageName);
        new InboundReceiptException_WH().FAQ(wait,driver,packageName);
    }

    @Test(priority = 4)
    public void WHFeedback() throws InterruptedException, MalformedURLException {

        new Feedback_WH().ClickNBack(wait, driver ,packageName);
        new Feedback_WH().NetworkConnectivityFeedback(wait, driver ,packageName);
        new Feedback_WH().DataAccuracyFeedback(wait, driver ,packageName);
        new Feedback_WH().AppExperienceFeedback(wait, driver ,packageName);
        new Feedback_WH().MobileDeviceFeedback(wait, driver ,packageName);
        new Feedback_WH().EmptyFeedback(wait, driver ,packageName);
        new Feedback_WH().backToWHHome(wait, driver ,packageName);

    }

    /**
     * Logging out of app
     */
    @AfterTest
    public void logOut() throws InterruptedException, MalformedURLException{
        if (!invisionLoaded)
            commonTests.signIntoINVisionS21(wait, driver, "SJC",whPersona,whUser);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String logoutText=driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView").getText();
        System.out.println(logoutText);
        Assert.assertEquals(logoutText,"SIGN OUT?");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/btn_yes"))).click();
        driver.quit();
    }
}
