/*******************************************************
 *  Class name: Search_eBastaTest
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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;

public class Search_eBastaTest 
{
	WebDriver driver;
	String url = "";
	public Search_eBastaTest()
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
		GenerateReport.addTitle("Search eBasta Test-");
	}
	
	/*********************************************************
	 *  Method name: search_eBasta
	 *  Functionality: To test the eBasta search option.
	 *  @param name
	 *  	   Sample eBasta name.
	 *  
	 *  @param output
	 *  	   Expected output based on above provided data
	 *  		i.e. available/unavailable
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@Test (priority = 2, dataProvider = "eBastaNames")
	public void search_eBasta(String name, String output)
	{
		String TestCaseId = "SEB1";
		String ExpectedOutput = output;
		String TestCaseObjective = "To search eBasta";
		String TestData = name;
		String status = "";
		try
		{
			System.out.println("Searching eBasta using eBasta name");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys(name);
			driver.findElement(By.xpath("//*[@id='edit-submit-all-ebastas']")).click();
			try
			{
				if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/p")).getText().contains("There are no available eBastas."))
				{
					status = "unavailable";
				}
				else
				{
					status = "available";
				}
				
			}
			catch (NoSuchElementException w)
			{
				status = "available";
			}
			if (status == output)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, status, "Fail");
				System.out.println("Test fail");
			}
			driver.findElement(By.xpath("//*[@id='edit-reset']")).click();
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: eBastaNamesProvider
	 *  Functionality: Provides the data to search_eBasta method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@DataProvider (name = "eBastaNames")
	public String[][] eBastaNamesProvider()
	{
		return new String[][]{{"test31march2016","available"},{"abc","unavailable"},{"ClassXbasta","available"}};
	}
	
	/*********************************************************
	 *  Method name: search_eBastaAdvanced
	 *  Functionality: To test the advanced eBasta search option
	 *  @param name
	 *  	   Sample eBasta name.
	 *  
	 *  @param Class
	 *  	   Sample class name
	 *  
	 *  @param city
	 *  		city of the school.
	 *  
	 *  @param output
	 *  	   Expected output based on above provided data
	 *  		i.e. available/unavailable
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@Test (priority = 3, dataProvider = "AdvanceSearch_eBastaNames")
	public void search_eBastaAdvanced(String name, String Class, String city, String school, String output)
	{
		String TestCaseId = "SEB2";
		String ExpectedOutput = output;
		String TestCaseObjective = "To search eBasta using advanced search option";
		String TestData = name;
		String status = "";
		try
		{
			System.out.println("Advance eBasta search");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys(name);
			
			driver.findElement(By.xpath("//*[@id='edit-secondary-wrapper']/div/fieldset/legend/a")).click();
			Thread.sleep(300);
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-class-value']")).sendKeys(Class);
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-city-value']")).sendKeys(city);
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-school-value']")).sendKeys(school);
			
			driver.findElement(By.xpath("//*[@id='edit-submit-all-ebastas']")).click();
			try
			{
				if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/p")).getText().contains("There are no available eBastas."))
				{
					status = "unavailable";
				}
				else
				{
					status = "available";
				}
				
			}
			catch (NoSuchElementException w)
			{
				status = "available";
			}
			if (status == output)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, status, "Fail");
				System.out.println("Test fail");
			}
			driver.findElement(By.xpath("//*[@id='edit-reset']")).click();
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: AdvanceSearch_eBastaNamesProvider
	 *  Functionality: Provides the data to search_eBastaAdvanced method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@DataProvider (name = "AdvanceSearch_eBastaNames")
	public String[][] AdvanceSearch_eBastaNamesProvider()
	{
		
		return new String[][]{{"test31march2016","Pre-Class I","Navi Mumbai","BAL BHARATI PUBLIC SCHOOL","available"},
			{"test31march2016","Pre-Class II","Mumbai","BAL BHARATI PUBLIC SCHOOL","unavailable"},
			{"Learning for life","Pre-Class II","mohali","Others","available"}};
	}
	
	@Test(priority = 4)
	public void check_eBastaGridViewDetails()
	{
		String TestCaseId_1 = "SEB3";
		String TestCaseId_2 = "SEB4";
		
		String ExpectedOutput_1 = "Details of eBasta should be displayed from GRID view";
		String TestCaseObjective_1 = "To check details of eBasta through GRID view";
		
		String ExpectedOutput_2 = "Buy process of eBasta should be successful from GRID view";
		String TestCaseObjective_2 = "To check buy process of eBasta through GRID view";
		
		String TestData = "test31march2016";
		String status = "";
		try
		{
			System.out.println("Searching eBasta using eBasta name");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys("test31march2016");
			driver.findElement(By.xpath("//*[@id='edit-submit-all-ebastas']")).click();
			try
			{
				if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/p")).getText().contains("There are no available eBastas."))
				{
					status = "unavailable";
				}
				else
				{
					status = "available";
				}
				
			}
			catch (NoSuchElementException w)
			{
				status = "available";
			}
			if (status == "available")
			{
				
				try
				{
					driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/div/ul/li/input[2]")).click();
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submitform']")));
					driver.findElement(By.xpath("//*[@id='submitform']")).click();
					wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.name("op")).get(0)));
					driver.findElements(By.name("op")).get(0).click();
					GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details are shown from grid view", "Pass");
					if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().contains("Order complete"))
					{
						System.out.println("Buy process completed, Test pass");
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed from grid view", "Pass");
					}
					else
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process incompleted from grid view", "Fail");
					}
				}
				catch(Exception e)
				{
					System.out.println("Test fail");
					GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occured,Details are not shown from grid view", "Fail");
					GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Exception occured,Buy process incompleted from grid view", "Skipped");
					e.printStackTrace();
				}
				
				
			}
			else
			{
				System.out.println("Test fail");
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "eBasta not found", "Skipped");
				GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "eBasta not found", "Skipped");
				
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Test fail");
			GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occured", "Skipped");
			GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Exception occured", "Skipped");
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 5)
	public void check_eBastaTableViewDetails()
	{
		String TestCaseId_1 = "SEB5";
		String TestCaseId_2 = "SEB6";
		
		String ExpectedOutput_1 = "Details of eBasta should be displayed from TABLE view";
		String TestCaseObjective_1 = "To check details of eBasta through TABLE view";
		
		String ExpectedOutput_2 = "Buy process of eBasta should be successful from TABLE view";
		String TestCaseObjective_2 = "To check buy process of eBasta through TABLE view";
		
		String TestData = "test31march2016";
		String status = "";
		try
		{
			System.out.println("Searching eBasta using eBasta name");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-field-ebasta-name-value']")).sendKeys("test31march2016");
			driver.findElement(By.xpath("//*[@id='edit-submit-all-ebastas']")).click();
			try
			{
				if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/p")).getText().contains("There are no available eBastas."))
				{
					status = "unavailable";
				}
				else
				{
					status = "available";
				}
				
			}
			catch (NoSuchElementException w)
			{
				status = "available";
			}
			if (status == "available")
			{
				
				try
				{
					driver.findElement(By.xpath("html/body/div[5]/div[2]/div[2]/div/ul/li[2]/a")).click();
					driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/table/tbody/tr/td[5]/input[2]")).click();
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submitform']")));
					driver.findElement(By.xpath("//*[@id='submitform']")).click();
				//	wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.name("op")).get(0)));
					driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
					GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Details are shown from table view", "Pass");
					if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().contains("Order complete"))
					{
						System.out.println("Buy process completed, Test pass");
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process completed from table view", "Pass");
					}
					else
					{
						GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Buy process incompleted from table view", "Fail");
					}
				}
				catch(Exception e)
				{
					System.out.println("Test fail");
					GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occured,Details are not shown from table view", "Fail");
					GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Exception occured,Buy process incompleted from table view", "Skipped");
					e.printStackTrace();
				}
				
				
			}
			else
			{
				System.out.println("Test fail");
				GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "eBasta not found", "Skipped");
				GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "eBasta not found", "Skipped");
				
			}
			
		}
		catch (Exception e)
		{
			System.out.println("Test fail");
			GenerateReport.addData(TestCaseId_1, TestCaseObjective_1, TestData, ExpectedOutput_1, "Exception occured", "Skipped");
			GenerateReport.addData(TestCaseId_2, TestCaseObjective_2, TestData, ExpectedOutput_2, "Exception occured", "Skipped");
			e.printStackTrace();
		}
	}
}
