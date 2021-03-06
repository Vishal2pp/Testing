package eBastaRole;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBastaTestingClasses.GenerateReport;
import eBastaTestingClasses.GetUrl;
import eBastaTestingClasses.GetWebDriver;
/*******************************************************
 *  Class name: PublisherRoleTest
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  Methods:
 *  	1)addTestCaseHeading
 *  	2)addNew_eContent
 *  	3)checkMy_eContents
 *  	4)checkLinks
 *  	5)getLinks
 *  	6)logout
 *  @Functionality To test the different publisher roles. 
 *  @Visibility Public
 ********************************************************/
public class PublisherRoleTest 
{
	WebDriver driver;
	String url = "";
	public PublisherRoleTest()
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
		GenerateReport.addTitle("Publisher role Test cases-");
	}
	
	/*********************************************************
	 *  Method name: addNew_eContent
	 *  @Functionality Adds the new eContent.
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 2)
	public void addNew_eContent()
	{
		String TestCaseId = "PR1";
		String ExpectedOutput = "eContent created";
		String TestCaseObjective = "To add new eContent";
		String TestData = "null";
		try
		{
			System.out.println("Adding new eContent");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='edit-name']")).sendKeys("ncert");
			driver.findElement(By.xpath("//*[@id='edit-pass']")).sendKeys("demo");
			Thread.sleep(12000);
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			if (driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).getText().equals("ncert"))
			{
				driver.findElement(By.xpath("//*[@id='block-menu-menu-publisher-menu']/ul/li[1]/a")).click();
				driver.findElement(By.xpath("//*[@id='edit-title']")).sendKeys("eBasta econtent");
				driver.findElement(By.xpath("//*[@id='edit-field-class-und-12']")).click();
				
				Select subject = new Select(driver.findElement(By.id("edit-field-subject-und")));
				subject.selectByIndex(5);
				
				Select language = new Select(driver.findElement(By.id("edit-field-language-und")));
				language.selectByIndex(2);
				
				Select econtentType = new Select(driver.findElement(By.id("edit-field-econtent-type-und")));
				econtentType.selectByIndex(2);
				Thread.sleep(200);
				
				Select format = new Select(driver.findElement(By.id("edit-field-media-format-und")));
				format.selectByIndex(4);
				driver.findElement(By.xpath("//*[@id='edit-next']")).click();
				
				driver.findElement(By.xpath("//*[@id='edit-field-econtent-description-und-0-value']")).sendKeys("eBasta testing");
				driver.findElement(By.xpath("//*[@id='edit-field-sell-price-und-0-value']")).sendKeys("100");
				
				driver.findElement(By.xpath("//*[@id='edit-field-preview-und-preview-content']")).click();
				WebDriverWait wt = new WebDriverWait(driver, 10);
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='edit-field-econtent-preview-und-0-ajax-wrapper']/div/label"))));
				try
				{
					System.out.println("Checking upload preview content dialog");
					if(driver.findElement(By.xpath("//*[@id='edit-field-econtent-preview-und-0-ajax-wrapper']/div/label")).isDisplayed())
					{
						System.out.println("Test Pass");
						GenerateReport.addData("PR1.1", "To check upload preview dialog", TestData, "Upload preview content dialog should be displayed", "displayed", "Pass");
					}
					else
					{
						System.out.println("Test fail");
						GenerateReport.addData("PR1.1", "To check upload preview dialog", TestData, "Upload preview content dialog should be displayed", "not displayed", "Fail");
					}
				}
				catch(Exception e)
				{
					GenerateReport.addData("PR1.1", "To check upload preview dialog", TestData, "Upload preview content dialog should be displayed", "Exception occured", "Fail");
					e.printStackTrace();
				}
				
				driver.findElement(By.xpath("//*[@id='edit-field-preview-und-preview-url']")).click();
				wt = new WebDriverWait(driver, 10);
				wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='edit-field-e-content-preview-url-und-0']/div/div/div/label"))));
				try
				{
					System.out.println("Checking content preview url dialog");
					if(driver.findElement(By.xpath("//*[@id='edit-field-e-content-preview-url-und-0']/div/div/div/label")).isDisplayed())
					{
						System.out.println("Test Pass");
						GenerateReport.addData("PR1.2", "To check content preview url dialog", TestData, "Content preview url dialog should be displayed", "displayed", "Pass");
					}
					else
					{
						System.out.println("Test fail");
						GenerateReport.addData("PR1.2", "To check content preview url dialog", TestData, "Content preview url dialog should be displayed", "not displayed", "Fail");
					}
				}
				catch(Exception e)
				{
					GenerateReport.addData("PR1.2", "To check content preview url dialog", TestData, "Content preview url dialog should be displayed", "Exception occured", "Fail");
					e.printStackTrace();
				}
				driver.findElement(By.xpath("//*[@id='edit-field-preview-und-none']")).click();
				driver.findElement(By.xpath("//*[@id='edit-field-drm-content-und-yes']")).click();
				
				try
				{
					System.out.println("Checking DRM provider dropdown");
					if(driver.findElement(By.xpath("//*[@id='edit-field-drm-provider']/div/label")).isDisplayed())
					{
						System.err.println("Test pass");
						Select s = new Select(driver.findElement(By.xpath("//*[@id='edit-field-drm-provider-und']")));
						List<WebElement> ss = s.getOptions();
						if(ss.isEmpty())
						{
							System.out.println("Test fail-Drop down empty");
							GenerateReport.addData("PR1.3", "To check DRM provider dropdown", TestData, "dropdown should be displayed", "displayed but empty", "Fail");
						}
						else
						{
							GenerateReport.addData("PR1.3", "To check DRM provider dropdown", TestData, "Dropdown should be displayed", "displayed with values", "Pass");
							s.selectByVisibleText("e-Shabda");
							try
							{
								System.out.println("Checking shared secret key dialog");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='field-shared-secret-key-add-more-wrapper']/div/label"))));
								if(driver.findElement(By.xpath("//*[@id='field-shared-secret-key-add-more-wrapper']/div/label")).isDisplayed())
								{
									System.out.println("Test pass");
									GenerateReport.addData("PR1.4", "To check shared secret key dialog", TestData, "dialog should be displayed", "Dailog displayed", "Pass");
								}
								else
								{
									System.out.println("Test fail");
									GenerateReport.addData("PR1.4", "To check shared secret key dialog", TestData, "dailog should be displayed", "Not displayed", "Fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1.4", "To check shared secret key dialog", TestData, "Dialog should be displayed", "Exception occured", "Fail");
								e.printStackTrace();
							}
							try
							{
								System.out.println("Checking distributor vendor id dialog");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='field-distributor-vendor-id-add-more-wrapper']/div/label"))));
								if(driver.findElement(By.xpath("//*[@id='field-distributor-vendor-id-add-more-wrapper']/div/label")).isDisplayed())
								{
									System.out.println("Test pass");
									GenerateReport.addData("PR1.5", "To check Distributor_ID/Vendor_ID dialog", TestData, "dialog should be displayed", "Dailog displayed", "Pass");
								}
								else
								{
									System.out.println("Test fail");
									GenerateReport.addData("PR1.5", "To check Distributor_ID/Vendor_ID dialog", TestData, "dailog should be displayed", "Not displayed", "Fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1.5", "To check Distributor_ID/Vendor_ID dialog", TestData, "Dialog should be displayed", "Exception occured", "Fail");
								e.printStackTrace();
							}
							try
							{
								System.out.println("checking book id/resource id dialog");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='field-book-id-resource-id-add-more-wrapper']/div/label"))));
								if(driver.findElement(By.xpath("//*[@id='field-book-id-resource-id-add-more-wrapper']/div/label")).isDisplayed())
								{
									System.out.println("Test pass");
									GenerateReport.addData("PR1.6", "To check Book ID/Resource ID dialog", TestData, "dialog should be displayed", "Dailog displayed", "Pass");
								}
								else
								{
									System.out.println("Test fail");
									GenerateReport.addData("PR1.6", "To check Book ID/Resource ID dialog", TestData, "dailog should be displayed", "Not displayed", "Fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1.6", "To check Book ID/Resource ID dialog", TestData, "Dialog should be displayed", "Exception occured", "Fail");
								e.printStackTrace();
							}
							
							s.selectByVisibleText("uLektz");
							try
							{
								System.out.println("Checking book id/resource id dialog");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='field-book-id-resource-id-add-more-wrapper']/div/label"))));
								if(driver.findElement(By.xpath("//*[@id='field-book-id-resource-id-add-more-wrapper']/div/label")).isDisplayed())
								{
									System.out.println("Test pass");
									GenerateReport.addData("PR1.7", "To check Book ID/Resource ID dialog", TestData, "dialog should be displayed", "Dailog displayed", "Pass");
								}
								else
								{
									System.out.println("Test failed");
									GenerateReport.addData("PR1.7", "To check Book ID/Resource ID dialog", TestData, "dailog should be displayed", "Not displayed", "Fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1.7", "To check Book ID/Resource ID dialog", TestData, "Dialog should be displayed", "Exception occured", "Fail");
								e.printStackTrace();
							}
							try
							{
								System.out.println("Checking upload file dailog");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='edit-field-upload-key-file-und-0-ajax-wrapper']/div/label"))));
								if(driver.findElement(By.xpath("//*[@id='edit-field-upload-key-file-und-0-ajax-wrapper']/div/label")).isDisplayed())
								{
									System.out.println("Test pass");
									GenerateReport.addData("PR1.8", "To check Upload Key File dialog", TestData, "dialog should be displayed", "Dailog displayed", "Pass");
								}
								else
								{
									System.out.println("Test fail");
									GenerateReport.addData("PR1.8", "To check Upload Key File dialog", TestData, "dailog should be displayed", "Not displayed", "Fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1.8", "To check Upload Key File dialog", TestData, "Dialog should be displayed", "Exception occured", "Fail");
								e.printStackTrace();
							}
							
							s.selectByVisibleText("e-Shabda");
							try
							{
								System.out.println("Adding new eContent");
								wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='field-shared-secret-key-add-more-wrapper']/div/label"))));
								driver.findElement(By.xpath("//*[@id='field-shared-secret-key-add-more-wrapper']/div/label")).sendKeys("ABCDEFG");
								driver.findElement(By.xpath("//*[@id='field-distributor-vendor-id-add-more-wrapper']/div/label")).sendKeys("123456");
								driver.findElement(By.xpath("//*[@id='field-book-id-resource-id-add-more-wrapper']/div/label")).sendKeys("123456");
								driver.findElement(By.xpath("//*[@id='edit-field-preferred-reader-und-android']")).click();
								driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
								if (driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/ul/li[2]/a")).getText().equals("Edit"))
								{
									GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eContent created", "Pass");
									System.out.println("Test pass");
								}
								else
								{
									GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "eContent has not created", "Fail");
									System.out.println("Test fail");
								}
							}
							catch(Exception e)
							{
								GenerateReport.addData("PR1", TestCaseObjective, TestData, ExpectedOutput, "Exception occured", "Fail");
								e.printStackTrace();
							}
						}
					}
					else
					{
						GenerateReport.addData("PR1.3", "To check DRM provider dropdown", TestData, "Dropdown should be displayed", "not displayed", "Fail");
					}
				}
				catch(Exception e)
				{
					GenerateReport.addData("PR1.3", "To check DRM provider dropdown", TestData, "Dropdown should be displayed", "Exception occured", "Fail");
					e.printStackTrace();
				}
			
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Sorry, unrecognized username or password. Publisher login failed.", "Fail");
				System.out.println("Login for publisher failed\n\n");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: checkMy_eContents
	 *  @Functionality Checks the already present eContents.
	 *  @Visibility Public
	 *********************************************************/
	@Test(priority = 3)
	public void checkMy_eContents()
	{
		String TestCaseId = "PR2";
		String ExpectedOutput = "My eContent should be present";
		String TestCaseObjective = "To check My eContent";
		String TestData = "null";
		int GridFlag = 0;
		int TableFlag = 0;
		try
		{
			System.out.println("Checking my eContent");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-menu-menu-publisher-menu']/ul/li[2]/a")).click();
			String GridLink = driver.findElement(By.xpath("//*[@id='quicktabs-tab-my_e_contents-0']")).getAttribute("href");
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(GridLink);
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				GridFlag = 1;
			}
			String TableLink = driver.findElement(By.xpath("//*[@id='quicktabs-tab-my_e_contents-1']")).getAttribute("href");
			request = new HttpGet(TableLink);
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200)
			{
				TableFlag = 1;
			}
			if (GridFlag == 1 && TableFlag == 1)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "MyEcontent is present in both table and grid view", "Pass");
			}
			if (GridFlag == 1 && TableFlag == 0)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "MyEcontent is present in grid view and ABSENT in table view", "Fail");
			}
			if (GridFlag == 0 && TableFlag == 1)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "MyEcontent is present in table view and ABSENT in grid view", "Fail");
			}
			if (GridFlag == 0 && TableFlag == 0)
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "MyEcontent is ABSENT in both table and grid view", "Fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void checkMy_eContents1()
	{
		
		String ExpectedOutput = "My eContent details page should be displayed";
	
		String TestData = "null";
		
		try
		{
			System.out.println("Checking my eContents details from grid view");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-menu-menu-publisher-menu']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='views-bootstrap-grid-1']/div[1]/div[1]/div[2]/span/a")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='node-6647']/div[1]/div/button")));
			if(driver.findElement(By.xpath("//*[@id='node-6647']/div[1]/div/button")).isDisplayed())
			{
				System.out.println("Test pass");
				GenerateReport.addData("PR3.1", "To check my eContent details from grid view", TestData, ExpectedOutput, "My eContent details page displayed from grid view", "Pass");
				try
				{
					System.out.println("Checking Buy process from grid view");
					driver.findElement(By.xpath("//*[@id='node-6647']/div[2]/div[2]/p[11]/button")).click();
					driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
					driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
					if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
					{
						System.out.println("Test pass");
						GenerateReport.addData("PR3.1.1", "TO check buy process from grid view", TestData, "Order complete", "Order complete", "Pass");
					}
					else
					{
						System.out.println("Test fail");
						GenerateReport.addData("PR3.1.1", "TO check buy process from grid view", TestData, "Order complete", "Order incomplete", "Fail");
					}
				}
				catch(Exception e)
				{
					System.out.println("Test fail");
					GenerateReport.addData("PR3.1.1", "TO check buy process from grid view", TestData, "Order complete", "Order incomplete", "Fail");
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Test fail");
				GenerateReport.addData("PR3.1", "To check my eContent details from grid view", TestData, ExpectedOutput, "My eContent details page is not displayed from grid view", "Fail");
			}
		}
		catch(Exception e)
		{
			GenerateReport.addData("PR3.1", "To check my eContent details from grid view", TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			GenerateReport.addData("PR3.1.1", "TO check buy process from grid view", TestData, "Order complete", "Order incomplete", "Test skipped due to exception");
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("Checking my eContents details from table view");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-menu-menu-publisher-menu']/ul/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id='quicktabs-tab-my_e_contents-1']")).click();
			driver.findElement(By.xpath("//*[@id='quicktabs-tabpage-table_view-0']/div/div[1]/table/tbody/tr[1]/td[6]/a/span")).click();
			if(driver.findElement(By.xpath("//*[@id='node-6647']/div[1]/div/button")).isDisplayed())
			{
				System.out.println("Test pass");
				GenerateReport.addData("PR3.2", "To check my eContent details from table view", TestData, ExpectedOutput, "My eContent details page displayed from table view", "Pass");
				try
				{
					System.out.println("Checking Buy process from table view");
					driver.findElement(By.xpath("//*[@id='node-6647']/div[2]/div[2]/p[11]/button")).click();
					driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
					driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
					if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().equals("Order complete"))
					{
						System.out.println("Test pass");
						GenerateReport.addData("PR3.2.1", "TO check buy process from table view", TestData, "Order complete", "Order complete", "Pass");
					}
					else
					{
						System.out.println("Test fail");
						GenerateReport.addData("PR3.2.1", "TO check buy process from table view", TestData, "Order complete", "Order incomplete", "Fail");
					}
				}
				catch(Exception e)
				{
					System.out.println("Test fail");
					GenerateReport.addData("PR3.2.1", "TO check buy process from table view", TestData, "Order complete", "Order incomplete", "Fail");
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Test fail");
				GenerateReport.addData("PR3.2", "To check my eContent details from grid view", TestData, ExpectedOutput, "My eContent details page is not displayed from table view", "Fail");
			}
		}
		catch (Exception e)
		{
			GenerateReport.addData("PR3.2", "To check my eContent details from table view", TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			GenerateReport.addData("PR3.2.1", "TO check buy process from table view", TestData, "Order complete", "Order incomplete", "Test skipped due to exception");
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name: checkLinks
	 *  @Functionality Checks the links on publisher portal.
	 *  @param xpath
	 *  	   xpath of the link which is to be tested.
	 *  
	 *  @param name
	 *  	   Name of the link to be tested.
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@Test(priority = 5, dataProvider = "LinkData")
	public void checkLinks(String xpath, String name)
	{
		String TestCaseId = "PR4";
		String ExpectedOutput = "Link should work";
		String TestCaseObjective = "To check different publisher links";
		String TestData = name;
		
		try
		{
			System.out.println("Checking publisher links");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[2]/a")).click();
			String getLink = driver.findElement(By.xpath(xpath)).getAttribute("href");
			driver.findElement(By.xpath(xpath)).click();
			//System.out.println(driver.getCurrentUrl());
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
				System.out.println("Test pass");
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
	 *  @Functionality Provides the data to checkLinks method.
	 *  			Acts as a data provider.
	 *  @return two dimensional string array. 
	 *  
	 *  @Visibility Public
	 *********************************************************/
	@DataProvider (name = "LinkData")
	public String[][] getLinks()
	{
		return new String[][]{
			{"//*[@id='block-menu-menu-publisher-menu']/ul/li[3]/a","Bulk upload link"},
			{"//*[@id='block-menu-menu-publisher-menu']/ul/li[4]/a","Custom sales report link"},
			{"//*[@id='block-menu-menu-publisher-menu']/ul/li[5]/a","Product sales report link"},
			{"//*[@id='block-menu-menu-publisher-menu']/ul/li[6]/a","Year sales report link"}};
	}
	
	
	@Test(priority = 6)
	public void checkPreview()
	{
		String TestCaseId = "PR5";
		String ExpectedOutput = "Preview should be displayed";
		String TestCaseObjective = "To check ebasta preview";
		String TestData = "null";
		
		try
		{
			System.out.println("Checking preview");
			driver.get(url);
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/ul/li[1]/input[1]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='j1_1_anchor']"))));
			if(driver.findElement(By.xpath("//*[@id='j1_1_anchor']")).isDisplayed())
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Preview displayed", "Pass");
				driver.findElement(By.xpath("//*[@id='gridSystemModalLabel']/div[2]/div/div[1]/button")).click();
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Preview not displayed", "Fail");
			}
			
			
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}
	
	/*@Test(priority = 7)
	public void buy_ebasta()
	{
		String TestCaseId = "PR6";
		String ExpectedOutput = "buy process should be complete";
		String TestCaseObjective = "To buy ebasta";
		String TestData = "null";
		
		try
		{
			System.out.println("Buying ebasta");
			driver.get("http://14.139.112.73:8001/ebasta-test/");
			driver.findElement(By.xpath("//*[@id='navbar']/nav/ul/li[3]/a")).click();
			driver.findElement(By.xpath("//*[@id='block-system-main']/div/div[1]/div/ul/li[1]/input[2]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submitform']")));
			driver.findElement(By.xpath("//*[@id='submitform']")).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='edit-continue']"))));
			driver.findElement(By.xpath("//*[@id='edit-continue']")).click();
			driver.findElement(By.xpath("//*[@id='edit-submit']")).click();
			
			if(driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div/h1")).getText().contains("Order complete"))
			{
				System.out.println("Buy process completed, Test pass");
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Buy process completed", "Pass");
			}
			else
			{
				GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Buy process incompleted", "Fail");
			}
			
			
		}
		catch (Exception e)
		{
			GenerateReport.addData(TestCaseId, TestCaseObjective, TestData, ExpectedOutput, "Exception occurred,Test execution failed. Check error on console", "Fail");
			e.printStackTrace();
		}
	}*/
	/*********************************************************
	 *  Method name: logout
	 *  @Functionality Logout as a publisher.
	 *  @Visibility Public
	 *********************************************************/
	@Test (priority = 8)
	public void logout()
	{
		driver.get(url);
		driver.findElement(By.xpath("//*[@id='block-block-20']/ul/li[3]/a")).click();
	}
	
}
