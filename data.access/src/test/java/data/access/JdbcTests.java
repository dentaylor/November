package data.access;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JdbcTests {
	private DatabaseUtility accessor;

	@BeforeMethod 
	public void Setup() {
		var connectionString = "jdbc:mysql://localhost/sakila?user=dtaylor&password=1234";
		this.accessor = new DatabaseUtility(connectionString);
	}

	@Test
	public void canGet10CitiesInDescAlphaOrder() {
		var expectedResult = new String[] {
				"Ziguinchor"
				,"Zhoushan"
				,"Zhezqazghan"
				,"Zeleznogorsk"
				,"Zaria"
				,"Zapopan"
				,"Zaoyang"
				,"Zanzibar"
				,"Zalantun"
				,"Yuzhou"};

		var sql = "SELECT city FROM city ORDER BY city DESC LIMIT 10;";

		var result = this.accessor.executeSingleColumn(sql);

		assertEquals(result, expectedResult, "the query should return the cities in order.");
	}

	@Test 
	public void canGetHighestPaymentAmount() {
		var expectedResult = "11.99";

		var sql = "SELECT MAX(amount) FROM PAYMENT";

		var result = this.accessor.executeSingleCell(sql);

		assertEquals(result, expectedResult, "the query should return a single cell.");
	}
	
	@Test
	public void canUseViewToGetFilmInfo() {
		var expectedResult = "Action: DARN FORRESTER; "
                + "Animation: DARES PLUTO, LAWLESS VISION, OSCAR GOLD; "
                + "Children: CIRCUS YOUTH; "
                + "Classics: DYNAMITE TARZAN; "
                + "Comedy: CONTROL ANTHEM, HATE HANDICAP, SADDLE ANTITRUST; "
                + "Documentary: ADAPTATION HOLES, PELICAN COMFORTS; "
                + "Drama: JACKET FRISCO, SCORPION APOLLO; "
                + "Family: HOMICIDE PEACH; "
                + "Games: DAZED PUNK; "
                + "Horror: ACE GOLDFINGER; "
                + "Music: PERSONAL LADYBUGS, RUNNER MADIGAN, TAXI KICK; "
                + "New: CHINATOWN GLADIATOR, JUMANJI BLADE, RUN PACIFIC; "
                + "Sci-Fi: RAGING AIRPLANE; "
                + "Travel: LEATHERNECKS DWARFS, SHAWSHANK BUBBLE";
		
		var sql = "select film_info from actor_info where actor_id = "
				+ "(select actor_id from actor where first_name = 'Bob' and last_name = 'Fawcett');";
		
		var result = this.accessor.executeSingleCell(sql);

		assertEquals(result, expectedResult, "the query should return a single cell with the film info.");
	}

	@Test
	public void canUseStoredProcToGetFilmIds() {
		var row1 = new ResultDataRow("inventory_id", "73");
		var row2 = new ResultDataRow("inventory_id", "74");		
		var row3 = new ResultDataRow("inventory_id", "75");			
		var row4 = new ResultDataRow("inventory_id", "76");

		var expectedResult = new ArrayList<DataRow>();
		expectedResult.add(row1);
		expectedResult.add(row2);
		expectedResult.add(row3);
		expectedResult.add(row4);
		
		var sql = "call film_in_stock((select film_id from film as f where f.title = 'Alien Center'), 2, @out_value)";
		
		var result = this.accessor.execute(sql);

		assertEquals(result, expectedResult, "the query should the film ids.");	
	}
}
