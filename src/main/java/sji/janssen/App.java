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
	//static String url = "file:///F:/QA/Janssen/4May2021/1598.html"; // 121
	//static String url = "file:///F:/QA/Janssen/1595/1595%20zip.html"; // zip
	//static String url = "file:///F:/QA/Janssen/5May2021/1599.html"; // 121
	//static String url = "file:///F:/QA/Janssen/1596.html"; // eloqua
	//static String url = "file:///F:/QA/Janssen/1572%20updated.html"; // 121
	//static String url = "file:///F:/QA/Janssen/1600.html"; // 121
	//static String url = "file:///F:/QA/Janssen/123/123.html"; // Zip
	//static String url = "file:///F:/QA/Janssen/1610-eloqua.html"; // Eloqua
	static String url = "file:///F:/QA/Janssen/120/120%20CP%20180375.html"; // Zip
	static Types type = Types.ZIP;
	
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
    	
    	ChromeOperator chdriver = new ChromeOperator();
//    	Test test = new Test(chdriver.driver);
//    	test.resizeBox();
//    	new EloquaServer(chdriver.driver);
    	
    	chdriver.openUrl(url);
    	VarifyLinks varifyLinks = new VarifyLinks(chdriver.driver, type);
    	System.out.println("\t\t ----- IMAGES ----------");
    	VarifyImages varifyImages = new VarifyImages(chdriver.driver, type);
    	chdriver.closeUrl();
    	
    	
    	
    }
}
