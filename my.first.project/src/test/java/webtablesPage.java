import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.Angular.Table;

public class webtablesPage extends PageObject {

	@FindBy(how = How.CLASS_NAME, using = "rt-table")
	private WebElement webTable;

	public webtablesPage(WebDriver driver) {
		super(driver);
	}

	public webtablesPage navigate() {
		this.driver.get("https://demoqa.com/webtables");
		return this;
	}

	public Table getTable() {
		return new Table(webTable);
	}

}
