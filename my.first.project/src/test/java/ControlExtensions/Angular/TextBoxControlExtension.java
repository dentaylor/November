package ControlExtensions.Angular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ControlExtensions.ControlExtension;
import ControlExtensions.TextBox;

public class TextBoxControlExtension extends ControlExtension implements TextBox {

	public TextBoxControlExtension(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setValue(String value) {
		getInputElement().sendKeys(value);
	}

	@Override
	public String getValue() {
		return getInputElement().getAttribute("value");
	}

	public String getLabel() {
		return getLabelElement().getAttribute("textContent");
	}

	private WebElement getInputElement() {
		return this.mappedElement.findElement(By.tagName("input"));
	}

	private WebElement getLabelElement() {
		return this.mappedElement.findElement(By.tagName("label"));
	}
}
