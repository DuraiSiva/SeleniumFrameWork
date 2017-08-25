package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditLeadsPage extends AbstractPage{
	
	public EditLeadsPage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input")
	WebElement companyNameInputBox;
	public EditLeadsPage changeCompanyName(){
		clearText(companyNameInputBox);
		type(companyNameInputBox,"Amazon");
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "(//div[@class='fieldgroup-body'])[1]/table/tbody/tr[1]/td[2]/input")
	WebElement updateButton;
	public ViewLeadsPage updateCompanyName(){
		click(updateButton);
		return new ViewLeadsPage();
	}

}
