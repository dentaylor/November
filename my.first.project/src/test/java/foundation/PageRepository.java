package foundation;

import org.openqa.selenium.WebDriver;

import Pages.RadioButtonPage;

public class PageRepository {

	private WebDriver driver;

	public PageRepository(WebDriver driver) {
		this.driver = driver;
	}

	public RadioButtonPage radioButtonPage() {
		this.driver.navigate().to("https://demoqa.com/radio-button");

		return new RadioButtonPage(this.driver);
	}
}
