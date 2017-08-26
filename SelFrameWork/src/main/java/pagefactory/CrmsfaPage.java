package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CrmsfaPage extends AbstractPage{
	public CrmsfaPage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "CRM/SFA")
		WebElement crmsfaLink;
	public MyHomePage CRMSFAPage(){
		clickOn(crmsfaLink);
		return new MyHomePage();
	}
	
}
