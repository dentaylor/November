package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.React.ReactTableCell;

public class WebTablesPage extends PageObject {

	@FindBy(how = How.CLASS_NAME, using = "rt-table")
	private WebElement webTable;

	public WebTablesPage(WebDriver driver) {
		super(driver);
	}

	public WebTablesPage navigate() {
		this.driver.get("https://demoqa.com/webtables");
		return this;
	}

	public ControlExtensions.React.ReactTable getTable() {
		return new ControlExtensions.React.ReactTable(webTable);
	}

	public ReactTableCell getTableCell(int row, int col) {
		var tableRow = getTable().getRow(row);
		var tableCell = tableRow.getCell(col);
		return tableCell;
	}

	public String getAgeOfDepartmentEmployee(String department) {
		var row = getTable().findRow(TableColumnIndexes.Department, department);

		if(row < 1) {
			throw new RuntimeException("Department '" +department+ "' could not be found.");
		}

		var age = getTable().getRow(row).getCell(TableColumnIndexes.Age).getValue();

		return age;
	}

	public class TableColumnIndexes {
		public static final int Age = 2;
		public static final int Department = 5;
		public static final int FirstName = 0;
		public static final int LastName = 1;
	}
}
