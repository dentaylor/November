import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AmpegTests {
	protected WebDriver driver;
	protected String baseUrl;

	@BeforeMethod
	public void beforeMethod() {
		this.baseUrl = "https://www.ampeg.com/";
		this.launchDriver();
	}

	@AfterMethod
	public void Cleanup() {
		this.quitDriver();
	}

	private void quitDriver() {
		if(this.driver == null) {
			return;
		}
		this.driver.quit();
	}

	private void launchDriver() {
		var driverPath = "C:\\Users\\dtaylor\\Downloads\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		this.driver = new ChromeDriver();		
		
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
		this.driver.navigate().to(this.baseUrl);
	}
}
