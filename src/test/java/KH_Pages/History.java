package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class History {
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver,String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_history_img"))).click();
        String historyLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("History header : "+historyLabel);
        Assert.assertTrue(historyLabel.equals("History"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));

    }
}
