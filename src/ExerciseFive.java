import Helper.DriverManager;
import PageObjects.LoginPage;
import PageObjects.MenuPage;
import PageObjects.WelcomePage;

public class ExerciseFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		// Go to https://app-tst-training.azurewebsites.net/
		DriverManager.getDriver().navigate().to("https://app-tst-training.azurewebsites.net/");
		//driver.manage().window().maximize();
		
		MenuPage menu = new MenuPage();
		LoginPage login = new LoginPage();
		WelcomePage welcome = new WelcomePage();
		
		menu.logout();
		//login.loginWith("admin", "superduper", "French");
		//login.loginWith("admin", "123456", "French");
		login.loginAsAdmin();
		//System.out.println(login.getErrorMessage());

		if (welcome.getWecolmeMessage().contains("Welcome")) {
			System.out.println("The Welcome message is correct!");
		}
		else
			System.out.println("The Welcome message is NOT correct!");
		
		welcome.displayTheBear();
		
		if (welcome.isTheBearDisplayed())
			System.out.println("The bear is displayed!");
		else
			System.out.println("The bear is NOT displayed!");
		
		
		DriverManager.getDriver().quit();
	}

}
