import org.testng.annotations.Test;

import Pages.WebTablesPage;
import Pages.WebTablesPage.TableColumnNames;
import foundation.TestBase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

public class EmployeeTests extends TestBase {
	private WebTablesPage page;

	@BeforeMethod
	public void startup() {
		page = new WebTablesPage(this.driver).navigate();
	}

	@Test
	public void canGetCellValue() {
		var department = "Compliance";
		var expectedAge = "45";

		var age = page.getAgeOfDepartmentEmployee(department);

		assertEquals(age, expectedAge, "ReactTable control extension should get the correct value.");
	}

	@Test
	public void canGetColumn() {
		var expected = new String[]{ "Vega", "Cantrell", "Gentry" };
		var actual = page.getRoster();

		assertEquals(actual, expected, "Column 'Last Name' should have been returned.");
	}

	@Test
	public void canGetAvgSalary() {
		double expected = 8000;
		var actual = page.avgSalary();

		assertEquals(actual, expected, "Returned value should be the average salary.");
	}
}
