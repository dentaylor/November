package data.access;

import java.util.HashMap;

public interface DatabaseAccessor {
	String[] executeSingleColumn(String sql);

	String executeSingleCell(String sql);

	DataRow[] execute(String sql); 

	DataRow[] executeStoredProcedure(
			String storeProc, 
			HashMap<String,String> inParameters, 
			HashMap<String,String> outParameters);
}
