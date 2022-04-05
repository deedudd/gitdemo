package HomePractice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandlesPractice {
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();

		WindowHandlesPractice wp = new WindowHandlesPractice();
		// wp.loginPractice();
		// wp.heroku();
		wp.linkcount();
	}

	private void linkcount() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("li")).size());
		
		WebElement footerColoumn = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		
		List<WebElement> links = footerColoumn.findElements(By.tagName("a"));
		for(int i=1;i<footerColoumn.findElements(By.tagName("a")).size();i++) {
			footerColoumn.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			while(it.hasNext()) {
				
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		
	}

	private void loginPractice() {
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[contains(@href,'documents-request')]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentid = it.next();
		String childId = it.next();
		driver.manage().window().maximize();
		driver.switchTo().window(childId);
		// driver.findElement(By.xpath("(//a[text()='Home'])[1]")).click();

		String text = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String[] email = text.split(" ");
		String[] emailid = email[4].split("@");

		driver.switchTo().window(parentid);
		driver.findElement(By.cssSelector("input#username")).sendKeys(emailid[1]);

	}

	private void heroku() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> it1 = windows1.iterator();
		it1.next();
		it1.next();
		String secondChild = it1.next();
		driver.switchTo().window(secondChild);
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Elemental Selenium')]")).getText());
	}

}
