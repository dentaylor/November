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

	public ReactTableCell getTableCell(int s) {
		// TODO Auto-generated method stub
		return null;
	}

}
