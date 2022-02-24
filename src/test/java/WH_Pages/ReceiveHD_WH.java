package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class ReceiveHD_WH {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/returns_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String receiveHDHeader = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        System.out.println("ReceiveHD header : "+receiveHDHeader);
        Assert.assertTrue(receiveHDHeader.equals("Receive HD"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/img_back"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }
}
