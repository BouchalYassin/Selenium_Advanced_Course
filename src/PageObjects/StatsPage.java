package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Helper.DriverManager;


public class StatsPage {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[4]/a")
	private WebElement btnStats;
	
	@FindBy(how = How.ID, using = "statTotalConn")
	private WebElement statTotalConn;
	
	@FindBy(how = How.ID, using = "stats")
	private WebElement page;

	
	//constructor
	public StatsPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	
	public StatsPage goToStatsPage() {
		btnStats.click();
		return this;
	}
	
	public boolean isShown() {
		return page.isDisplayed();
	}
	
	public boolean hasConnections() {
		return !statTotalConn.getText().contains("N/A");
	}

}
