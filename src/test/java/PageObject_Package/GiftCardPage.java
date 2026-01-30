
package PageObject_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GiftCardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public GiftCardPage() {
        
    }

    public void openGiftCardsAndChooseBirthday() {
        
    }

    public void fillGiftCardForm(String rname, String sname, String rmob, String smob, String rmail, String smail, String rmsg) {
        
    }


//    public void triggerSenderEmailValidation() {
//        try {
//            WebElement senderEmail = driver.findElement(By.xpath("//input[@formcontrolname='smail']"));
//            senderEmail.click();
//            senderEmail.clear();
//            senderEmail.sendKeys("laavaa.comda"); // invalid format
//            // blur by clicking elsewhere
//            actions.moveByOffset(10,10).click().perform();
//            Thread.sleep(1500);
//        } catch (Exception ignored) {}
//    }
}
