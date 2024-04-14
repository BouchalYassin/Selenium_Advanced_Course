package Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null) {
			setChromeDriver();
		}
		return driver;
	}
	
 
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void setFireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void setEdgeDriver() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	
	public static void quitDriver() {
		if (!(driver == null)) {
			driver.quit();
		}
		driver = null;
	}
}
