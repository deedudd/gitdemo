package maven.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ParameterizationPractice2 {
	String browserName;
	String urlName;
	WebDriver driver;
	ExtentReports extent;
	@Parameters({ "username", "password" })
	@Test
	public void test1(String username, String password) {

		System.out.printf(username, password);
	}

	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[2][2];
		data[0][0] = "name1";
		data[0][1] = "password1";
		data[1][0] = "name2";
		data[1][1] = "password2";
		return data;
	}

	@Test(dataProvider = "getdata")
	public void test2(String username, String password) {
		System.out.printf(username, password);
	}

	@Test(groups = {"smoke","regression"})
	public void test3() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
		prop.load(fis);
		browserName = prop.getProperty("browser");
		urlName = prop.getProperty("url");
		System.out.println(urlName);
	}

	@Test(dependsOnMethods = "reportsPractice")
	public void test4() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		extent.createTest("Testname4");
		ParameterizationPractice2 pp2 = new ParameterizationPractice2();
		pp2.test3();
		String uname = pp2.urlName;
		driver.get(uname);
		extent.flush();
		
		
	}
	@Test
	public void reportsPractice() {
		String path = "C:\\Users\\deepi\\eclipse-workspace\\project\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Deepika");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("deepika", "tester");
		
		
	}
	@Test(dependsOnMethods = "reportsPractice")
	public void test5() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		extent.createTest("Testname5");
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String chilId = it.next();
		driver.switchTo().window(chilId);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		extent.flush();
	}
	
	
}
