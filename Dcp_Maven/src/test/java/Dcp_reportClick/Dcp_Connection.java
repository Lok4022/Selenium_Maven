package Dcp_reportClick;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Dcp_Connection {
	 WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	 
	  System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	  driver=new ChromeDriver();
	 
  
  }

  @AfterTest
  public void afterTest() throws Throwable {
	  
	  WebDriver  augmenter = new Augmenter().augment(driver);
		 Date today = Calendar.getInstance().getTime();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss a");
		 String folderName = formatter.format(today);
		 File scrFile = ((TakesScreenshot) augmenter).getScreenshotAs(OutputType.FILE);
		 File DestFile=new File("C:/Selenium/Stopped_PROMED"+ folderName +" "+System.getProperty("os.name")+".png ");
		 FileUtils.copyFile(scrFile, DestFile);
		 driver.quit();
		 
  }

}
