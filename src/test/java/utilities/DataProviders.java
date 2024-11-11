package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationpage;
import pageObject.HomePage;
import pageObject.LoginPage;
import testaBase.BaseClass;

public class DataProviders extends BaseClass{

	@DataProvider(name ="logindata") 
	public String[][] getdata() throws IOException 
	{
	  
	  ExcelUtility xlutil = new ExcelUtility(".//testData//Opencart_LoginData.xlsx");
	  int totalrows = xlutil.getRowCount("Sheet1");
	  int totalcols = xlutil.getCellCount("Sheet1", 1);
	  
	  String logindata[][]= new String [totalrows][totalcols]; // Created for two dimenaionL array which can store string type of data
	  
	  for(int i=1;i<totalrows;i++)
	  {
	    
	    for(int j=0;j<totalcols;j++)
	    {
	      logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
	      
	    }
	    
	    
	  }
	  return logindata;
	
}
}