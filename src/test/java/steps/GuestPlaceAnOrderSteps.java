package steps;

import apis.CartApi;
import constants.EndPoint;
import context.TestContext;
import domainobjects.BillingDetails;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;

public class GuestPlaceAnOrderSteps {

    private BillingDetails billingDetails;
    private final StorePage storePage;
    private final CheckoutPage checkoutPage;
    private final CartPage cartPage;
    private TestContext context;

    public GuestPlaceAnOrderSteps(TestContext context) {
        WebDriver driver = context.getWebDriver();
        storePage = PageFactoryManager.getStorePage(driver);
        checkoutPage = PageFactoryManager.getCheckoutPage(driver);
        cartPage = PageFactoryManager.getCartPage(driver);
        this.context = context;
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        storePage.load(EndPoint.STORE);
    }

    @And("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        //storePage.addToCart("Blue Shoes");
        CartApi cartApi = new CartApi(context.getAppCookies().getCookies());
        cartApi.addToCart(1215, 1);
        context.setAppCookies(cartApi.getCookies());
        context.getAppCookies().injectCookiesToBrowser(context.getWebDriver());
    }

    @Given("I'm on the checkout page")
    public void i_m_on_the_checkout_page() {
       checkoutPage.load(EndPoint.CHECKOUT);
    }

    @When("I provide billing details")
    public void i_provide_billing_details() {
        checkoutPage.setBillingDetails(billingDetails);
    }

    @When("I place an order")
    public void i_place_an_order() {
        checkoutPage.clickPlaceOrder();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }


}
