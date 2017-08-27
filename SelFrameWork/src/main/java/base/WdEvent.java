package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import reporter.ExtentReporter;

public abstract class WdEvent extends ExtentReporter implements WebDriverEventListener {
		
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		reportStep(("After the alert is accepted"),"");
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		reportStep(("After alert is dismissed"),"PASS");
				
	}

	@Override
	public void afterChangeValueOf(WebElement ele, WebDriver driver, CharSequence[] arg2) {
		
		reportStep((arg2 +" After value is changed"),"PASS");
		
	}

	@Override
	public void afterClickOn(WebElement ele, WebDriver driver) {
		
		reportStep(("Element has been clicked"),"PASS");
		
	}

	@Override
	public void afterFindBy(By using, WebElement ele, WebDriver driver) {
		reportStep(("The element was located by "),"PASS");
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		reportStep(("After navigate back"),"PASS");
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		reportStep(("After navigate forward"),"PASS");
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("The browser has been refreshed");
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("The browser was launched with url " + url);
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		System.out.println("Before Alert is accepted");
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		System.out.println("Before Alert is dismissed");
		
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver driver, CharSequence[] arg2) {
		
		reportStep(("Before value is changed"),"PASS");
		
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		
		reportStep(("Before the Element has been clicked"),"PASS");
		
	}

	@Override
	public void beforeFindBy(By using, WebElement ele, WebDriver driver) {
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver);
		fwait.withTimeout(16, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, TimeoutException.class);
		System.out.println("WebDriver is about to find the element");
		
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		System.out.println("Before Navigating back");
		
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		System.out.println("Before Navigating forward");
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		System.out.println("Refresh Before Navigating");
		
	}

	@Override
	public void beforeNavigateTo(String Url, WebDriver driver) {
		System.out.println("The Browser is about to launch the url "+ Url);
		
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver arg1) {
		if(throwable instanceof NoSuchElementException)
			System.out.println("The element could nnot be found" + throwable.getMessage().split("Element info:")[1]);
		else if(throwable instanceof NoSuchWindowException)
			System.out.println("The window could not be found "+ throwable.getMessage());
		else if(throwable instanceof InvalidSelectorException)
			System.out.println("The webelement locator is wrong "+throwable.getMessage());
		else if(throwable instanceof TimeoutException)
			System.out.println("The webdriver has timed out "+throwable.getMessage());	
		else if(throwable instanceof NoSuchFrameException)
			System.out.println("The Frame could not be found "+ throwable.getMessage());
		else if(throwable instanceof NoAlertPresentException)
			System.out.println("No alert is found "+throwable.getMessage());
		else if(throwable instanceof ElementNotVisibleException)
			System.out.println("The webelement is present in DOM but not visible and hence not interactable "+throwable.getMessage());	
		else if(throwable instanceof ElementNotSelectableException)
			System.out.println("The webelement is present in DOM but not selectable and hence not interactable "+throwable.getMessage());
		else if(throwable instanceof ElementNotInteractableException)
			System.out.println("The webelement is present in DOM but not in a state that can be interacted with "+throwable.getMessage());
		else if(throwable instanceof StaleElementReferenceException)
			System.out.println("The element no longer appears on the DOM of the page "+ throwable.getMessage());
			
	}

	@Override
	public EventFiringWebDriver getEventDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public abstract long takeSnap();
	
	}


