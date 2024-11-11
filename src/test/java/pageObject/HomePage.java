package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Login']")
	WebElement clkLogin;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']")
	WebElement clkregister;
	
	public void clickRegister() 
	{
		clkregister.click();
	}
	
	public void clickLogin() 
	{
		clkLogin.click();
	}
	
	
}
