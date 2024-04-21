package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Helper.DriverManager;

public class LoginPage {
	
	@FindBy(how = How.ID, using = "login")
	private WebElement page;
	
	@FindBy(how = How.ID, using = "username")
	private WebElement fldUsername;
	
	@FindBy(how = How.ID, using = "password")
	private WebElement fldPassword;
	
	@FindBy(how = How.NAME, using = "language")
	private WebElement fldLanguage;
	
	@FindBy(how = How.TAG_NAME, using = "label")
	private WebElement btnLogin;
	
	@FindBy(how = How.ID, using = "errors")
	private WebElement errorMessage;
	
	
	//constructor
	public LoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public WelcomePage loginWith(String username, String password, String language) {
		fldUsername.clear();
		fldUsername.sendKeys(username);
		fldPassword.clear();
		fldPassword.sendKeys(password);
		setLanguage(language);
		btnLogin.click();
		return new WelcomePage();
	}
	
	public boolean isShown() {
		return page.isDisplayed();
	}
	
	public LoginPage setLanguage(String language) {
		Select options = new Select(fldLanguage);
		options.selectByVisibleText(language);
		return this;
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	
	public WelcomePage loginAsAdmin() {
		fldUsername.clear();
		fldUsername.sendKeys("admin");
		fldPassword.clear();
		fldPassword.sendKeys("superduper");
		setLanguage("French");
		btnLogin.click();
		return new WelcomePage();
	}

}
