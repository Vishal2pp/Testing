package eBastaRegistration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;
/*******************************************************
 *  Class name: Register_eTailerTest
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  Methods:
 *  	1)addTestCaseHeading
 *  	2)testUsername
 *  	3)usernameDataProvider
 *  	4)testEmail
 *  	5)emailIdDataProvider
 *  	6)testStateAndCity
 *  	7)testPostalCode
 *  	8)postalCodeDataProvider
 *  	9)testMobileNumber
 *     10)mobileNumberDataProvider
 *     11)testEtailerName
 *     12)eTailerDataProvider
 *     13)testNatureOfBusinessDropdown
 *     14)createEtailer
 *  @Functionality To test eTailer registration form. 
 *  @Visibility Public
 ********************************************************/
public class Register_eTailerTest 
{
	WebDriver driver;
	String url = "";
	public Register_eTailerTest()
	{
		driver = GetWebDriver.getDriver();
		url = GetUrl.getUrl();
	}
	
	/*********************************************************
	 *  Method name: addTestCaseHeading
	 *  @Functionality Adds the heading of the test cases into
	 				   TestReport.xls file.
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 1)
	public void addTestCaseHeading()
	{
		GenerateReport.addTitle("eTailer Registration Test cases-");
	}
	
	/*********************************************************
	 *  Method name: testUsername
	 *  @Functionality Test the validation of username on eTailer
	 *  		registration form.
	 *  @param data
	 *  	   Sample username which is to be tested.
	 *  
	 *  @param output
	 *  	   Expected output of provided username.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 2, dataProvider = "UsernameData")
	public void testUsername(String data, String output)
	{
		String TestCaseId = "RET1";
		String ExpectedOutput = output;
		String TestCaseObjective = "To check validation of user name for Etailer";
		String TestData =data;
	    String Status = "";
		String temp = "rgba(255, 0, 0, 1)";
		try
		{
			System.out.println("Checking validation of etailer user name");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys(TestData);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			System.out.println(driver.findElement(By.xpath("//*[@id='edit-account']/div[1]/label")).getCssValue("color"));
			if (temp.equals(driver.findElement(By.xpath("//*[@id='edit-account']/div[1]/label")).getCssValue("color").toString()))
			{
				Status = "invalid";
			}
			else
			{
				Status = "valid";
			}
			if (Status == ExpectedOutput)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: usernameDataProvider
	 *  @Functionality Provides the data to testUsername method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "UsernameData")
	public String[][] usernameDataProvider()
	{
		return new String[][]{{"vvv","valid"},{"vv/12","invalid"},{" james","invalid"},{"jake   ","invalid"},{"5555","valid"}};
		
	}
	
	/*********************************************************
	 *  Method name: testEmail
	 *  @Functionality Test the validation of email on eTailer
	 *  		registration form.
	 *  @param email
	 *  	   Sample email which is to be tested.
	 *  
	 *  @param output
	 *  	   Expected output of provided email.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 3, dataProvider = "EmailData")
	public void testEmail(String email, String output)
	{
		String TestCaseId = "RET2";
		String ExpectedOutput = output;
		String TestCaseObjective = "To check validation of email id for Etailer";
		String TestData =email;
	    String Status = "";
		String temp = "rgba(255, 0, 0, 1)";
		
		try
		{
			System.out.println("Checking email validation for etailer");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-mail']")).sendKeys(TestData);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			System.out.println(driver.findElement(By.xpath("//*[@id='edit-account']/div[2]/label")).getCssValue("color"));
			if (temp.equals(driver.findElement(By.xpath("//*[@id='edit-account']/div[2]/label")).getCssValue("color").toString()))
			{
				Status = "invalid";
			}
			else
			{
				Status = "valid";
			}
			if (Status == ExpectedOutput)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
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
		return new String[][]{{"ebasta@gmail.com","valid"},{"@ebasta.com","invalid"},{"'ebasta'@gmail.com","valid"},{"email@domain@domain.com","invalid"}};
	}
	
	/*********************************************************
	 *  Method name: testStateAndCity
	 *  @Functionality To test the values in state and city 
	 *  		drop down boxes are present or not.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 4)
	public void testStateAndCity()
	{
		String TestCaseId = "RET3";
		String ExpectedOutputForState = "state should be present in dropdown";
		String ExpectedOutputForCity = "cities should be present in dropdown";
		String TestCaseObjective = "To check dropdown boxes for Etailer registration";
		String TestData ="none";
		
		try
		{
			System.out.println("Checking state and city dropdown for etailer");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			Select state = new Select(driver.findElement(By.id("edit-profile-etailer-field-etailer-state-and-city-und-0-tid-select-1")));
			List<WebElement> StateOptions = state.getOptions();
			if (StateOptions.isEmpty())
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForState, "State dropdown is empty", "Fail");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForCity, "As state dropdown is empty,cities dropdown will not be shown unless nd until state is selected", "Fail");
				System.out.println("Test fail(both state and city)");
			}
			else
			{
				for (WebElement Soption : StateOptions) 
				{
				    if (Soption.getText().equalsIgnoreCase("Maharashtra")) 
				    {
				    	state.selectByVisibleText("Maharashtra");
				    	GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForState, "States in dropdown are present", "Pass");
				    	System.out.println("Test pass(state)");
				        Thread.sleep(500);
				        Select city = new Select(driver.findElement(By.id("edit-profile-etailer-field-etailer-state-and-city-und-0-tid-select-2")));
						List<WebElement> CityOptions = city.getOptions();
						for (WebElement Coption : CityOptions) 
						{
						    if (Coption.getText().equalsIgnoreCase("Latur")) 
						    {
						    	GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForCity, "Cities in dropdown are present", "Pass");
						    	System.out.println("Test pass(cities)");
						    }
						    else
						    {
						    	GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForCity, "City dropdown is not visible", "Fail");
						    	System.out.println("Test fail(cities)");
						    }
						}
					}
				    else
				    {
				    	GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForState, "State dropdown is empty", "Fail");
				    	GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForCity, "As state dropdown is empty,cities dropdown will not be shown unless nd until state is selected", "Fail");
				    	System.out.println("Test fail(both state and city)");
				    }
				}
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForState, "Exception occurred,Test execution failed. Check error on console", "Fail");
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutputForCity, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: testPostalCode
	 *  @Functionality Test the validation of postal code on eTailer
	 *  		registration form.
	 *  @param data
	 *  	   Sample postal code which is to be tested.
	 *  
	 *  @param output
	 *  	   Expected output of provided postal code.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 5, dataProvider = "PostalCodeData")
	public void testPostalCode(String data, String output)
	{
		String TestCaseId = "RET4";
		String ExpectedOutput = output;
		String TestCaseObjective = "To check validation of postal code for Etailer";
		String TestData = data;
		String temp = "rgba(255, 0, 0, 1)";
		String Status = "";
		try
		{
			System.out.println("checking postal code validation for etailer");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-postal-code-und-0-value']")).sendKeys(TestData);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			
			System.out.println(driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-postal-code-und-0-value']")).getCssValue("color"));
			
			if (temp.equals(driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-postal-code-und-0-value']")).getCssValue("color").toString()))
			{
				Status = "invalid";
			}
			else
			{
				Status = "valid";
			}
			if (Status == ExpectedOutput)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Fail");
				System.out.println("Test fail");
			}
			
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	
	}
	
	/*********************************************************
	 *  Method name: postalCodeDataProvider
	 *  @Functionality Provides the data to testPostalCode method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "PostalCodeData")
	public String[][] postalCodeDataProvider()
	{
		return new String[][]{{"123456","valid"},{"ebasta","invalid"},{"5694","invalid"},{"123@56","invalid"}};
	}

	/*********************************************************
	 *  Method name: testMobileNumber
	 *  @Functionality Test the validation of mobile number on eTailer
	 *  		registration form.
	 *  @param data
	 *  	   Sample mobile number which is to be tested.
	 *  
	 *  @param output
	 *  	   Expected output of provided mobile number.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 6, dataProvider = "MobileNumberData")
	public void testMobileNumber(String data, String output)
	{
		String TestCaseId = "RET5";
		String ExpectedOutput = output;
		String TestCaseObjective = "To check validation of mobile number for Etailer";
		String TestData = data;
		String temp = "rgba(255, 0, 0, 1)";
		String Status = "";
		try
		{
			System.out.println("Checking mobile number validation for etailer");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-phone-no-und-0-number']")).sendKeys(TestData);
			driver.findElement(By.xpath("//*[@id='profile-etailer-field-etailer-phone-no-add-more-wrapper']/div/label")).click();
			Thread.sleep(2500);
	
			if (temp.equals(driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-phone-no-und-0-number']")).getCssValue("color").toString()))
			{
				Status = "invalid";
			}
			else
			{
				Status = "valid";
			}
			
			if (Status == ExpectedOutput)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, Status, "Fail");
				System.out.println("Test fail");
			}
			
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	
	}
	
	/*********************************************************
	 *  Method name: mobileNumberDataProvider
	 *  @Functionality Provides the data to testMobileNumber method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "MobileNumberData")
	public String[][] mobileNumberDataProvider()
	{
		return new String[][]{{"1234567892","valid"},{"ebasta","invalid"},{"5694","invalid"},{"-256478965","invalid"}};
	}
	
	/*********************************************************
	 *  Method name: testEtailerName
	 *  @Functionality Test the validation of eTailer name on eTailer
	 *  		registration form.
	 *  @param email
	 *  	   Sample name which is to be tested.
	 *  
	 *  @param output
	 *  	   Expected output of provided name.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 7, dataProvider = "EtailerData")
	public void testEtailerName(String data, String output)
	{
		String TestCaseId = "RET6";
		String ExpectedOutput = null;
		String TestCaseObjective = "To check validation of Etailer name";
		String TestData = null;
		//String temp = "rgba(255, 0, 0, 1)";
		//String Status = "";
		System.out.println("Checking validation for etailer name");
		GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "No validation is present for teacher name", "Fail");
		System.out.println("Test fail");
	}
	
	/*********************************************************
	 *  Method name: eTailerDataProvider
	 *  @Functionality Provides the data to testEtailerName method.
	 *  			Acts a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "EtailerData")
	public String[][] eTailerDataProvider()
	{
		return new String[][]{{"vvv","valid"},{"vv/12","invalid"},{" james","invalid"},{"jake   ","invalid"},{"5555","valid"}};
	}
	
	/*********************************************************
	 *  Method name: testNatureOfBusinessDropdown
	 *  @Functionality To test the values in Nature of Business 
	 *  		drop down box are present or not.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 8)
	public void testNatureOfBusinessDropdown()
	{
		String TestCaseId = "RET7";
		String ExpectedOutput = "Nature of business should be present in dropdown";
		String TestCaseObjective = "To check nature of business dropdown";
		String TestData ="none";
		
		try
		{
			System.out.println("Checking nature of business dropdown");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			Thread.sleep(300);
			Select etailerDropdown = new Select(driver.findElement(By.id("edit-profile-etailer-field-nature-of-business-und")));
			driver.findElement(By.id("edit-profile-etailer-field-nature-of-business-und")).click();
			List<WebElement> BusinessNames = etailerDropdown.getOptions();
			if (BusinessNames.isEmpty())
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Nature of business dropdown is empty", "Fail");
				System.out.println("Test fail");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Nature of business names in dropdown are present", "Pass");
				System.out.println("Test pass");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: createEtailer
	 *  @Functionality To register a eTailer with all valid details.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 9)
	public void createEtailer()
	{
		String TestCaseId = "RET8";
		String ExpectedOutput = "Etailer account should be created";
		String TestCaseObjective = "To create new Etailer account";
		String TestData = "null";
		
		double i = Math.random();
		try
		{
			System.out.println("Creating etailer account");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='myidmenu']/li[3]/a")).click();
			
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys("ebastaTest"+i+"");
			driver.findElement(By.xpath("//*[@id='edit-mail']")).sendKeys("abcdefgh"+i+"@gmail.com");
			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-name-und-0-value']")).sendKeys("testEbasta"+i+"");
			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-address-und-0-value']")).sendKeys("temporary"); // sending address

			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-postal-code-und-0-value']")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id='edit-profile-etailer-field-etailer-phone-no-und-0-number']")).sendKeys("1234567890");
			Select s = new Select(driver.findElement(By.id("edit-profile-etailer-field-nature-of-business-und")));
			s.selectByIndex(2);
			Thread.sleep(12000);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Registration Successful!"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Etailer account created", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Successful message not shown", "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
}
