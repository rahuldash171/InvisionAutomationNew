package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AllMarketQR {
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver,String packageName) {
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
}
