import static org.testng.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DataHolder.Connection;
import Helper.ChildAvailable;
import Helper.DriverManager;

public class AdvancedExercises extends BaseClass {
	
	@FindBy(how = How.ID, using = "myrecords")
    private WebElement divMyConnections;
	
	
	//@BeforeEach
	@BeforeMethod
	public void initializePage() {
		menu.logout();
	}
	
	@Test
	public void TestUsingJavascriptFunction() {
		login.loginWith("admin", "superduper", "French");
		//Assert.assertTrue(welcome.isShown());
		
		// open my connections
		stats.goToStatsPage();
		
		
		/* Reset all connections by executing (Javascript) this function:
		- resetAddressBook(false) */
		admin.resetAddressBook(false);
		admin.closePopup();
		
		/*
		 * Check that there are no connections in the connections statistics table
			(StatsPage). 
		 */
		Assert.assertFalse(stats.hasConnections());
		
		/*
		 * Populate the connections by executing (Javascript) this function:
			populateForTesting(false)
		 */
		admin.populateForTesting(false);
		admin.closePopup();
		
		
		
		/*
		 * Check that:
			- The connections page contains Peter Parker as a record
			- The stats page contains 13 men & 3 women
		 */
		myConnections.gotoConnectionsTab();
		Assert.assertTrue(myConnections.isRecordAvailable("parker"));
		
		stats.goToStatsPage();
		Assert.assertTrue(statsTable.getText(1, 2).contains("13")); // 13 men
		Assert.assertTrue(statsTable.getText(2, 2).contains("3")); // 3 women
	}
	
	@Test
	public void TestUsingCustomExpectedCondition() {
		login.loginWith("admin", "superduper", "French");
		connection.goToConnectionPage();
		
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
		connection.addConnection(conn);
		
		myConnections.gotoConnectionsTab();
		Assert.assertTrue(myConnections.isRecordAvailable("doe"));
		
		WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), Duration.ofMinutes(1));
		Boolean elements = wait.until(new ChildAvailable(divMyConnections, By.id("records")));
		
		Assert.assertTrue(elements);
	}
	
	@Test
	public void TestUsingImageRecognition() {
		login.loginWith("admin", "superduper", "French");
		welcome.displayTheBear();
		
		Assert.assertTrue(welcome.isTheBearDisplayed());
	}

	
	
}
