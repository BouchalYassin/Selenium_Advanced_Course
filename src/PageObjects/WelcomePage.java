package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.DriverManager;

public class WelcomePage {
	
	@FindBy(how = How.ID, using = "welcome")
	private WebElement message;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"welcome\"]/p[4]/input")
	private WebElement btnShowMe;
	
	@FindBy(how = How.ID, using = "bear")
	private WebElement bearImage;
	
	
	//constructor
	public WelcomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
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
