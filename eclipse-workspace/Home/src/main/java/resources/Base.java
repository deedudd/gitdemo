package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public Properties prop;
	public WebDriver driver;
public WebDriver initializer() throws IOException {
	String path = "C:\\Users\\deepi\\eclipse-workspace\\Home\\src\\main\\java\\resources\\data.properties";
	FileInputStream fis = new FileInputStream(path);
	prop = new Properties();
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
}
public String getScreenShot(String testname, WebDriver driver) throws IOException {
	String path = System.getProperty("user.dir")+"\\reports\\"+testname+"Screenshot"+".png";
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(path));
	return path;
	
}
}
