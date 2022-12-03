import org.openqa.selenium.WebElement;

import ControlExtensions.TableCell;

public class TableCellControlExtension implements TableCell {
	
	WebElement mappedElement;
	public TableCellControlExtension (WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	@Override
	public String getValue() {
		String value = mappedElement.getText();
		return value;
	}
}