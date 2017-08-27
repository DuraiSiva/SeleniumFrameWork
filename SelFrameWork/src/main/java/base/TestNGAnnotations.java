package base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import base.WdMethods;
import dataprovider.ExcelDataProvider;

public class TestNGAnnotations extends WdMethods{
	
	public static Properties prop;
	public String dataSheetName;
	public DesiredCapabilities dc;
	public String testCaseName;
	public String testDescription;
	public String category;
	public String authors;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		 
		prop = new Properties();
		prop.load(new FileInputStream("./src/main/resources/config.properties"));
		startResult();
		System.out.println("BeforeSuite");
			
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("Before Test");
	}
	
	@BeforeGroups
	public void beforeGroups(){
		System.out.println("Before Groups");
	}
	
	
	@DataProvider(name = "excelDataProvider")
	public Object[][] getData(){
		
		return ExcelDataProvider.excelDataProvider(dataSheetName);
	}

@BeforeMethod
	public void start() throws MalformedURLException{
		dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		dc.setVersion("59.0");
		startTestCase( testCaseName,  testDescription,  category,  authors);
		//System.out.println("Remote Run");
		if(prop.getProperty("RUN").equalsIgnoreCase("remote")){
			driver = new RemoteWebDriver(new URL(prop.getProperty("HUB")), dc);
		}
		else{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		startTestCase(testCaseName,  testDescription,  category,  authors);
		eventDriver = new EventFiringWebDriver(driver);
		//FluentWait<EventFiringWebDriver> fwait = new FluentWait<EventFiringWebDriver>(eventDriver);
		//fwait.withTimeout(16, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.ECONDS).ignoring(NoSuchElementException.class, TimeoutException.class);
		WdEvent handler = new WdMethods();
		eventDriver.register(handler);
		eventDriver.get(prop.getProperty("URL"));
		eventDriver.manage().window().maximize();
		eventDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void afterMethod(){
		closeApp();
		endResult();
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	
	@AfterGroups
	public void afterGroups(){
		System.out.println("After Groups");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
		endTestCase();
	}
	
	
}
