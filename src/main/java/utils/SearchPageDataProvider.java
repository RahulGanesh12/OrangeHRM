package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SearchPageDataProvider {

	public static String[][] searchPageValues() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Admin\\OneDrive\\Desktop\\JavaConcepts\\JavaCoding\\OrangeHRM\\TestData\\TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook xw = new XSSFWorkbook(file);
		XSSFSheet xs = xw.getSheet("SearchOptions");
		int LastRow = xs.getLastRowNum();
		int LastColumn = xs.getRow(LastRow).getLastCellNum();
		String[][] DataProviderValues = new String[LastRow + 1][LastColumn];
		for (int i = 1; i <= LastRow; i++) {
			XSSFRow xr = xs.getRow(i);
			for (int j = 0; j < LastColumn; j++) {
				DataProviderValues[i][j] = xr.getCell(j).getStringCellValue();
			}
		}
		return DataProviderValues;
	}

}
