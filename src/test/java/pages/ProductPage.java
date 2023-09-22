package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;

public class ProductPage extends MobileObject {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='PRODUCT_DETAIL_SCREEN']/android.view.ViewGroup[2]//android.widget.ImageView")
    private WebElement productImage;

    @AndroidFindBy(accessibility = "ADD_TO_CART_BUTTON")
    private WebElement addToCartBtn;

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_BUTTON\"])[2]")
    private WebElement addToCartBtn2;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.widget.TextView[1]")
    private WebElement cardUpdateField;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.widget.TextView[2]")
    private WebElement productNameOnCardUpdate;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.widget.TextView[3]")
    private WebElement skuNameOnCardUpdate;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.widget.TextView[4]")
    private WebElement quantityOnCartUpdate;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.view.ViewGroup[2]/android.widget.TextView[1]")
    private WebElement viewCartText1;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ADD_TO_CART_SUCCESS_MODAL\"]/android.view.ViewGroup[2]/android.widget.TextView[2]")
    private WebElement viewCartText2;

    private String xpathCountProductInCart = "//android.view.ViewGroup[@content-desc=\"cartButton\"]/android.view.ViewGroup[3]/android.widget.TextView";
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cartButton\"]/android.view.ViewGroup[3]/android.widget.TextView")
    private WebElement countProductInCart;

    public void swipeImageProduct() {
        waitFor(productImage);
        Point location = productImage.getLocation();
        Dimension dimension = productImage.getSize();
        PointOption pointOptionStart, pointOptionEnd;
        int startX = location.x + dimension.width / 4;
        int startY = location.y + dimension.height / 2;
        pointOptionStart = PointOption.point(startX, startY);
        int endX = location.x + dimension.width / 4 * 3;
        int endY = location.y + dimension.height / 2;
        pointOptionEnd = PointOption.point(endX, endY);
        new TouchAction(this.androidDriver())
                .press(pointOptionEnd)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(250)))
                .moveTo(pointOptionStart)
                .release()
                .perform();

    }

    public void chooseSku(String skuName) {
        waitABit(2000);
        String accessibility = String.format("VARIANT_ITEM_1_%s",skuName);
        androidDriver().findElement(AppiumBy.accessibilityId(accessibility)).click();
    }

    public void tapOnAddToCardButton() {
        clickOn(addToCartBtn);
    }

    public void tapOnAddToCardAgain() {
        waitFor(addToCartBtn2);
        clickOn(addToCartBtn2);
    }

    public String getHeaderCartUpdate() {
        return cardUpdateField.getText();
    }

    public String getProductNameInCartUpdate() {
        return productNameOnCardUpdate.getText();
    }

    public String getSkuNameOnCartUpdate() {
        return skuNameOnCardUpdate.getText();
    }

    public int getQuantityOnCartUpdate() {
        String quantity = quantityOnCartUpdate.getText().split(" ")[1];
        return Integer.valueOf(quantity);
    }

    public String getTextViewCartButton() {
        return String.format("%s %s",viewCartText1.getText(),viewCartText2.getText());
    }

    public int getCountProductInCart() {
        boolean isExist = isElementVisible(By.xpath(xpathCountProductInCart));
        if (isExist == true)
            return Integer.valueOf(countProductInCart.getText());
        return 0;
    }
}
