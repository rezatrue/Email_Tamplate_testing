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
		
		getAllImages();
	}
	
	private void getAllImages() {
			
			
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
				checkImageSrc(anchorWe);
				System.out.println("\t \t \t -X \t -X \t -X \t -");
				
			}		
	}

	private void checkImageSrc(WebElement anchorWe) {
		
		//String src = anchorWe.getAttribute("outerHTML");
		String src = anchorWe.getAttribute("src");

		if(src.contains("elqTrackId"))
			System.err.println("link should not contains elqTrackId");
		
		if(type == Types.ZIP) {
			if(src.contains("assets/images/"))
				System.out.println("Image resource is local");
			else
				System.err.println("Image resource is not local");
			
			String imageExtension = src.substring(src.lastIndexOf("."), src.length());
			boolean hasUppercase = !imageExtension.equals(imageExtension.toLowerCase());
			if(hasUppercase)
				System.err.println(imageExtension + ": image Extension contains Uppercase!!");
			else
				System.out.println(imageExtension + ": all are lowercase");
			
		}else {
			if(src.contains("/EloquaImages/"))
				System.out.println("Image resource is in EloquaImages");
			else
				System.err.println("Image resource is not in EloquaImages server");
		}
		
	}
	
	
}
