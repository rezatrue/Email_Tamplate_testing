package sji.janssen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EloquaServer {
	
	WebDriver driver = null;
	
	String EloquaSiteUrl = "https://secure.p03.eloqua.com/Main.aspx#emails&id=19522";
	
	String EloquaSite = "JanssenPharmaceutica";
	String userName = "Arif.Islam";
	String password = "2@Queensvillage#";
	
	public EloquaServer(WebDriver driver) {
		this.driver = driver;
		
		signin();
		
		saveEmail();
	}
	
	public boolean inElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

	public String getText(By by) {
		String txt="";
		try {
			txt = driver.findElement(by).toString();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return txt;
	}
	
	
	public boolean waitUntillVisible(By by) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean waitUntillClickable(By by) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean signin() {
		
		// Signin to Eloqua
		driver.get(EloquaSiteUrl);
    	
    	By eloquaLoginFromBy = By.xpath("//div[@class='name-bar-title']/div[@class='app-name']");
    	By sitenameBy = By.xpath("//input[@id='sitename']");
    	By usernameBy = By.xpath("//input[@id='username']");
    	By passwordBy = By.xpath("//input[@id='password']");
    	By saveCredentialsCheckboxBy = By.xpath("//input[@id='saveCredentialsCheckbox']");
    	By submitButtonBy = By.xpath("//button[@id='submitButton']");
    	
    	waitUntillVisible(eloquaLoginFromBy);
    	//String formHeader = "Oracle Eloqua";
    	if(inElementPresent(eloquaLoginFromBy)) {
    		if(!getText(sitenameBy).equalsIgnoreCase(EloquaSite)) {
    			driver.findElement(sitenameBy).clear();
    			driver.findElement(sitenameBy).sendKeys(EloquaSite);;
    		}
    		if(!getText(usernameBy).equalsIgnoreCase(userName)) {
    			driver.findElement(usernameBy).clear();
    			driver.findElement(usernameBy).sendKeys(userName);;
    		}
    		if(!getText(passwordBy).equalsIgnoreCase(password)) {
    			driver.findElement(passwordBy).clear();
    			driver.findElement(passwordBy).sendKeys(password);;
    		}
    		if(!driver.findElement(saveCredentialsCheckboxBy).isSelected())
    			driver.findElement(saveCredentialsCheckboxBy).click();
    		
    		driver.findElement(submitButtonBy).click();
    	}else {
    		System.out.println("Login Form not found");
    		return false;
    	}
    	
    	By loggedinPageheaderBy = By.xpath("//div[@title='My Eloqua']");
    	By testMailPageBy = By.xpath("//span[@class='logo-name' and contains(.,'Eloqua')]");
    	
    	if(waitUntillVisible(loggedinPageheaderBy)) {
    		// Go to Eloqua QA test main page
    		driver.get(EloquaSiteUrl);
    		return waitUntillVisible(testMailPageBy); 
    		
    	}else {
    		System.out.println("Opps !! something wrong");
    	}
    	
    	return false;
	}
	

	public boolean saveEmail() {
		By emailSubBy = By.xpath("//div[@id='email-subject-field']/pre");
		By saveButtonBy = By.xpath("//div[@title='Save']");
		By emailBodyBy = By.xpath("//div[@class='CodeMirror-code']");
		
		By druftTitleBy = By.xpath("//div[@class='sc-view menubar-container']/div[contains(@class,'statustitle-view')]");
		waitUntillVisible(druftTitleBy);
		System.out.println(driver.findElement(druftTitleBy).getText());
		
		if(inElementPresent(emailSubBy)) {
			waitUntillClickable(emailSubBy);
			driver.findElement(emailSubBy).clear();
			//org.openqa.selenium.InvalidElementStateException: invalid element state
			driver.findElement(emailSubBy).sendKeys("Hello");
		}
		
		if(inElementPresent(emailBodyBy)) {
			driver.findElement(emailBodyBy).clear();
			driver.findElement(emailBodyBy).sendKeys("Hello");;
		}
		
		return false;
	}
	
}
