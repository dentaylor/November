package TestDoubles;

public class MockDatabaseClient implements DatabaseUtility {
	@Override
	public double execute(String sql, int parameter) {
		if(parameter == 0) {
			return 0;
		}
		if(parameter > 0) {
			return 1;
		}
		throw new RuntimeException("Unsupported parameter " + parameter);
	}
}
