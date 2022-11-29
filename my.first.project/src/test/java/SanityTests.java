import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import foundation.DriverManagerFactory;
import foundation.TestBase;

public class SanityTests extends TestBase {
	@Test
	public void canRunTestNgTest() {
		// If this doesn't pass then nothing will
	}

	@Test
	public void canUseVar() {
		String myString = "Taylo  rDennis";
		var myVarString = "Dennis";			  
	}
	
	@Test
	public void canLaunchEdgeDriver() {
		var browserType = "edge";
		
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = this.manager.getDriver();
		
		assertTrue(this.driver != null, "the driver should be launched");
	}
	
	@Test
	public void canLaunchChromeDriver() {
		var browserType = "chrome";
		
		this.manager = DriverManagerFactory.getManager(browserType);
		this.manager.createDriver();
		this.driver = this.manager.getDriver();
		
		assertTrue(this.driver != null, "the driver should be launched");
	}
}
