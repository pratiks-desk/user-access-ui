package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

public class RegisterTestCases {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://pratiks-desk.site/user-access-ui/register.html");
        RegisterPage reg = new RegisterPage(driver);

        // TC101 - Valid Registration
        reg.fillAllFields("testuser", "test@example.com", "Password1", "Password1", "Male", "9876543210");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        // TC102 - Empty Fields
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();

        System.out.println("--------------------------------------------------------------");
        
        // TC103 - Password Mismatch
        reg.fillAllFields("testuser", "test@example.com", "Password1", "Password2", "Male", "9876543210");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        // TC104 - Invalid Email Format
        reg.fillAllFields("testuser", "invalid-email", "Password1", "Password1", "Female", "9876543210");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        // TC105 - Invalid Contact Number
        reg.fillAllFields("testuser", "test@example.com", "Password1", "Password1", "Male", "abc123");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        // TC106 - Gender Not Selected
        reg.enterUsername("testuser");
        reg.enterEmail("test@example.com");
        reg.enterPassword("Password1");
        reg.enterConfirmPassword("Password1");
        reg.enterContact("9876543210");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        // TC107 - Password too short
        reg.fillAllFields("testuser", "test@example.com", "123", "123", "Other", "9876543210");
        reg.clickRegister();
        reg.handleAlertIfPresent();
        reg.resetForm();
        
        System.out.println("--------------------------------------------------------------");

        System.out.println("✅ All registration test cases completed.");
        driver.quit();
    }
}
