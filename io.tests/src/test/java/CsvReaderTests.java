import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvReaderTests {
	private final String BASSES_FILE = "basses.csv";

	@Test
	public void canReadCsvIntoHashMap() throws CsvValidationException, IOException {
		var expectedCount = 6;
		var bassModel = "BB500";
		var bassMake = "Yamaha";
		var bassMakesByModel = new HashMap<String, String>();
		CSVReader reader = null;

		reader = CsvReaderFactory.getReader(BASSES_FILE);
		String[] record = null;

		while ((record = reader.readNext()) != null) {
			String make = record[0];
			String model = record[1];
			bassMakesByModel.put(model, make);
		}

		Assert.assertEquals(bassMakesByModel.size(), expectedCount, "File contains 6 rows not including header.");
		Assert.assertEquals(bassMakesByModel.get(bassModel), bassMake, "All Object in collection should be populated.");
	}

	@Test
	public void canHydrateFromCsv() throws CsvValidationException, NumberFormatException, IOException {
		var expectedRowCount = 6;
		var basses = new ArrayList<BassGuitar>();
		CSVReader reader = null;

		String[] record = null;
		reader = CsvReaderFactory.getReader(BASSES_FILE);

		while ((record = reader.readNext()) != null) {
			var make = record[0];
			var model = record[1];
			var stringCount = Short.parseShort(record[2]);

			var bass = new BassGuitar();
			bass.make = make;
			bass.model = model;
			bass.stringCount = stringCount;

			basses.add(bass);
		}

		Assert.assertEquals(basses.size(), expectedRowCount, "File contains 6 rows not including header.");
		Assert.assertNotNull(basses.get(0).make, "All Object in collection should be populated.");
	}
}
