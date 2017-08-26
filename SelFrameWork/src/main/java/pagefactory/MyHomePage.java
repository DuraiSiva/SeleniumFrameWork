package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyHomePage extends AbstractPage {
	
	public MyHomePage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Leads")
	WebElement leadsLink;
	public MyLeadsPage cilckLeads(){
		clickOn(leadsLink);
		return new MyLeadsPage();
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Create Lead")
	WebElement createLeadLink;
	public CreateLeadPage cilckCreateLeads(){
		clickOn(createLeadLink);
		return new CreateLeadPage();
	}
	
	

}
