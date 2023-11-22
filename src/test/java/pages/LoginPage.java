package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@text='Вход в Alfa-Test']")
    private AndroidElement title;
    @FindBy(xpath = "//*[contains(@resource-id,'etUsername')]")
    private AndroidElement loginInput;
    @FindBy(id = "etPassword")
    private AndroidElement passwordInput;
    @FindBy(css = ".android.widget.Button")
    private AndroidElement loginButton;
    @FindBy(xpath = "//*[contains(@resource-id,'tvError')]")
    private AndroidElement errorMessage;
    @FindBy(xpath = "//*[@text='Вход в Alfa-Test выполнен']")
    private AndroidElement successLoginLabel;
    @FindBy(id = "text_input_end_icon")
    private AndroidElement showPasswordButton;

    private final By loginLocator = By.xpath("//android.widget.ProgressBar");

    public LoginPage(AndroidDriver<?> driver) {
        super(driver);
    }

    public boolean ifTitlePresent() {
        return isDisplayed(title);
    }

    public boolean isLoginPresent() {
        return isDisplayed(loginInput);
    }

    public boolean isPasswordPresent() {
        return isDisplayed(passwordInput);
    }

    public boolean isLoginSuccessLabelPresent() {
        return isDisplayed(successLoginLabel);
    }

    public String getUsernameValue() {
        return getElementValue(loginInput);
    }

    public String getErrorMessage() {
        return getElementValue(errorMessage);
    }

    public void clickLogIn() {
        click(loginButton);
        waitForElementLocatedDisappearance(loginLocator);
    }

    public boolean isLoginButtonPresent() {
        return isDisplayed(loginButton);
    }

    public void enterLogin(String text) {
        enterTextToInput(loginInput, text);
    }

    public void enterPassword(String text) {
        enterTextToInput(passwordInput, text);
    }

    public boolean isPasswordMasked() {
        return Boolean.parseBoolean(passwordInput.getAttribute("password"));
    }

    public void clickShowPassword() {
        click(showPasswordButton);
    }
}
