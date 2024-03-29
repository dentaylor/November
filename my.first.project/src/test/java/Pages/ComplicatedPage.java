package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ComplicatedPage extends PageObject {

	@FindBy(how=How.ID, using="user_login_638670f6a552d")
	private WebElement userIdElement;

	@FindBy(how=How.XPATH, using="//input[@id='et_pb_contact_email_0']/..")
	private WebElement emailAddressElement;

	@FindBy(how=How.XPATH, using="//input[@id='et_pb_contact_name_0']/..")
	private WebElement nameElement;

	@FindBy(how=How.XPATH, using="//textarea[@id='et_pb_contact_message_0']/..")
	private WebElement messageElement;

	public ComplicatedPage(WebDriver driver) {
		super(driver);
	}

	public ComplicatedPage navigate() {
		this.driver.get("https://ultimateqa.com/complicated-page");

		return this;
	}

	public ComplicatedPage setUserName(String value) {
		new ControlExtensions.JQuery.TextBoxControlExtension(userIdElement).setValue(value);

		return this;
	}

	public String getUserName() {
		return new ControlExtensions.JQuery.TextBoxControlExtension(userIdElement).getValue();
	}

	public ComplicatedPage setEmailAddress(String value) {
		new ControlExtensions.Angular.TextBoxControlExtension(emailAddressElement).setValue(value);

		return this;
	}

	public String getEmailAddress() {
		return new ControlExtensions.Angular.TextBoxControlExtension(emailAddressElement).getValue();
	}

	public String getEmailAddressLabel() {
		return new ControlExtensions.Angular.TextBoxControlExtension(emailAddressElement).getLabel();
	}

	public ComplicatedPage enterFormDetails(String name, String email, String message) {
		new ControlExtensions.Angular.TextBoxControlExtension(nameElement).setValue(name);
		new ControlExtensions.Angular.TextBoxControlExtension(emailAddressElement).setValue(email);
		new ControlExtensions.Angular.TextAreaControlExtension(messageElement).setValue(message);	

		return this;
	}

	public String getName() {
		return new ControlExtensions.Angular.TextBoxControlExtension(nameElement).getValue();
	}

	public String getEmail() {
		return new ControlExtensions.Angular.TextBoxControlExtension(emailAddressElement).getValue();
	}

	public String getMessage() {
		return new ControlExtensions.Angular.TextAreaControlExtension(messageElement).getValue();
	}
}
