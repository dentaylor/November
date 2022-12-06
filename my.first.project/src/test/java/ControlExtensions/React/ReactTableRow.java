package ControlExtensions.React;

import org.openqa.selenium.WebElement;

import ControlExtensions.TableCell;

public class ReactTableRow extends ControlExtensions.ControlExtension implements ControlExtensions.TableRow {

	public ReactTableRow(WebElement findElement) {
		super(findElement);
	}

	@Override
	public TableCell getCell(int index) {
		return null;
	}
	
	public WebElement getElement() {
		return this.mappedElement;
	}

}
