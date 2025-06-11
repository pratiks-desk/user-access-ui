package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RegisterPage {
    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.id("regUsername");
    By email = By.id("regEmail");
    By password = By.id("regPassword");
    By confirmPassword = By.id("regConfirmPassword");
    By male = By.cssSelector("input[name='gender'][value='Male']");
    By female = By.cssSelector("input[name='gender'][value='Female']");
    By other = By.cssSelector("input[name='gender'][value='Other']");
    By contact = By.id("regContact");
    By registerButton = By.xpath("//button[text()='Register']");

    public void enterUsername(String value) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);
    }

    public void enterConfirmPassword(String value) {
        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void selectGender(String gender) {
        switch (gender.toLowerCase()) {
            case "male":
                driver.findElement(male).click(); break;
            case "female":
                driver.findElement(female).click(); break;
            case "other":
                driver.findElement(other).click(); break;
        }
    }

    public void enterContact(String value) {
        driver.findElement(contact).clear();
        driver.findElement(contact).sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public void handleAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }
    }

    public void fillAllFields(String uname, String mail, String pwd, String confirmPwd, String gen, String phone) {
        enterUsername(uname);
        enterEmail(mail);
        enterPassword(pwd);
        enterConfirmPassword(confirmPwd);
        selectGender(gen);
        enterContact(phone);
    }

    public void resetForm() {
        driver.navigate().refresh();
    }
}
