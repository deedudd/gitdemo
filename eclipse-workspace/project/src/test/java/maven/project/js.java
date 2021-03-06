package maven.project;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class js {
	WebDriver driver;

	
	
	@Test
	public void jstest() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amdlearning.udemy.com/organization/home/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
	}
	@Test
	public void jscript() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		js.executeScript("alert('+alertMessage+');");
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("window.scrollBy(0,document.body.scroll)", "");
	}

	@Test
	public void webTabl() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.cssSelector("div.tableFixHead"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollBy(0,100)", ele);
		List<WebElement> lis = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
		int sum = 0;
		for (int i = 0; i < lis.size() - 1; i++) {
			int val = Integer.parseInt(lis.get(i).getText());
			sum = sum + val;
		}
		System.out.println(sum);
		String totalamt = driver.findElement(By.cssSelector("div.totalAmount")).getText();
		Assert.assertEquals(sum, totalamt.split(" ")[3]);
	}
	
	@Test
	public void frames() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[@href = '/frames']")).click();
		driver.findElement(By.xpath("//a[@href = '/iframe']")).click();
		int framescount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(framescount);
		driver.switchTo().frame(0).findElement(By.cssSelector("body.mce-content-body ")).click();
		driver.findElement(By.cssSelector("body.mce-content-body ")).sendKeys("hi I am Deepika");
		driver.switchTo().defaultContent();
		driver.navigate().back();
	}
	
	@Test
	public void actio() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Hovers')]")).click();
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='figure'][1]"))).click().build().perform();
		driver.findElement(By.xpath("(//a[text()='View profile'])[1]")).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
	}
	
	
	
	
}
