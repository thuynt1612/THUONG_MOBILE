package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.util.concurrent.TimeUnit.SECONDS;

public class NavBottomPage extends MobileObject {
    public NavBottomPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "HOME_BOTTOM_BUTTON")
    private WebElement homeButton;

    @AndroidFindBy(accessibility = "BRAND_BUTTON")
    private WebElement brandButton;

    @AndroidFindBy(accessibility = "SCAN_BUTTON")
    private WebElement scanButton;

    @AndroidFindBy(accessibility = "MYPOD_BUTTON")
    private WebElement myPodButton;

    @AndroidFindBy(accessibility = "PROFILE_BUTTON")
    private WebElement accountBtn;

    public void clickAccountButton(){
        withTimeoutOf(10, SECONDS).waitFor(accountBtn);
        accountBtn.click();
    }
}
