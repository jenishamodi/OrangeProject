package basePackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

 public class BaseOrangeHRMClass {
	
	public static Properties prop= new Properties();
	public static ChromeOptions op= new ChromeOptions();
	public static WebDriver driver;
	  
	//Step1 
	  public BaseOrangeHRMClass() {  
		 
			  try { 
				  FileInputStream file = new FileInputStream("D:\\Jenisha\\OrangeHRM\\src\\test\\java\\environmentvariables\\Config.properties");
				  prop.load(file);
			  } catch(FileNotFoundException e) {
				  e.printStackTrace();
			  } catch(IOException a) {
			    a.printStackTrace(); 
			  }
	  }
	  //step 2
	 
	public static void initiation() {
		  
		  //get browser
		  String browsername = prop.getProperty("browser"); 
		  if(browsername.equals("Firefox")) {
			  System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			  driver=new FirefoxDriver();
		  } else if(browsername.equals("chrome")) {
			  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			  op.addArguments("--remote-allow-origins=*");
			  driver=new ChromeDriver(op);
			 
		  }
		  //Maximizes the browser window
		  driver.manage().window().maximize();
		  
		  // set the time of 30 seconds for page to complete the loading
		 //driver.manage().timeouts().pageLoadTimeout(utility.TimeUtils.timepage, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utility.TimeUtils.timepage));
		  
		  //get url
		  driver.get(prop.getProperty("url"));
		  
	}
	
	//TakesScreenshot
	public static void screenshots(String Filename) {
		//taking the Screenshot help of getScreenshotAs
		//screenshot store in file
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		
		//copy Screenshot as a desire folder as a D:\\Jenisha\\OrangeHRM\\src\\test\\java\\screenshots\\Screenshots
		try {
		 FileUtils.copyFile(file, new File("D:\\Jenisha\\OrangeHRM\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	 
	

}
