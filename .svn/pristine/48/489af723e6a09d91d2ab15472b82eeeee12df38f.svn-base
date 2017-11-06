/*******************************************************
 *  Class name: LinkTest
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  Methods:
 *  	1)addTestCaseHeading
 *  	2)checkLinks
 *  	3)getLinks
 *  Functionality: To check the links on the eBasta portal. 
 *  Visibility:Public
 ********************************************************/

package eBastaTestingClasses;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinksTest 
{
	WebDriver driver;
	String url = "";
	public LinksTest()
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
	@Test(priority = 1)
	public void addTestCaseHeading()
	{
		GenerateReport.addTitle("Links Test-");
	}
	
	/*********************************************************
	 *  Method name: checkLinks
	 *  Functionality: Checks the links on portal.
	 *  @param xpath
	 *  	   xpath of the link which is to be tested.
	 *  
	 *  @param name
	 *  	   Name of the link to be tested.
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@Test(priority = 2, dataProvider = "LinkData")
	public void checkLinks(String xpath, String name)
	{
		String TestCaseId = "LT1";
		String ExpectedOutput = "Link should work";
		String TestCaseObjective = "To check different publisher links";
		String TestData = name;
		try
		{
			System.out.println("Checking Links");
			driver.get(url);
			String getLink = driver.findElement(By.xpath(xpath)).getAttribute("href");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(getLink);
			HttpResponse response = client.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is working", "Pass");
				System.out.println("Test pass");
			}
			else if (response.getStatusLine().getStatusCode() == 403)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is working", "Pass");
				System.out.println("Test fail");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is not working", "Fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: getLinks
	 *  Functionality: Provides the data to checkLinks method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  Visibility: Public
	 *********************************************************/
	@DataProvider (name = "LinkData")
	public String[][] getLinks()
	{
		return new String[][]{
			{"//*[@id='navbar']/nav/ul/li[1]/a","About eBasta link"},
			{"//*[@id='wrap']/nav[2]/div/div/div[1]/a/img","eBasta logo link"},
			{"//*[@id='block-block-20']/ul/li[1]/a","Download eBasta App link"},
			{"//*[@id='navbar']/nav/ul/li[4]/a","Forums link"},
			{"//*[@id='navbar']/nav/ul/li[5]/a","FAQ link"},
			{"//*[@id='navbar']/nav/ul/li[6]/a","Useful tools link"}};
	}
	
	@Test(priority = 2)
	public void checkLinks2()
	{
		String TestCaseId = "LT2";
		String ExpectedOutput = "Link should work";
		String TestCaseObjective = "To check different publisher resources links";
		String TestCaseObjective_2 = "To check different DRM providers links";
		String TestCaseObjective_3 = "To check different Useful tools links";
		String TestData = null;
		try
		{
			System.out.println("Checking Links of publisher resources");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[7]/a")).click();
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[7]/ul/li[1]/a")).click();
			WebElement div = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div"));
			List<WebElement> ss = div.findElements(By.tagName("a"));
			String getLink = "";
			for(WebElement s : ss)
			{
				try
				{
					getLink = s.getAttribute("href");
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(getLink);
					HttpResponse response = client.execute(request);
					System.out.println(response.getStatusLine().getStatusCode());
					if (response.getStatusLine().getStatusCode() == 200)
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective, getLink, ExpectedOutput, "Link is working", "Pass");
						System.out.println("Test pass");
					}
					else if (response.getStatusLine().getStatusCode() == 403)
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective, getLink, ExpectedOutput, "Link is working", "Pass");
						System.out.println("Test fail");
					}
					else
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective, getLink, ExpectedOutput, "Link is not working", "Fail");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					GenerateReport.addData(TestCaseId, TestCaseObjective, getLink, ExpectedOutput, "Can't connect to website cause of security issue", "Fail");
				}
			}
			System.out.println("Checking Links of DRM providers");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[7]/a")).click();
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[7]/ul/li[2]/a")).click();
			div = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div"));
			ss = null;
			ss = div.findElements(By.tagName("a"));
			for(WebElement s : ss)
			{
				if(!s.getText().contains("@"))
				{
					try
					{
						getLink = s.getAttribute("href");
						HttpClient client = HttpClientBuilder.create().build();
						HttpGet request = new HttpGet(getLink);
						HttpResponse response = client.execute(request);
						System.out.println(response.getStatusLine().getStatusCode());
						if (response.getStatusLine().getStatusCode() == 200)
						{
							GenerateReport.addData(TestCaseId, TestCaseObjective_2, getLink, ExpectedOutput, "Link is working", "Pass");
							System.out.println("Test pass");
						}
						else if (response.getStatusLine().getStatusCode() == 403)
						{
							GenerateReport.addData(TestCaseId, TestCaseObjective_2, getLink, ExpectedOutput, "Link is working", "Pass");
							System.out.println("Test fail");
						}
						else
						{
							GenerateReport.addData(TestCaseId, TestCaseObjective_2, getLink, ExpectedOutput, "Link is not working", "Fail");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
						GenerateReport.addData(TestCaseId, TestCaseObjective_2, getLink, ExpectedOutput, "Can't connect to website cause of security issue", "Fail");
					}
				}
			}
			
			System.out.println("Checking Links of Useful tools");
			driver.get(url);
			
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[6]/a")).click();
			
			div = driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div"));
			ss = div.findElements(By.tagName("a"));
			getLink = "";
			for(WebElement s : ss)
			{
				try
				{
					getLink = s.getAttribute("href");
					HttpClient client = HttpClientBuilder.create().build();
					HttpGet request = new HttpGet(getLink);
					HttpResponse response = client.execute(request);
					System.out.println(response.getStatusLine().getStatusCode());
					if (response.getStatusLine().getStatusCode() == 200)
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective_3, getLink, ExpectedOutput, "Link is working", "Pass");
						System.out.println("Test pass");
					}
					else if (response.getStatusLine().getStatusCode() == 403)
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective_3, getLink, ExpectedOutput, "Link is working", "Pass");
						System.out.println("Test fail");
					}
					else
					{
						GenerateReport.addData(TestCaseId, TestCaseObjective_3, getLink, ExpectedOutput, "Link is not working", "Fail");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					GenerateReport.addData(TestCaseId, TestCaseObjective_3, getLink, ExpectedOutput, "Can't connect to website cause of security issue", "Fail");
				}
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
}
