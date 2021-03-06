package maven.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CheckboxPractice {
	static WebDriver driver;

	@Test
	public void checkbox() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		ParameterizationPractice2 pp2 = new ParameterizationPractice2();
		pp2.reportsPractice();
		pp2.extent.createTest("checkbox");
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.xpath("//div[@id=\"checkbox-example\"]/fieldset/label")).size());
		pp2.extent.flush();
	}

	@Test(dependsOnMethods = "checkbox")
	public void alerts() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).sendKeys("Hi deepu");
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	@Test(dependsOnMethods = "checkbox")
	public void dropdown() {
		WebElement drop = driver.findElement(By.id("dropdown-class-example"));
		driver.manage().window().maximize();
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("Option2");
		List<WebElement> links = driver.findElements(By.xpath("//div[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul/li"));
		System.out.println(links.size());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class=\"tableFixHead\"]/table/tbody/tr/td[4]"));
		int sum = 0;
		for (int i = 0; i < amounts.size(); i++) {

			sum = sum + Integer.parseInt(amounts.get(i).getText());
			

		}
		System.out.println(sum);

	}
}
