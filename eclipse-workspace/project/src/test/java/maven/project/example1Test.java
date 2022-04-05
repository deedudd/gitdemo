package maven.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class example1Test {
	WebDriver driver;
	ExtentReports extent;

	@Test(groups= {"smoke"})
	public void propFile() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		prop.setProperty("browser", "firefox");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
		prop.store(fos, null);
		
		
	}
	@Test
	public void EReports() {
		String path = "C:\\Users\\deepi\\eclipse-workspace\\project" + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Deepika");

	}

	@Test(dependsOnMethods = "EReports")
	public void test1() {
		ExtentTest test = extent.createTest("example1Test");
		System.out.println("in exampletest1");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		extent.flush();
		
	}
	
	@Test(enabled=false)
	public void test2() {
		driver.findElement(By.cssSelector("a#opentab")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Consulting')]")).getText());
		driver.close();
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//legend[contains(text(),'Window')]")).getText());
	}

	@Test(enabled=false)
	public void usingActions() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/#/index");
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("a.btn.btn-theme.btn-sm.btn-min-block")))
		.click().keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
	}
	@Test(dependsOnMethods = "test1")
	public void alert() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("deepika");
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test(dataProvider = "getdata")
	public void data(String username,String password) {
		System.out.printf(username,password);
	}
	@DataProvider
	public Object[][] getdata() {
		Object[][] data = new Object[3][2];
		data[0][0] = "qwe";
		data[0][1] = "asd";
		data[1][0] = "qwe2";
		data[1][1] = "asd2";
		data[2][0] = "qwe3";
		data[2][1] = "asd3";
		return data;
		
	}
}
