package foundation;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
		var driverPath = "C:\\Users\\dtaylor\\Downloads\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);

		this.setDriver(new EdgeDriver());
	}
}
