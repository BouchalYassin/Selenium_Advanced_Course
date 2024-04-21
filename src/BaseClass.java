import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Helper.DriverManager;
import PageObjects.AdminPage;
import PageObjects.ConnectionPage;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.MyConnectionsPage;
import PageObjects.StatsPage;
import PageObjects.WelcomePage;

public class BaseClass {
	public static MenuPage menu;
	public static LoginPage login;
	public static AdminPage admin;
	public static WelcomePage welcome;
	public static StatsPage stats;
	public static ConnectionPage connection;
	public static MyConnectionsPage myConnections;
	public static StatsConnectionsTable statsTable;
	
	//@BeforeAll
	@BeforeClass
	public static void setup() {
		
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
		
		menu = new MenuPage();
		login = new LoginPage();
		admin = new AdminPage();
		welcome = new WelcomePage();
		stats = new StatsPage();
		connection = new ConnectionPage();
		myConnections = new MyConnectionsPage();
		statsTable = new StatsConnectionsTable();
		
	}
	
	
	//@AfterAll
	@AfterClass
	public static void quit() {
		DriverManager.getDriver().quit();
	}
}
