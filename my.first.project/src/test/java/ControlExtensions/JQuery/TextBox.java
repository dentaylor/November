package ControlExtensions.JQuery;

import org.openqa.selenium.WebElement;
import ControlExtensions.ITextBox;

public class TextBox extends ControlExtensions.ControlExtension implements ITextBox {

	public TextBox(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public void setValue(String value) {
		this.mappedElement.sendKeys(value);
	}

	@Override
	public String getValue() {
		return this.mappedElement.getAttribute("value");
	}
}
