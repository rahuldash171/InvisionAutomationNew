package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class InboundReceipts_WH {
    /*
    @author : Rahul Dash
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        driver.findElementById(packageName+":id/inbound_btn").click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String inboundLabel= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Inbound header : " + inboundLabel);
        Assert.assertTrue(inboundLabel.equals("Download Manifest"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/img_back"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(whLabel.trim().equals("Warehouse"));

    }
}
