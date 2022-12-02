package ControlExtensions.Angular;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Table extends ControlExtension implements ControlExtensions.Table {

	public Table(WebElement mappedElement) {
		super(mappedElement);
	}

	@Override
	public TableRow getRow(int ordinalRow) {
		return new TableRow(
				mappedElement.findElement(By.xpath(String.format("//div[@class='rt-tr-group'][%d]", ordinalRow))));
	}
	
	public TableRow[] getRows() {
		List<TableRow> returnRows = new ArrayList<TableRow>();
		List<WebElement> foundRows = mappedElement.findElements(By.xpath("//div[@class='rt-tr-group']"));
		for(WebElement element : foundRows ) {
			returnRows.add(new TableRow(element));
		}
		return returnRows.toArray(new TableRow[0]);
	}

	@Override
	public int findRow(int columnIndex, String cellValue) {

		List<WebElement> tableBody = mappedElement
				.findElements(By.cssSelector("div.rt-td:nth-child(" + columnIndex + ")"));

		try {
			int i = 1;
			for (WebElement row : tableBody) {
				if (row.getText().equalsIgnoreCase(cellValue)) {
					return i;
				}

				i++;
			}
			throw new Exception("Element not found");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}
