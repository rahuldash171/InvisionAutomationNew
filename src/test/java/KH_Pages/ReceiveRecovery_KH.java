package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReceiveRecovery_KH {
    /*
    @author : Nikita Gopathi
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/receive_recovery_btn"))).click();
        String recoveryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/txt_toolbar_title"))).getText();
        System.out.println("Receive Recovery header : " + recoveryLabel);
        Assert.assertTrue(recoveryLabel.equals("Receive Recovery"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/img_back"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(khLabel.equals("Keyholder"));

    }
}
