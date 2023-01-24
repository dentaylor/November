package data.access;

public interface DataRow {
	String[] getColumns();
	String getCellValue(String columnName);
}
