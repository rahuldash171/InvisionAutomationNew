package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoadTruck {
    /*
    @author : Rahul Dash
     */

    public void ClickNBack(WebDriverWait wait, AndroidDriver driver ,String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_load_truck_img"))).click();
        String loadTruckLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Load Truck header : " + loadTruckLabel);
        Assert.assertTrue(loadTruckLabel.equals("Load Truck"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));

    }
}