package utilies;

import java.io.IOException;

public class ReadExcelData {

	public static int getRowCount(String xlfilepath, String sheetName) throws IOException {
		int data = ExcelUtils.getRowCount(xlfilepath, sheetName);
		return data;
	}

	public static String getActionData(String xlfilepath, String sheetName, int rowNum, int colNum) throws IOException {
		String data = ExcelUtils.getCellData(xlfilepath, sheetName, rowNum, colNum);
		return data;
	}

	public static String getObjectData(String xlfilepath, String sheetName, int rowNum, int colNum) throws IOException {
		String data = ExcelUtils.getCellData(xlfilepath, sheetName, rowNum, colNum);
		return data;
	}

	public static void setCellData(String xlfilepath, String sheetName, int rowNum, int colNum, String value)
			throws IOException {
		ExcelUtils.setCellData(xlfilepath, sheetName, rowNum, colNum, value);

	}
}
