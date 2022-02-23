package stepDefinitions;

import base.BaseMethods;
import org.openqa.selenium.WebDriver;

import static constants.RapsodoConstants.*;
import static driver.Driver.webDriver;
import static locator.RapsodoLocator.*;

public class RapsodoDefinitions extends BaseMethods {
    public RapsodoDefinitions(WebDriver driver) {
        super(driver);
    }

    String item, amount, mlm, errorMessage;

    public void rapsodoHeaderControl() {
        findElement(SHOP_NOW);
        findElement(GOLF);
        findElement(BASEBALL);
        findElement(SOFTBALL);
        findElement(LEARNING_CENTER);
        findElement(CLUBHOUSE);
    }

    public void homePageControl() {
        checkCurrentUrl(BASE_URL);
        checkURLTitle(HOME_PAGE_TITLE);
        rapsodoHeaderControl();
    }

    public void mlmPageControl() {
        hoverElement(GOLF);
        clickElement(MLM);
        checkURLTitle(MLM_PAGE_TITLE);
        rapsodoHeaderControl();
        item = getTextElement(ZERO_ITEM).substring(0, 7);
        amount = getTextElement(ZERO_AMOUNT);
        if (item.contains("0") && amount.contains("0")) {
            System.out.println("ITEM: " + item + " and " + "AMOUNT: " + amount);
        } else {
            System.out.println("ITEM AND AMOUNT ARE NOT ZERO");
            webDriver.quit();
        }
    }

    public void shoppingSteps() {
        clickElement(SHOP_NOW);
        mlm = getTextElement(MOBILE_LOUNCH_MONITOR);
        if (mlm.contains("Mobile Launch Monitor")) {
            System.out.println(mlm + " is listed successfully");
        } else {
            System.out.println("Mobile Launch Monitor could not be listed");
            webDriver.quit();
        }
        clickElement(MOBILE_LOUNCH_MONITOR);
        checkCurrentUrl("mobile-launch-monitor");
        scrollToWindowWithIndex("750");
        clickElement(PLUS_QUANTITY);
        clickElement(ADD_TO_CART);
        checkCurrentUrl("cart");
        findElement(TWO_PRODUCT);
        item = getTextElement(TWO_ITEM).substring(0, 7);
        amount = getTextElement(TWO_ITEM_AMOUNT);
        if (item.contains("2 item") && amount.contains("999.98")) {
            System.out.println("ITEM: " + item + " and " + "AMOUNT: " + amount);
        } else {
            System.out.println("ITEM AND AMOUNT ARE NOT ZERO");
            webDriver.quit();
        }

    }

    public void couponCodeCheck() {
        getSendKeyElement(COUPON_CODE, GOLF_THE_BEST);
        clickElement(APPLY_COUPON);
        errorMessage = getTextElement(ERROR_MESSAGE).toUpperCase();
        if (errorMessage.contains(GOLF_THE_BEST)) {
            System.out.println("Coupon code " + GOLF_THE_BEST + " succesfully displayed");
        } else {
            System.out.println("Coupon code not succesfully displayed");
        }
        rapsodoHeaderControl();
    }

}
