import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderTests {
	@Test
	public void canGetStateName() {
		var expectedState = "Texas";

		var actualState = States.Texas.Name;

		Assert.assertEquals(actualState, expectedState, "the state name should be returned.");
	}

	@Test
	public void canGetStateAbbreviation() {
		var expectedState = "TX";

		var actualState = States.Texas.Abbreviation;

		Assert.assertEquals(actualState, expectedState, "the state name should be returned.");
	}

	@Test
	public void canGetCity() {
		var expectedCity = "Houston";

		var actualCity = Cities.Houston.Name;

		Assert.assertEquals(expectedCity, actualCity, "the city name should be returned.");	
	}

	@Test
	public void canGetStateFromObjectMother() {
		var expectedState = "Louisiana";

		var actualState = getState(LocationObjectMothers.NewOrleans());

		Assert.assertEquals(actualState.Name, expectedState, "the state name should be returned.");	
	}

	@Test
	public void canGetCityFromObjectMother() {
		var expectedCity = "Houston";

		var actualCity = LocationObjectMothers.Houston().City.Name;

		Assert.assertEquals(actualCity, expectedCity, "the city name should be returned.");	
	}

	@Test
	public void canGetStateFlowerFromObjectMother() {
		var expectedFlower = "Sagauro";

		var actualFlower = LocationObjectMothers.Flagstaff().Flower.Name;

		Assert.assertEquals(actualFlower, expectedFlower, "the state flower should be returned.");	
	}

	private State getState(LocationObjectMother mother) {
		return mother.State;
	}
}
