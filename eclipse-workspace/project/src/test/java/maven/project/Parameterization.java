package maven.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	@Parameters({"url"})
	@Test
	public void method1(String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
	}
	
	
	@DataProvider
	
	public Object[][] method2() {
		Object[][] getdata = new Object[1][1];
		getdata[0][0] = "hello";
		return getdata;
		
		
	}
	@Test(dataProvider = "method2")
	public void method3(String getdata) {
		System.out.println(getdata);
	}
}
