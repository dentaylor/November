package data.access;

public class SakilaQueries {

	private DatabaseAccessor accessor;

	public SakilaQueries(DatabaseAccessor databaseUtility) {
		this.accessor = databaseUtility;
	}

	public String[] get10CitiesInDescAlphaOrder() {
		var sql = "SELECT city FROM city ORDER BY city DESC LIMIT 10";
		
		return this.accessor.executeSingleColumn(sql);
	}

	public String getHighestPaymentAmount() {
		var sql = "SELECT MAX(amount) FROM PAYMENT";

		return this.accessor.executeSingleCell(sql);
	}

	public String getFilmInfo() {
		var sql = "select film_info from actor_info where actor_id = "
				+ "(select actor_id from actor where first_name = 'Bob' and last_name = 'Fawcett');";
		
		
		return this.accessor.executeSingleCell(sql);
	}

	public DataRow[] getFilmIds() {
		var sql = "call film_in_stock((select film_id from film as f where f.title = 'Alien Center'), 2, @out_value)";
		
		return this.accessor.execute(sql);
	}
}
