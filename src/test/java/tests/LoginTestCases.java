package tests;

import java.awt.Button;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.LoginPage;

public class LoginTestCases {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://pratiks-desk.site/user-access-ui/login.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage login = new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// TC001 - Valid Login
			login.enterUsername("testuser@example.com");
			login.enterPassword("Pass@123");
			login.clickLogin();
			handleAlert(wait);
			driver.navigate().refresh();

			System.out.println("--------------------------------------------------------------");

			// TC002 - Empty Fields
			login.enterUsername("");
			login.enterPassword("");
			login.clickLogin();
			driver.navigate().refresh();
			System.out.println("Empty fields checked");

			System.out.println("--------------------------------------------------------------");

			// TC003 - Wrong Password
			login.enterUsername("testuser@example.com");
			login.enterPassword("wrongpass");
			login.clickLogin();
			handleAlert(wait);
			driver.navigate().refresh();

			System.out.println("--------------------------------------------------------------");

			// TC004 - Invalid Username
			login.enterUsername("invalid@example.com");
			login.enterPassword("Pass@123");
			login.clickLogin();
			handleAlert(wait);
			driver.navigate().refresh();

			System.out.println("--------------------------------------------------------------");

			// TC005 - Password Masking
			String type = login.getPasswordInputType();
			System.out.println("TC005 - Password field type: " + type);
			if (type.equals("password")) {
				System.out.println("✅ TC005 Passed: Password is masked");
			} else {
				System.out.println("❌ TC005 Failed: Password is not masked");
			}
			Thread.sleep(1000);
			driver.navigate().refresh();

			System.out.println("--------------------------------------------------------------");

			// TC006 - Form alert for random input
			login.enterUsername("random@example.com");
			login.enterPassword("1234");
			login.clickLogin();
			handleAlert(wait);
			driver.navigate().refresh();

			System.out.println("--------------------------------------------------------------");

			// TC007 - Forgot Password link
			login.clickForgotPassword();
			Thread.sleep(3000);
		
			String tabtitle = driver.getTitle();
			if (driver.getTitle().equalsIgnoreCase("Forgot Password")) {
				System.out.println("The title of current tab is : " +tabtitle);
				System.out.println("✅ TC007 Clicked Forgot Password link");
			}else {
				System.out.println("✅ TC007 Clicked Forgot Password link");
				System.out.println("but the page title is : "+tabtitle);
				
			}
			
			
		} catch (Exception e) {
			System.out.println("❌ Exception occurred: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

	// Utility to handle alert with wait
	public static void handleAlert(WebDriverWait wait) {
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("🔔 Alert Text: " + alert.getText());
			alert.accept();
		} catch (Exception e) {
			System.out.println("❌ No alert appeared: " + e.getMessage());
		}
	}
}
