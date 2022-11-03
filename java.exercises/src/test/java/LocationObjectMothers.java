
public class LocationObjectMothers {

	public static LocationObjectMother Houston() {
		return new LocationBuilder()
				.WithState(States.Texas)
				.WithCity(Cities.Houston)
				.Build();
	}
	
	public static LocationObjectMother NewOrleans() {
		return new LocationBuilder()
				.WithState(States.Louisiana)
				.WithCity(Cities.NewOrleans)
				.Build();
	}
}
