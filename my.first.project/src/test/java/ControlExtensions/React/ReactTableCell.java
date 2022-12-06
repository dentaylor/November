package ControlExtensions.React;

import org.openqa.selenium.WebElement;

public class ReactTableCell implements ControlExtensions.TableCell{

	private WebElement tableCellElement;
	
	public ReactTableCell(WebElement tableCellElement) {
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
