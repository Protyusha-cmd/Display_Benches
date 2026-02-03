
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
        try {
            WebElement clibenches = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[3]/pf-clip-category-list/div/a/div/div[1]")));
            clibenches.click();
        } catch (Exception ignored) {
        }

    }

    public void expandMaterialFilter() {

    }

    public void expandPriceFilter() {

    }

    public void setMinPriceAndApply() {

    }

    public String topNItemsWithPrice(int n) {
        try {
            WebElement any = driver.findElement(
                    By.xpath("//*[@class='product-name color-tertiary text-md font-medium ng-star-inserted']"));
            actions.scrollToElement(any).perform();
            List<WebElement> names = driver.findElements(
                    By.xpath("//*[@class='product-name color-tertiary text-md font-medium ng-star-inserted']"));
            List<WebElement> prices = driver
                    .findElements(By.xpath("//*[@class='product-offer-price font-bold text-xl ng-star-inserted']"));
            int size = Math.min(n, Math.min(names.size(), prices.size()));
            String[][] arr = new String[size][2];
            for (int i = 0; i < size; i++) {
                arr[i][0] = names.get(i).getText();
                arr[i][1] = prices.get(i).getText();
            }
            return arr;
        } catch (Exception e) {
            return new String[0][0];
        }
    }
}
