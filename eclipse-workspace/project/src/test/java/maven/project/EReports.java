package maven.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EReports{
	static WebDriver driver;
@Test
public void test1() throws IOException {
	String path = "C:\\Users\\deepi\\eclipse-workspace\\project\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("Automation Results");
	reporter.config().setReportName("name");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("deepika", "tester");
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	driver = new ChromeDriver();
	extent.createTest("googlePageChecking");
	driver.get("https://www.google.com");
	EReports er = new EReports();
	er.screenShot();
	extent.flush();
	

}
@Test
public void screenShot() throws IOException {
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(src, new File("C:\\Users\\deepi\\Desktop\\screenshot1.png"));
}
@Parameters({"urlname","username"})
@Test

public void para1(String url,String username) {
	System.out.println(url);
	System.out.println(username);
}

@DataProvider
public Object[][] getdata(){
	Object[][] data = new Object[2][2];
	data[0][0]=1;
	data[0][1]=2;
	data[1][0]=3;
	data[1][1]=4;
	
	return data;
	
}
@Test(dataProvider = "getdata")
public void dataPractice(int i,int j) {
	
	
	System.out.println(i+" "+j);
}

@Test
public void propPractice() throws IOException {
	PropRetrieval pr = new PropRetrieval();
	
	
	String urlname= pr.propFileReading().getProperty("url");
	System.out.println(urlname);
}

@Test
public void excelRetrieval() throws IOException {
	int k=0;
	int columnNumber = 0;
	FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\Desktop\\seleniumPractice.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	int sheetCount = wb.getNumberOfSheets();
	for(int i=0;i<sheetCount;i++)
	{
		if(wb.getSheetAt(i).getSheetName().equalsIgnoreCase("sheetname")) {
			XSSFSheet sheet = wb.getSheetAt(i);
			Iterator<Row> row =  sheet.iterator();
			Row firstrow = row.next();
		Iterator<Cell> ce = firstrow.iterator();
		
		while(ce.hasNext()) {
			if(ce.next().getStringCellValue().equalsIgnoreCase("testcases")) {
				columnNumber = k;
			}
			k++;
		}
		while(row.hasNext()) {
			Row ro = row.next();
			Iterator<Cell> c = ro.iterator();
			if(ro.getCell(columnNumber).getStringCellValue().equalsIgnoreCase("tc1")) {
			while(c.hasNext())
				System.out.println(c.next().getStringCellValue());
			}
		}
		
		}
	}
}
@Test
public void havaPractice() {
	int[][] arr = {{1,2},{3,4},{5,6}};
	int big = arr[0][0];
	int bigcolumn=0;
	System.out.println(arr.length);
	System.out.println(arr[1].length);
	for(int i=0;i<arr.length;i++ ) {
		for(int j=0;j<arr[1].length;j++) {
			if(big<arr[i][j])
			{
				big=arr[i][j];
				bigcolumn=j;
			}
		}
	}
	System.out.println(big);
	int small=arr[0][bigcolumn];
	for(int k=0;k<arr.length;k++) {
		if(small>arr[0][bigcolumn])
			small=arr[k][bigcolumn];
	}
	System.out.println(small);
}

@Test
public void pattern() {
	int k=0;
	for(int i=0;i<4;i++) {
	
		for(int j=0;j<=i;j++) {
			System.out.print(k+"  ");
			k++;
		}
		System.out.println("\n");
	}
}
@Test
public void stringPrac() {
	String s= "DEEpeed";
	String newstr="";
	for(int i =0;i<s.length();i++) {
	newstr = s.charAt(i)+newstr;
	}
	System.out.println(newstr);
	s.replace("DEE", "E");
	System.out.println(s);

int upper=0;
int lower = 0;
for(int i =0;i<s.length();i++) {
if(s.charAt(i)>=65&&s.charAt(i)<=92)
{
	upper++;
}
else
	lower++;
}
System.out.println(upper+"  "+lower);
System.out.println(s.toLowerCase());
if(s.equalsIgnoreCase(newstr)) {
	System.out.println("palindrome");
}
}
@Test
public void arrayLi() {
	List<String> lst1 = new ArrayList<>();
	List<String> lst2 = new ArrayList<>();
	List<String> lst3 = new ArrayList<>();

	lst1.add("deepika");
	lst1.add("aniket");
	lst1.add("kishore");
	lst1.add("deepika");
	lst1.add("aniket");
	lst1.add("kishore");
	for(int i=lst1.size()-1;i>=0;i--) {
		lst2.add(lst1.get(i));
	}
	System.out.println(lst2);
}
}