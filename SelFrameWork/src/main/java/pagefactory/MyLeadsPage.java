package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyLeadsPage extends AbstractPage{
	public MyLeadsPage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Find Leads")
	WebElement findLeadsLink;
	public FindLeadPage cilckFindLeads(){
		click(findLeadsLink);
		return new FindLeadPage();
	}
}
