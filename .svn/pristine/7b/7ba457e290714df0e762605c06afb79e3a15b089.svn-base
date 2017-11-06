package eBastaSearchOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;

public class QuickBuy 
{
	WebDriver driver;
	String url = "";
	public QuickBuy()
	{
		driver = GetWebDriver.getDriver();
		url = GetUrl.getUrl();
	}
	
	/*********************************************************
	 *  Method name: addTestCaseHeading
	 *  
	 *  @Functionality Adds the heading of the test cases into
	 				   TestReport.xls file.
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 1)
	public void addTestCaseHeading()
	{
		GenerateReport.addTitle("Quick buy test cases-");
	}
	
	@Test (priority = 2)
	public void quickSearch()
	{
		String TestCaseId = "QBT1";
		String ExpectedOutput = "eBasta should found";
		String TestCaseObjective = "Checking quick buy option";
		String TestData = "test31march2016";
		System.out.println("Checking quick buy option");
		try
		{
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys("test31march2016");
			driver.findElement(By.xpath("//*[@id='edit-submit-quick-buy']")).click();
			if (driver.getCurrentUrl() == url)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta not found", "Fail");
			}
			else
			{
				driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/div/form/div[1]/div[1]/div/div[2]/input[3]")).click();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submitform']")));
				driver.findElement(By.xpath("//*[@id='submitform']")).click();
				System.out.println("Pass");
				
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta found", "Pass");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed.Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void anonymoseUserBuyProcess()
	{
		String TestCaseId = "QBT2";
		String TestCaseId_1 = "QBT3";
		String ExpectedOutput = "Buy process with anonymous user must be successful";
		String TestCaseObjective = "Checking quick buy option";
		String TestData = "null";
		System.out.println("Checking anonymous user buy option");
		try
		{
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys("test31march2016");
			driver.findElement(By.xpath("//*[@id='edit-submit-quick-buy']")).click();
			if (driver.getCurrentUrl() == url)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta not found", "Fail");
			}
			else
			{
				double i = Math.random();
				driver.findElement(By.xpath("//*[@id='buyentire']")).click();
				driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/div/form/div[1]/div[1]/div/div[2]/input[3]")).click();
				driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email']")).sendKeys("test"+i+"@gmail.com");
				driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email-confirm']")).sendKeys("test"+i+"@gmail.com");
				driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
				driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
				if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
				{
					
					if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).getText().contains("Logout"))
					{
						GenerateReport.addData(TestCaseId_1, "Anonymous user must get login after buy eBasta", TestData, "Anonymous user must atomatically log in", "Anonymous user login completed", "Pass");
						GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Buy process with anonymous user successful", "Pass");
					}
					else
					{
						GenerateReport.addData(TestCaseId_1, "Anonymous user must get login after buy eBasta", TestData, "Anonymous user must atomatically log in", "Anonymous user is not logged in", "Fail");
						GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Buy process with anonymous user not successful", "Fail");
					}
				}
				else
				{
					GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Order buy failed so Buy process with anonymous user not successful", "Fail");
					GenerateReport.addData(TestCaseId_1, "Anonymous user must get login after buy eBasta", TestData, "Anonymous user must atomatically log in", "Anonymous user is not logged in", "Test skipped");
				}
			}
			
			
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occured", "Fail/skipped");
			GenerateReport.addData(TestCaseId_1, "Anonymous user must get login after buy eBasta", TestData, "Anonymous user must atomatically log in", "Anonymous user is not logged in", "Test skipped");
			e.printStackTrace();
		}
	}

}
