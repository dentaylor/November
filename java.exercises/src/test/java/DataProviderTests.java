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
	
	private State getState(LocationObjectMother mother) {
		return mother.State;
	}
}
