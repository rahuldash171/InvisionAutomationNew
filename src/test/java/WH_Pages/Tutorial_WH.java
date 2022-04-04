package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Tutorial_WH {
    /*
    @author : Rahul Dash
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Tutorial\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }
}
