package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {
    @Test
    public void verifyInventoryPageElements() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Login first
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Assertions
        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Swag Labs",
                "Page title is incorrect"
        );

        Assert.assertTrue(
                inventoryPage.isCartIconDisplayed(),
                "Cart icon is not displayed"
        );

        Assert.assertEquals(
                inventoryPage.getProductsCount(),
                6,
                "Products count is not 6"
        );
    }
}
