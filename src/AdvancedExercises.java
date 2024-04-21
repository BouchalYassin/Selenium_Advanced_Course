import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdvancedExercises extends BaseClass {
	
	
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
	

	
	
}
