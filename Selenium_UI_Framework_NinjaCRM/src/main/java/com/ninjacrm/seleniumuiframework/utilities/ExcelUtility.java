package com.ninjacrm.seleniumuiframework.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String FILE_PATH = "./src/test/resources/orangehrms.testscriptdata/TestCase_Data_NinjaCRM.xlsx";
	FileInputStream fis = null;
	Workbook wb = null;
	Sheet sheet = null;

	// read data
	public Object[][] getExcelDataAsArray(String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount - 1];

		DataFormatter formatter = new DataFormatter();

		int validRowCount = 0;

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);

			// Skip empty row
			if (row == null || formatter.formatCellValue(row.getCell(0)).trim().isEmpty()) {
				continue;
			}

			for (int j = 1; j < colCount; j++) {

				Cell col = row.getCell(j);

				if (col != null) {
					data[validRowCount][j - 1] = formatter.formatCellValue(col);

				}
			}
			validRowCount++;
		}
		Object[][] finalData = new Object[validRowCount][colCount - 1];

		for (int i = 0; i < validRowCount; i++) {
			finalData[i] = data[i];
		}

		return finalData;
	}

	public void createSheetData(String sheetname, int rowno, int cellno)
			throws EncryptedDocumentException, IOException {

		fis = new FileInputStream(FILE_PATH);
		wb = WorkbookFactory.create(fis);
		sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		if (row == null) {
			row = sheet.createRow(rowno);
		}
		Cell col = row.createCell(cellno);
		if (col == null) {
			col = row.createCell(cellno);
		}

	}
}