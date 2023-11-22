package tests.login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import tests.BaseTest;

public class LoginUnacceptedSymbolsTest extends BaseTest {
    private LoginPage loginPage;
    private String unacceptedSymbols;
    private String errorMessage;

    @BeforeMethod
    public void setUpMethod() {
        loginPage = new LoginPage(driver);
        unacceptedSymbols = "<>!~`?@$%^&*()+=";
        errorMessage = "InvalidValue";
    }

    @Test
    public void loginLengthTest() {
        SoftAssert softAssert = new SoftAssert();
        String symbol;
        for(char ch : unacceptedSymbols.toCharArray()) {
            symbol = String.valueOf(ch);
            loginPage.enterLogin(symbol);
            softAssert.assertEquals(loginPage.getErrorMessage(), errorMessage, "Character '" + symbol + "' did not trigger InvalidValue error");
        }
        softAssert.assertAll();
    }
}
