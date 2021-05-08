package sji.janssen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test {

	WebDriver driver = null;
	String url = "https://jqueryui.com/resizable/";
	
	public Test(WebDriver driver) {
		this.driver = driver;
	}
	
	public void resizeBox() {
		
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		By holdPointBy = By.xpath("//div[@id='resizable']/div[contains(@class,'ui-resizable-se')]");
		
		WebElement we = driver.findElement(holdPointBy);
		Actions actions = new Actions(driver);
		
		actions.moveToElement(we).clickAndHold(we).moveByOffset(120, 120).release().build();
		
		actions.perform();
		
		
		
	}
	
}
