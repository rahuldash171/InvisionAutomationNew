package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AllMarketReturnsQRCodes_KH {
    /*
    @author : Nikita Gopathi ,Rahul Dash
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver, String packageName) {

        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"All Market Returns\").instance(0))";
        //driver.findElementByAndroidUIAutomator(scrollElement).click();

        String ele = driver.findElementByAndroidUIAutomator(scrollElement).getText();
        System.out.println("scroll ele is - "+ele);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/all_market_qr_code"))).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String headerText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        System.out.println("All market QR codes header : "+headerText);
        Assert.assertEquals(headerText,"All Market Returns QR Codes");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(khLabel.trim().equals("Key Holder"));
    }

    public void openQRCode(WebDriverWait wait, AndroidDriver driver , String packageName){
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"All Market Returns\").instance(0))";
        String ele = driver.findElementByAndroidUIAutomator(scrollElement).getText();
        System.out.println("scroll ele is - "+ele);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/all_market_qr_code"))).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String headerText = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView").getText();
        System.out.println("All market QR codes header : "+headerText);
        Assert.assertEquals(headerText,"All Market Returns QR Codes");

        //if QR codes are displayed
        try
        {
            if(driver.findElementById(packageName+":id/card_view").isDisplayed()) {
                System.out.println("QR code(s) is displayed in the tile");
                driver.findElementById(packageName + ":id/card_view").click();
                System.out.println("First QR code is opened");
                String scanQRPopup = driver.findElementById(packageName+":id/header").getText();
                Assert.assertEquals(scanQRPopup.trim(),"Scan QR code");
                System.out.println("QR code pop up header is : "+scanQRPopup);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName+":id/dismiss_qr_code"))).click();
                System.out.println("Pop up is closed by clicking on Complete button");
            }
        }
        catch (Exception p)
        {
            System.out.println("No QR Codes are Available in tile");
        }
        backToKHHome(wait,driver,packageName);
    }

    public void backToKHHome(WebDriverWait wait, AndroidDriver driver , String packageName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(khLabel.trim().equals("Key Holder"));
        System.out.println("Back on home page");
    }
}
