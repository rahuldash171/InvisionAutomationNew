import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonTests {

    private final String packageName = "com.sleepnumber.invision.stage";
    public static AndroidDriver android_driver = null;


    //declare needed variables
    public static final String orderNumberForReturns = "95012058520";
    public static String[] skusForReturns = {"122601", "123673", "125374"};

    public void signIntoINVision(WebDriverWait wait, AndroidDriver driver, String marketLocation) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                packageName+":id/btn_skip"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        Thread.sleep(10000);
       DesiredCapabilities capabilities =new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.BROWSER);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        driver.activateApp("com.sec.android.app.chrome");

        Set<String> contextNames = driver.getContextHandles();
        /*Set contexts = android_driver.getContextHandles();
        for(String contextName : contextNames){
            System.out.println(contextName);}
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        try {
            
            /*driver.context("WEBVIEW_Terrace");
            driver.context((String) contextNames.toArray()[1]);
            System.out.println( "context is :"+driver.getContextHandles().toArray()[1].toString());
            driver.context(driver.getContextHandles().toArray()[1].toString());
            System.out.println(contextNames);
            /*driver.navigate().to("https://login.microsoftonline.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//div[@data-test-id=\"homedeliverysn2021@gmail.com\"]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//input[@type=\"submit\"]"))).click();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        driver.context("NATIVE_APP");*/


        /*Set<String> contextNames = driver.getContextHandles();
        for(String contextName : contextNames){
            System.out.println(contextName);
            try {
                driver.context("WEBVIEW_Terrace");
                //driver.context((String) contextNames.toArray()[1]);
                System.out.println(contextNames);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//div[@data-test-id=\"homedeliverysn2021@gmail.com\"]"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//input[@type=\"submit\"]"))).click();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            driver.context("NATIVE_APP");
        }*/

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/input_locationName")));
        driver.findElementById(packageName+":id/input_locationName").sendKeys(marketLocation);
        driver.findElementById(packageName+":id/input_userID").sendKeys("abcde");
        driver.findElementById(packageName+":id/proceed_btn").click();
    }

    public String getGeneratedRTID() {
        String RTID = "R" + String.valueOf(new Date().getTime());
        return RTID.substring(0, 9);
    }



}
