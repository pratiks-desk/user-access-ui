package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    WebDriver driver;

    // Locators
    private By emailField = By.id("forgotEmail");
    private By submitButton = By.xpath("//button[@type='submit']");

    // Constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions
    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public void submitFormWithEmail(String email) {
        enterEmail(email);
        clickSubmit();
    }
}
