
package Utility_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class driversetup {
    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();
    private static Properties props;

    private static void initConfig() {

    }

    public static void initDriver() {
        initConfig();
        String browser = props.getProperty("browser", "edge").trim().toLowerCase();
        switch (browser) {
            case "chrome":
                TL.set(new ChromeDriver());
                break;
            case "firefox":
                TL.set(new FirefoxDriver());
                break;
            default:
                TL.set(new EdgeDriver());
        }
        getDriver().manage().window().maximize();
        int iw = Integer.parseInt(props.getProperty("implicitWait", "10"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(iw));
    }

    public static WebDriver getDriver() {
        return TL.get();
    }

    public static void quitDriver() {

    }
}
