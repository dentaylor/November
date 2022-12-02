import org.openqa.selenium.WebElement;

public class TableCell implements ControlExtensions.TableCell{

	private WebElement tableCellElement;
	
	public TableCell(WebElement tableCellElement) {
		this.tableCellElement = tableCellElement;
	}
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public WebElement getElement() {
		return this.tableCellElement;
	}
}
