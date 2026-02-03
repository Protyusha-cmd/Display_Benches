
package PageObject_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FurniturePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public FurniturePage() {
        
    }

    public void clickMoreCategories() {
         try {
            WebElement more = driver.findElement(By.xpath("/html/body/app-root/main/app-category/pf-clp/div/div[1]/div/div/pf-category-list/div/div[3]"));
            actions.scrollToElement(more).perform();
            more.click();
        } catch (Exception ignored) {}
        
    }

    public void openSetteesAndBenches() {
       
    }
}
