package pom1;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	
// Globlly we declare object with access Specifier Private 
	@FindBy (xpath="//input[@id='username']")
	private WebElement Username;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement KeepLoggedIn;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement Loginbutton;
	
	@FindBy(xpath="common files")
	private List<WebElement> ele;
	
	
	
	private WebDriver driver;
	private Actions act;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
		
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
		wait= new WebDriverWait(driver, 20);
	}
	
	
	
	
	public void SendUsername(String UserName) {
		act.moveToElement(Username).sendKeys(UserName).build().perform();
		
	}
	
	public void SendPassword(String passWord) {
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.sendKeys(passWord);
	}
	
	public void ClickOnKeepMeSignIn() {
		KeepLoggedIn.click();
	}
	
	public void ClickLoginButton() {
		Loginbutton.click();
	}
	
	
	
//	public void ClickOnAllObject() {
//		Username.sendKeys("");
//		Password.sendKeys("");
//		KeepLoggedIn.click();
//		Loginbutton.click();
//		
//	}
	
	
	
	
	
	
	
	

	
	
}
