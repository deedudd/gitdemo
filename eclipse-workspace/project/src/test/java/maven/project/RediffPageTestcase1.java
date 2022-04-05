package maven.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RediffPageTestcase1 {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com");
		rediffHomePage rhome = new rediffHomePage(driver);
		driver.manage().window().maximize();
		WebElement ele = rhome.search();
		WebElement ele1 = driver.findElement(By.cssSelector("input#srchquery_tbox"));
		
		ele1.sendKeys("shane");
		File src =ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\deepi\\Desktop\\rediffPartialImage.png"));
		Actions a = new Actions(driver);
		a.moveToElement(rhome.search()).sendKeys(Keys.ENTER).perform();
		// rhome.searchclick().click();
	}

	@Test
	public void loginPageTopStories() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rediff.com");
		rediffHomePage rhome = new rediffHomePage(driver);
		driver.manage().window().maximize();
		int countOfLinks = rhome.topstorieslinks().size();
		System.out.println(countOfLinks);
	}
}
