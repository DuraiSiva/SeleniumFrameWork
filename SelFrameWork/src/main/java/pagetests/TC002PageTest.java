package pagetests;

import org.testng.annotations.Test;

import base.TestNGAnnotations;
import pagefactory.LoginPage;

public class TC002PageTest extends TestNGAnnotations {
	
	@Test
	public void editLead(){

		new LoginPage().
		typeUserID().
		typePwd().
		clickLogin().
		CRMSFAPage().
		cilckLeads().
		cilckFindLeads().
		typeFirstName().
		clickFindLeads().
		clickFirstLead().
		verifyPageTitle().
		clickEditButton().
		changeCompanyName().
		updateCompanyName();
	}

}
