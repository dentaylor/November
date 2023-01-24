package ControlExtensions.JQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ControlExtensions.ControlExtension;

public class RadioButton extends ControlExtension {

	public RadioButton(WebElement mappedElement) {
		super(mappedElement);
	}

	public void select() {
		var inputElement = getInputElement();

		executeJavascriptOnElement(".click();", inputElement);
	}

	public boolean isSelected() {
		return getInputElement().isSelected();
	}

	public String getLabel() {
		return getLabelElement().getText();
	}

	private WebElement getLabelElement() {
		return this.mappedElement.findElement(By.tagName("label"));
	}

	private WebElement getInputElement() {
		return this.mappedElement.findElement(By.tagName("input"));
	}
}
