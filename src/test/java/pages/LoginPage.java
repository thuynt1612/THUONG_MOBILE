package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends MobileObject{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "EMAIL_INPUT")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "PASSWORD_INPUT")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "LOGIN_BUTTON")
    private WebElement loginBtn;

    public void loginToApp(String email, String password){
        waitFor(emailField);
        enter(email).into(emailField);
        enter(password).into(passwordField);
        clickOn(loginBtn);
    }
}
