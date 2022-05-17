package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class InboundReceiptException_WH {
    /*
        @author : Rahul Dash
         */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inbound Receipt Exception\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement exceptionFAQ = driver.findElementById(packageName+":id/popup_element");
        Assert.assertTrue(exceptionFAQ.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/close_dialog_btn"))).click();
        String InboundexceptionHeader = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView").getText();
        System.out.println("Inbound exception header : "+InboundexceptionHeader);
        Assert.assertEquals(InboundexceptionHeader,"Exception");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(whLabel.trim().equals("Warehouse"));
    }

    public void ManualEntryboxTest_OrderSKU(WebDriverWait wait, AndroidDriver driver, String packageName)
    {
        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/pw_input_trailerNum"))).sendKeys("testing");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/btn_ok"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/problem_reading_barcode"))).click();
        WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
        if (inputBox.isDisplayed()) {
            System.out.println("Manual Entry box opened");
            System.out.println("Providing Order and SKU");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_orderNum"))).sendKeys("95012993829");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_skuNum"))).sendKeys("124353");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_theiaverify"))).click();
            try {
                if (driver.findElement(By.id(packageName + ":id/sv_order")).isDisplayed()) {
                    System.out.println("Valid inputs and confirm transfer as Yes");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                            packageName + ":id/sv_btnSubmit"))).click();
                    if(driver.findElement(By.id(packageName + ":id/add_time")).isDisplayed()){
                        System.out.println("Duplicate order and SKU entered , Overriding");
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                                packageName + ":id/dps_no"))).click();
                    }
                }

            } catch (Exception e) {
                //driver.findElement(By.id(packageName + ":id/rs_btnForceInvalidTransfer")).isDisplayed();
                System.out.println("valid Order/Sku combination");
                //driver.findElement(By.id(packageName + ":id/rs_btnRescan")).click();

            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/action_home"))).click();
        } else {
            System.out.println("Manual Entry box didn't open");
        }

    }

    public void FAQ(WebDriverWait wait, AndroidDriver driver, String packageName) {
        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        System.out.println("Click on FAQ button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/tutorial_btn"))).click();
        try {
            WebElement tutorialImg = driver.findElement(By.id(packageName + ":id/tut_img"));
            while (tutorialImg.isDisplayed()) {
                System.out.println("FAQ ...");
                tutorialImg.click();
            }
        }catch (Exception e) {
            System.out.println("FAQ is not working");

        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
    }




    public void EmptyEntries (WebDriverWait wait, AndroidDriver driver, String packageName)
    {
        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        System.out.println("Click on Manual Entry tab");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/problem_reading_barcode"))).click();
        WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
        if (inputBox.isDisplayed()) {
            System.out.println("Manual Entry box opened");
            System.out.println("Do not provide entries and click on Verify");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_theiaverify"))).click();
            try {
                if (driver.findElement(By.id(packageName + ":id/popup_element")).isDisplayed())
                {
                    System.out.println("Error messages appears as user does not provide entries");
                    driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); //Device back button
                }
            } catch (Exception e) {
                System.out.println("Empty entries feature not working");

            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/action_home"))).click();
        } else {
            System.out.println("Manual Entry box didn't open");
        }
    }
    public void Flashbutton (WebDriverWait wait, AndroidDriver driver, String packageName)
    {

        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        System.out.println("Click on flash button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/flash_toggle"))).click();
        try{
            if (driver.findElement(By.id( packageName + ":id/flash_toggle")).isEnabled()) {
                System.out.println("Flash is enabled");
                System.out.println("Disabling flash..");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/flash_toggle"))).click();

            }
        }catch (Exception e) {
            System.out.println("Flash is not working");

        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
    }
    public void ScanGun (WebDriverWait wait, AndroidDriver driver, String packageName)
    {

        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        System.out.println("Click on ScanGun button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/bluetooth_toggle"))).click();
        try{
            if (driver.findElement(By.id( packageName + ":id/bluetooth_toggle")).isEnabled())
            {
                System.out.println("ScanGun is enabled");
            }
        }catch (Exception e) {
            System.out.println("ScanGun is not opening");

        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
    }

    public void InvalidEntries (WebDriverWait wait, AndroidDriver driver, String packageName) {
        new InboundReceiptException_WH().commonActivities(wait,driver,packageName);
        System.out.println("Click on Manual Entry tab");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/problem_reading_barcode"))).click();
        WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
        if (inputBox.isDisplayed()) {
            System.out.println("Manual Entry box opened");
            System.out.println("Provide invalid Order and SKU");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_orderNum"))).sendKeys("95300197429");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_skuNum"))).sendKeys("233212");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_theiaverify"))).click();
            try {
                if (driver.findElement(By.id(packageName + ":id/rs_btnForceInvalidTransfer")).isDisplayed()) {
                    System.out.println("Invalid Pop up appears , Not scanning ");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                            packageName + ":id/rs_btnRescan"))).click();
                }
            } catch (Exception e) {

                System.out.println(e +"Invalid entries feature not working");
                driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); //Device back button


            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/action_home"))).click();
        } else {
            System.out.println("Manual Entry box didn't open");
        }
    }

    public void commonActivities(WebDriverWait wait, AndroidDriver driver, String packageNameSTAGE)
    {
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Inbound Receipt Exception\").instance(0))";
        driver.findElementByAndroidUIAutomator(scrollElement).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }


}
