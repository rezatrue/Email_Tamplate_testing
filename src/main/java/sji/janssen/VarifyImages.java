package sji.janssen;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VarifyImages {
	WebDriver driver = null;
	Types type = null;
	
	public VarifyImages(WebDriver driver, Types type) {
		this.driver = driver;
		this.type = type;
	}
	
	public void getAllImages(String url) {
			
			driver.get(url);
			
			List<WebElement> listOfImageWe = driver.findElements(By.xpath("//img"));
			
			Iterator<WebElement> it = listOfImageWe.iterator();
			
			while(it.hasNext()) {
				System.out.println("\t \t \t -----");
				WebElement anchorWe = it.next();
				System.out.println("HTML : " + anchorWe.getAttribute("outerHTML"));
				System.out.println("\t \t \t ----- >>");
				System.out.println(anchorWe.getText());
				System.out.println("Src: " + anchorWe.getAttribute("src"));
				System.out.println("Width: " + anchorWe.getAttribute("width"));
				System.out.println("Height: " + anchorWe.getAttribute("height"));
				System.out.println("\t \t \t -X \t -X \t -X \t -");
				
			}
		
		
	}

	
	
}
