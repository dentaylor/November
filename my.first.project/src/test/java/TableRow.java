import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ControlExtensions.React.ReactTableCell;

public class TableRow implements ControlExtensions.TableRow{
	
	private WebElement tableRowElement;
	ArrayList<WebElement> tableCellElements = new ArrayList<WebElement>();
	
	public TableRow(WebElement tableRowElement) {
		this.tableRowElement = tableRowElement;
	}

	@Override
	public ReactTableCell getCell(int columnIndex) {
		tableCellElements.addAll(tableRowElement.findElements(By.className("rt-td")));
		ReactTableCell tableCell = new ReactTableCell(tableCellElements.get(columnIndex));                      
		return tableCell;
	}
}