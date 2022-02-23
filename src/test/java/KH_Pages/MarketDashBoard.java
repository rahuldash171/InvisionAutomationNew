package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MarketDashBoard {
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver,String packageName) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_leadership_view_img"))).click();
        String dateToday= driver.findElementById(packageName + ":id/dm_date_txt").getText();
        String marketHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Market header : "+marketHeader);
        Assert.assertTrue(marketHeader.equals("Market"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/route_txt_btn"))).click();
        String routeHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Route header : "+routeHeader);
        Assert.assertTrue(routeHeader.equals("Route"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_txt_btn"))).click();
        String boxHeader=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Box header : "+boxHeader);
        Assert.assertTrue(boxHeader.equals("Box"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/user_txt_btn"))).click();
        String userHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard User header : "+userHeader);
        Assert.assertTrue(userHeader.equals("User"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_delivery_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(hdLabel.equals("Home Delivery"));

    }
}
