import java.util.Set;
import Helper.DriverManager;
import PageObjects.AdminPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.StatsPage;

public class ExerciseSevenBis {
	
	public static void main(String[] args) {
		// Go to https://app-tst-training.azurewebsites.net/
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
	
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		AdminPage admin = new AdminPage();
		StatsPage stats = new StatsPage();
		
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
		
		System.out.println("Reset Connections");
		admin.resetConnections();
		admin.closePopup();
		
		//---------------------------------------------------------------------------
		stats.goToStatsPage();
		Set<String> all = DriverManager.getDriver().getWindowHandles();
		String statsWindow = null;
		for (String window : all) {
			if (!currentWindow.equals(window) && !currentWindow.equals(newWindow) ) {
				statsWindow = window;
				break;
			}
		}
		
		// Switching to Stats tab
		DriverManager.getDriver().switchTo().window(statsWindow);
		
		
		if (!stats.hasConnections()) {
			System.out.println("There are no connections!");
		}
		
		System.out.println("Populate Records");
		if (stats.hasConnections()) {
			System.out.println("There are connections!");
		}
		
		
		
	}

}
