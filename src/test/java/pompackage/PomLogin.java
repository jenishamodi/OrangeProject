package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseOrangeHRMClass;

public class PomLogin extends BaseOrangeHRMClass {
	 
	//object repository
	@FindBy(name="username") //driver.findElement(By.cssSelector) = @FindBy
	WebElement Username; //Store above line in Username
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement UserPassword; //Store above line in UserPassword
	@FindBy(className="orangehrm-login-button")
	WebElement Loginbtn; //Store above line in Loginbtn
	
	
	//@findby all elements initiate page 
	public PomLogin () {
		
		PageFactory.initElements(driver, this); // Call initElements() method by using PageFactory reference and pass driver and this as parameters.
		
	}
	
	public void typeusername(String name) { 
		Username.sendKeys(name);
	}
	public void typepassword(String pass) {
		UserPassword.sendKeys(pass);
	}
	
	public void loginbtnclick() {
		Loginbtn.click();
	}
	
	public String verifypagetitle() {
		return driver.getTitle();
	}
	
	
}
