import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WebTablesPage extends PageObject{
	
	@FindBy(how=How.XPATH, using="//DIV[@class='rt-tr-group'][2]")
	private WebElement tableRowElement;
	
	private String URL = "https://demoqa.com/webtables";
	
	public WebTablesPage(WebDriver driver) {
		super(driver);
	}
	
	public TableCell getCell(int columnIndex) {
		this.driver.navigate().to(URL);
		return new TableRow(tableRowElement).getCell(columnIndex);
		
	}
}
