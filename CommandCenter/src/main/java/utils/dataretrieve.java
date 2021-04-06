package utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataretrieve {

	// @DataProvider(name = "testdata")
	
	public String[] readdatafunction(int y) {
		

	    //Create an object of ReadGuru99ExcelFile class

		Exceldata objExcelFile = new Exceldata();

	    //Prepare the path of excel file

	 //   String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		
		String filePath = "C:\\Users\\vivek\\Desktop";
		

	    //Call read file method of the class to read data

	  String[] a = new String[5];
	  
	try {
		String[] data = objExcelFile.readExcel(filePath,"Testdata.xlsx","serverapi", y);
	//	System.out.println(data);
		a = data;
		System.out.println(); 
		 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
//	System.out.println(a); 
	return a;
      
	    }
}
