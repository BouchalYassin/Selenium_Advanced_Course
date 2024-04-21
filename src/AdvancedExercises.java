import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataHolder.Connection;
import Helper.ChildAvailable;
import Helper.DriverManager;

public class AdvancedExercises extends BaseClass {
	
	public static ExtentTest test;
	public static ExtentReports report;
	
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
	
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports("C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Java\\testReport.html");
		test = report.startTest("My Custom Report");
	}
	
	@Test
	public void TestUsingImageRecognition() {
		test.log(LogStatus.INFO, "Connection to the site...");
		login.loginWith("admin", "superduper", "French");
		
		test.log(LogStatus.INFO, "Clicking on the 'Show me' button");
		//welcome.displayTheBear();
		
		test.log(LogStatus.INFO, "Checking if the bear image is displayed");
		if (welcome.isTheBearDisplayed()) {
			test.log(LogStatus.PASS, "The Bear is displayed!");
		}
		else {
			// if test fails => add screenshot
			try {
				test.log(LogStatus.FAIL,test.addScreenCapture(capture(DriverManager.getDriver()))+ "Test Failed, the bear is not displayed");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		Assert.assertTrue(welcome.isTheBearDisplayed());
		
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		// Get the current timestamp 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss"); 
        String timestamp = dateFormat.format(new Date());
		File Dest = new File("C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Java\\" + timestamp
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileHandler.copy(scrFile, Dest);
		return errflpath;
		}
	
	@AfterMethod
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
	
	@Test
	public void GenerateCustomReport() {
		
	}

	
	
}
