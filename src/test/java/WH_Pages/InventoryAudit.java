package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class InventoryAudit {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {

        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inventory Audit\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String recoveryTab = driver.findElementById(packageName+":id/txt_cycle").getText();
        Assert.assertTrue(recoveryTab.equals("Held for Recovery"));
        String adcTab = driver.findElementById(packageName+":id/txt_ship").getText();
        Assert.assertTrue(adcTab.equals("Return to ADC Lane"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/txt_cycle"))).click();
        String headerTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Inventory audit header: "+headerTab);
        Assert.assertTrue(headerTab.equals("Inventory Audit"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String scrollElement1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inventory Audit\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/txt_ship"))).click();
        String headADC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Return to ADC Lane\"]/android.widget.TextView"))).getText();
        System.out.println("Inventory audit header for Return to ADC: "+headADC);
        Assert.assertTrue(headADC.equals("RETURN TO ADC LANE"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }
}
