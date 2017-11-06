/*******************************************************
 *  Class name: Search_eContentTest
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  Methods:
 *  	1)addTestCaseHeading
 *  	2)search_eBasta
 *  	3)eBastaNamesProvider
 *  	4)search_eBastaAdvanced
 *  	5)AdvanceSearch_eBastaNamesProvider

 *  Functionality: To test eBasta search option. 
 *  Visibility:Public
 ********************************************************/

package eBastaSearchOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;

public class Search_eContentTest 
{
	WebDriver driver;
	String url = "";
	public Search_eContentTest()
	{
		driver = GetWebDriver.getDriver();
		url = GetUrl.getUrl();
	}
	
	/*********************************************************
	 *  Method name: addTestCaseHeading
	 *  Functionality: Adds the heading of the test cases into
	 				   TestReport.xls file.
	 *  Visibility: Public
	 *********************************************************/
	@Test (priority = 1)
	public void addTestCaseHeading()
	{
		GenerateReport.addTitle("Search eContent Test-");
	}
	
	/*********************************************************
	 *  Method name: search_eContent
	 *  Functionality: To search the eContent
	 *  Visibility: Public
	 *********************************************************/
	@Test (priority = 2)
	public void search_eContent()
	{
		String TestCaseId = "SEC1";
		String ExpectedOutput = "Search results should be displayed";
		String TestCaseObjective = "To search eContent";
		String TestData = "null";
		try
		{
			System.out.println("Searching eContent");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[2]/a")).click();
			
			driver.findElement(By.partialLinkText("V")).click();
			driver.findElement(By.partialLinkText("Activity Book")).click();
			driver.findElement(By.partialLinkText("English")).click();
			driver.findElement(By.partialLinkText("pdf")).click();
			driver.findElement(By.partialLinkText("MBD Group")).click();
			driver.findElement(By.partialLinkText("A team of Authors and Consultants")).click();
		
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/a[2]")).click();
			
			if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[2]/table/tbody/tr[1]/td[2]")).getText().contains("English"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Search results are displayd", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Search results are not displayd", "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	
	@Test (priority = 3)
	public void eContentDetailsGrid()
	{
		String TestCaseId_1 = "SEC2";
		String TestCaseId_2 = "SEC3";
		String ExpectedOutput_1 = "Details of eContent should be shown from grid view";
		String TestCaseObjective_1 = "To check details of eContent from grid view";
		String ExpectedOutput_2 = "Buy process should complete from grid view";
		String TestCaseObjective_2 = "To check buy process from grid view";
		
		String TestData = "null";
		try
		{
			System.out.println("Checking eContent details from grid view");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='views-bootstrap-grid-1']/div[1]/div[1]/div[2]/span/a")).click();
			
			if (driver.findElement(By.xpath(".//*[@id='node-6647']/div[1]/div/button")).getText().contains("Back"))
			{
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details displayed", "Pass");
				try
				{
					driver.findElement(By.xpath("//*[@id='node-6647']/div[2]/div[2]/p[11]/button")).click();
					double i = Math.random();
					
					driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email']")).sendKeys("test"+i+"@gmail.com");
					driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email-confirm']")).sendKeys("test"+i+"@gmail.com");
					driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
					driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
					if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process complete", "Pass");
						if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).getText().contains("Logout"))
						{
							driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
							GenerateReport.addData("SEC3.1", TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed but anonymous user logged in", "Pass");
						}
						else
						{
							GenerateReport.addData("SEC3.1", TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed but anonymous user logged in", "Pass");
						}
					}
					else
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process incomplete", "Fail");
					}
				}
				catch(Exception e)
				{
					GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process failed", "Fail");
				}
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details not displayed", "Fail");
				GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process skipped", "Skipped");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occurred,Test execution failed. Check error on console", "Fail");
			GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process skipped", "Skipped");
			e.printStackTrace();
		}
	}
	
	@Test (priority = 4)
	public void eContentDetailsTable()
	{
		String TestCaseId_1 = "SEC4";
		String TestCaseId_2 = "SEC5";
		String ExpectedOutput_1 = "Details of eContent should be shown from table view";
		String TestCaseObjective_1 = "To check details of eContent from table view";
		String ExpectedOutput_2 = "Buy process should complete from table view";
		String TestCaseObjective_2 = "To check buy process from table view";
		
		String TestData = "null";
		try
		{
			System.out.println("Checking eContent details from table view");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/a[2]")).click();
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[2]/table/tbody/tr[1]/td[1]/a")).click();
			
			if (driver.findElement(By.xpath("//*[@id='node-6647']/div[1]/div/button")).getText().contains("Back"))
			{
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details displayed", "Pass");
				try
				{
					driver.findElement(By.xpath("//*[@id='node-6647']/div[2]/div[2]/p[11]/button")).click();
					double i = Math.random();
					
					driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email']")).sendKeys("test"+i+"@gmail.com");
					driver.findElement(By.xpath("//*[@id='edit-panes-customer-primary-email-confirm']")).sendKeys("test"+i+"@gmail.com");
					driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
					driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
					if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process complete", "Pass");
						if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).getText().contains("Logout"))
						{
							GenerateReport.addData("SEC5.1", TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed but anonymous user logged in", "Pass");
						}
						else
						{
							GenerateReport.addData("SEC5.1", TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed but anonymous user logged in", "Pass");
						}
					}
					else
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process incomplete", "Fail");
					}
				}
				catch(Exception e)
				{
					GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process failed", "Fail");
				}
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details not displayed", "Fail");
				GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process skipped", "Skipped");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occurred,Test execution failed. Check error on console", "Fail");
			GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process skipped", "Skipped");
			e.printStackTrace();
		}
	}
}
