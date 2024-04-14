import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExerciseThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Go to https://app-tst-training.azurewebsites.net/
		driver.navigate().to("https://app-tst-training.azurewebsites.net/");
		driver.manage().window().maximize();
		
		// Click on logout button
		WebElement logoutButton = driver.findElement(By.id("logout"));
		logoutButton.click();
		
		// Set the language to FR
		WebElement setLanguangeToFrench = driver.findElement(By.name("language"));
		Select options = new Select(setLanguangeToFrench);
		options.selectByVisibleText("French");
		
		// enter username "admin"
		WebElement username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("admin");
		
		// Enter password
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("superduper");
		
		// Click the log in button
		WebElement loginButton = driver.findElement(By.tagName("label"));
		loginButton.click();
		
		System.out.println("Succesfully connected!");
		
		// Exercise 3bis
		// Go to the New tab
		WebElement newTab = driver.findElement(By.id("crudConnection"));
		newTab.click();
		
		// Firstname
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.clear();
		firstName.sendKeys("Yassin");
		
		// Lastname
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		lastName.sendKeys("Bouchal");
		
		// Sex
		WebElement sex = driver.findElement(By.id("sex"));
		Select sexOptions = new Select(sex);
		sexOptions.selectByVisibleText("M");
		
		
		// Email
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("Bouchal_test@gmail.com");
		
		// Telephone
		WebElement telephone = driver.findElement(By.id("telephone"));
		telephone.clear();
		telephone.click();
		telephone.sendKeys("0486874512");
		
		// Company
		WebElement company = driver.findElement(By.id("company"));
		company.clear();
		company.sendKeys("CTG Belgium");
		
		// SSU
		WebElement ssu = driver.findElement(By.id("SSU"));
		Select ssuOptions = new Select(ssu);
		ssuOptions.selectByVisibleText("Testing");
		
		// Seniority
		WebElement seniority = driver.findElement(By.id("seniority"));
		Select seniorityOptions = new Select(seniority);
		seniorityOptions.selectByVisibleText("Experienced");
		
		// Additional info
		WebElement moreInfo = driver.findElement(By.id("interests"));
		moreInfo.clear();
		moreInfo.sendKeys("This is an additional text message!");
		
		// Click the Add button
		WebElement addButton = driver.findElement(By.id("add"));
		addButton.click();
		System.out.println("Succesfully added!");
		
		driver.quit();

	}

}
