package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends BasePage{

	WebDriver driver;
	
	public AccountRegistrationpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement boxfirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement boxlastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement boxEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement boxTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement boxPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement boxCnfPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement selectCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement selectContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfmessage;
	
	public void setfirstname(String firstname) 
	{
		boxfirstname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) 
	{
		boxlastName.sendKeys(lastname);
	}
	
	public void setEmail(String email) 
	{
		boxEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) 
	{
		boxTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password) 
	{
		boxPassword.sendKeys(password);
	}
	
	public void setcnfpassword(String cnfpassword) 
	{
		boxCnfPassword.sendKeys(cnfpassword);
	}
	
	public void clickCheckbox() 
	{
		selectCheckbox.click();
	}
	
	public void clkbtnContinue() 
	{
		selectContinue.click();
	}
	
	public String getcnfmessage() 
	{
		try {
			return(cnfmessage.getText());
			
		} catch (Exception e) {
			e.printStackTrace();
			return(e.getMessage());
		}
	}
	
}
