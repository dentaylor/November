
public class LocationBuilder {

	private LocationObjectMother locationObjectMother;

	public LocationBuilder() {
		locationObjectMother = new LocationObjectMother();
	}
	
	public LocationBuilder WithState(State state) {
		this.locationObjectMother.State = state;
		
		return this;
	}

	public LocationBuilder WithCity(City city) {
		this.locationObjectMother.City = city;
		
		return this;
	}

	public LocationObjectMother Build() {
		return this.locationObjectMother;
	}

	public LocationBuilder WithFlower(Flower flower) {
		this.locationObjectMother.Flower = flower;
		return this;
	}
}
