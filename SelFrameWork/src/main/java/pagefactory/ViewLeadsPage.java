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

	@FindBy(how = How.XPATH, using = "Edit")
	WebElement editButton;
	public EditLeadsPage clickEditButton(){
		click(editButton);
		return new EditLeadsPage();
	}
}
