package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BoxSearch_WH {
    /*
    @author : Rahul Dash, Nikita Gopathi
     */

    public WebDriverWait wait;

    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/box_search_btn"))).click();
        String boxSearchLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView"))).getText();
        System.out.println("Box Search header : "+boxSearchLabel);
        Assert.assertTrue(boxSearchLabel.equals("Box Search"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        //validating home screen again
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }

    public void enterBSTile(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/box_search_btn"))).click();
        String boxSearchLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[1]/android.widget.TextView"))).getText();
        System.out.println("Box Search header : "+boxSearchLabel);
        Assert.assertTrue(boxSearchLabel.equals("Box Search"));
    }

    public void backToWHHome(WebDriverWait wait, AndroidDriver driver , String packageName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        //validating home screen again
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/warehouse_persona_label"))).getText();
        Assert.assertTrue(whLabel.equals("Warehousing"));
    }

    public void flashOnOff(WebDriverWait wait, AndroidDriver driver , String packageName) {
        var flashEle = driver.findElementById( packageName + ":id/flash_toggle");
        System.out.println("Flash toggle is initially disabled");
        flashEle.click();
        System.out.println("Flash toggle is enabled");
        flashEle.click();
        System.out.println("Flash toggle is disabled");
    }

    public void scanGunOnOff(WebDriverWait wait, AndroidDriver driver , String packageName) {
        var scanGunEle = driver.findElementById( packageName + ":id/bluetooth_toggle");
        scanGunEle.click();
        System.out.println("Scan Gun is enabled");
        scanGunEle.click();
        System.out.println("User returns to Box Search screen");
    }

    public void manualEntry(WebDriverWait wait, AndroidDriver driver , String packageName) {
        var manualEntry = driver.findElementById( packageName + ":id/problem_reading_barcode");
        manualEntry.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/popup_element")));
        System.out.println("Manual Entry pop up is displayed");
    }

    public void validateEnterBarcodes(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/popup_element")));
        String manualELabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"))).getText();
        System.out.println("Manual entry header : "+manualELabel);
        Assert.assertTrue(manualELabel.equals("Enter Barcodes"), "Manual entry box did not open");
    }

    public void verifyME(WebDriverWait wait, AndroidDriver driver , String packageName) {
        var verifyBtn = driver.findElementById( packageName + ":id/btn_theiaverify");
        verifyBtn.click();
        System.out.println("Manual Entry pop up's Verify button is clicked");
    }

    public void enterOrderSKU(WebDriverWait wait, AndroidDriver driver , String packageName, String order, String sku) {
        var orderEle = driver.findElementById( packageName + ":id/pw_input_orderNum");
        var skuEle = driver.findElementById( packageName + ":id/pw_input_skuNum");
        orderEle.clear();
        orderEle.click();
        orderEle.sendKeys(order);
        System.out.println("Entered order number : "+order);
        skuEle.clear();
        skuEle.click();
        skuEle.sendKeys(sku);
        System.out.println("Entered sku : "+sku);
        verifyME(wait, driver,packageName);
    }

    public void prodDetails(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/popup_element")));
        String prodDetailsLabel = driver.findElementById( packageName + ":id/productDetails").getText();
        System.out.println("Product Details header : "+prodDetailsLabel);
        Assert.assertTrue(prodDetailsLabel.equals("Product Details"));
        driver.findElementById( packageName + ":id/info_ok_btn").click();
        System.out.println("User is now on Box Search screen");

    }

    public void enterRTID(WebDriverWait wait, AndroidDriver driver , String packageName, String rtid) {
        var rtidEle = driver.findElementById( packageName + ":id/pw_input_rtidNum");
        rtidEle.clear();
        rtidEle.click();
        rtidEle.sendKeys(rtid);
        System.out.println("Entered RTID : "+rtid);
        verifyME(wait,driver,packageName);
    }

    public void manualEValidRTID(WebDriverWait wait, AndroidDriver driver , String packageName) {
        manualEntry(wait, driver ,packageName);
        validateEnterBarcodes(wait, driver ,packageName);
        enterRTID(wait, driver ,packageName,"R88879740");
        prodDetails(wait, driver ,packageName);
    }

}
