package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class MarketDashboard_KH {
    /*
    @author : Nikita Gopathi
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver, String packageName) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_dashboard_btn"))).click();
        //String dateToday= driver.findElementById(packageName + ":id/dm_date_txt").getText();
        //checking Market header
        String marketHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard Market header : "+marketHeader);
        Assert.assertTrue(marketHeader.equals("Market"));
        //checking Route header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/route_txt_btn"))).click();
        String routeHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Route header : "+routeHeader);
        Assert.assertTrue(routeHeader.equals("Route"));
        //checking Box header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_txt_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt")));
        String boxHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Box header : "+boxHeader);
        Assert.assertTrue(boxHeader.equals("Box"));
        //checking User header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/user_txt_btn"))).click();
        String userHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard User header : "+userHeader);
        Assert.assertTrue(userHeader.equals("User"));

        //back to home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(khLabel.equals("Keyholder"));

    }
}
