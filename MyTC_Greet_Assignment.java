package stringdate_Assignment;


import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class MyTC_Greet_Assignment {

	//public boolean actualresult;
	public static String actualgreet;
	public static String expectedgreet;
	//public boolean result;
	
	@BeforeClass
	public static void readPropertyfile() throws IOException
	{
	  Properties p = new Properties();
	  
	  FileInputStream fis = new FileInputStream("C://Users//Administrator//eclipse-workspace//JavaProject//config.properties");
	  p.load(fis);
	  
	  expectedgreet = p.getProperty("expectedgreeting");
	  System.out.println("Expected Result:" + expectedgreet);
	}
	
	@Test
	public void currTime()
	{

	 LocalDateTime now = LocalDateTime.now();
		
	 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:MM:ss");
	
	 String formatDateTime = now.format(format);
	 System.out.println("Current Date & Time: " + formatDateTime);
	
	
	 	int curtime = LocalTime.now().getHour();
	    //String actualgreet;
	
	
	if (curtime < 12)
	{	
		actualgreet = "Good morning";
	}
	else if (curtime >= 12 && curtime <= 16)
	{
		actualgreet = "Good afternoon";
	}
	else if (curtime >= 16 && curtime <= 19)
	{
		actualgreet = "Good evening";
	}
	else 
	{
		actualgreet = "Good night";
	}

	System.out.println(LocalTime.now().getHour());
	System.out.println("Actual Result: " + actualgreet);
	
	Assert.assertEquals(actualgreet, expectedgreet);
}
	
	
}

	
	