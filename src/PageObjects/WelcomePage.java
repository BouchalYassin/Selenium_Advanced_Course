package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	@FindBy(how = How.ID, using = "welcome")
	private WebElement message;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/p[4]/input")
	private WebElement btnShowMe;
	
	@FindBy(how = How.ID, using = "bear")
	private WebElement bearImage;
	
	private WebDriver driver;
	
	//constructor
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getWecolmeMessage() {
		return message.getText();
	}
	
	public WelcomePage displayTheBear() {
		btnShowMe.click();
		return this;
	}
	
	public boolean isTheBearDisplayed() {
		return bearImage.isDisplayed();
	}
	
	public boolean isShown() {
		//return getWecolmeMessage().contains("Welcome");
		return message.isDisplayed();
	}

}
