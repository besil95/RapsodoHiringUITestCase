package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BaseMethods {

    WebDriver driver = null;
    WebDriverWait wait = null;
    final static Logger logger = Logger.getLogger(String.valueOf(BaseMethods.class));


    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        logger.info("Element " + by + " is visible and clickable");
        return driver.findElement(by);
    }

    public void hoverElement(By by) {
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(findElement(by)).build().perform();
            logger.info("Hovered over object " + by);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Failed to hover over object " + by);
        }
    }

    public void clickElement(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            findElement(by).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getTextElement(By by) {
        return ((WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by))).getText();
    }

    public void getSendKeyElement(By by, String text) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            findElement(by).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean checkURLTitle(String title) {
        String Actual = driver.getTitle();

        if (Actual.equals(title)) {
            logger.info(title + " : title successful checked");
            return true;
        } else {
            logger.info(title + " : title failed");
            return false;
        }

    }

    public void scrollToWindowWithIndex(String scroll) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + scroll + ")");
        logger.info("Page scrolled down by " + scroll);
    }

    public Boolean checkCurrentUrl(String key) {
        String url = driver.getCurrentUrl();
        if (key.contains(" ")) {
            {
                String[] keyList = key.split(" ");
                key = keyList[0];
            }
        }
        if (url.contains(key)) {
            logger.info("Searched word of ' " + key + " ' is found");
            return true;
        } else {
            logger.info("Searched word of '' " + key + " '' is not found");
            return false;
        }
    }

}
