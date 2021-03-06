package HD_Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BoxSearch {

    public void ClickNBack(WebDriverWait wait, AndroidDriver driver, String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
        String boxSearchLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView"))).getText();
        System.out.println("Box Search header : " + boxSearchLabel);
        Assert.assertTrue(boxSearchLabel.equals("Box Search"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String hdLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(hdLabel.trim().equals("Home Delivery"));
    }

    public void ManualEntryboxTest_OrderSKU(WebDriverWait wait, AndroidDriver driver, String packageName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
        System.out.println("Click on Manual Entry tab");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/problem_reading_barcode"))).click();
        WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
        if (inputBox.isDisplayed()) {
            System.out.println("Manual Entry box opened");
            System.out.println("Providing Order and SKU");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_orderNum"))).sendKeys("95013197429");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_skuNum"))).sendKeys("125376");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_theiaverify"))).click();
            try {
                if (driver.findElement(By.id(packageName + ":id/productDetails")).isDisplayed()) {
                    System.out.println("Valid inputs");
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                            packageName + ":id/info_ok_btn"))).click();
                }
            } catch (Exception e) {
                System.out.println("Invalid Order/Sku combination");

            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/img_back"))).click();
        } else {
            System.out.println("Manual Entry box didn't open");
        }

    }

    public void ManualEntryboxTest_RTID(WebDriverWait wait, AndroidDriver driver, String packageName)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/home_box_search_img"))).click();
            System.out.println("Click on Manual Entry tab");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/problem_reading_barcode"))).click();
            WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
            if (inputBox.isDisplayed()) {
                System.out.println("Manual Entry box opened");
                System.out.println("Providing RTID");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/pw_input_rtidNum"))).sendKeys("R88899510");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/btn_theiaverify"))).click();
                try {
                    if (driver.findElement(By.id(packageName + ":id/productDetails")).isDisplayed())
                     {
                        System.out.println("Valid RTID");
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                                packageName + ":id/info_ok_btn"))).click();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid RTID provided by User");

                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/img_back"))).click();
            } else {
                System.out.println("Manual Entry box didn't open");
            }
        }

        public void EmptyEntries (WebDriverWait wait, AndroidDriver driver, String packageName)
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                        packageName + ":id/home_box_search_img"))).click();
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
                            packageName + ":id/img_back"))).click();
                } else {
                    System.out.println("Manual Entry box didn't open");
                }
        }
    public void Flashbutton (WebDriverWait wait, AndroidDriver driver, String packageName)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
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
                packageName + ":id/img_back"))).click();
    }
    public void ScanGun (WebDriverWait wait, AndroidDriver driver, String packageName)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
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
                packageName + ":id/img_back"))).click();
    }

    public void InvalidEntries (WebDriverWait wait, AndroidDriver driver, String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/home_box_search_img"))).click();
        System.out.println("Click on Manual Entry tab");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/problem_reading_barcode"))).click();
        WebElement inputBox = driver.findElement(By.id(packageName + ":id/popup_element"));
        if (inputBox.isDisplayed()) {
            System.out.println("Manual Entry box opened");
            System.out.println("Provide invalid RTID which does not start with R");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/pw_input_rtidNum"))).sendKeys("ABCD1234");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/btn_theiaverify"))).click();
            try {
                if (driver.findElement(By.id(packageName + ":id/popup_element")).isDisplayed()) {
                    System.out.println("Error messages appears for invalid RTID");
                    driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK)); //Device back button
                }
            } catch (Exception e) {
                System.out.println("Invalid entries feature not working");

            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                    packageName + ":id/img_back"))).click();
        } else {
            System.out.println("Manual Entry box didn't open");
        }
    }


}
