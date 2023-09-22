package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends MobileObject {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "SEARCH_INPUT")
    private WebElement searchInput;

    public void searchProduct(String productName){
        waitFor(searchInput);
        enter(productName).into(searchInput);
        this.androidDriver().pressKey(new KeyEvent(AndroidKey.ENTER));
        androidDriver().hideKeyboard();
        String uiSelector = String.format("new UiSelector().className(\"android.widget.TextView\").text(\"%s\")",productName);
        waitABit(2000);
        WebElement elementFirstProduct = androidDriver().findElement(AppiumBy.androidUIAutomator(uiSelector));
        elementFirstProduct.click();
    }
}
