package ControlExtensions.React;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReactTable extends ControlExtensions.ControlExtension implements ControlExtensions.Table {

	public ReactTable(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public ReactTableRow getRow(int ordinalRow) {
		return new ReactTableRow(
				mappedElement.findElement(By.xpath(String.format("//div[@class='rt-tr-group'][%d]", ordinalRow))));
	}

	public ReactTableRow[] getRows() {
		var rowElements = getRowElements();
		
		List<ReactTableRow> returnRows = new ArrayList<ReactTableRow>();
		
		for (WebElement element : rowElements) {
			returnRows.add(new ReactTableRow(element));
		}
		return returnRows.toArray(new ReactTableRow[0]);
	}
	
	public List<WebElement> getRowElements() {
		var tableBody = mappedElement.findElement(By.cssSelector(".rt-tbody"));
		var rowElements = tableBody.findElements(By.cssSelector("div[role=row]"));
		
		return rowElements;
	}

	@Override
	public int findRow(int columnIndex, String cellValue) {
		var rowElements = getRowElements();
		var rowElementsCount = rowElements.size();

		for(var row = 0; row < rowElementsCount; row++) {
			var rowElement = rowElements.get(row);
			var cellElements = rowElement.findElements(By.cssSelector("div[role=gridcell]"));
			var cellElementsCount = cellElements.size();
			var isValidColumnIndex = columnIndex < cellElementsCount && columnIndex > -1;

			if(!isValidColumnIndex) {
				throw new RuntimeException(columnIndex + " is not a valid column index. Ensure that row count is less than " + columnIndex);
			}

			var cellElement = cellElements.get(columnIndex);
			var textToMatch = cellElement.getText();

			if (textToMatch.equalsIgnoreCase(cellValue)) {
				return row + 1;
			}
		}
		return 0;
	}

	@Override
	public int findRow(String columnName, String cellValue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
