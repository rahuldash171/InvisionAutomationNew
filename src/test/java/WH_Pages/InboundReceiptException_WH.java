package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class InboundReceiptException_WH {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/exception_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement exceptionFAQ = driver.findElementById(packageName+":id/popup_element");
        Assert.assertTrue(exceptionFAQ.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/close_dialog_btn"))).click();
        String InboundexceptionHeader = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView").getText();
        System.out.println("Inbound exception header : "+InboundexceptionHeader);
        Assert.assertTrue(InboundexceptionHeader.equals("Exception"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }
}
