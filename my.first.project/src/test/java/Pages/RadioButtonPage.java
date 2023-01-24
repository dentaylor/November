package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ControlExtensions.JQuery.RadioButtonGroup;

public class RadioButtonPage extends PageObject {

	@FindBy(how=How.XPATH, using="//div[./div[text()='Do you like the site?']]")
	private WebElement radioButtonElement;

	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}

	public RadioButtonPage selectRadioButton(String label) {
		getRadioButtonGroup().getRadioButton(label).select();

		return this;
	}

	public String getSelectedRadioButtonValue() {
		return getRadioButtonGroup().getSelected();
	}

	private RadioButtonGroup getRadioButtonGroup() {
		return new RadioButtonGroup(this.radioButtonElement);
	}
}
