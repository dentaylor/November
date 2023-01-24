import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CsvReaderFactory {

	public static CSVReader getReader(String csvFile) {
		try {
			return getCsvReader(csvFile);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private static String getFileFromResources(String fileName) {
		var fileUrl = ClassLoader.getSystemResource(fileName);

		if(fileUrl == null) {
			throw new RuntimeException(fileName + " is invalid.");
		}

		var filePath = fileUrl.getFile();

		if(filePath == null) {
			throw new RuntimeException("Could not get file path for " + fileUrl);
		}

		return filePath;
	}
	
	private static CSVReader getCsvReader(String file) {
		var filePath = getFileFromResources(file);

		try {
			return new CSVReaderBuilder(new FileReader(filePath))
					.withSkipLines(1)
					.build();
		
		} catch (Exception ex) {
			var message = ex.getMessage();
			throw new RuntimeException(message);	
		}		
	}
}
