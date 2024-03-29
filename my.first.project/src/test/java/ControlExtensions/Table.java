package ControlExtensions;

public interface Table {
	TableRow getRow(int ordinalRow);
	
	int findRow(int columnIndex, String cellValue);
	
	int findRow(String columnName, String cellValue);
}
