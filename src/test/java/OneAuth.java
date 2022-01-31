import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
@Test
public class OneAuth
{
    private final String packageName = "com.sleepnumber.invision.stage";

    //declare needed variables
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public void authComplete() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "ce011821cbf838ec0c");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", packageName);
        caps.setCapability("appActivity", "com.sleepnumber.invision.WelcomeActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                packageName+":id/btn_skip"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        Thread.sleep(5000);

        /*wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                "com.sec.android.app.sbrowser:id/option_menu"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"))).click();
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sec.android.app.sbrowser:id/location_bar_edit_text")));
        element.click();
        String browse= element.getText();
        System.out.println(browse);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sec.android.app.sbrowser:id/copy_button"))).click();
        caps.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("platformVersion", "9.0.0");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.dash\\OneDrive - Mahindra & Mahindra Ltd.-55241918-Bristlecone India Pvt Ltd\\Documents\\chromedriver");
        driver.get(browse);
        Thread.sleep(5000);*/
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName:contextNames)
        {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_chrome");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@data-test-id=\"homedeliverysn2021@gmail.com\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//input[@type=\"submit\"]"))).click();
        System.out.println("Done!");
        Thread.sleep(5000);
        driver.context("NATIVE_APP");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/input_locationName")));
        driver.findElementById(packageName+":id/input_locationName").sendKeys("DEN");
        driver.findElementById(packageName+":id/input_userID").sendKeys("abcde");
        driver.findElementById(packageName+":id/proceed_btn").click();

    }

}
