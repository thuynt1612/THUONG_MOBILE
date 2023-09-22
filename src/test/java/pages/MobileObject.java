package pages;

import com.google.common.base.Predicate;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MobileObject extends PageObject {
    public MobileObject(final WebDriver driver) {
        super(driver, new Predicate<net.serenitybdd.core.pages.PageObject>() {
            @Override
            public boolean apply(net.serenitybdd.core.pages.PageObject page) {

                PageFactory
                        .initElements(new AppiumFieldDecorator( ((WebDriverFacade) page.getDriver()).getProxiedDriver(),
                                page.getImplicitWaitTimeout()), page);
                return true;
            }

        });
    }

    AndroidDriver androidDriver() {
        return (AndroidDriver)
                ((WebDriverFacade) getDriver()).getProxiedDriver();
    }
}
