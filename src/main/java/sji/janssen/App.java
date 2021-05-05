package sji.janssen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
	//static String url = "file:///F:/QA/Janssen/2021-4/5April/1550-eloqua.html"; // eloqua
	//static String url = "file:///F:/QA/Janssen/2021-4/29April2021/1584/1584.html"; // zip
	//static String url = "file:///F:/QA/Janssen/1602.html"; // eloqua
	static String url = "file:///F:/QA/Janssen/4May2021/1598.html"; // 121
	
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
    	
    	ChromeOperator chdriver = new ChromeOperator();
    	chdriver.openUrl(url);
    	VarifyLinks varifyLinks = new VarifyLinks(chdriver.driver, Types.ONETOONE);
    	//varifyLinks.getAllImages(url);
    	chdriver.closeUrl();
    }
}
