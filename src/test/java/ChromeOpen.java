import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class ChromeOpen {
    DesiredCapabilities cap = new DesiredCapabilities();
    public AndroidDriver<MobileElement> driver;

    public WebDriverWait wait;
    public void Authentication(String url) throws MalformedURLException, InterruptedException {

        cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability("deviceName", "ce011821cbf838ec0c");
        cap.setCapability("platformVersion", "9.0.0");
        cap.setCapability("platformName", "Android");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.dash\\OneDrive - Mahindra & Mahindra Ltd.-55241918-Bristlecone India Pvt Ltd\\Documents\\chromedriver");
        Thread.sleep(5000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, 300);
        Thread.sleep(5000);
        driver.get(url);
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName:contextNames)
        {
            System.out.println(contextName);
        }
        driver.context("CHROMIUM");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"email\"]"))).sendKeys("homedeliverysn2021@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"submit\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"passwd\"]"))).sendKeys("HomeDelivery");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"submit\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=\"submit\"]"))).click();
        System.out.println("Done!");
        Thread.sleep(5000);
        driver.context("NATIVE_APP");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
        //"com.sleepnumber.invision.WelcomeActivity:id/input_locationName")));
        driver.findElementById("com.sleepnumber.invision.WelcomeActivity:id/input_locationName").sendKeys("DEN");
        driver.findElementById("com.sleepnumber.invision.WelcomeActivity:id/input_userID").sendKeys("abcde");
        driver.findElementById("com.sleepnumber.invision.WelcomeActivity:id/proceed_btn").click();

    }
    public void SamsungAuth() throws MalformedURLException, InterruptedException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                "com.sec.android.app.sbrowser:id/option_menu"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"))).click();
        Thread.sleep(5000);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sec.android.app.sbrowser:id/location_bar_edit_text")));
        element.click();
        String browse= element.getText();
        System.out.println(browse);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.sec.android.app.sbrowser:id/copy_button"))).click();
        Authentication(browse);



           /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//div[@data-test-id=\"homedeliverysn2021@gmail.com\"]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//input[@type=\"submit\"]"))).click();*/

    }
}
