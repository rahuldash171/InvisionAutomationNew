package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class InventoryCheck {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/inventory_check_btn"))).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String boxHead= driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Box\"]/android.widget.TextView").getText();
        System.out.println("Inventory check Box header : " + boxHead);
        Assert.assertTrue(boxHead.equals("BOX"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Order\"]"))).click();
        String orderHead= driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Order\"]/android.widget.TextView").getText();
        System.out.println("Inventory check order header : " + orderHead);
        Assert.assertTrue(orderHead.equals("ORDER"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));

    }
}
