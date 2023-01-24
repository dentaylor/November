package TestDoubles;

public class FakeDatabaseClient implements DatabaseUtility {

	@Override
	public double execute(String sql, int parameter) {
		// code to connect to in-memory database instead
		// of the 'real' database as this will be faster and
		// will contain only data needed for the test.
		return 9999.0;
	}
}
