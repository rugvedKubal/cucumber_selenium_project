package pages;

import domainobjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name") private WebElement firstNameTxtBox;
    @FindBy(id = "billing_last_name") private WebElement lastNameTxtBox;
    @FindBy(id = "billing_address_1") private WebElement addressOneTxtBox;
    @FindBy(id = "billing_city") private WebElement cityTxtBox;
    @FindBy(id = "billing_state") private WebElement billingStateDropdown;
    @FindBy(id = "billing_postcode") private WebElement billingPostalCodeTxtBox;
    @FindBy(id = "billing_email") private WebElement billingEmailIdTxtBox;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(firstNameTxtBox));
        e.clear();
        e.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(lastNameTxtBox));
        e.clear();
        e.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressOne(String addressOne) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(addressOneTxtBox));
        e.clear();
        e.sendKeys(addressOne);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(cityTxtBox));
        e.clear();
        e.sendKeys(city);
        return this;
    }

    public CheckoutPage selectBillingState(String billingState) {
        Select s = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropdown)));
        s.selectByVisibleText(billingState);
        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPostalCodeTxtBox));
        e.clear();
        e.sendKeys(postalCode);
        return this;
    }

    public CheckoutPage enterEmailId(String email) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailIdTxtBox));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public CheckoutPage clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterFirstName(billingDetails.getFirstName())
                .enterLastName(billingDetails.getLastName())
                .enterAddressOne(billingDetails.getAddressOne())
                .enterCity(billingDetails.getCity())
                .selectBillingState(billingDetails.getState())
                .enterPostalCode(billingDetails.getPinCode())
                .enterEmailId(billingDetails.getEmail());
    }
}
