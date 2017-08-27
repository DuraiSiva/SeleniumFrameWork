package pagetests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestNGAnnotations;
import dataprovider.ExcelDataProvider;
import pagefactory.LoginPage;

public class TC002PageTest extends TestNGAnnotations {
	
	@BeforeClass
	public void setValues(){
		dataSheetName = "TC002";
		testCaseName = "Edit Lead";
		testDescription = "Edit the Lead name";
		category = "regression";
		authors = "Durai";
	}
	
	@Test(dataProvider = "excelDataProvider")
	public void verifyCompanyNameUpdated(String userName, String passWord, String firstName, String newCompanyName){

		new LoginPage().
		typeUserID(userName).
		typePwd(passWord).
		clickLogin().
		CRMSFAPage().
		cilckLeads().
		cilckFindLeads().
		typeFirstName(firstName).
		clickFindLeads().
		clickFirstLead().
		verifyPageTitle().
		clickEditButton().
		changeCompanyName(newCompanyName).
		updateCompanyName().
		verifyPresenceOfCompanyName(newCompanyName); 
		
	}
	
	

}
