package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testaBase.BaseClass;

public class TC002LoginTest extends BaseClass{

	@Test(groups= {"smoke", "sanity"})
	public void verifyLogin()
	{
		HomePage hm = new HomePage(driver);
		hm.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(p.getProperty("username"));
		lp.setPassword(p.getProperty("password"));
		lp.clkLoginbtn();
		
		
		
	}
}
