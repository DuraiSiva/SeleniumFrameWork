package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
	public LoginPage(){
		PageFactory.initElements(eventDriver, this);
	}
	
	@FindBy(how = How.ID, using = "username")
		WebElement uName;
	
	public LoginPage typeUserID(){
		type(uName, "DemoSalesManager");
		return this;
	}
	
	
	/*@FindBys({
		@FindBy(how = How.ID, using = "password"),
		@FindBy(how = How.NAME, using = "PASSWORD" )
			})*/
	@FindBy(how = How.ID, using = "password")
		WebElement pwd;
	public LoginPage typePwd(){
		type(pwd, "crmsfa");
		return this;
	}
	
	
	@FindAll({
		@FindBy(how = How.CLASS_NAME, using = "decorativeSubmit")
	})
	WebElement loginButtton;
	public CrmsfaPage clickLogin(){
		click(loginButtton);
		return new CrmsfaPage();
	}
		
	
}
