import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableRow implements ControlExtensions.TableRow{
	
	private WebElement tableRowElement;
	ArrayList<WebElement> tableCellElements = new ArrayList<WebElement>();
	
	public TableRow(WebElement tableRowElement) {
		this.tableRowElement = tableRowElement;
	}

	@Override
	public TableCell getCell(int columnIndex) {
		tableCellElements.addAll(tableRowElement.findElements(By.className("rt-td")));
		TableCell tableCell = new TableCell(tableCellElements.get(columnIndex));                      
		return tableCell;
	}
}