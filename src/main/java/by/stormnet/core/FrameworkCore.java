package by.stormnet.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import by.stormnet.core.utils.BrowserConstants;
import by.stormnet.core.utils.IOUtils;

public class FrameworkCore {
    private static WebDriver driver;
    public static String browser = IOUtils.loadGenericProperty("browser", "configuration");
    public static String baseUrl = IOUtils.loadGenericProperty("baseUrl", "configuration");


    public static WebDriver getInstance() {
        if (browser.equals(BrowserConstants.CHROME)) {
            driver = new ChromeDriver();
        } else {
            if (browser.equals(BrowserConstants.FIREFOX)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser value from property file is incorrect!");
            }
        }
        return driver;
    }
}
