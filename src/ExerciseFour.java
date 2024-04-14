import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Go to https://app-tst-training.azurewebsites.net/
		driver.navigate().to("https://app-tst-training.azurewebsites.net/");
		driver.manage().window().maximize();
				
		// Click on logout button
		WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"logout\"]"));
		logoutButton.click();
		
		// enter username "admin"
		WebElement username = driver.findElement(By.cssSelector("#username"));
		username.clear();
		username.sendKeys("admin");
				
		// Enter password
		WebElement password = driver.findElement(By.cssSelector("#password"));
		password.clear();
		password.sendKeys("superduper");
		
		// Click the log in button
		WebElement loginButton = driver.findElement(By.className("content"));
		loginButton.click();
				
		System.out.println("Succesfully connected!");
		
		driver.quit();
	}

}
