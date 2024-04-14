import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com");
		System.out.println("The title is " + driver.getTitle());
		String firstTitle = driver.getTitle(); // save the title of page 1
		// check url
		if (driver.getCurrentUrl().equals(firstTitle))
			System.out.println("The current URL is " + driver.getCurrentUrl());
		
		driver.navigate().to("https://www.bing.com");
		System.out.println("The title is " + driver.getTitle());
		String secondTitle = driver.getTitle(); // save the title of page 2
		// check url
		if (driver.getCurrentUrl().equals(secondTitle))
			System.out.println("The current URL is " + driver.getCurrentUrl());
		
		driver.navigate().back();
		
		if (firstTitle.equals(driver.getTitle()))
			System.out.println("First check: The title is the same as in (1)");
		
		driver.navigate().refresh();
		
		if (firstTitle.equals(driver.getTitle()))
			System.out.println("Second check: The title is the same as in (1)");
		
		driver.quit();
		
		// Exercise 2bis
		
		
		
	}

}
