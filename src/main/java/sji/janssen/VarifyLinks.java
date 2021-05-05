package sji.janssen;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VarifyLinks {
	WebDriver driver = null;
	Types type = null;
	
	public VarifyLinks(WebDriver driver, Types type) {
		this.driver = driver;
		this.type = type;
		
		getAllLinks();
	}
	
	private void getAllLinks() {
		
		List<WebElement> listOfAnchorWe = driver.findElements(By.xpath("//a"));
		
		Iterator<WebElement> it = listOfAnchorWe.iterator();
		
		while(it.hasNext()) {
			WebElement anchorWe = it.next();
			String href = anchorWe.getAttribute("href");
			System.out.println("-------- >>> "+anchorWe.getText()+" <<< -----------");
			if(href==null) {
				System.err.println("Please Check :--  No href value ");
				continue;
			}
			if(anchorWe.getText().trim().contains("Read Online") && href.toLowerCase().contains("http")) {
				checkReadOnline(anchorWe);
				continue;
			}	
			if(href.toLowerCase().contains("http")) {
				urlCheck(anchorWe);
			}
			else if(href.toLowerCase().contains("mailto"))
				mailToCheck(anchorWe);
			else {
				System.out.println("NO href: " + href);
			}
			//System.out.println("Style: " + anchorWe.getAttribute("style"));
		}
	}
	
	// if contains "Read Online"
	private void checkReadOnline(WebElement anchorWe) {
		if(type == Types.ONETOONE) {
			System.err.println(" 121 Email should not have 'Read Online' ");
			return;
		}
			
		urlCheck(anchorWe);
		System.out.println("-- No EA Token & No underline needed ----\n");
	}
	
	private void mailToCheck(WebElement anchorWe) {
		String href = anchorWe.getAttribute("href");
		System.out.println("\t"+ href);
		System.out.println("\t"+ anchorWe.getAttribute("target"));
		if(!anchorWe.getAttribute("target").isEmpty()) {
			System.err.println("mailto should not contains target attribute");
			System.out.println("target\t"+ anchorWe.getAttribute("target"));
		}
		
		//Eloquatrackid
		if(href.contains("elqTrackId"))
			System.err.println("link should not contains elqTrackId");
		
	}
	
	private void urlCheck(WebElement anchorWe) {
		
		String href = anchorWe.getAttribute("href");
		System.out.println("href:\t"+ href);
		if(href.contains(".ics")) {
			System.err.println("Please check this .isc file");
			return;
		}
		
		// link text should not contain http
		if(anchorWe.getText().contains("http")) {
			System.err.println("link text should not contain http");
			System.out.println("Please Ignore if it is in referrence section");
		}
		
		if(href.contains("ea="))
			System.out.println("EA Token\t"+ href.substring(href.indexOf("ea="), href.length()));
		else 
			System.err.println("NO EA Token");
		if(type == Types.ZIP) {
			if(href.contains("utm_campaign="))
				System.out.println("utm campaign\t"+ href.substring(href.indexOf("utm_campaign="), href.length()));
			else
				System.err.println("NO utm canpaign present");			
		}else {
			if(href.contains("utm_campaign="))
				System.err.println("link should not contains utm_campaign");
		}
		
		if(href.contains("elqTrackId"))
			System.err.println("link should not contains elqTrackId");
		
		if(anchorWe.getAttribute("target") == null)
			System.err.println("target attribute is missing");
		else
			System.out.println("target\t"+ anchorWe.getAttribute("target"));
		
		String color = rgbaToHash(anchorWe.getCssValue("color"));
		if(!color.equals("#00407b"))
			System.err.println("Link color should be #00407b");
		else
			System.out.println("color\t"+ color);
		String decoration = anchorWe.getCssValue("text-decoration");
		if(decoration.contains("underline"))
			System.err.println("Link text should be underline");
		else
			System.out.println("text-decoration\t"+ decoration);
		
	}
	
	private String rgbaToHash(String rgbaColor) {
		String color = rgbaColor.trim();
	//  RGB to HEX   
		 String color_hex[];  
		 color_hex = color.replace("rgba(", "").split(",");       
		 String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  
		return actual_hex;
	}
		
}
