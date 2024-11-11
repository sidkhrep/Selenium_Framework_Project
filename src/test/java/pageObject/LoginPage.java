package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement setUserName;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement setPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setUsername(String username) 
	{
		setUserName.sendKeys(username);
	}
	public void setPassword(String pwd) 
	{
		setPassword.sendKeys(pwd);
	}
	public void clkLoginbtn() 
	{
		btnLogin.click();
	}
}
