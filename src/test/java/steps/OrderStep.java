package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderStep {
    private EnvironmentVariables env;
    private NavBottomPage navBottomPage;
    private AccountPage accountPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    int countProductBefore;

    @Given("Login to app")
    public void loginToApp() {
        homePage.clickSkipButton();
        navBottomPage.clickAccountButton();
        accountPage.clickLoginButton();
        String email = EnvironmentSpecificConfiguration.from(env).getProperty("email");
        String pass = EnvironmentSpecificConfiguration.from(env).getProperty("password");
        loginPage.loginToApp(email, pass);
        homePage.closePopup();
    }

    @When("On the search bar enter {} and choose this product")
    public void searchProduct(String productName) {
        homePage.clickSearchField();
        searchPage.searchProduct(productName);
    }

    @And("Swipe left")
    public void swipeLeft() {
        productPage.swipeImageProduct();
        countProductBefore = productPage.getCountProductInCart();
    }

    @And("Tap on Add to cart button")
    public void tapOnAddToCartButton() {
        productPage.tapOnAddToCardButton();
    }

    @And("Choose sku {}")
    public void chooseSkuProduct(String skuName) {
        productPage.chooseSku(skuName);
    }

    @And("Tap on Add to cart button again")
    public void tapOnAddToCartButtonAgain() {
        productPage.tapOnAddToCardAgain();
    }

    @Then("Verify the following information the same productName= {}, skuName= {}, quantity= {}")
    public void verifyInformation(String productName, String skuName, int quantity) {
        String realHeaderCartUpdate = productPage.getHeaderCartUpdate();
        assertThat(realHeaderCartUpdate).isEqualTo("Cart updated");
        String realProductNameOnCartUpdate = productPage.getProductNameInCartUpdate();
        assertThat(realProductNameOnCartUpdate).isEqualTo(productName);
        String realSkuNameOnCarUpdate = productPage.getSkuNameOnCartUpdate();
        assertThat(realSkuNameOnCarUpdate).isEqualTo(skuName);
        int realQuantity = productPage.getQuantityOnCartUpdate();
        assertThat(realQuantity).isEqualTo(quantity);
        String realViewCartButtonText = productPage.getTextViewCartButton();
        assertThat(realViewCartButtonText).isEqualTo("VIEW CART");
        int countProductInCartAfter = productPage.getCountProductInCart();
        assertThat(countProductInCartAfter).isEqualTo(countProductBefore + 1);
    }
}
