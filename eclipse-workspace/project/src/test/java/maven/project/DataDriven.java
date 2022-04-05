package maven.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataDriven {

	@Test
	public void dataRetrieval() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\Desktop\\seleniumPractice.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int noOfSheets = wb.getNumberOfSheets();
		int columnNumer = 0;
		int k = 0;
		for (int i = 0; i < noOfSheets; i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			if (sheet.getSheetName().equalsIgnoreCase("sheetname")) {
				Iterator<Row> row = sheet.rowIterator();
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				while (ce.hasNext()) {
					if (ce.next().getStringCellValue().equalsIgnoreCase("testcases")) {
						columnNumer = k;
					}
					k++;
				}
				while(row.hasNext()) {
					Row r = row.next();
					Iterator<Cell> c = r.cellIterator();
					
					if(r.getCell(columnNumer).getStringCellValue().equalsIgnoreCase("tc1")) {
						
						while (c.hasNext()) {
							
								System.out.println(c.next().getStringCellValue());}
					}
				}
			}

		}

	}
}
