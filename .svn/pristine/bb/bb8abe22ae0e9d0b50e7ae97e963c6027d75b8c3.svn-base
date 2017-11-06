package eBastaTestingClasses;

import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*******************************************************
 *  Class name: GenerateReport
 *  @author Vishal Patil
 *  @version 1.0
 *  @since 2016-06-08
 *  
 *  Methods:
 *  	1)addTitle
 *  	2)addData
 *  @Functionality To generate the test report in xl format. 
 *  @Visibility Public
 *******************************************************/
public class GenerateReport 
{
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	static int rowCount=1;
	static FileOutputStream fileOut;
	static
	{
		 try 
		 {
			 DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	         Calendar calobj = Calendar.getInstance();
	         fileOut = new FileOutputStream("Test Report.xls");
	         workbook = new HSSFWorkbook();
			 sheet = workbook.createSheet("Test Results "+df.format(calobj.getTime()).toString()+"");
			
			 HSSFRow row = sheet.createRow(0);
			 row.createCell(0).setCellValue("Module/Unit in Focus-");
			 row.createCell(1).setCellValue("eBasta");
			 
			 row = sheet.createRow(2);
			 row.createCell(0).setCellValue("Test Date-");
			 row.createCell(1).setCellValue(""+df.format(calobj.getTime()).toString()+"");
			 
			 row = sheet.createRow(5);
			 row.createCell(0).setCellValue("Test Case ID");
			 row.createCell(1).setCellValue("Test Case Objective");
			 row.createCell(2).setCellValue("Test Data");
			 row.createCell(3).setCellValue("Expected Output");
			 row.createCell(4).setCellValue("Actual Output");
			 row.createCell(5).setCellValue("Result (Pass/ Fail)");
			 
			 rowCount = 6;
			 workbook.write(fileOut);
	         fileOut.close();
	         System.out.println("Your excel file has been generated!");
         } 
		 catch (Exception e) 
		 {
 			e.printStackTrace();
 		 }
	}
	
	/*********************************************************
	 *  Method name: addTitle
	 *  @Functionality Adds the heading of the test cases into
	 				   TestReport.xls file.
	 *  @Visibility Public
	 *  @param title
	 *  	   Title to be added in xl file.
	 *********************************************************/
	public static void addTitle(String title)
	{
		try
		{
	        rowCount++;
	        rowCount++;
			HSSFRow rowhead = sheet.createRow(rowCount);
	        rowhead.createCell(0).setCellValue(title);
	        FileOutputStream fileOut = new FileOutputStream("Test Report.xls");
	        workbook.write(fileOut);
	        fileOut.close();
	        rowCount++;
	        rowCount++;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*********************************************************
	 *  Method name addDara
	 *  @Functionality Adds the details of the test case in 
	 			TestReport.xls file after performing the test.
	 *  @Visibility Public
	 *  @param TestCaseId
	 *  	   Id of the test case to be added.
	 *  
	 *  @param TestCaseObjective
	 *  	   Objective of the test case to be added.
	 *  
	 *  @param TestData
	 *  	   Test data used to perform the test.
	 *  
	 *  @param  ExpectedOutput
	 *          Expected output of the test case.
	 *          
	 *  @param 	ActualOutput
	 *  		Actual output of the test case. 	
	 *  
	 *  @param Status
	 *  	Status of the test i.e. Pass/Fail.
	 *********************************************************/
	public static void addData(String TestCaseId, String TestCaseObjective, String TestData, String ExpectedOutput, String ActualOutput, String Status)
	{
		try 
		{
			HSSFRow rowhead = sheet.createRow(rowCount);
	        rowhead.createCell(0).setCellValue(TestCaseId);
	        rowhead.createCell(1).setCellValue(TestCaseObjective);
	        rowhead.createCell(2).setCellValue(TestData);
	        rowhead.createCell(3).setCellValue(ExpectedOutput);
	        rowhead.createCell(4).setCellValue(ActualOutput); 
	        rowhead.createCell(5).setCellValue(Status);
	        for (int i = 0; i<6; i++)
	        {	
	          	sheet.autoSizeColumn(i);
	        }
	         
	        FileOutputStream fileOut = new FileOutputStream("Test Report.xls");
	        workbook.write(fileOut);
	        fileOut.close();
	        rowCount++;
	            
	            
	    }
		catch (Exception ex ) 
		{
			System.out.println(ex);
	    }
	}
}
