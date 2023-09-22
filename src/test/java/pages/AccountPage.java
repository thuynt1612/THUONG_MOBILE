package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage extends MobileObject {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    private WebElement loginBtn;

    public void clickLoginButton() {
        waitFor(loginBtn);
        loginBtn.click();
    }
}
