/*import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;*/
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import Helper.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.WelcomePage;

public class ExerciseEleven {
	
	public static MenuPage menu;
	public static LoginPage login;
	public static AdminPage admin;
	public static WelcomePage welcome;
	
	//@BeforeAll
	@BeforeClass
	public static void setup() {
		
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
		
		menu = new MenuPage(DriverManager.getDriver());
		login = new LoginPage(DriverManager.getDriver());
		admin = new AdminPage(DriverManager.getDriver());
		welcome = new WelcomePage(DriverManager.getDriver());
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), admin);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		
		
	}
	
	//@BeforeEach
	@BeforeMethod
	public void initializePage() {
		menu.logout();
	}
	
	/*@ParameterizedTest
	@CsvSource({
		"admin, incorrect, French",
		"incorrect, superduper, French",
		", , French"
	})*/
	void LoginWithIncorrecttUsernameOrPassword(String username, String password, String language) {
		if (username == null && password == null) {
			username = "";
			password = "";
		}
		login.loginWith(username, password, language);
		Assert.assertFalse(welcome.isShown());
	}
	

	
	//@AfterAll
	@AfterClass
	public static void quit() {
		DriverManager.getDriver().quit();
	}


}
