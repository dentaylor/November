import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebTablesPage extends PageObject {
	
	@FindBy(how = How.CLASS_NAME, using = "rt-td")
	private List<WebElement> tableCellList;
	
	public WebTablesPage(WebDriver driver) {
		super(driver);
	}
	
	public WebTablesPage navigate() {
		this.driver.get("https://demoqa.com/webtables");

		return this;
	}
	
	public List<WebElement> getTableCells() {
		return this.tableCellList;
	}
	
	public WebElement getTableCell(int index) {
		if (index >= tableCellList.size() || index < 0)
			throw new IllegalStateException("Index is out of bounds.");
		// throw an out of bounds exception
		return this.tableCellList.get(index);
	}
}
