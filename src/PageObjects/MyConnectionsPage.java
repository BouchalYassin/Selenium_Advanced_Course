package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.DriverManager;

public class MyConnectionsPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[2]/a")
	private WebElement connTab;
	
	@FindBy(how = How.ID, using = "searchTerm")
	private WebElement fldSearch;
	
	@FindBy(how = How.ID, using = "Peter;Parker")
	private WebElement row;
	
	//constructor
	public MyConnectionsPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public ConnectionPage gotoConnectionsTab() {
		connTab.click();
		return new ConnectionPage();
	}
	
	public boolean isRecordAvailable(String record) {
		fldSearch.clear();
		fldSearch.sendKeys(record);
		
		return row.isDisplayed();
	}

}
