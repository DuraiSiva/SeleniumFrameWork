package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {
	
		
	public static void main(String args[]) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("firstName")).sendKeys("James");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr[1]/td[2]/div/a")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input")).clear();
		driver.findElement(By.xpath("(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input")).sendKeys("Infy");
		driver.findElement(By.className("smallSubmit")).click();
		
		String company = driver.findElement(By.xpath("//div[@class='fieldgroup']/div[2]/table/tbody/tr[1]/td[2]/span")).getText();
		System.out.println(company);
		driver.close();
		
	}
	

}
