package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	WebDriver driver;
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement clickLogout;
	
	public boolean isMyAcccountisExists() 
	{
		try {
			boolean result = msgMyAccount.isDisplayed();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void clickLogout() 
	{
		clickLogout.click();
	}
}
