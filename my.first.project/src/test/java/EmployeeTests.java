import org.testng.annotations.Test;

import Pages.WebTablesPage;
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

		var age = page.getAgeOfDepartmentEmployee(department );

		assertEquals(age, expectedAge, "ReactTable control extension should get the correct value.");
	}
}
