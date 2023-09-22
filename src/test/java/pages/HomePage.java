package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage extends MobileObject {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String uiAutomatorSkip = "new UiSelector().text(\"SKIP\")";
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"SKIP\")")
    private WebElement skipButton;

    private String uiAutomatorClosePopup = "new UiSelector().text(\"CLOSE\")";
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"CLOSE\")")
    private WebElement closePopUp;

    @AndroidFindBy(accessibility = "SEARCH_INPUT")
    private WebElement searchInput;


    public void clickSkipButton() {
        withTimeoutOf(20, TimeUnit.SECONDS).waitFor(skipButton);
        skipButton.click();
    }

    public void closePopup() {
        boolean isDisplayPopup = withTimeoutOf(Duration.ofSeconds(5)).elementIsDisplayed(new AppiumBy.ByAccessibilityId(uiAutomatorClosePopup));
        if(isDisplayPopup) {
            closePopUp.click();
        }
    }

    public void clickSearchField() {
        waitFor(searchInput);
        searchInput.click();
    }
}
