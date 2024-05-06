package AdvantageShoppingOnline;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvSearch_TestCase{
	static WebDriver driver;
	boolean res;

	@Test
	public  void search() 
	{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\ustlearningmaven\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("123");
	    driver = new ChromeDriver(options);
	    driver.get("https://www.advantageonlineshopping.com/#/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    String srch = "mouse";
	    driver.findElement(By.id("menuSearch")).click();
	    driver.findElement(By.id("autoComplete")).sendKeys(srch + Keys.ENTER);
	    
	    try {
	    	
	    	String howmanyequalto = driver.findElement(By.xpath("//*[contains(@class,\"titleItemsCount\")]//parent::p")).getText();		
		    System.out.println(howmanyequalto);
		    res = true;
	    }		
	
	    catch(NoSuchElementException e)
	    {
	     System.out.println("no items found for: " + srch);
	     res = false;
	    }
	    Assert.assertEquals(true, res);   
        
	
	}	
}