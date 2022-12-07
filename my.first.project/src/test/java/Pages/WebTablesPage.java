package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.React.*;

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

	public ReactTable getTable() {
		return new ReactTable(webTable);
	}

	public ReactTableCell getTableCell(int s) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAgeOfDepartmentEmployee(String department) {
		var searchColumn = TableColumnNames.Department;
		var findColumn = TableColumnNames.Age;
		var row = getTable().findRow(searchColumn, department);

		if (row < 1) {
			throw new RuntimeException("Department '" + department + "' could not be found.");
		}

		var toReturn = getTable().getRow(row).getCell(findColumn).getValue();

		return toReturn;
	}
	
	public String[] getRoster() {
		return getColumnValues(TableColumnNames.LastName);
	}

	public double avgSalary() {
		var salaries = getColumnValues(TableColumnNames.Salary);
		double toReturn = 0;
		int i = 0;

		for (String salary : salaries) {
			if (salary.isBlank()) {
				break;
			}
			toReturn += Double.parseDouble(salary);
			i++;
		}
		toReturn = toReturn / i;

		return toReturn;
	}

	private String[] getColumnValues(int columnIndex) {
		var table = getTable().getRows();
		List<String> toReturn = new ArrayList<String>();

		for (ReactTableRow row : table) {
			toReturn.add(row.getCell(columnIndex).getValue());
		}

		return toReturn.toArray(new String[0]);
	}
	
	public class TableColumnNames {
		public static final int FirstName = 0;
		public static final int LastName = 1;
		public static final int Age = 2;
		public static final int Email = 3;
		public static final int Salary = 4;
		public static final int Department = 5;
	}
}
