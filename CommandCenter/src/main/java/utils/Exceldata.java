package utils;



import java.io.File;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exceldata{

	String a2;

	
	public String[] readExcel(String filePath,String fileName,String sheetName, int y) throws IOException {

	    //Create an object of File class to open xlsx file
		
		

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file
System.out.println(file);
	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    
	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file
	    
	    

	   // int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();
	    
	    int rowCount = guru99Sheet.getPhysicalNumberOfRows();
        int colcount = guru99Sheet.getRow(y).getPhysicalNumberOfCells(); 
        
   //     System.out.println(rowCount);
   //     System.out.println(colcount);
        
       
	//   Object data[][] = new Object[rowCount][colcount-1];
	   
	  

	   
	 //  ArrayList<Object> list = new ArrayList<Object>();
	   
	    //Create a loop over all the rows of excel file to read it
	   
	    

	//   System.out.println(list.get(0)); 

	//    for (int i = 0; i < rowCount; i++) {
        
        String[] values = new String[colcount];
        
        for(int m = 0; m < colcount; m++ )
        	
        {
        	String value = guru99Sheet.getRow(y).getCell(m).getStringCellValue();
        	values[m] = value;
        }
        
    /*    String[] input = y.split(",");
        
        int i = Integer.parseInt(input[0]);
        int j = Integer.parseInt(input[1]);
        
         String[] input1 = z.split(",");
        
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
      
	        String value = guru99Sheet.getRow(i).getCell(j).getStringCellValue();  */
	    //    String value1 = guru99Sheet.getRow(i).getCell(j).getStringCellValue();
	        
	     //   System.out.println(value);
	    //    System.out.println(row.getLastCellNum());
	        //Create a loop to print cell values in a row

	//        for (int j = 0; j < row.getLastCellNum(); j++) {

	        	
	            //Print Excel data in console
	        	
	      //     System.out.println(row.getCell(j).getStringCellValue());

	          
	           
	           
	       //    System.out.println(data[i][j]);
 //  
	           
	     

	        
	        
	    
	    
	    
	    
	    return values;	
		
		
	     

	
}
	
	
	//@DataProvider(name = "testdata")
	
	

	}















