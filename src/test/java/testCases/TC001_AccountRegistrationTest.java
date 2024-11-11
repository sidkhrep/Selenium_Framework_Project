package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationpage;
import pageObject.HomePage;
import testaBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups= {"sanity"})
	public void Register() throws InterruptedException 
	{
		logger.info("Test Case 001 has started successfully");
		
		HomePage hm = new HomePage(driver);
		Thread.sleep(3);
		hm.clickRegister();
		
		logger.info("Account Registration has started");
		AccountRegistrationpage ap = new AccountRegistrationpage(driver);
		Thread.sleep(3);
		ap.setfirstname(randomAlphabhatic());
		ap.setLastname(randomAlphabhatic());
		ap.setEmail(randomAlphabhatic()+"@gmail.com");
		ap.setTelephone(randomNumeric());
		String pwd = randomAlphaNumeric();
		ap.setPassword(pwd);
		ap.setcnfpassword(pwd);
		ap.clickCheckbox();
		ap.clkbtnContinue();
		
		logger.info("TC001 has completed successfully");
	}
	
	public String randomNumeric() 
	{
		String randomnum = RandomStringUtils.randomAlphabetic(4);
		return randomnum;
	}
	
	public String randomAlphabhatic()
	{
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(4);
		return randomAlphabetic;
	}
	
	public String randomAlphaNumeric()
	{
		String Numeric = RandomStringUtils.randomAlphabetic(3);
		String Alpha = RandomStringUtils.randomAlphabetic(3);
		return(Alpha+"@"+Numeric);
	}
}
