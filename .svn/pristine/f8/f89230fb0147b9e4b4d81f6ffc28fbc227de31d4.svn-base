package eBastaRole;

import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;

/*******************************************************
 *  Class name:TeacherRoleTest
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  
 *  Methods:
 *  	1)addTestCaseHeading
 *  	2)emptyLoginTest
 *  	3)loginTest
 *  	4)create_eBasta
 *  	5)check_eBastaName
 *  	6)check_eBastaStatus
 *  	7)checkSaveButtonMessage
 *  	8)test_eBastaStatistics
 *  	9)downloadXLS
 *     10)preview_eBasta
 *     11)edit_eBasta
 *     12)buy_eBasta
 *     13)logOut
 *     14)createFolder
 *     15)renameFolder
 *     16)cutFolder
 *     17)copyFolder
 *     18)loginData
 *  @Functionality To test the different teacher roles. 
 *  @Visibility Public
 *******************************************************/
public class TeacherRoleTest 
{
	WebDriver driver;
	String url = "";
	public TeacherRoleTest()
	{
		driver = GetWebDriver.getDriver();
		url = GetUrl.getUrl();
		driver.get(url);
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
		GenerateReport.addTitle("Create eBasta Test Cases-");
	}
	
	/*********************************************************
	 *  Method name: emptyLoginTest
	 *  @Functionality Checks the login form without entering
	 				any values in text boxes.
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 2)
	public void emptyLoginTest()
	{
		String TestCaseId = "CEB1";
		String ExpectedOutput = "Error Message";
		String TestCaseObjective = "Validation of username and password";
		String TestData = "null";
		System.out.println("Checking Login without entering data...");
		try
		{
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]/ul/li[1]")).getText().equals("Username field is required."))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Error message shown", "Pass");
				System.out.println("Empty login Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Error message is not shown", "Fail");
				System.out.println("Empty login text failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed.Check error on console", "Fail");
			e.printStackTrace();
		}

	}

	/*********************************************************
	 *  Method name: loginData
	 *  @Functionality Provides the data to loginTest method.
	 *  			Acts a data provider.
	 *  @Visibility Public
	 *********************************************************/
	/*@DataProvider(name = "loginData")
	public String[][]loginData()
	{
		return new String[][]{{"mukund","Welcome123"},{"vishal","1225"},{"ddd","1235"}};
	}*/
	
	/***********************************************************
	 *  Method name: loginTest
	 *  @Functionality: Performs login with different credentials.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 3)
	public void loginTest()
	{
		String TestCaseId = "CEB2";
		String ExpectedOutput = "Login successful/Failed";
		String TestCaseObjective = "Checking login with valid and invalid credentials";
		String TestData ="mukund,Welcome123";
		System.out.println("Performaing login test...");
		try
		{
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys("mukund");
			driver.findElement(By.xpath("//*[@id='edit-pass']")).sendKeys("Welcome123");
			Thread.sleep(12000);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).getText().equals("mukund"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Login successful/Failed", "Pass");
				System.out.println("Login test with user mukund is successful");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Sorry, unrecognized username or password", "Fail");
				System.out.println("Login with user mukund is failed.");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}

	/***********************************************************
	 *  Method name: create_eBasta
	 *  @Functionality Checks the validation of mandatory fields
	 *  			in create eBasta form .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 4)
	public void create_eBasta()
	{
		String TestCaseId = "CEB3";
		String ExpectedOutput = "eBasta Name field is required.";
		String TestCaseObjective = "check mandatory fields";
		String TestData = "null";
		System.out.println("Creating eBasta without entering mandatory fields...");
		try
		{
			driver.findElement(By.xpath("//*[@id='block-menu-menu-teacher-menu']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			WebDriver driver1 = driver;
			Alert alt = driver1.switchTo().alert();
			alt.accept();
			Thread.sleep(1000);
			WebDriverWait wt = new WebDriverWait(driver, 10);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]")));
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]")).getText().contains("eBasta Name field is required."))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta Name field is required.", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Error Message not shown", "Fail");
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	/***********************************************************
	 *  Method name: check_eBastaName
	 *  @Functionality Checks the validation of name field
	 *  			in create eBasta form .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 5)
	public void check_eBastaName()
	{
		String TestCaseId = "CEB4";
		String ExpectedOutput = "eBasta name is already in use";
		String TestCaseObjective = "check availability of eBasta Name";
		String TestData = "skumar";
		System.out.println("Check availability of eBasta Name..");
		try
		{
			driver.findElement(By.xpath("//*[@id='edit-ebasta-name']")).sendKeys("skumar");
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/div[1]")).getText().contains("eBasta name is already in use"))
			{
				System.out.println("Test pass");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta name is already in use.", "Pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta saved", "Fail");
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	/***********************************************************
	 *  Method name: check_eBastaStatus
	 *  @Functionality Checks the status of unpublished radio
	 *  			button on create eBasta form .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 6)
	public void check_eBastaStatus()
	{
		String TestCaseId = "CEB5";
		String ExpectedOutput = "unpublished checked";
		String TestCaseObjective = "Default status unpublished check";
		String TestData = "null";

		System.out.println("Checking Default status unpublished check");
		try
		{
			if (driver.findElement(By.xpath("//*[@id='edit-status-0']")).getAttribute("checked").equals("true"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "unpublished check", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "unpublished unchecked", "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	/***********************************************************
	 *  Method name: checkSaveButtonMessage
	 *  @Functionality Checks the save button message when all 
	 *  			fields are filled valid on create eBasta form .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 7)
	public void checkSaveButtonMessage()
	{
		String TestCaseId = "CEB6";
		String ExpectedOutput = "Save Message";
		String TestCaseObjective = "Save Button Click";
		String TestData = "Button clicked";

		System.out.println("Checking save button click message");
		try
		{
			driver.findElement(By.xpath("//*[@id='edit-ebasta-name']")).clear();
			driver.findElement(By.xpath("//*[@id='edit-ebasta-name']")).sendKeys("vishal");
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[2]/div/div[1]")).getText().contains("eBasta vishal saved"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eBasta Saved", "Pass");
				System.out.println("Test pass");
				if (driver.findElement(By.xpath("//*[@id='block-system-main']/div/div/div/ul/li[1]/b")).getText().equals("vishal"))
				{
					WebDriver driver1 = driver;
					driver.findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/ul/li[1]/input[3]")).click();
					Alert alt = driver1.switchTo().alert();
					alt.accept();
					System.out.println("eBasta deleted");
				}
				else
				{
					System.out.println("Failed to delete the eBasta.");
				}
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Not displayed", "Fail");
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	/***********************************************************
	 *  Method name: test_eBastaStatistics
	 *  @Functionality Checks the eBasta statistics link is
	 *                 working or not .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 8)
	public void test_eBastaStatistics()
	{
		String TestCaseId = "CEB7";
		String ExpectedOutput = "eBasta statistics link should work";
		String TestCaseObjective = "To check eBasta statistics link";
		String TestData = "null";
		try
		{
			System.out.println("checking statistic link");
			driver.get(url);
			Thread.sleep(500);
			WebDriverWait wt = new WebDriverWait(driver, 10);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("mukund")));
			driver.findElement(By.partialLinkText("mukund")).click();
			String getLink = driver.findElement(By.xpath("//*[@id='block-menu-menu-teacher-menu']/ul/li[3]/a")).getAttribute("href");
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
				System.out.println("test pass");
			}
			else
			{
				System.out.println("test fail");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is not working", "Fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}

	}
	
	/***********************************************************
	 *  Method name: downloadXLS
	 *  @Functionality Checks the download xls file link is working
	 *  			or not .
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 9)
	public void downloadXLS()
	{
		String TestCaseId = "CEB8";
		String ExpectedOutput = "eBasta statistics XLS file download link should work";
		String TestCaseObjective = "To check eBasta statistics XLS download link";
		String TestData = "null";
		try
		{
			System.out.println("Checking XLS file download link");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-menu-menu-teacher-menu']/ul/li[3]/a")).click();

			String getLink = driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[2]/a")).getAttribute("href");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(getLink);
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is working", "Pass");
				System.out.println("Test pass");
			}
			else if (response.getStatusLine().getStatusCode() == 403)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is working", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Link is not working", "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/***********************************************************
	 *  Method name: preview_eBasta
	 *  @Functionality Checks preview of eBasta is available
	 *  			or not .
	 *  @Visibility Public
	 ***********************************************************/
	
	@Test (priority = 10)
	public void preview_eBasta()
	{
		String TestCaseId = "CEB9";
		String ExpectedOutput = "Preview should be displayed";
		String TestCaseObjective = "To check preview of eBasta";
		String TestData = "null";
		try
		{
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			String bastaName = driver.findElement(By.xpath(".//*[@id='block-system-main']/div/div[1]/div/ul/li[1]/b")).getText();
			driver.findElement(By.xpath(".//*[@id='block-system-main']/div/div[1]/div/ul/li[1]/input[1]")).click();
			WebDriverWait wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j1_1_anchor']")));
			
			if (driver.findElement(By.xpath(".//*[@id='name']")).getText().contains(bastaName))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Preview displayed", "Pass");
				driver.findElement(By.xpath("//*[@id='gridSystemModalLabel']/div[2]/div/div[1]/button")).click();
				System.out.println("pass 2");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Preview not displayed", "Fail");
				System.out.println("fail");
			}
			
		}
		catch(Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/***********************************************************
	 *  Method name: edit_eBasta
	 *  @Functionality Checks edit eBasta form is getting shown
	 *  			or not after clicking on edit button.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 11)
	public void edit_eBasta()
	{
		String TestCaseId = "CEB10";
		String ExpectedOutput = "Edit eBasta form should be displayed";
		String TestCaseObjective = "To check edit eBasta option";
		String TestData = "null";
		try
		{
			System.out.println("checking edit ebasta form");
			driver.get(url);
			driver.findElement(By.xpath(".//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='block-menu-menu-teacher-menu']/ul/li[1]/a")).click();
			driver.findElement(By.xpath("html/body/div[5]/div[2]/div[2]/div/ul/li[2]/a")).click();
			driver.findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/ul/li[1]/input[1]")).click();
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Edit eBasta"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Edit eBasta form displayed", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Edit eBasta form not displayed", "Fail");
				System.out.println("Test fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/***********************************************************
	 *  Method name: buy_eBasta
	 *  @Functionality Checks buy process of eBasta.
	 *  			
	 *  @Visibility Public
	 ***********************************************************/
	
	@Test (priority = 12)
	public void buy_eBasta()
	{
		String TestCaseId = "CEB11";
		String ExpectedOutput = "Buying process should be successful";
		String TestCaseObjective = "To check buy eBasta option";
		String TestData = "null";
		try
		{
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/ul/li[1]/input[2]")).click();
			WebDriverWait wt = new WebDriverWait(driver, 10);
			wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submitform']")));
			driver.findElement(By.xpath("//*[@id='submitform']")).click();
			Thread.sleep(200);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='edit-continue']")));
			driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			
			if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Order complete", "Pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Order buy failed", "Fail");
			}
			System.out.println("Test pass");
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/***********************************************************
	 *  Method name: logOut
	 *  @Functionality Performs logout operation.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 13)
	public void logOut()
	{
		System.out.println("7) Logout test");
		try
		{
			List<WebElement> tags = driver.findElements(By.tagName("a"));
			Iterator<WebElement> iterator = tags.iterator();
			while (iterator.hasNext()) 
			{
				WebElement anchor = iterator.next();
				if (anchor.getAttribute("href").contains("/ebasta-test/user/logout")) 
				{
					anchor.click();
					break;
				}
			}
			if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).getText().equals("Login"))
			{
				System.out.println("Test pass");
			}
			else
			{
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			System.out.println("logout failed with exception "+e.toString());
		}
	}

	/***********************************************************
	 *  Method name: createFolder
	 *  @Functionality Checks folder is getting created or not
	 *  			in eBasta creation.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 14)
	public void createFolder()
	{
		String TestCaseId = "CEB12";
		String ExpectedOutput = "Folder created";
		String TestCaseObjective = "Two folder Creation in eBasta Structure";
		String TestData = "folder creation clicked";

		System.out.println("8) Folder creation in eBasta");
		try
		{
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys("mukund");
			driver.findElement(By.xpath("//*[@id='edit-pass']")).sendKeys("Welcome123");
			Thread.sleep(12000);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			driver.findElement(By.xpath("//*[@id='block-menu-menu-teacher-menu']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-ebasta-name']")).sendKeys("vishal");
			Actions ac = new Actions(driver).contextClick(driver.findElement(By.xpath("//*[@id='j1_1_anchor']")));
			ac.build().perform();	
			driver.findElement(By.xpath("html/body/ul/li[1]/a")).click();
			driver.findElement(By.xpath("html/body/ul/li[1]/ul/li[1]/a")).click();
			driver.findElement(By.className("jstree-rename-input")).sendKeys("myfolder");
			driver.findElement(By.className("jstree-rename-input")).sendKeys(Keys.RETURN);

			if (driver.findElement(By.linkText("myfolder")).getText().equals("myfolder"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "1st folder created", "Pass");
				System.out.println("Test pass(1st folder)");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "1st folder not created", "Fail");
				System.out.println("Test failed(1st folder creation)");
			}

			ac = new Actions(driver).contextClick(driver.findElement(By.xpath("//*[@id='j1_1_anchor']")));
			ac.build().perform();	
			driver.findElement(By.xpath("html/body/ul/li[1]/a")).click();
			driver.findElement(By.xpath("html/body/ul/li[1]/ul/li[1]/a")).click();
			driver.findElement(By.className("jstree-rename-input")).sendKeys("copyfolder");
			driver.findElement(By.className("jstree-rename-input")).sendKeys(Keys.RETURN);

			if (driver.findElement(By.linkText("copyfolder")).getText().equals("copyfolder"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "2nd folder created", "Pass");
				System.out.println("Test pass(2nd folder)");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "2nd folder not created", "Fail");
				System.out.println("Test failed(2nd folder creation)");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}

	}

	/***********************************************************
	 *  Method name: reanameFolder
	 *  @Functionality Checks folder is getting renamed or not
	 *  			in eBasta creation.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 15, dependsOnMethods = "createFolder")
	public void renameFolder()
	{

		String TestCaseId = "CEB13";
		String ExpectedOutput = "folder renamed";
		String TestCaseObjective = "Rename Folder in eBasta Structure";
		String TestData = "folder renamed clicked";

		System.out.println("9) Renaming folder");
		try
		{
			Actions ac = new Actions(driver).contextClick(driver.findElement(By.linkText("myfolder")));
			ac.build().perform();	
			driver.findElement(By.xpath("html/body/ul/li[3]/a")).click();
			driver.findElement(By.className("jstree-rename-input")).sendKeys("myfolder1");
			driver.findElement(By.className("jstree-rename-input")).sendKeys(Keys.RETURN);
			if (driver.findElement(By.linkText("myfolder1")).getText().equals("myfolder1"))
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "folder renamed", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "folder not renamed", "Fail");
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}

	/***********************************************************
	 *  Method name: cutFolder
	 *  @Functionality Checks folder is getting cut or not
	 *  			in eBasta creation.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 16, dependsOnMethods = "renameFolder")
	public void cutFolder()
	{
		String TestCaseId = "CEB14";
		String ExpectedOutput = "folder cut";
		String TestCaseObjective = "Cut Folder in eBasta Structure";
		String TestData = "folder cut clicked";

		System.out.println("Cut folder test");
		try
		{
			Actions ac = new Actions(driver).contextClick(driver.findElement(By.xpath("//*[@id='j1_1_anchor']")));
			ac.build().perform();	
			driver.findElement(By.xpath("html/body/ul/li[1]/a")).click();
			driver.findElement(By.xpath("html/body/ul/li[1]/ul/li[1]/a")).click();
			driver.findElement(By.className("jstree-rename-input")).sendKeys("movefolder");
			driver.findElement(By.className("jstree-rename-input")).sendKeys(Keys.RETURN);

			if (driver.findElement(By.linkText("movefolder")).getText().equals("movefolder"))
			{
				ac = new Actions(driver).contextClick(driver.findElement(By.linkText("myfolder1")));
				ac.build().perform();
				driver.findElement(By.xpath("html/body/ul/li[6]/a")).click();
				driver.findElement(By.xpath("html/body/ul/li[6]/ul/li[1]/a")).click();
				ac = new Actions(driver).contextClick(driver.findElement(By.linkText("movefolder")));
				ac.build().perform();
				driver.findElement(By.xpath("html/body/ul/li[6]/a")).click();
				driver.findElement(By.xpath("html/body/ul/li[6]/ul/li[3]/a")).click();
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "folder cut", "Pass");
				System.out.println("Test pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "folder not cut", "Fail");
				System.out.println("Test failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}

	/***********************************************************
	 *  Method name: copyFolder
	 *  @Functionality Checks folder is getting copied or not
	 *  			in eBasta creation.
	 *  @Visibility Public
	 ***********************************************************/
	@Test (priority = 17, dependsOnMethods = "cutFolder")
	public void copyFolder()
	{
		String TestCaseId = "CEB15";
		String ExpectedOutput = "folder copy";
		String TestCaseObjective = "Copy Folder in eBasta Structure";
		String TestData = "folder copy clicked";

		System.out.println("Copy folder test");
		try
		{
			Actions ac = new Actions(driver).contextClick(driver.findElement(By.linkText("copyfolder")));
			ac.build().perform();
			driver.findElement(By.xpath("html/body/ul/li[6]/a")).click();
			driver.findElement(By.xpath("html/body/ul/li[6]/ul/li[2]/a")).click();
			ac = new Actions(driver).contextClick(driver.findElement(By.linkText("movefolder")));
			ac.build().perform();
			driver.findElement(By.xpath("html/body/ul/li[6]/a")).click();
			driver.findElement(By.xpath("html/body/ul/li[6]/ul/li[3]/a")).click();
			System.out.println("Test pass");
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "folder copied", "Pass");
			List<WebElement> tags = driver.findElements(By.tagName("a"));
			Iterator<WebElement> iterator = tags.iterator();
			while(iterator.hasNext()) 
			{
				WebElement anchor = iterator.next();
				if (anchor.getAttribute("href").contains("/ebasta-test/user/logout")) 
				{
					anchor.click();
					break;
				}
			}
			if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).getText().equals("Login"))
			{
				System.out.println("Logout Done");
			}
			else
			{
				System.out.println("Logout failed");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
}