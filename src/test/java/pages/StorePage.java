package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    @FindBy(css = "a[title = 'View cart']")
    private WebElement viewCart;

    @FindBy(xpath = "//h1[normalize-space()='Store']")
    private WebElement titleText;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        By addToCartBtn = By.xpath("//*[text()='"+productName+"']/parent::*/following-sibling::*[text()='Add to cart']");
        wait.until(ExpectedConditions.visibilityOf(titleText));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
    }

}
