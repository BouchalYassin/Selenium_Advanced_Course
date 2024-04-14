package PageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.DriverManager;

public class AdminPage {
	
	@FindBy(how = How.ID, using = "admin")
	private WebElement page;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[2]/td[1]/label")
	private WebElement btnResetUsers;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[6]/a")
	private WebElement btnAdmin;
	
	@FindBy(how = How.ID, using = "new_username")
	private WebElement newUsername;
	
	@FindBy(how = How.ID, using = "new_password")
	private WebElement newPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[1]/tbody/tr[3]/td[2]/span")
	private WebElement btnCreate;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[1]/td[1]/label")
	private WebElement btnResetConnections;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"admin\"]/table[2]/tbody/tr[3]/td[1]/label")
	private WebElement btnPopulateRecords;
	
	@FindBy(how = How.ID, using = "inccorect")
	private WebElement bntNotExist;
	
	private WebDriver driver;
	
	//constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isShown() {
		return page.isDisplayed();
	}
	
	
	public AdminPage goToAdminPage() {
		btnAdmin.click();
		return new AdminPage(driver);
	}
	
	public AdminPage clickOnResetUsers() {
		btnResetUsers.click();
		return this;
	}
	
	public AdminPage createNewUser(String username, String password) {
		newUsername.sendKeys(username);
		newPassword.sendKeys(password);
		btnCreate.click();
		return this;
	}
	
	public Alert getPopup() {
		return DriverManager.getDriver().switchTo().alert();
	}
	
	public String getPopupText() {
		return getPopup().getText();
	}
	
	public AdminPage closePopup() {
		getPopup().accept();
		return this;
	}
	
	public AdminPage populateForTesting() {
		btnPopulateRecords.click();
		return this;
	}
	
	public AdminPage resetConnections() {
		btnResetConnections.click();
		return this;
	}
	
	public AdminPage clickOnNonExistingButton() {
		bntNotExist.click();
		return this;
	}

}
