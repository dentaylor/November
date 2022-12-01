package ControlExtensions;

public interface Table {
	TableRow getRow(int ordinalRow);
	
	int findRow(String columnIndex, String cellValue);
}
