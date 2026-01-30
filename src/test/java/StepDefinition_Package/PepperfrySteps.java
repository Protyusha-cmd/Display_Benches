
package StepDefinition_Package;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import Utility_Package.AllureReportOpener;
import io.cucumber.java.en.*;
import PageObject_Package.*;
import Utility_Package.driversetup;
import Utility_Package.Screenshots;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class PepperfrySteps {
    private WebDriver driver;
    private HomePage home;
    private FurniturePage furniture;
    private BenchesPage benches;
    private GiftCardPage gift;
    private LuxuryPage luxury;

    @Before
    public void before() {
        driversetup.initDriver();
        driver = driversetup.getDriver();
        home = new HomePage(driver);
        furniture = new FurniturePage(driver);
        benches = new BenchesPage(driver);
        gift = new GiftCardPage(driver);
        luxury = new LuxuryPage(driver);
    }

    @After
    public void after() { driversetup.quitDriver(); }

    @Given("I open the Pepperfry website")
    public void open_site() throws InterruptedException {
        home.open("https://www.pepperfry.com/");
        Thread.sleep(1500);
        home.closePopupIfPresent();
    }

    @When("I go to Furniture > Settees & Benches > Metal Benches")
    public void go_to_metal_benches() {
        home.clickFurniture();
        furniture.clickMoreCategories();
        furniture.openSetteesAndBenches();
        benches.openMetalBenches();
    }

    @And("I set minimum price to {string} and apply the filter")
    public void set_min_price(String min) {
        benches.expandMaterialFilter();
        benches.expandPriceFilter();
        benches.setMinPriceAndApply(min);
    }

    @Then("I print top {int} product names with prices")
    public void print_top(int n) {
        String[][] items = benches.topNItemsWithPrice(n);
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d) %s : %s%n", i + 1, items[i][0], items[i][1]);
        }
    }

    @And("I list top {int} luxury categories")
    public void list_top_luxury(int n) { luxury.listTopLuxuryCategories(n); }

    @When("I open Gift Cards and choose Birthday design")
    public void open_gift_cards() { gift.openGiftCardsAndChooseBirthday(); }

    @And("I fill the gift card form with details")
    public void fill_form(io.cucumber.datatable.DataTable data) {
        Map<String, String> d = data.asMaps(String.class, String.class).get(0);
        gift.fillGiftCardForm(
            d.getOrDefault("recipient_name", "Ganash"),
            d.getOrDefault("sender_name", "Laavaa"),
            d.getOrDefault("recipient_mobile", "1234567890"),
            d.getOrDefault("sender_mobile", "0987654321"),
            d.getOrDefault("recipient_email", "Ganash@yaahoo.com"),
            d.getOrDefault("sender_email", "laavaa.comda"),
            d.getOrDefault("message", "Ganash happy birthday")
        );
    }
    @AfterAll
    public static void tearDown() {
        AllureReportOpener.openAllureReport();
    }

    @Then("I capture an invalid email error screenshot on gift card")
    public void capture_invalid_email_screenshot() throws InterruptedException {
        // Force invalid sender email validation and take screenshot
     //   gift.triggerSenderEmailValidation();
        Thread.sleep(1500);
        String path = Screenshots.takeAndAttach(driver, "giftcard_invalid_email");
        System.out.println("Saved screenshot: " + path);
    }
}
