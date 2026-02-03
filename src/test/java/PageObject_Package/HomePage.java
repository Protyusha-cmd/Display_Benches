
package PageObject_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void open() {
    }

    public void closePopupIfPresent() {
        try {
            driver.findElement(By.xpath("//*[@class='close-modal']")).click();
        } catch (Exception ignored) {
        }
    }

    public void clickFurniture() {

    }
}
