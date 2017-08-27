package base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WdMethods extends WdEvent implements WdBase {
	
	public WebElement ele;
	public WebDriver driver;
	public static EventFiringWebDriver eventDriver;
	
	/*public void invokeApp(String browser, String Url){
		
		switch(browser){
		case("chrome"):
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			eventDriver = new EventFiringWebDriver(driver);
			WdEvent handler = new WdEvent();
			eventDriver.register(handler);
			eventDriver.get(Url);
			eventDriver.manage().window().maximize();
			eventDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			break;
			
		case("firefox"):
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			eventDriver.get(Url);
		}	
	}*/
		
	public WebElement locateElement(String locator, String using){
		ele=null;
		switch(locator){
		case ("id"):
			ele = eventDriver.findElement(By.id(using));
			break;
		case ("name"):
			ele = eventDriver.findElement(By.name(using));
			break;
		case ("className"):
			ele = eventDriver.findElement(By.className(using));
			break;
		case ("linkText"):
			ele = eventDriver.findElement(By.linkText(using));
			break;
		case ("partialLinkText"):
			ele = eventDriver.findElement(By.partialLinkText(using));
			break;
		case ("xpath"):
			ele = eventDriver.findElement(By.xpath(using));
			break;
		case ("type"):
			ele = eventDriver.findElement(By.xpath("//[@type='"+using+"']"));
			break;
		case ("ng-reflect-name"):
			ele = eventDriver.findElement(By.xpath("//[@ng-reflect-name='"+using+"']"));
			break;
			
		}
		return ele;
	}
	
	public void type(WebElement ele, String text){
		ele.sendKeys(text);
		
	}
	
	public void clearText(WebElement ele){
		ele.clear();
	}
	
	public void clickOn(WebElement ele){
		
		ele.click();
		
	}
	
	public void selectByVisibleText(WebElement ele, String text){
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(text);
		
	}
	
	public void selectByIndex(WebElement ele, int index){
		Select dropdown = new Select(ele);
		dropdown.selectByIndex(index);
	}
	
	public void selectByValue(WebElement ele, String value){
		Select dropdown = new Select(ele);
		dropdown.selectByValue(value);
	}
	
	public void acceptAlert(WebElement ele){
		eventDriver.switchTo().alert().accept();
		
	}
	
	public void dismissAlert(WebElement ele){
		eventDriver.switchTo().alert().dismiss();
	}
	
	public String alertText(WebElement ele){
		String text = null;
		eventDriver.switchTo().alert().getText();
		return text;
	}
	
	//HashSet --> random order
	//TreeSet --> ASCII order
	//LinketHashSet --> Order of insertion 
	
	public void switchWindow(int index){
		Set<String> allWindowHandles = eventDriver.getWindowHandles();
		List<String> allWindows = new ArrayList<String>();
		allWindows.addAll(allWindowHandles);
		if(index>=allWindows.size()){
			System.out.println("Entered window size is greater than number of active window.");
			throw new RuntimeException();
		}
		eventDriver.switchTo().window(allWindows.get(index));
	}
	
	public void switchFrame(WebElement ele){
		eventDriver.switchTo().frame(ele);
	}
	
	public void verifyTitle(String title){
		//boolean isTitle = false;
		if(eventDriver.getTitle().equals(title)){
			System.out.println( "Title is correct");
		}
		else
			System.out.println( "Title is incorrect");
	}
	
	public String getAttribute(WebElement ele, String attr ){
		String attribute = null;
		attribute = ele.getAttribute(attr);
		return attribute;
	}
	
	public String getTextFrom(WebElement ele){
		String text = null;
		//s1.replaceAll("[^a-zA-Z0-9 ]", "")
		text = ele.getText().replaceAll("[^a-zA-Z ]", "");
		System.out.println(text);
		return text;
	}
	
	public void verifyText(WebElement ele, String text){
		//boolean isText = false;
			System.out.println(ele.getText());
			if((ele.getText().contains(text))){
				System.out.println( "Company name has been updated");
			}	
			
			else
				System.out.println("Company name not updated");
		
	}
	
	public void takeSnap(WebElement ele){
		
	}
	
	public void closeApp(){
		eventDriver.close();
		
	}
	
	public long takeSnap(){
		
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		File src = eventDriver.getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(src, new File("./reports/snaps/snap"+number+".jpg")); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
		return number;
	}

	

}
