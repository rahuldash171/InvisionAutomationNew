package WH_Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Feedback_WH {
    /*@author -
    Rahul Dash, Nikita Gopathi*/
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[11]/android.widget.CheckedTextView"))).click();
        String FeedbackHead= driver.findElementById(packageName+":id/feedback_header_txt").getText();
        System.out.println("Feedback tab header: "+FeedbackHead);
        Assert.assertTrue(FeedbackHead.equals("Feedback"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
               "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        System.out.println("WH label is "+ whLabel);
        Assert.assertTrue(whLabel.trim().equals("Warehouse"));
    }

    public void openNavigationBar(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String feedbackLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[11]/android.widget.CheckedTextView"))).getText();
        System.out.println("Feedback tab header from navigation : "+feedbackLabel);
        Assert.assertTrue(feedbackLabel.equals("Feedback"));
    }

    public void enterFeedbackTile(WebDriverWait wait, AndroidDriver driver , String packageName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[11]/android.widget.CheckedTextView"))).click();
        String FeedbackHead= driver.findElementById(packageName+":id/feedback_header_txt").getText();
        System.out.println("Feedback tab header: "+FeedbackHead);
        Assert.assertTrue(FeedbackHead.equals("Feedback"));
    }

    public void chooseType(WebDriverWait wait, AndroidDriver driver , String packageName, String type){
        String curTypePath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.TextView";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curTypePath))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select reqType = new Select(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView")));
        //reqType.selectByVisibleText(type);
        String curType = driver.findElement(By.xpath(curTypePath)).getText();
        System.out.println("Selected Feedback type is "+curType);
        Assert.assertTrue(type.equals(curType));
    }

    public void enterCustomerFeedback(WebDriverWait wait, AndroidDriver driver , String packageName){
        String textFeedback = "Feedback from the customer with respect to the type is written here";
        driver.findElementById(packageName+":id/feedback_txt").sendKeys(textFeedback);
        System.out.println("Feedback is : "+textFeedback);
    }

    public void clickSubmit(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( packageName + ":id/feedback_btn"))).click();
        System.out.println("Submit button is clicked in Feedback page");
    }

    public void backToWHHome(WebDriverWait wait, AndroidDriver driver , String packageName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName+":id/action_home"))).click();
        String whLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"))).getText();
        Assert.assertTrue(whLabel.trim().equals("Warehouse"));
        System.out.println("Back on home page");
    }


    public void chooseDA(WebDriverWait wait, AndroidDriver driver , String packageName, String type){
        String curTypePath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.TextView";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curTypePath))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))).click();

        String curType = driver.findElement(By.xpath(curTypePath)).getText();
        System.out.println("Selected Feedback type is "+curType);
        Assert.assertTrue(type.equals(curType));
    }

    public void chooseAE(WebDriverWait wait, AndroidDriver driver , String packageName, String type){
        String curTypePath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.TextView";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curTypePath))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"))).click();

        String curType = driver.findElement(By.xpath(curTypePath)).getText();
        System.out.println("Selected Feedback type is "+curType);
        Assert.assertTrue(type.equals(curType));
    }

    public void chooseMD(WebDriverWait wait, AndroidDriver driver , String packageName, String type){
        String curTypePath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.Spinner/android.widget.TextView";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(curTypePath))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]"))).click();

        String curType = driver.findElement(By.xpath(curTypePath)).getText();
        System.out.println("Selected Feedback type is "+curType);
        Assert.assertTrue(type.equals(curType));
    }

    public void NetworkConnectivityFeedback(WebDriverWait wait, AndroidDriver driver , String packageName) {
        openNavigationBar(wait, driver ,packageName);
        enterFeedbackTile(wait, driver ,packageName);
        enterCustomerFeedback(wait, driver ,packageName);
        clickSubmit(wait, driver ,packageName);
    }

    public void DataAccuracyFeedback(WebDriverWait wait, AndroidDriver driver , String packageName) {
        chooseDA(wait, driver ,packageName,"Data Accuracy");
        enterCustomerFeedback(wait, driver ,packageName);
        clickSubmit(wait, driver ,packageName);
    }

    public void AppExperienceFeedback(WebDriverWait wait, AndroidDriver driver , String packageName) {
        chooseAE(wait, driver ,packageName,"App Experience");
        enterCustomerFeedback(wait, driver ,packageName);
        clickSubmit(wait, driver ,packageName);
    }

    public void MobileDeviceFeedback(WebDriverWait wait, AndroidDriver driver , String packageName) {
        chooseMD(wait, driver ,packageName,"Mobile Device");
        enterCustomerFeedback(wait, driver ,packageName);
        clickSubmit(wait, driver ,packageName);
    }

    public void EmptyFeedback(WebDriverWait wait, AndroidDriver driver , String packageName) {
        clickSubmit(wait, driver ,packageName);
        System.out.println("Error message appears as user does not provide any feedback before clicking on Submit button");
        System.out.println("Error message is - Please write few words or at least 50 characters");
    }
}
