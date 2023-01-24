import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
	protected WebDriver driver;
	protected String baseUrl;
	private String url;
	
	protected PageObject(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		
		PageFactory.initElements(driver, this);
	}

	protected void navigateDirectUrl() {
		var fullUrl = this.baseUrl + getUrl();

		this.driver.navigate().to(fullUrl);
	}

	protected String getUrl() {
		return url;
	}

	protected void setUrl(String url) {
		this.url = url;
	}
}
