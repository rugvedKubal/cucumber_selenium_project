package steps;

import constants.EndPoint;
import context.TestContext;
import domainobjects.Product;
import factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.StorePage;

public class AddToCartSteps {
    private final StorePage storePage;
    private final CartPage cartPage;

    public AddToCartSteps(TestContext context) {
        WebDriver driver = context.getWebDriver();
        storePage = PageFactoryManager.getStorePage(driver);
        cartPage = PageFactoryManager.getCartPage(driver);
    }

    @Given("I'm on the store page")
    public void i_m_on_the_store_page() {
        storePage.load(EndPoint.STORE);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.getName());
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(Integer expectedQuantity, Product product) {
        Assert.assertEquals(cartPage.getProductName(), product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(), expectedQuantity);
    }

}
