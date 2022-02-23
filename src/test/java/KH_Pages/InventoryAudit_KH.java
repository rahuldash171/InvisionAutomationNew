package KH_Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InventoryAudit_KH {
    /*
    @author : Nikita Gopathi
     */
    public void ClickNBack(WebDriverWait wait, AndroidDriver driver , String packageName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_cycle_count_btn"))).click();
        String heldForRecoveryLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/txt_cycle"))).getText();
        System.out.println("Inventory Audit Option : " + heldForRecoveryLabel);
        Assert.assertEquals(heldForRecoveryLabel.trim(),"Held for Recovery");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/txt_cycle"))).click();
        String invAuditLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView"))).getText();
        System.out.println("Inventory Audit - Held for Recovery header : " + invAuditLabel);
        Assert.assertTrue(invAuditLabel.equals("Inventory Audit"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/action_home"))).click();
        String khLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
                packageName + ":id/keyholder_persona_label"))).getText();
        //TODO - actually get this test to work
        Assert.assertTrue(khLabel.equals("Keyholder"));

    }
}
