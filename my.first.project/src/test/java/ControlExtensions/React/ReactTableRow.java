package ControlExtensions.React;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReactTableRow implements ControlExtensions.TableRow{
	private WebElement mappedElement;

	public ReactTableRow(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}

	@Override
	public ReactTableCell getCell(int columnIndex) {
		var cellElements = mappedElement.findElements(By.cssSelector("div[role=gridcell]"));
		var cellElement = cellElements.get(columnIndex);
		var cellElementsCount = cellElements.size();
		var isValidColumnIndex = columnIndex < cellElementsCount && columnIndex > -1;

		if(!isValidColumnIndex) {
			throw new RuntimeException(columnIndex + " is not a valid column index. Ensure that row count is less than " + columnIndex);
		}
		
		return new ReactTableCell(cellElement);
	}
}
