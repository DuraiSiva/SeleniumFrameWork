package test;

import org.testng.annotations.Test;

import base.TestNGAnnotations;
import base.WdMethods;

public class TC002 extends TestNGAnnotations{
	
	@Test
	public void editLead() throws InterruptedException{
		
		type(locateElement("id", "username"),"DemoSalesManager");
		type(locateElement("id", "password"),"crmsfa");
		
		clickOn(locateElement("className","decorativeSubmit"));
		clickOn(locateElement("linkText","CRM/SFA"));
		clickOn(locateElement("linkText","Leads"));
		Thread.sleep(1000);
		clickOn(locateElement("linkText","Find Leads"));
		Thread.sleep(1000);
		
		type(locateElement("xpath", "(//input[@name='firstName'])[3]"),"James");
		clickOn(locateElement("xpath","//button[text()='Find Leads']"));
		Thread.sleep(2000);
		clickOn(locateElement("xpath","(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a"));
		
		verifyTitle("View Lead | opentaps CRM");
		
		clickOn(locateElement("linkText","Edit"));
		clearText(locateElement("xpath","(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input"));
		type(locateElement("xpath","(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input"),"Infy");
		
		clickOn(locateElement("xpath", "//div[@class='fieldgroup-body']/table/tbody/tr[12]/td[2]/input"));
		//verifyText();

	}


}
