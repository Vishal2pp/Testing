package eBastaTestingClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForgetPasswordTest 
{
	WebDriver driver;
	String url;
	public ForgetPasswordTest()
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
		GenerateReport.addTitle("Forget password Test Cases-");
	}
	
	@Test (priority = 2, dataProvider = "EmailData")
	public void testEmail(String email, String output)
	{
		String TestCaseId = "FPT1";
		String ExpectedOutput = output;
		String TestCaseObjective = "Validation of Email address";
		String TestData = email;
		String temp = "rgba(255, 0, 0, 1)";
		System.out.println("Checking email validation");
		
		try
		{
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='user-login']/div/div[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys(TestData);
			Thread.sleep(12000);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			try
			{
			if (temp.equals(driver.findElement(By.xpath("//*[@id='user-pass']/div/div[1]/label")).getCssValue("color").toString()))
			{
				System.out.println("In 1 if");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Sorry, "+TestData+" is not recognized as a user name or an e-mail address.", "Fail");
			}
			}
			catch (Exception ee){}
			if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]")).getText().contains("Unable to send e-mail."))
			{
				System.out.println("2 if");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Unable to send e-mail. Contact the site administrator if the problem persists.", "Fail");
			}
			else if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]")).getText().contains("Further instructions have been sent to your e-mail address"))
			{
				System.out.println("3 if");
				if (ExpectedOutput == "mail should be sent")
				{
					System.out.println("4 if");
					GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Email sent", "Pass");
				}
				else
				{
					System.out.println("4 else");
					GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Email sent", "Fail");
				}
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed.Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: emailIdDataProvider
	 *  @Functionality Provides the data to testEmail method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "EmailData")
	public String[][] emailIdDataProvider()
	{
		return new String[][]{{"abc@gmail.com","mail should be sent"},{"xyz@ebasta.com","mail should not be sent"}};
	}
}
