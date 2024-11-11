package testaBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups= {"smoke", "sanity", "regression"})
	@Parameters({"os","browser"})
	public void setup( String os,String br) throws IOException 
	{
		
		FileReader file = new FileReader("./src//test//resources//config.properties"); 
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities dcp = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				dcp.setPlatform(Platform.WIN11);
			}else if(os.equalsIgnoreCase("mac"))
			{
				dcp.setPlatform(Platform.MAC);
			}else if(os.equalsIgnoreCase("linux")) 
			{
				dcp.setPlatform(Platform.LINUX);
			}else 
			{
				System.out.println("No Matching OS");
				return;
			}
			
			switch(br.toLowerCase()) 
			{
			case "chrome": dcp.setBrowserName("chrome"); break;
			case "firefox": dcp.setBrowserName("firefox"); break;
			case "edge": dcp.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser");return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dcp);
		}
		
		
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver();break;
		case "edge": driver = new EdgeDriver(); break;
	    default:System.out.println("Invalid Browser Name"); return;
		}
		
		
		
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
	}
	
	public String captureScreen(String tname) throws IOException {

	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    
	    String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	    File targetFile=new File(targetFilePath);
	    
	    sourceFile.renameTo(targetFile);
	      
	    return targetFilePath;
	  
	  
	  
	  
	  }
	
	
	@AfterClass(groups= {"smoke", "sanity", "regression"})
	public void tearDown() 
	{
		driver.close();
		}
}
