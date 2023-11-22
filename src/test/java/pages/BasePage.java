package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected AndroidDriver<?> driver;
    protected WebDriverWait wait;

    protected BasePage(AndroidDriver<?> driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected void enterTextToInput(WebElement input, String text) {
        input.sendKeys(text);
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    protected String getElementValue(WebElement element) {
        return element.getText();
    }

    protected void waitForElementLocatedDisappearance(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
