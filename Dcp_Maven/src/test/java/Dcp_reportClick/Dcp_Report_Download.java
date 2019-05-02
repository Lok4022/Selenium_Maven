package Dcp_reportClick;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Dcp_Report_Download extends Dcp_Connection {
	public void PageLoad(WebDriver driver)

	  {
		  /*Page load wait*/
		  try
		  {
		  Wait<WebDriver> wait_Search = new FluentWait<WebDriver>(driver)
				    .withTimeout( 1000, TimeUnit.SECONDS )
				    .pollingEvery( 3, TimeUnit.SECONDS )
				    .ignoring( NoSuchElementException.class);
		  ExpectedCondition<Boolean> pageLoadCondition = new
				    ExpectedCondition<Boolean>() {
				        public Boolean apply(WebDriver driver) {
				            return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				        }
				    };
				    wait_Search.until(pageLoadCondition);
				    /*End of Page load wait statement*/
		  }
		  catch(Exception e)
		  {
			  
		  }
	  }
  @Test
  public void CLick_DcpReport() {
	  driver.get("https://reports.capellaehr.com/htmlReportGenerator.htm?CUserRole=Physician&CUserName=PHY_1&CFacilityName=1904 N OG AVE&ProjectType=CMG&CurrPhyId=2854");
	  
	  driver.manage().window().maximize();
	  PageLoad(driver);
	  /*WebElement element =  driver.findElement(By.xpath("//*[@id='sltReportType']"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", element);*/
	  driver.findElement(By.xpath("//*[@id='sltReportType']")).click();
	  PageLoad(driver);
	  Select oSelect = new Select(driver.findElement(By.xpath("//*[@id='sltReportType']")));
	  oSelect.selectByIndex(7);
	  PageLoad(driver);
	/*  executor.executeScript("arguments[0].click();", element);*/
	  PageLoad(driver);
	  
	  
	  
  }
}
