import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelTests extends AmpegTests {

	@DataProvider (name = "provideIteration")
	public Object [] provideIteration ()
	{
		var numberOfTimesToRunEachTest = 5;
		var data = new Object [numberOfTimesToRunEachTest];
		var i = 0;
		
		while(i < numberOfTimesToRunEachTest) {
			data[i] = i++;
		}
		
		return data;
	}

	@Test (dataProvider = "provideIteration")
	public void one(int dummy) {
		var expectedUrl = "https://ampeg.com/products/classic/";

		var url = new HomePage(this.driver.get(), baseUrl)
				.clickProductsLink()
				.clickClassicBassHeadsAndEnclosuresLink()
				.driver.getCurrentUrl();

		Assert.assertEquals(url, expectedUrl);	
	}

	@Test (dataProvider = "provideIteration")
	public void two(int dummy) {
		var expectedUrl = "https://ampeg.com/products/";

		var url = new HomePage(this.driver.get(), baseUrl)
				.clickProductsLink()
				.driver.getCurrentUrl();

		Assert.assertEquals(url, expectedUrl);	
	}
}
