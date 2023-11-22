package tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.BaseTest;

public class PasswordMaskedTest extends BaseTest {
    private LoginPage loginPage;
    private String password;

    @BeforeMethod
    public void setUpMethod() {
        loginPage = new LoginPage(driver);
        password = "Password";
    }

    @Test
    public void passwordMaskedTest() {
        loginPage.enterPassword(password);
        int count = (int) (Math.random() * 10);
        for(int i = 0; i < count; i++) {
            loginPage.clickShowPassword();
        }
        if(count % 2 == 0) {
            Assert.assertTrue(loginPage.isPasswordMasked(), "Password is not masked after even count of presses on Show Password");
        } else Assert.assertFalse(loginPage.isPasswordMasked(), "Password is not masked after odd count of presses on Show Password");
    }
}
