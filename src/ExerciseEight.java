import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import Helper.CustomListener;
import Helper.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.StatsPage;

public class ExerciseEight {
	
	public static void main(String[] args) {
		
		WebDriver normalDriver = new ChromeDriver();
		WebDriverListener listener = new CustomListener();
		WebDriver eventDriver = new EventFiringDecorator<WebDriver>(listener).decorate(normalDriver);
		
		
		
		
		// Go to https://app-tst-training.azurewebsites.net/
		eventDriver.navigate().to("https://app-tst-training.azurewebsites.net/");
	
		MenuPage menu = new MenuPage(DriverManager.getDriver());
		LoginPage login = new LoginPage(DriverManager.getDriver());
		AdminPage admin = new AdminPage(DriverManager.getDriver());
		StatsPage stats = new StatsPage(DriverManager.getDriver());
		
		PageFactory.initElements(eventDriver, menu);
		PageFactory.initElements(eventDriver, login);
		PageFactory.initElements(eventDriver, admin);
		PageFactory.initElements(eventDriver, stats);
		
		menu.logout();
		login.loginAsAdmin();
		
		//save the wh of the main page
		String currentWindow = eventDriver.getWindowHandle();
		
		admin.goToAdminPage();
		
		admin.clickOnNonExistingButton();
		
		
	}

}
