import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.testng.annotations.Test;

import ControlExtensions.React.ReactTableCell;
import Pages.WebTablesPage;
import foundation.TestBase;

public class TableCellTests extends TestBase {

	private static final Class<IllegalStateException> ISE = IllegalStateException.class;

	@Test
	public void canGetFrontTableCellBoundary() {
		var expectedValue = "Cierra";

		var tableCell = new WebTablesPage(this.driver)
				.navigate()
				.getTableCell(0);

		var tableCellControlExtension = new ReactTableCell(tableCell.unWrap());

		var actualValue = tableCellControlExtension.getValue();

		assertEquals(actualValue, expectedValue, "the first cell value should be got using a Control Extension.");
	}

	@Test
	public void canGetSecondTableCellValue() {
		var expectedValue = "Vega";

		var tableCell = new WebTablesPage(this.driver)
				.navigate()
				.getTableCell(1);
		var tableCellControlExtension = new ReactTableCell(tableCell.unWrap());

		var actualValue = tableCellControlExtension.getValue();

		assertEquals(actualValue, expectedValue, "the second cell value should be got using a Control Extension.");
	}

	@Test
	public void canHandleBiggerThanIndex() {
		var page = new WebTablesPage(this.driver)
				.navigate();

		assertThrows(ISE, () -> page.getTableCell(999));
	}

	@Test
	public void canHandleNegativeIndex() {
		var page = new WebTablesPage(this.driver)
				.navigate();

		assertThrows(ISE, () -> page.getTableCell(-1));

	}

	@Test
	public void canHandleShortIndex() {
		var expectedValue = "Vega";

		var tableCell = new WebTablesPage(this.driver)
				.navigate()
				.getTableCell((short)1);

		var tableCellControlExtension = new ReactTableCell(tableCell.unWrap());

		var actualValue = tableCellControlExtension.getValue();

		assertEquals(actualValue, expectedValue, "the cell value should be got using a short index");

	}
}
