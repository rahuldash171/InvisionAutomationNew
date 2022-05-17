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
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Market Dashboard\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        //String dateToday= driver.findElementById(packageName + ":id/dm_date_txt").getText();
        //checking Market header
        String marketHeader= driver.findElementById(packageName + ":id/box_search_header_txt").getText();
        System.out.println("Market Dashboard Market header : "+marketHeader);
        Assert.assertEquals(marketHeader,"Market");
        //checking Route header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/route_txt_btn"))).click();
        String routeHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Route header : "+routeHeader);
        Assert.assertEquals(routeHeader,"Route");
        //checking Box header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_txt_btn"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt")));
        String boxHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard Box header : "+boxHeader);
        Assert.assertEquals(boxHeader,"Box");
        //checking User header
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/user_txt_btn"))).click();
        String userHeader= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/box_search_header_txt"))).getText();
        System.out.println("Market Dashboard User header : "+userHeader);
        Assert.assertEquals(userHeader,"User");

        //back to home page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(khLabel.trim().equals("Key Holder"));

    }
}
