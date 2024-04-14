import org.openqa.selenium.support.PageFactory;

import DataHolder.Connection;
import Helper.DriverManager;
import PageObjects.ConnectionPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.StatsPage;

public class ExerciseCustomControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Go to https://app-tst-training.azurewebsites.net/
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
				
		Connection conn = new Connection();
		conn.setFirstName("John");
		conn.setLastName("Doe");
		conn.setSex("M");
		conn.setEmail("testing.it@hotmail.com");
		conn.setTelephone("0496123456");
		conn.setCompany("CTG Belgium");
		conn.setSsu("Testing");
		conn.setSeniority("Senior");
		conn.setAdditionalInfo("This is a test using Data Holder class!");
					
		MenuPage menu = new MenuPage(DriverManager.getDriver());
		LoginPage login = new LoginPage(DriverManager.getDriver());
		ConnectionPage connection = new ConnectionPage(DriverManager.getDriver());
		StatsPage stats = new StatsPage(DriverManager.getDriver());
						
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), connection);
		PageFactory.initElements(DriverManager.getDriver(), stats);
		
						
		menu.logout();
		login.loginAsAdmin();
				
		// clicking on the "New" menu button
		connection.goToConnectionPage();
			
		// Filling in fields and adding a new connection using a data holder class
		connection.addConnection(conn);
		
		// Clicking the "Stats" menu button
		stats.goToStatsPage();
		
		// Checking data in the table
		System.out.println("Number of rows in the table: " + stats.getRowCount());
		
		int row = 4;
		int col = 0;
		System.out.println("Text in row " + row + " and col " + col + " is: " + stats.getText(row, col));
		
		DriverManager.getDriver().quit();

	}

}
