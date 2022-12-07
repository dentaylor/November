import org.testng.annotations.Test;

import ControlExtensions.React.ReactTableHeader;
import foundation.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;

public class TableHeaderTests extends TestBase {
	private WebElement element;

	@Test
	public void canGetHeaders() {

		Map<Integer, String> expectedMap = new HashMap<Integer, String>();
		expectedMap.put(0, "First Name");
		expectedMap.put(1, "Last Name");
		expectedMap.put(2, "Age");
		expectedMap.put(3, "Email");
		expectedMap.put(4, "Salary");
		expectedMap.put(5, "Department");
		expectedMap.put(6, "Action");

		Map<Integer, String> actualMap = new ControlExtensions.React.ReactTableHeader(element).getColumnNamesByColumnIndex();

		assertTrue(expectedMap.equals(actualMap));
	}

	@Test
	public void confirmHeaderOrder() {

		var expectedColumnName = "Salary";

		Map<Integer, String> headers = new ReactTableHeader(element).getColumnNamesByColumnIndex();

		assertEquals(headers.get(4), expectedColumnName);	
	}
	
	

	@BeforeMethod
	public void BeforeMethod() {
		//setup();
		driver.navigate().to("https://demoqa.com/webtables");
		element = driver.findElement(By.cssSelector("[class='rt-table']"));
	}

}