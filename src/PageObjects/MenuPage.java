package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.DriverManager;

public class MenuPage {
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	//constructor
	public MenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public boolean isShown() {
		return btnLogout.isDisplayed();
	}
	
	public LoginPage logout() {
		btnLogout.click();
		return new LoginPage();
	}

}
