package maven.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelSheet {
	@Test
	public ArrayList<String> excelPractice(String testcaseName) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\Desktop\\seleniumPractice.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int count = wb.getNumberOfSheets();
		int columnNumber = 0;
		int k=1;
		ArrayList<String> listOfData = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			if(sheet.getSheetName().equalsIgnoreCase("sheetname")) {
				Iterator<Row> row = sheet.rowIterator();
				Row firstrow = row.next();
				Iterator<Cell> ce = firstrow.iterator();
				while(ce.hasNext()) {
					String tmpstr1 = ce.next().getStringCellValue();
					if(tmpstr1.equalsIgnoreCase("testcases")) {
						columnNumber = k;
					}
						k++;
					}
				while(row.hasNext()) {
					Row r = row.next();
					String tmpstr = r.getCell(columnNumber).getStringCellValue();
					if(r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> c = r.iterator();
						while(c.hasNext()) {
							Cell cv = c.next();
							if(cv.getCellTypeEnum()==org.apache.poi.ss.usermodel.CellType.STRING)
							listOfData.add(cv.getStringCellValue());
							else
								
								listOfData.add(NumberToTextConverter.toText(cv.getNumericCellValue()));					
						}
					}
					
				}
			}
		}
		return listOfData;
	}
	
	@Test
	public void dataRetrieval() throws IOException {
		ExcelSheet es = new ExcelSheet();
		ArrayList<String> list = new ArrayList<>();
		list = es.excelPractice("TC1");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
