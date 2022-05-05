package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Pick_KH {
    /*
    @author : Nikita Gopathi
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_pickbtn"))).click();
        //checking Pick for Recovery header from pop up
        String pickForRecoveryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/txt_pick"))).getText();
        System.out.println("Pick for Recovery header : " + pickForRecoveryLabel);
        Assert.assertEquals(pickForRecoveryLabel,"Pick for Recovery");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/txt_pick"))).click();
        //checking Pick for Recovery header
        String pickLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Pick For Recovery\"]/android.widget.TextView"))).getText();
        System.out.println("Pick - Pick for Recovery header : " + pickLabel);
        Assert.assertEquals(pickLabel,"PICK FOR RECOVERY");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_pickbtn"))).click();
        //checking Move to Return Lane header from pop up
        String returnLaneLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/txt_move"))).getText();
        System.out.println("Move to Return Lane header : " + returnLaneLabel);
        Assert.assertEquals(returnLaneLabel,"Ship Back to ADC");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(packageName + ":id/txt_move"))).click();
        //checking Move to Return Lane header
        String returnLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"Ship Back to ADC\"]/android.widget.TextView"))).getText();
        System.out.println("Pick - Move to Return Lane header : " + returnLabel);
        Assert.assertEquals(returnLabel,"SHIP BACK TO ADC");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();

        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertEquals(khLabel,"Keyholder");

    }
}
