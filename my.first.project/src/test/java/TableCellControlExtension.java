import org.openqa.selenium.WebElement;

import ControlExtensions.TableCell;

public class TableCellControlExtension implements TableCell {
	
	WebElement mappedElement;
	public TableCellControlExtension (WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	public TableCellControlExtension(Object webElement) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getValue() {
		String value = mappedElement.getText();
		return value;
	}
}