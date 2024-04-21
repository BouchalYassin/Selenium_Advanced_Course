package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ChildAvailable implements ExpectedCondition<Boolean> {
	
	@FindBy(how = How.ID, using = "myrecords")
    private WebElement divMyConnections;
    //private WebElement divMyConnections;
	private By records;
	
	//constructor
	public ChildAvailable(WebElement divMyConnections, By records) {
		this.divMyConnections = divMyConnections;
		this.records = records;
	}


	@Override
	public Boolean apply(WebDriver driver) {
		return driver.findElement(records).isDisplayed();
		//return divMyConnections.isDisplayed() && driver.findElement(records).isDisplayed();
	}

}
