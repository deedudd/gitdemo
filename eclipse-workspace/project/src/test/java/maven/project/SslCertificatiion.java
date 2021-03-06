package maven.project;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SslCertificatiion {
	WebDriver driver;

	@Test
	public void certf() {

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
	}

	@Test
	public void screenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\deepi\\Desktop\\screenshot.png"));
	}

	@Test
	public void brokenLinks() throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li/a"));
		for (int i =0;i<listOfLinks.size();i++) {

			String Link = listOfLinks.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(Link).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
		System.out.println(i+ "count");
			if (respcode > 400) {
				System.out.println("it is a broken link");
			}
		}
	}

	@Test
	public void http() throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li/a"));
		for(int i=0;i<links.size();i++) {
		HttpURLConnection conn = (HttpURLConnection)new URL(links.get(i).getAttribute("href")).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode = conn.getResponseCode();
		if(respcode>400)
			System.out.println("its a broken link");
		else
			System.out.println("not a broken link");
	}
	}
	@Test
	public void autoDropDown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Thread.sleep(3000);
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));

		for (int i = 0; i < listOfCountries.size(); i++) {
			if (listOfCountries.get(i).getText().equals("India")) {
				listOfCountries.get(i).click();
				//System.out.println(i);
			}
		}
		driver.manage().deleteCookieNamed("[]");
		System.out.println(driver.manage().getCookies());

	}

}
