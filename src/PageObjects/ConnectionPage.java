package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import DataHolder.Connection;

public class ConnectionPage {
	
	@FindBy(how = How.ID, using = "firstName")
	private WebElement fldFirstName;

	@FindBy(how = How.ID, using = "lastName")
	private WebElement fldLastName;
	
	@FindBy(how = How.ID, using = "sex")
	private WebElement fldSex;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement fldEmail;
	
	@FindBy(how = How.ID, using = "telephone")
	private WebElement fldTelephone;
	
	@FindBy(how = How.ID, using = "company")
	private WebElement fldCompany;
	
	@FindBy(how = How.ID, using = "SSU")
	private WebElement fldSsu;
	
	@FindBy(how = How.ID, using = "seniority")
	private WebElement fldSeniority;
	
	@FindBy(how = How.ID, using = "interests")
	private WebElement fldAdditionalInfo;
	
	@FindBy(how = How.ID, using = "add")
	private WebElement btnAdd;
	
	@FindBy(how = How.ID, using = "crudConnection")
	private WebElement newTab;
	
	@FindBy(how = How.ID, using = "newRecord")
	private WebElement page;
	
	private WebDriver driver;

	//constructor
	public ConnectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isShown() {
		return page.isDisplayed();
	}
	
	public ConnectionPage goToConnectionPage() {
		newTab.click();
		return new ConnectionPage(driver);
	}
	
	public ConnectionPage addConnection(Connection conn) {
		fldFirstName.sendKeys(conn.getFirstName());
		fldLastName.sendKeys(conn.getLastName());
		Select sexOptions = new Select(fldSex);
		sexOptions.selectByVisibleText(conn.getSex());

		fldEmail.sendKeys(conn.getEmail());
		
		fldTelephone.clear();
		fldTelephone.click();
		fldTelephone.sendKeys(conn.getTelephone());
		
		fldCompany.sendKeys(conn.getCompany());
		
		Select ssuOptions = new Select(fldSsu);
		ssuOptions.selectByVisibleText(conn.getSsu());
		
		Select seniorityOptions = new Select(fldSeniority);
		seniorityOptions.selectByVisibleText(conn.getSeniority());
		
		fldAdditionalInfo.clear();
		fldAdditionalInfo.sendKeys(conn.getAdditionalInfo());
		
		btnAdd.click();
		return this;
	}
}
