import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import foundation.TestBase;

public class WebTableTests extends TestBase {

	webtablesPage page;

	@BeforeMethod
	public void Startup() {
		page = new webtablesPage(this.driver).navigate();
	}

	@Test
	public void canFindRow() {

		var expectedState = 2;

		var table = page.getTable();

		var actualState = table.findRow(2, "Cantrell");

		assertEquals(actualState, expectedState);

	}

	@Test
	public void canGetRow() {

		var expectedState = page.getTable().getRows()[1].getElement().getText();

		var actualState = page.getTable().getRow(2).getElement().getText();

		assertEquals(actualState, expectedState, "getRow should return the second row");
	}
}
