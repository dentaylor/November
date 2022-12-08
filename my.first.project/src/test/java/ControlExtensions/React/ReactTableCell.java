package ControlExtensions.React;

import org.openqa.selenium.WebElement;

import ControlExtensions.TableCell;

public class ReactTableCell implements TableCell {

	WebElement mappedElement;

	public ReactTableCell(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	@Override
	public String getValue() {
		return mappedElement.getText();
	}
}
