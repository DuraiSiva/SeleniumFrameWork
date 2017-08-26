package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FindLeadPage extends AbstractPage{
	public FindLeadPage(){
		PageFactory.initElements(eventDriver, this);
		}
	
		@FindBy(how = How.XPATH, using = "(//input[@name='firstName'])[3]")
		WebElement firstNameInputBox;
		public FindLeadPage typeFirstName(String firstName){
			type(firstNameInputBox, firstName);
			return this;
		}
		
		@FindBy(how = How.XPATH, using = "//button[text()='Find Leads']")
		WebElement findLeadsButton;
		public FindLeadPage clickFindLeads(){
			clickOn(findLeadsButton);
			return this;
		}
		
		@FindBy(how = How.XPATH, using = "(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")
		WebElement firstLead;
		public ViewLeadsPage clickFirstLead(){
			clickOn(firstLead);
			return new ViewLeadsPage();
		}
		

}

