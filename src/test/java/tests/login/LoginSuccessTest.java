package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class LoginSuccessTest extends BaseTest {
    private LoginPage loginPage;
    private String login;
    private String password;

    @BeforeMethod
    public void setUpMethod() {
        loginPage = new LoginPage(driver);
        login = "Login";
        password = "Password";
    }

    @Test
    public void loginSuccessTest() {
        loginPage.enterLogin(login);
        loginPage.enterPassword(password);
        loginPage.clickLogIn();
        Assert.assertTrue(loginPage.isLoginSuccessLabelPresent(), "User was not logged in");
    }
}
