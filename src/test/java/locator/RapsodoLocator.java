package locator;

import org.openqa.selenium.By;

public class RapsodoLocator {
    public static final By SHOP_NOW = By.cssSelector("div.ShopNow.Desktop");
    public static final By GOLF = By.xpath("//div[@class='Item MainMenuHover']//a[contains(text(),'GOLF')]");
    public static final By BASEBALL = By.xpath("//div[@class='Item MainMenuHover']//a[contains(text(),'BASEBALL')]");
    public static final By SOFTBALL = By.xpath("//div[@class='Item MainMenuHover']//a[contains(text(),'SOFTBALL')]");
    public static final By LEARNING_CENTER = By.xpath("//div[@class='Item SubMenuHover']//a[contains(text(),'LEARNING CENTER')]");
    public static final By CLUBHOUSE = By.xpath("//div[@class='Item SubMenuHover']//a[contains(text(),'CLUBHOUSE')]");
    public static final By MLM = By.xpath("//div[@class='OwlItem']//span[starts-with(text(),'MLM')]");
    public static final By ZERO_ITEM = By.xpath("//span[starts-with(text(),'0 item')]");
    public static final By TWO_ITEM = By.xpath("//span[starts-with(text(),'2 item')]");
    public static final By ZERO_AMOUNT = By.xpath("//span[@class='woocommerce-Price-currencySymbol']//..//..//bdi[text()='0.00']");
    public static final By TWO_ITEM_AMOUNT = By.xpath("//span[@class='woocommerce-Price-currencySymbol']//..//..//bdi[text()='999.98']");
    public static final By MOBILE_LOUNCH_MONITOR = By.xpath("//*[@class='woocommerce-loop-product__title' and text()='Mobile Launch Monitor (MLM)']");
    public static final By PLUS_QUANTITY = By.id("plus_qty");
    public static final By ADD_TO_CART = By.className("single_add_to_cart_button");
    public static final By TWO_PRODUCT = By.xpath("//input[@value='2']");
    public static final By COUPON_CODE = By.id("coupon_code");
    public static final By APPLY_COUPON = By.name("apply_coupon");
    public static final By ERROR_MESSAGE = By.xpath("//ul[@class='woocommerce-error']//li");
}
