package pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	// Private variable --- WebElement
	
	@FindBy(xpath="//a[@class='content tt']")
	private WebElement Timetrack;
	
	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy(xpath="//a[@class='content reports']")
	private WebElement reports;
	
	@FindBy(xpath="//a[@class='content users']")
	private WebElement user;
	
	
	@FindBy(xpath="(//a[text( )='Logout'])[1]")
	private  WebElement Logout;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions act;
	

// public Constructor -- Intialized WebElement
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait=new WebDriverWait(driver,20 );
    act =new Actions(driver);
}

// Public methods-- Actions on WebElement
public void openTimeTrack() {
	Timetrack.click();
}
public void openTasks() {
	
	wait.until(ExpectedConditions.visibilityOf(task));
	act.moveToElement(task).click().build().perform();
}
public void openReports() {
	reports.click();
}
public void openUsers() {
	user.click();
}
public void ClickonLogout() {
	act.moveToElement(Logout).click().build().perform();
}



}
