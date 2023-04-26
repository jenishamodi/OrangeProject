package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseOrangeHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;


public class LoginTest extends BaseOrangeHRMClass {
	
	PomLogin log;
	//create LoginTest Constructor
	public LoginTest() {
		
		super(); //initialize and read all properties of config.propertise file
		
	}
	
	@BeforeMethod
	public void initsetup() {
		
		initiation(); //call initiation method 
		screenshots("Login"); //call screenshots method 
		log = new PomLogin();
	}
	
	
	  @Test(priority=1)
	  public void Title() { 
	     String actual = log.verifypagetitle();
	     //System.out.println("Your input was: " + actual);
	     Assert.assertEquals(actual,"OrangeHRM"); 
	  }
	  
	  //fetch data from only websheet then use this code
	  @DataProvider
	  public Object[][] Details() {
		  Object result[][]=ExcelSheet.readdata("Sheet1");
		  return result;
	  }
	  
	  
	  @Test(priority=2, dataProvider="Details")
	  public void Login(String name,String password) throws InterruptedException {
		 //System.out.println(prop.getProperty("username"));
		  //Config file from get user name and password then use this code and no pass parameter in login method as a name and password
		  //log.typeusername(prop.getProperty("username"));
		  //log.typepassword(prop.getProperty("password"));
		  //log.loginbtnclick();
		  
		  //if data get from excel sheet (websheet) then pass parameter in above Login method other wise not pass parameter name and password
		  Thread.sleep(3000);
		  log.typeusername(name);
		  Thread.sleep(3000);
		  log.typepassword(password);
		  Thread.sleep(3000);
		  //log.loginbtnclick();
	  }
	  
	  @AfterMethod
	  public void close() {
		  //driver.close();
	  }
	 
	

}
