package sji.janssen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeOperator {

	public WebDriver driver = null;

	public ChromeOperator() {

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver[90].exe");
    	
    	ChromeOptions options = new ChromeOptions();
//    	options.addArguments("user-data-dir=C:/Users/JAVA_USER/AppData/Local/Google/Chrome/User Data/Profile 1");
    	options.addArguments("--start-maximized");
    	driver = new ChromeDriver(options);
    	
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public void closeUrl() {
		driver.close();
	}

	public boolean waitUntillVisible(By by) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inElementPresent(By by) {
		
		return waitUntillVisible(by) ? true : false;
	}
	
	public String getText(By by) {
		String txt = "";
		try {
			txt = driver.findElement(by).getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return txt;
	}
	
	public boolean inputTxt(By by, String txt) {
		
		try {
			driver.findElement(by).sendKeys(txt);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean checkBox(By by) {
		
		try {
			driver.findElement(by).sendKeys(Keys.SPACE);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean click(By by) {	

		try {
			driver.findElement(by).click();;
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
	
	
}
