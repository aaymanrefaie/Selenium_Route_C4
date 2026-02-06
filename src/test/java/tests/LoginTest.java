package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    public void verifySuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"),
                "User is NOT redirected to Inventory page"
        );
    }
    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Username and password do not match"),
                "Error message is incorrect"
        );
    }

    @Test
    public void verifyLoginWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.getErrorMessage().contains("Password is required"),
                "Error message is incorrect"
        );
    }
}


