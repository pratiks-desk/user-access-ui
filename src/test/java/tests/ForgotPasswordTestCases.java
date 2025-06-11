package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.ForgotPasswordPage;

public class ForgotPasswordTestCases {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);

        driver.get("https://pratiks-desk.site/user-access-ui/forgot-password.html"); // Update path to your local HTML file
        driver.manage().window().maximize();

        // ---------- TC201: Valid Email Submission ----------
        System.out.println("Running TC201: Valid Email Submission");
        forgotPage.submitFormWithEmail("test@example.com");
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Text: " + alert1.getText());
        alert1.accept();
        
        System.out.println("--------------------------------------------------------------");

        // ---------- TC202: Empty Email ----------
        System.out.println("Running TC202: Empty Email");
        forgotPage.submitFormWithEmail("");
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Text: " + alert2.getText());
        alert2.accept();
        
        System.out.println("--------------------------------------------------------------");

        // ---------- TC203: Invalid Email Format ----------
        System.out.println("Running TC203: Invalid Email Format");
        forgotPage.submitFormWithEmail("invalid-email");
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Text: " + alert3.getText());
        alert3.accept();
        
        System.out.println("--------------------------------------------------------------");

        driver.quit();
    }
}
