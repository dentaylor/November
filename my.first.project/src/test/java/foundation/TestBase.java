package foundation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected WebDriver driver;
	
	public void setup() {
		var browserType = "chrome";
		var manager = DriverManagerFactory.getManager(browserType);
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
}
