import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		//String browser = "Chrome";
		
		driver.get("https://be.ctg.com/");
		
		driver.manage().window().maximize();	
		System.out.println("The title is " + driver.getTitle());
		
		/*switch (browser) {
        case "Chrome":
          driver = new ChromeDriver();
          break;
        case "Firefox":
        	driver = new FirefoxDriver();
        	
        default;*/
		
		
		
		
		driver.quit();
	}

}
