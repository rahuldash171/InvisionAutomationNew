package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ReturnToADC {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/returns_ADC"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String textADCPopUp = driver.findElementById(packageName+":id/txt_header").getText();
        System.out.println("Return to ADC pop up text : "+textADCPopUp);
        Assert.assertTrue(textADCPopUp.equals("Returns Truck Arriving Today"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.TextView"))).click();
        String footerText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView").getText();
        System.out.println("Return to ADC footer text : "+footerText);
        Assert.assertTrue(footerText.equals("Returns Lane"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/img_back"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));


    }
}
