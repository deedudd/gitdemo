package maven.project;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class example3Test {
	static WebDriver driver;
	@Parameters({"URL"})
	@BeforeTest
	public void initialization(String URL) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
	}

	@Test(dependsOnMethods = { "radioButtonClick" })
	public void radibuttonCheck() {
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
	}

	@Test
	public void radioButtonClick() {
		driver.findElement(By.xpath("//input[@value='radio1']")).click();

	}

	@Test
	public void radioButtonCount() {
		System.out.println(driver.findElements(By.xpath("//input[@name=\"radioButton\"]")).size());
	}

	@Test
	public void staticDropdown() {
		WebElement drop = driver.findElement(By.cssSelector("select#dropdown-class-example"));
		Select dropdown = new Select(drop);
		dropdown.selectByVisibleText("Option1");
		System.out.println(drop.isSelected());
		
	}
	@Test
	public void openwindow(){
		example3Test e3 = new example3Test();
		//e3.initialization();
		driver.findElement(By.cssSelector("button#openwindow")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId=it.next();
		String childId= it.next();
		driver.switchTo().window(childId);
		String txt = driver.findElement(By.xpath("//h2[text()='Featured Courses']")).getText();
		System.out.println(txt);
		driver.close();
		//driver.switchTo().defaultContent();
	}

	@Test
	public void closure() {
		driver.close();
	}
}
