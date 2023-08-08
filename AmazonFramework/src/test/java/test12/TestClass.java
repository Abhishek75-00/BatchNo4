package test12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.HomePage;
import pom1.LoginPage;
import util.UtilityClass;

public class TestClass {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\browsers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://online.actitime.com/marolix4/login.do");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	LoginPage Lp=new LoginPage(driver);
    String UserName=UtilityClass.FetchData("Sheet1", 1, 0);
	Lp.SendUsername(UserName);
	  String passWord=UtilityClass.FetchData("Sheet1", 1, 1);
	Lp.SendPassword(passWord);
	Lp.ClickOnKeepMeSignIn();
	Lp.ClickLoginButton();
	
	
	
	HomePage h=new HomePage(driver);
	h.openTasks();
	h.openReports();
	h.openUsers();
	h.ClickonLogout();
	
}
}
