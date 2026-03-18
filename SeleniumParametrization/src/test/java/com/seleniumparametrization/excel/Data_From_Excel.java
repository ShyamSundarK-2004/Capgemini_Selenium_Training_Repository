package com.seleniumparametrization.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Data_From_Excel {

	@Test
	public void readExcel() throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./src/test/resources/orangehrms.testscriptdata/vacancies.xlsx");

		Workbook workbook = WorkbookFactory.create(fs);
		Sheet sheet = workbook.getSheet("addVacancy");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(1);
//		String vacancyname = cell.getStringCellValue();
//		System.out.println(vacancyname);

		Iterator<Row> rows = sheet.iterator();
		// cell value ones based index
		System.out.println(rows.next().getLastCellNum());
		// row has 0 based index
		System.out.println(rows.next().getRowNum());
		rows.next();
		System.out.println("----------Single column--------------");
		while (rows.hasNext()) {
			Cell c = rows.next().getCell(1);
			if (c.getCellType() == CellType.NUMERIC)
				System.out.println(c.getNumericCellValue());
			else if (c.getCellType() == CellType.BOOLEAN)
				System.out.println(c.getBooleanCellValue());
			else
				System.out.println(c.getStringCellValue());
		}

		Iterator<Row> rows1 = sheet.iterator();
		rows1.next();
		System.out.println("---------full row values---------------");
		while (rows1.hasNext()) {
			Row r = rows1.next();

			for (int i = 1; i < r.getLastCellNum(); i++) {
				Cell c = r.getCell(i);
				if (c.getCellType() == CellType.NUMERIC)
					System.out.println(c.getNumericCellValue());
				else if (c.getCellType() == CellType.BOOLEAN)
					System.out.println(c.getBooleanCellValue());
				else
					System.out.println(c.getStringCellValue());
			}

		}

	}

}
