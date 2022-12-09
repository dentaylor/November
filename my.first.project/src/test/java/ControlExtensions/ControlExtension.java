package ControlExtensions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public abstract class ControlExtension {

	protected WebElement mappedElement;

	protected ControlExtension(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	protected Object executeJavascript(String script, Object arguments) {
		var driver= ((WrapsDriver)this.mappedElement).getWrappedDriver();

		var js = (JavascriptExecutor) driver;  
		return js.executeScript(script, arguments);		
	}
	
	protected void executeJavascriptOnElement(String script, WebElement element) {
		var fullScript = "arguments[0]" + script;

		var driver= ((WrapsDriver)element).getWrappedDriver();

		var js = (JavascriptExecutor) driver;  
		js.executeScript(fullScript, element);		
	}
}
