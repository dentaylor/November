package ControlExtensions.JQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ControlExtensions.ControlExtension;

public class RadioButtonGroup extends ControlExtension {

	private By radioButtonLocator = By.cssSelector(".custom-radio");

	public RadioButtonGroup(WebElement radioButtonElement) {
		super(radioButtonElement);
	}

	public RadioButton getRadioButton(String label) {
		var locator = By.xpath(".//label[text()='" +label+ "']/..");
		WebElement element = this.mappedElement.findElement(locator);

		return new RadioButton(element);
	}

	public String getSelected() {
		var elements = this.mappedElement.findElements(radioButtonLocator);

		for(var element : elements) {
			var radioButton = new RadioButton(element);

			if(radioButton.isSelected()) {
				return radioButton.getLabel();
			}
		}

		return null;
	}
}
