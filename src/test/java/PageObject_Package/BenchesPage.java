
package PageObject_Package;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BenchesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public BenchesPage() {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void openMetalBenches() {
        
    }

    public void expandMaterialFilter() {
       
    }

    public void expandPriceFilter() {
       
    }

    public void setMinPriceAndApply() {
       
    }

    public String topNItemsWithPrice() {
       
    }
}
