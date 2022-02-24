package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoadTruckException_KH {
    /*
    @author : Nikita Gopathi
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver, String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_exception_btn"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String exceptionLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView"))).getText();
        System.out.println("Load Truck Exception header : "+exceptionLabel);
        Assert.assertTrue(exceptionLabel.equals("Load Truck Exception"));
        String footerText=driver.findElementById(packageName + ":id/dept_img").getText();
        Assert.assertTrue(footerText.equals("Route"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(khLabel.equals("Keyholder"));
    }
}
