
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

	public static LocationObjectMother Flagstaff() {
		return new LocationBuilder()
				.WithState(States.Arizona)
				.WithCity(Cities.Flagstaff)
				.WithFlower(Flowers.Sagauro)
				.Build();
	}

}
