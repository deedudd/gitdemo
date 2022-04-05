package HomePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {
	static Actions a;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		 a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("div.nav-line-1-container"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"nav-al-your-account\"]/a[2]/span")).click();
		ActionsPractice ap = new ActionsPractice();
		ap.caps();
	}

	private void caps() {
		a.moveToElement(driver.findElement(By.id("ap_email"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	}

}
