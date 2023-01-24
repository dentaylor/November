package ControlExtensions.JQuery;

import org.openqa.selenium.WebElement;
import ControlExtensions.TextBox;

public class TextBoxControlExtension extends ControlExtensions.ControlExtension implements TextBox {

	public TextBoxControlExtension(WebElement mappedElement) {
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
