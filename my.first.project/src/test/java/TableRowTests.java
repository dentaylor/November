import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.WebTablesPage;
import foundation.TestBase;

public class TableRowTests extends TestBase{
	
	private String URL = "https://demoqa.com/webtables";
	private static final Class<IndexOutOfBoundsException> IOBE = IndexOutOfBoundsException.class;
	
	@BeforeMethod
	public void navigateDirect() {
		this.driver.navigate().to(URL);
	}
	
	
  @Test
  public void canGetSecondCell() {	  
	  var expectedCell = this.driver.findElement(By.xpath("//DIV[@class='rt-td'][.='Cantrell']")).getText();
		  
	  var actualCell = new WebTablesPage(this.driver)
			  .getTableCell(2,1)
			  .getValue();
	  
	  assertEquals(actualCell, expectedCell, "This should return the second web element");
  }
  
  
  @Test
  public void outOfBoundsTestForColumnLength() {
	  assertThrows(IOBE, () -> new WebTablesPage(this.driver).getTableCell(1,10));
	  assertThrows(IOBE, () -> new WebTablesPage(this.driver).getTableCell(1,'a'));
	  assertThrows(IOBE, () -> new WebTablesPage(this.driver).getTableCell(1,-5)); 
  }
  
  @Test
  public void canUseShortColumnIndexToGetCell() {
	  short val = 2;
	  var expectedCell = this.driver.findElement(By.xpath("//DIV[@class='rt-td'][.='45']")).getText();
	  
	  var actualCell = new WebTablesPage(this.driver).getTableCell(val,val).getValue();
	  
	  assertEquals(actualCell, expectedCell, "This should return the third element");
	  
  }
  
  @Test
  public void canGetLowestCell() {
	  var expectedCell = this.driver.findElement(By.xpath("//DIV[@class='rt-td'][.='Alden']")).getText();
	  
	  var actualCell = new WebTablesPage(this.driver).getTableCell(2,0).getValue();
	  
	  assertEquals(actualCell, expectedCell, "This should return the first element");
  }
}
