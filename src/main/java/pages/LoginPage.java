package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By forgotPasswordLink = By.linkText("Forgot Password?");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLink).click();
    }

    public String getPasswordInputType() {
        return driver.findElement(passwordInput).getAttribute("type");
    }
}

	



