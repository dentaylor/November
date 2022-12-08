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
		return new ReactTableRow(getRowElements().get(ordinalRow - 1));
	}

	public ReactTableRow[] getRows() {
		var rowElements = getRowElements();

		List<ReactTableRow> returnRows = new ArrayList<ReactTableRow>();

		for (WebElement element : rowElements) {
			returnRows.add(new ReactTableRow(element));
		}
		return returnRows.toArray(new ReactTableRow[0]);
	}

	private List<WebElement> getRowElements() {
		var tableBody = mappedElement.findElement(By.cssSelector(".rt-tbody"));
		var rowElements = tableBody.findElements(By.cssSelector("div[role=row]"));

		return rowElements;
	}

	@Override
	public int findRow(int columnIndex, String cellValue) {
		var rowElements = getRowElements();
		var rowElementsCount = rowElements.size();

		for(var row = 0; row < rowElementsCount; row++) {
			
			var tableRow = new ReactTableRow(rowElements.get(row));
			var tableCell = tableRow.getCell(columnIndex);
			
			var textToMatch = tableCell.getValue();
			if (textToMatch.equalsIgnoreCase(cellValue)) {
				return row + 1;
			}
		}
		return 0;
	}

	@Override
	public int findRow(String columnName, String cellValue) {
		var columnIndex = 0;
		var headers = new ReactTableHeader(mappedElement).getColumnNamesByColumnIndex();

		for (var header : headers.entrySet()) {
			if (header.getValue().equals(columnName)) {
				columnIndex = header.getKey();
			}
		}
		return findRow(columnIndex, cellValue);
	}
}
