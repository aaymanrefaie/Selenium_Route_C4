package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By cartIcon = By.className("shopping_cart_link");
    private By inventoryItems = By.className("inventory_item");

    // Actions
    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductsCount() {
        List<?> products = driver.findElements(inventoryItems);
        return products.size();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}