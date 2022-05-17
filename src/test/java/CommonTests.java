import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Set;

public class CommonTests {

    //declare needed variables
    private final String packageName = "com.sleepnumber.invision.stage";
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;
    public static final String orderNumberForReturns = "95012058520";
    public static String[] skusForReturns = {"122601", "123673", "125374"};

    public void signIntoINVision(WebDriverWait wait, AndroidDriver driver, String marketLocation, String persona,String user) throws InterruptedException, MalformedURLException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                packageName+":id/btn_skip"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.packageinstaller:id/permission_allow_button"))).click();
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName:contextNames)
        {
            System.out.println(contextName);
        }
        Thread.sleep(5000);
        driver.context("WEBVIEW_chrome");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@data-test-id=\""+persona+"\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//input[@type=\"submit\"]"))).click();
        System.out.println("MS Auth Successful!");
        Thread.sleep(6000);
        driver.context("NATIVE_APP");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/input_locationName")));
        driver.findElementById(packageName+":id/input_locationName").sendKeys(marketLocation);
        driver.findElementById(packageName+":id/input_userID").sendKeys(user);
        driver.findElementById(packageName+":id/proceed_btn").click();
    }

    public void signIntoINVisionS21(WebDriverWait wait, AndroidDriver driver, String marketLocation, String persona, String user) throws InterruptedException, MalformedURLException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById(
                packageName+":id/btn_skip"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.permissioncontroller:id/permission_allow_foreground_only_button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                "com.android.permissioncontroller:id/permission_allow_button"))).click();
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName:contextNames)
        {
            System.out.println(contextName);
        }
        Thread.sleep(5000);
        driver.context("WEBVIEW_chrome");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//div[@data-test-id=\""+persona+"\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//input[@type=\"submit\"]"))).click();
        System.out.println("MS Auth Successful!");
        Thread.sleep(5000);
        driver.context("NATIVE_APP");

        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/input_locationName")));
        driver.findElementById(packageName+":id/input_locationName").sendKeys(marketLocation);
        driver.findElementById(packageName+":id/input_userID").sendKeys(user);
        driver.findElementById(packageName+":id/proceed_btn").click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName+":id/tv_header_title")));
    }

    public String getGeneratedRTID() {
        String RTID = "R" + String.valueOf(new Date().getTime());
        return RTID.substring(0, 9);
    }


}
