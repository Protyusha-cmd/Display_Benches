
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
        
    }

    public static WebDriver getDriver() { return TL.get(); }

    public static void quitDriver() {
       
    }
}
