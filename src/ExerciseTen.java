//import org.junit.Assert;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Helper.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.WelcomePage;

public class ExerciseTen {
	
	public static MenuPage menu;
	public static LoginPage login;
	public static AdminPage admin;
	public static WelcomePage welcome;
	
	//@BeforeAll
	@BeforeClass
	public static void setup() {
		
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
		
		menu = new MenuPage();
		login = new LoginPage();
		admin = new AdminPage();
		welcome = new WelcomePage();
		
	}
	
	
	//@BeforeEach
	@BeforeMethod
	public void initializePage() {
		menu.logout();
	}
	
	
	@Test
	public void LoginWithCorrectUsernameAndPassword() {
		login.loginWith("admin", "superduper", "French");
		Assert.assertTrue(welcome.isShown());
	}
	
	@Test
	public void LoginWithCorrectUsernameAndIncorrectPassword() {
		login.loginWith("admin", "incorrect", "French");
		Assert.assertFalse(welcome.isShown());
	}
	
	@Test
	public void LoginWithIncorrectUsername() {
		login.loginWith("123", "superduper", "French");
		Assert.assertFalse(welcome.isShown());
	}
	
	@Test
	public void LoginWithEmptyUsernameAndPassword() {
		login.loginWith("", "", "French");
		Assert.assertFalse(welcome.isShown());	
	}
	
	//@AfterAll
	@AfterClass
	public static void quit() {
		DriverManager.getDriver().quit();
	}

}
