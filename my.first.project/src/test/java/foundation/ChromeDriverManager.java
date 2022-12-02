package foundation;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	
	public String findOS() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	@Override
	public void createDriver() {
		String osType = findOS();
		
		if(osType.equals("Windows 10")) {
			var driverPath = "C:\\temp\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
		} 
		
		if(osType.equals("Mac OS X")) {
			var driverPath = "/Users/temp/chromedriver";
			System.setProperty("webdriver.chrome.driver", driverPath);
		}
		
		this.setDriver(new ChromeDriver());
	}
}
