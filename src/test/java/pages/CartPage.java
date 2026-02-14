package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    // Locator for the specific 'Remove' button
    private final By removeBoltButton = By.id("remove-sauce-labs-bolt-t-shirt");
    private final By cartItems = By.className("cart_item");
    private final By continueShoppingBtn = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // This is the missing "symbol" the error is complaining about!
    public void removeBoltTshirt() {
        driver.findElement(removeBoltButton).click();
    }

    public int getNumberOfItemsInCart() {
        return driver.findElements(cartItems).size();
    }

    public InventoryPage clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
        return null;
    }
}