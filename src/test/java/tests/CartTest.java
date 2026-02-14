package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void verifySocialLinks() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");
        String originalWindow = driver.getWindowHandle();

        // Check Socials
        inventoryPage.clickLinkedIn();
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
        driver.close();
        driver.switchTo().window(originalWindow);

        inventoryPage.clickFacebook();
        switchToNewTab(originalWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void verifyCartFunctionality() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        // Step 1: Verify Empty
        CartPage cartPage = inventoryPage.openCart();
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(), 0);
        inventoryPage = cartPage.clickContinueShopping();

        // Step 2: Add 3 Items
        inventoryPage.addProductByName("Sauce Labs Backpack");
        inventoryPage.addProductByName("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductByName("Sauce Labs Onesie");
        cartPage = inventoryPage.openCart();
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(), 3);

        // Step 3: Remove Item & Verify
        cartPage.removeBoltTshirt();
        inventoryPage = cartPage.clickContinueShopping();
        Assert.assertEquals(inventoryPage.getButtonTextByProductName("Sauce Labs Bolt T-Shirt"), "Add to cart");
    }

    private void switchToNewTab(String originalWindow) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}