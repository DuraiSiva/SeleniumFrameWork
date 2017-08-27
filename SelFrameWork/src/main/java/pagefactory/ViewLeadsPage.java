package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViewLeadsPage extends AbstractPage{
	
	public ViewLeadsPage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	public ViewLeadsPage verifyPageTitle(){
		verifyTitle("View Lead | opentaps CRM");
		return this;
	}

	@FindBy(how = How.LINK_TEXT, using = "Edit")
	WebElement editButton;
	public EditLeadsPage clickEditButton(){
		clickOn(editButton);
		return new EditLeadsPage();
	}
	
	@FindBy(how = How.ID, using = "viewLead_companyName_sp")
	WebElement companyNameText;
	public ViewLeadsPage verifyPresenceOfCompanyName(String newCompanyName){
		verifyText(companyNameText, newCompanyName);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'viewLead_companyName_sp')]")
	WebElement leadIdAndCompanyName;
	public ViewLeadsPage getLeadID(){
		getTextFrom(leadIdAndCompanyName);
		return new ViewLeadsPage();
	}
	
	
	
	
}
