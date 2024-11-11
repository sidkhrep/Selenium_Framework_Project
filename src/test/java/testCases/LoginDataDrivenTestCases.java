package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testaBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTestCases extends BaseClass{

	@Test(dataProvider="logindata" , dataProviderClass= DataProviders.class, groups= {"smoke"})
	public void verify_LoginDDT(String username, String Password, String exp) 
	{
		logger.info("Started");
		
		
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(Password);
		lp.clkLoginbtn();
		
		MyAccountPage mp = new MyAccountPage(driver); 
		boolean myAccountExists = mp.isMyAcccountisExists();
		
		if(exp.equalsIgnoreCase("valid")) 
		{
			if(myAccountExists==true) 
			{
				mp.clickLogout();
				Assert.assertTrue(true);
			}else 
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(myAccountExists==true) 
			{
				mp.clickLogout();
				Assert.assertTrue(false);
			}else 
			{
				
				Assert.assertTrue(true);
			}
		}
		logger.info("End of test case");
	}
}
