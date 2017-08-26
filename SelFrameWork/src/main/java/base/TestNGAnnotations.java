package base;
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
	
	public String dataSheetName;
	@BeforeSuite
	public void beforeSuite(){
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
		
		return ExcelDataProvider.excelDataProvider("OpentapsData");
	}

	@BeforeMethod
	public void beforeMethod(){
		invokeApp("chrome",  "http://leaftaps.com/opentaps");
	}
	
	@AfterMethod
	public void afterMethod(){
		closeApp();
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
	}
	
	
}
