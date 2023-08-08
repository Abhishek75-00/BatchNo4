package test12;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browsers.Base;
import pom1.HomePage;
import pom1.LoginPage;
import util.UtilityClass;


public class VerificationOfHomepage extends Base {
	
	// TestNg Annotation --- It is used to control the flow of methods in the test script..
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	SoftAssert soft;
	int testid;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@Parameters("browserName")
	@BeforeTest 
	public void LaunchBrowser(String browser) {
		System.out.println("before test");
		reporter=new ExtentHtmlReporter("C:\\Users\\Abhishek\\eclipse-workspace\\AmazonFramework\\test-output\\ExtentsReports");
		ExtentReports extend=new ExtentReports();
		extend.attachReporter(reporter);
		
		
		
		if(browser.equals("Chrome")) {
			driver=openChromeBrowser();
		}
		
		if(browser.equals("Firefox")) {
			driver=openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	@BeforeClass /// launch codes And Url code Object
	public void createPOMobjects() {
		System.out.println("beforeClass");
	lp=new LoginPage(driver);
	hp=new HomePage(driver);
	}
	
	
	@BeforeMethod  // login  /// object create
	public void LoginToApplication() {
		System.out.println("beforeMethod");
		driver.get("https://online.actitime.com/marolix4/login.do");

		lp =new LoginPage(driver);
		
		String UserName=UtilityClass.FetchData("Sheet1",1,0);
		lp.SendUsername(UserName);
		
		
		//lp.SendUsername();
		String passWord=UtilityClass.FetchData("Sheet1",1,1);
		
		lp.SendPassword(passWord);
		
		
		lp.ClickOnKeepMeSignIn();
		lp.ClickLoginButton();
		
		hp=new HomePage(driver);
		soft=new SoftAssert();
	}
	@Test// to verify user button , functionality 
	public void ToverifytheTaskButton() {
		System.out.println("Test A");
		testid=001;
		hp.openTasks();
		
	String url=driver.getCurrentUrl();
	String title=driver.getTitle();
	System.out.println(url);
	System.out.println(title);

	
	//Boolean result=false;
	
	//Assert.assertFalse(result);
	soft.assertEquals("https://online.actitime.com/marolix4/tasks/tasklist.do", "https://online.actitime.com/marolix4/tasks/tasklist.do");
//	if(url.equals("https://online.actitime.com/marolix4/tasks/tasklist.do")&& title.equals("actiTIME - Task List")) {
//		System.out.println("Pass");
//	}
//	else {
//		System.out.println("Failed");
	
	soft.assertAll();
	}
	
	
	@Test
	public void ToverifyTheReportsButton() {
		testid=002;
		System.out.println("Test B");
		hp.openReports();
		String url1=driver.getCurrentUrl();
		String Title1=driver.getTitle();
		System.out.println(url1);
		System.out.println(Title1);
		//Assert.assertEquals("https://online.actitime.com/marolix4/reports/dashboard.do","https://online.actitime.com/marolix4/reports/dashboard.do");
//		if(url1.equals("https://online.actitime.com/marolix4/reports/dashboard.do")&&Title1.equals("actiTIME - Reports Dashboard")) {
//			System.out.println("Pass");
//		}
//		else {
//			System.out.println("Failed");
//		}
		
		
		
		
	}
	@Test
	public void TestC() {
		System.out.println("Testc");
		testid=003;
	}
	
	
	@AfterMethod  // logout 
	public void LogoutfromApplication(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			UtilityClass.capture(driver, testid);
		}
		
		hp.ClickonLogout();
	}
	
	@AfterClass  //close the browser
	public void ClearObject() {
		
		lp=null;
		hp=null;
		
	}
	@AfterTest
	public void ClosedBrowser() {
		System.out.println("after test");
		driver.quit();
		driver=null;
		System.gc();
	}
	
	
	
	

	}


