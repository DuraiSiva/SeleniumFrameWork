package base;

import org.openqa.selenium.WebElement;

public interface WdBase {
	/**
	 * This method invokes the browser 
	 * @param browser can be chrome or firefox or ie
	 * @param Url can be http: or https: or file
	 */
	public void invokeApp(String browser, String Url);
	
	/**
	 * This method finds and locates the WebElement using the locator and its value
	 * @param locator - can be id or xpath or name or className or linkText
	 * @param using - value of the locator
	 * @return The return type is WebElement
	 */
	public WebElement locateElement(String locator, String using);
	
	/**
	 * This method types in the text which was passed as String in the input field identified by the WebELement 
	 * @param ele is the WebElement
	 * @param text is the value to be entered in the input field
	 */
	public void type(WebElement ele, String text);
	
	/**
	 * This method clears the text or value present in the input field 
	 * @param ele is the WebElement where the text should be entered
	 */
	public void clearText(WebElement ele);
	
	/**
	 * This method clicks on the WebElement like button to submit an action
	 * @param ele is the WebElement which is clickable
	 */
	public void click(WebElement ele);
	
	/**
	 * This method selects an option from the dropdown using the visible text in the dropdown
	 * @param ele is the WebElement to be selected
	 * @param text is the value of the visible text
	 */
	public void selectByVisibleText(WebElement ele, String text);
	
	/**
	 * This method selects an option from the dropdown using the index value in the dropdown 
	 * @param ele is the WebElement to be selected
	 * @param text is the value of the visible text
	 */
	public void selectByIndex(WebElement ele, int index);
	
	/**
	 * This method selects an option from the dropdown using the value in the dropdown
	 * @param ele is the WebElement to be selected
	 * @param text is the value of the visible text
	 */
	public void selectByValue(WebElement ele, String value);
	
	/**
	 * This method simply accepts an alert or popup thrown by the Web page
	 */
	public void acceptAlert(WebElement ele);
	
	/**
	 * This method simply dismisses an alert or popup thrown by the Web page
	 */
	public void dismissAlert(WebElement ele);
	
	/**
	 * This method captures the text message present on the alert
	 * @return the message captured in String format 
	 */
	public String alertText(WebElement ele);
	
	//HashSet --> random order
	//TreeSet --> ASCII order
	//LinketHashSet --> Order of insertion 
	/**
	 * This method switches to the window identified by the index
	 * @param index
	 */
	public void switchWindow(int index);
	
	/**
	 * This method switches to the Frame identified by the WebElement
	 * @param ele
	 */
	public void switchFrame(WebElement ele);
	
	/**
	 * This method compares the Actual page title with the Expected Page title 
	 * @param title is the required page title
	 * @return returns the boolean value
	 */
	public void verifyTitle(String title);
	
	/**
	 * This method gets the Attribute of the WebElement 
	 * @param ele
	 * @param attr
	 * @return
	 */
	public String getAttribute(WebElement ele, String attr );
	
	/**
	 * This method gets the text value of the WebElement 
	 * @param ele
	 * @return
	 */
	public String getText(WebElement ele);
	
	/**
	 * This mehtod compares the Actual text with the Expected text
	 * @param ele
	 * @param text
	 */
	public void verifyText(WebElement ele, String text);
	
	public void takeSnap(WebElement ele);
	
	/**
	 * This method closes the browser without logging out
	 * @param ele is the WebElement
	 */
	public void closeApp();

}
