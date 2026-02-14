package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List ;

    public class InventoryPage {
        private WebDriver driver;

        private final By cartIcon = By.className("shopping_cart_link");
        private final By inventoryItems = By.className("inventory_item");
        private final By linkedinIcon = By.className("social_linkedin");
        private final By facebookIcon = By.className("social_facebook");
        private final By twitterIcon = By.className("social_twitter");

        public InventoryPage(WebDriver driver) {
            this.driver = driver;
        }

        // Requirement: Open cart and return the CartPage object [cite: 6, 25]
        public CartPage openCart() {
            driver.findElement(cartIcon).click();
            return new CartPage(driver);
        }

        public boolean isCartIconDisplayed() {
            return driver.findElement(cartIcon).isDisplayed();
        }

        public int getProductsCount() {
            return driver.findElements(inventoryItems).size();
        }

        public String getPageTitle() {
            return driver.getTitle();
        }

        // Social Media Actions [cite: 12, 13, 14]
        public void clickLinkedIn() { driver.findElement(linkedinIcon).click(); }
        public void clickFacebook() { driver.findElement(facebookIcon).click(); }
        public void clickTwitter()  { driver.findElement(twitterIcon).click();  }

        // Dynamic Product Selection [cite: 20, 32]
        public void addProductByName(String name) {
            driver.findElement(By.xpath("//div[text()='" + name + "']/ancestor::div[@class='inventory_item']//button")).click();
        }

        public String getButtonTextByProductName(String name) {
            return driver.findElement(By.xpath("//div[text()='" + name + "']/ancestor::div[@class='inventory_item']//button")).getText();
        }
    }
