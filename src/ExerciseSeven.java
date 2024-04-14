import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Helper.DriverManager;

public class ExerciseSeven {
	
	public static void main(String[] args) {
		// Go to https://app-tst-training.azurewebsites.net/
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
	
		MenuPage menu = new MenuPage(DriverManager.getDriver());
		LoginPage login = new LoginPage(DriverManager.getDriver());
		AdminPage admin = new AdminPage(DriverManager.getDriver());
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), admin);
		
		menu.logout();
		login.loginAsAdmin();
		
		//save the wh of the main page
		String currentWindow = DriverManager.getDriver().getWindowHandle();
		
		admin.goToAdminPage();
		
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for (String window : allWindows) {
			if (!currentWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
		
		// Switching to Admin tab
		DriverManager.getDriver().switchTo().window(newWindow);
		
		admin.clickOnResetUsers();
		
		
		//Alert popup = DriverManager.getDriver().switchTo().alert();
		String popupText = admin.getPopupText();
		
		// closing the popup
		admin.closePopup();
		
		// creating new user
		String newUsername = "Hello";
		String newPassword = "World";
		admin.createNewUser(newUsername, newPassword);
		
		// switch back to main page
		DriverManager.getDriver().switchTo().window(currentWindow);
		
		menu.logout();
		
		
		login.loginWith(newUsername, newPassword, "French");
		
	}
	
	

}
