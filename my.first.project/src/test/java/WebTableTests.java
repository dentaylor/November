import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.WebTablesPage;
import foundation.TestBase;

public class WebTableTests extends TestBase {

	WebTablesPage page;

	@BeforeMethod
	public void startup() {
		page = new WebTablesPage(this.driver).navigate();
	}

	@Test
	public void canFindRow() {
		int columnIndex = 1;
		var cellValue = "Cantrell";
		var expectedRowNumber = 2;

		var rowNumber = page.getTable().findRow(columnIndex, cellValue);

		assertEquals(rowNumber, expectedRowNumber, "row number should be found.");
	}

	@Test
	public void canGetRow() {
		
		var table = page.getTable();
		var expectedRow = table.getRows()[0].getCell(0).getValue();

		var row = table.getRow(1).getCell(0).getValue();

		assertNotNull(row, "getValue should return a value.");
		assertEquals(row, expectedRow, "getRow should return the second row");
	}
	
	@Test
	public void returnsZeroWhenRowNotFound() {
		var rowNotFoundRowNumber = 0;
		
		var row = page.getTable().findRow(WebTablesPage.TableColumnIndexes.FirstName, "dummy");

		assertEquals(row, rowNotFoundRowNumber, "findRow should return zero.");
	}
}
