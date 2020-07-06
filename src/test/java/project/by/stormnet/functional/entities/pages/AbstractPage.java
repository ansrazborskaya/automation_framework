package project.by.stormnet.functional.entities.pages;


import by.stormnet.core.FrameworkCore;
import by.stormnet.core.utils.GenerateData;
import by.stormnet.core.utils.PauseLength;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage extends FrameworkCore {

    private static WebDriver driver;
    private GenerateData generateData = new GenerateData();

    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String URL) {
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public void openBrowser(){
        driver = getInstance();
    }


    public static void waitForElementVisible(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public String generateEmailAddress(){
       return generateData.generateRandomEmail();
    }

    public String generateRandomValue(){
        return generateData.generateRandomValue();
    }

    public String generateRandomPostcode(){
        return generateData.generateRandomPostcode();
    }

    public String generateRandomPhone(){
        return generateData.generateRandomPhone();
    }


    public void waitForElementClickable(final By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, PauseLength.MAX.value());
            wait.until(ExpectedConditions.elementToBeClickable(by));

        } catch (Throwable e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public boolean isElementVisible(By by) {
        try {
            driver.manage().timeouts().implicitlyWait(PauseLength.AVG.value(), TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(by);

            if (list.size() == 0) {
                return false;
            } else {
                try {
                    return list.get(0).isDisplayed();
                } catch (StaleElementReferenceException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            driver.manage().timeouts().implicitlyWait(PauseLength.MAX.value(), TimeUnit.SECONDS);
        }
    }

    public static By getElementBy(String xpath) {
        return By.xpath(xpath);
    }

    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));

    }

    public List<WebElement> getElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public void placeCursor(String xpath){
        Actions action = new Actions(driver);
        action.moveToElement(getElement(xpath)).perform();
    }
}