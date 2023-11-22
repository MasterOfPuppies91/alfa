package tests.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import tests.BaseTest;

public class FieldsPresenceTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpMethod() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void fieldsPresenceTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.ifTitlePresent(), "Title is not displayed");
        softAssert.assertTrue(loginPage.isLoginPresent(), "Username field is not displayed");
        softAssert.assertTrue(loginPage.isPasswordPresent(), "Password field is not displayed");
        softAssert.assertTrue(loginPage.isLoginButtonPresent(), "Login Button is not displayed");
        softAssert.assertAll();
    }
}
