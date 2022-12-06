package ControlExtensions.React;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ControlExtensions.TableHeader;

public class ReactTableHeader implements TableHeader{
	private Map<Integer, String> headers;
	private WebElement parentElement;
	public ReactTableHeader(WebElement element) {
		this.parentElement = element;
		headers = new HashMap<Integer, String>();
	}

	@Override
	public Map<Integer, String> getColumnNamesByColumnIndex() {
		var elements = parentElement.findElements(By.cssSelector("[class='rt-resizable-header-content']"));
		int index = 0;
		for(var x : elements) {
			headers.put(index,x.getText());
			index++;
		}
		return headers;
	}
}

