package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Helper.Table;

public class StatsPage implements Table {
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"main-nav\"]/ul/li[4]/a")
	private WebElement btnStats;
	
	@FindBy(how = How.ID, using = "statTotalConn")
	private WebElement statTotalConn;
	
	@FindBy(how = How.ID, using = "stats")
	private WebElement page;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"statsConnections\"]/tbody")
	private WebElement table;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"statsConnections\"]/tbody/tr")
	private List<WebElement> rows;
	
	private WebDriver driver;
	
	//constructor
	public StatsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		
		return rows.size();
	}

	//test commit

	@Override
	public String getText(int row, int col) {

	    // Iterate rows of table
	    for (int i = 0; i < rows.size(); i++) {
	        // Get columns of the current row
	        List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	        
	        // If the current row matches the desired row
	        if (i == row) {
	            // Check if the column index is within bounds
	            if (col >= 0 && col < cols.size()) {
	                // Return the text of the cell at the specified row and column
	                return cols.get(col).getText();
	            } else {
	                // Return null if the column index is out of bounds
	                return null;
	            }
	        }
	    }
	    
	    // Return null if the row index is out of bounds
	    return null;
	}


}
