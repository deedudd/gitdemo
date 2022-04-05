package maven.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExcelPractice {
	ExtentSparkReporter reporter;
	ExtentReports extent;
	@Test
	public void report() {
		String path = "C:\\Users\\deepi\\eclipse-workspace\\project\\reports\\index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("My Test Reuslts");
		reporter.config().setDocumentTitle("results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("deepika", "tester");
	}
	@Test(dependsOnMethods = "report")
	public void test1() {
		extent.createTest("testname1");
		System.out.println("hello");
		extent.flush();
				
	}
	@Parameters({"url"})
	@Test(groups = "regression")
	public void test2(String url) {
		System.out.println("input from parameter"+url);
		
	}
	@DataProvider
	public Object[][] getdata(){
		Object[][] data = new Object[1][2];
		data[0][0]="hello1";
		data[0][1] = "hello2";
		return data;
		
		
	}
	@Test(dataProvider = "getdata")
	public void test3(String name1, String name2) {
		System.out.println(name1+"  "+name2);
	}
	WebDriver driver;
	@Test
	public void screensho() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\deepi\\Desktop\\screenshotOfgmailPage.png"));
	}
	@Test
	public void  test4() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
	}
	@Test
	public void excel() throws IOException {
		String path = "C:\\Users\\deepi\\Desktop\\seleniumPractice.xlsx";
		XSSFWorkbook wb = new XSSFWorkbook(path);
		int sheetCount = wb.getNumberOfSheets();
		int column = 0;
		int k=0;
		for( int i = 0; i<sheetCount;i++) {
			if(wb.getSheetAt(i).getSheetName().equalsIgnoreCase("sheetname")) {
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> row = sheet.rowIterator();
				Row firstrow = row.next();
				Iterator<Cell> cell= firstrow.cellIterator();
				while(cell.hasNext()) {
					Cell ce = cell.next();
					if(ce.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
				
				
				while(row.hasNext()) {
					Row r = row.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("tc1")) {
						System.out.println(r.getCell(column).getStringCellValue());
					}
				}
				
			}
			
		}
		
	}
}
