package Helper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomListener implements WebDriverListener {
	
	public void afterClick(WebElement element) {
		System.out.println("I clicked on " + element);
	}
	
	public void beforeClick(WebElement element) {
		System.out.println("I'm going to click on " + element);
	}
	
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		if (e.getTargetException() instanceof NoSuchElementException) {
			File f = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(f, new File("C:\\Users\\ybouchal\\OneDrive - CTG\\TAC 2024\\Selenium\\Screenshots\\screenshot_" +
				
						new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date()) + ".png"));
				System.out.println("NoSuchElementException error. See screenshot.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
