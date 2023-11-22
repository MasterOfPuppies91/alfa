package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;
import utility.RandomStringBuilder;

public class LoginLengthTest extends BaseTest {
    private LoginPage loginPage;
    private String acceptedSymbols;

    @BeforeMethod
    public void setUpMethod() {
        loginPage = new LoginPage(driver);
        acceptedSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz[.,/'_-] ";
    }

    @Test
    public void loginLengthTest() {
        String extraLengthLogin = RandomStringBuilder.getRandomString(acceptedSymbols, 51);
        String expectedLogin = extraLengthLogin.substring(0,50);
        loginPage.enterLogin(extraLengthLogin);
        Assert.assertEquals(loginPage.getUsernameValue(), expectedLogin, "Extra length username value was not trimmed");
    }
}
