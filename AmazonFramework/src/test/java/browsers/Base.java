package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {

	public static WebDriver openChromeBrowser() {
	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\browsers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\browsers\\geckodriver.exe");	
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openOperaMiniBrowser() {
		System.setProperty("webdriver.opera.driver", "D:\\abhi\\operadriver_win64\\operadriver_win64\\operadriver.exe");
	WebDriver driver=new OperaDriver();
	return driver;
	}
	
	public static WebDriver openMicrosoftedge() {
		System.setProperty("webdriver.micro.driver", "path for micro edge");
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	
	
	
	
}
