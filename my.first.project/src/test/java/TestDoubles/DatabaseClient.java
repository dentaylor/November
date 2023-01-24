package TestDoubles;

public class DatabaseClient implements DatabaseUtility {
	@Override
	public double execute(String sql, int parameter) {
		// Code to connect to connect to database and execute query
		// Omitted for brevity.
		return 999.0;
	}
}
