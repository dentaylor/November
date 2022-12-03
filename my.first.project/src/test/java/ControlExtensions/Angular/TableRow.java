package ControlExtensions.Angular;

import org.openqa.selenium.WebElement;

import ControlExtensions.TableCell;

public class TableRow extends ControlExtension implements ControlExtensions.TableRow {

	public TableRow(WebElement findElement) {
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
