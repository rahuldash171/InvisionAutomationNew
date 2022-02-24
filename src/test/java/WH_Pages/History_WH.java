package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class History_WH {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/history_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String skuTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"SKU\"]/android.widget.TextView"))).getText();
        System.out.println("History-SKU tab header: "+skuTab);
        Assert.assertTrue(skuTab.equals("SKU"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"BOL\"]"))).click();
        String bolTab = driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"BOL\"]/android.widget.TextView").getText();
        System.out.println("History-BOL tab header: "+bolTab);
        Assert.assertTrue(bolTab.equals("BOL"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }
}
