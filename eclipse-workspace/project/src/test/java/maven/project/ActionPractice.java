package maven.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ActionPractice {
	WebDriver driver;

	@Test
	public void amazon() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		driver = new RemoteWebDriver(new URL("http://192.168.1.15:4444"),options);
		driver.get("https://www.amazon.in");
		WebElement signin = driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
		Actions a= new Actions(driver);
		a.moveToElement(signin).build().perform();
		driver.findElement(By.cssSelector("span.nav-action-inner")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ap_email")).sendKeys("deepaalu@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Hanumaan_1");
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	@Test
	public void option() throws IOException, AWTException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("Deepika");
		FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--headless", "--window-size=1920,1200");
		options.setProfile(myprofile);
		
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getCurrentUrl());
		//driver.manage().deleteAllCookies();
		System.out.println(driver.manage().getCookies());
		HttpURLConnection conn = (HttpURLConnection)new URL(driver.getCurrentUrl()).openConnection();
		//conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode = conn.getResponseCode();
		System.out.println(respcode);
	}

	@Test
	public void test1() throws IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(
				"https://www.browserstack.com/guide/action-class-in-selenium#:~:text=Actions%20class%20is%20an%20ability,the%20advanced%20user%20interactions%20API.");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getWindowHandles().size());
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.cssSelector("span.nav_item_name"));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500)");
		// driver.switchTo().alert().accept();
		driver.findElement(By.id("accept-cookie-notification")).click();
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Documentation')]"))).contextClick()
				.sendKeys(Keys.ARROW_DOWN).perform();

	}

	@Test
	public void draganddrop() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		Actions a = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath(" //p[contains(text(),'Drag me to my target')]"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		a.dragAndDrop(drag, drop).perform();

	}

	@Test
	public void nestedframes() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(@href,'nested_frames')]")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']"))).switchTo()
				.frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
	}
}
