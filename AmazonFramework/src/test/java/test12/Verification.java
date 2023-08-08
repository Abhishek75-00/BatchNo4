package test12;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.HomePage;
import pom1.LoginPage;
import util.UtilityClass;

public class Verification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoginPage lp;
		HomePage h;
		
		System.setProperty("webdriver.chrome.driver","D:\\abhi\\chromedriver_win32 (7)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//TestCase 1 - Task page
		driver.get("https://online.actitime.com/marolix4/login.do");
		 lp=new LoginPage(driver);
		 String UserName=UtilityClass.FetchData("Sheet1", 1, 0);
		lp.SendUsername(UserName);
		 String passWord=UtilityClass.FetchData("Sheet1", 1, 1);
		lp.SendPassword(passWord);
		lp.ClickOnKeepMeSignIn();
		lp.ClickLoginButton();
		
		 h=new HomePage(driver);
		 h.openTasks();
		
		String url=driver.getCurrentUrl();
		String Title=driver.getTitle();
		System.out.println(url);
		System.out.println(Title);
		
		if(url.equals("https://online.actitime.com/marolix4/tasks/tasklist.do")&& Title.equals("actiTIME - Task List")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		
		h.ClickonLogout();
		
		
		// test case 2 -- Report Page
		driver.get("https://online.actitime.com/marolix4/login.do");
		 lp=new LoginPage(driver);
		 String UserName1=UtilityClass.FetchData("Sheet1", 1, 0);
		lp.SendUsername(UserName1);
		 String passWord1=UtilityClass.FetchData("Sheet1", 1, 1);
		lp.SendPassword(passWord1);
		lp.ClickOnKeepMeSignIn();
		lp.ClickLoginButton();
		
		 h=new HomePage(driver);
		 h.openReports();
		 
		 String url1=driver.getCurrentUrl();
		 String title1=driver.getTitle();
		 System.out.println(url1);
		 System.out.println(title1);
		 if(url1.equals("https://online.actitime.com/marolix4/reports/dashboard.do")&& title1.equals("actiTIME - Reports Dashboard")) {
			 System.out.println("Pass");
			 
		 }
		 else {
			 System.out.println("Failed");
		 }
		 
		 h.ClickonLogout();
	}

}
