package sji.janssen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EloquaServer {
	
	WebDriver driver = null;
	
	String EloquaSiteUrl = "https://secure.p03.eloqua.com/Main.aspx#emails&id=19522";
	
	String EloquaSite = "JanssenPharmaceutica";
	String userName = "Arif.Islam";
	String password = "2@Queensvillage#";
	
	public EloquaServer(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Signin() {
		
		// Signin to Eloqua
		driver.openUrl(EloquaSiteUrl);
    	
    	By eloquaLoginFromBy = By.xpath("//div[@class='name-bar-title']/div[@class='app-name']");
    	By sitenameBy = By.xpath("//input[@id='sitename']");
    	By usernameBy = By.xpath("//input[@id='username']");
    	By passwordBy = By.xpath("//input[@id='password']");
    	By saveCredentialsCheckboxBy = By.xpath("//input[@id='saveCredentialsCheckbox']");
    	By submitButtonBy = By.xpath("//button[@id='submitButton']");
    	
    	String formHeader = "Oracle Eloqua";
    	if(chdriver.inElementPresent(eloquaLoginFromBy) && chdriver.getText(eloquaLoginFromBy).equalsIgnoreCase(formHeader)) {
    		if(!chdriver.getText(sitenameBy).equalsIgnoreCase("JanssenPharmaceutica")) {
    			chdriver.inputTxt(sitenameBy, "");
    			chdriver.inputTxt(sitenameBy, "JanssenPharmaceutica");
    		}
    		chdriver.inputTxt(sitenameBy, "JanssenPharmaceutica");
    		chdriver.inputTxt(usernameBy, "Arif.Islam");
    		chdriver.inputTxt(passwordBy, "2@Queensvillage#");
    		chdriver.checkBox(saveCredentialsCheckboxBy);
    		//chdriver.click(submitButtonBy);
    	}else {
    		System.out.println("Login Form not found");
    	}
    	
    	By loggedinPageheaderBy = By.xpath("//div[@title='My Eloqua']");
    	
    	if(chdriver.inElementPresent(loggedinPageheaderBy)) {
    		// Go to Eloqua QA test main page
        	chdriver.openUrl(EloquaSiteUrl);
    	}else {
    		System.out.println("Opps !! something wrong");
    	}
	}
	

}
