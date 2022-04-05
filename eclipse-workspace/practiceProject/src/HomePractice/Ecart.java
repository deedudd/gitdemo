package HomePractice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.ExpectedExceptions;

public class Ecart {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Ecart ec = new Ecart();
		String[] itemsListToBeAdded = { "Cucumber", "Brocolli" };
		// ec.addToCart();
		// ec.SearchStringTest();
		// ec.addToCartList();
		// ec.addToCartListAgain();
		// ec.endToEnd();
		// ec.addingList(itemsListToBeAdded);
		ec.checkingTotal();
	}

	private void checkingTotal() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5, 0));
		String[] itemsListToBeAdded = { "Cucumber", "Brocolli" };
		addingList(itemsListToBeAdded);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='promoInfo']"))));
		List<WebElement> lst = driver.findElements(By.xpath("//td[5]/p[@class='amount']"));
		int sum = 0;
		for (int i = 0; i < lst.size(); i++) {
			sum = sum + Integer.parseInt(lst.get(i).getText());
		}
		System.out.println(sum);
		String finalAmount = driver.findElement(By.cssSelector("span.discountAmt")).getText();

		Assert.assertEquals((float) (sum * 0.9), Float.parseFloat(finalAmount));
		
		

	}

	private void addingList(String[] itemsListToBeAdded) {

		List<WebElement> listOfItems = driver.findElements(By.cssSelector("div.product"));
		List searchItems = Arrays.asList(itemsListToBeAdded);
		int click = 0;
		for (int i = 0; i < listOfItems.size(); i++) {
			String[] elementName = listOfItems.get(i).getText().split(" ");
			if (searchItems.contains(elementName[0])) {
				listOfItems.get(i).findElement(By.cssSelector("div.product-action")).click();
				click++;
				System.out.println(click);
				if (click == itemsListToBeAdded.length)
					break;
			}
		}
	}

	private void endToEnd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5, 0));
		driver.findElement(By.cssSelector("input.search-keyword")).sendKeys("brocolli");
		driver.findElement(By.cssSelector("button.search-button")).click();

		driver.findElement(By.cssSelector("div.product-action")).click();
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='promoInfo']"))));
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());

		Assert.assertTrue(driver.findElement(By.cssSelector("span.discountPerc")).getText().equals("10%"));
		String selectedAmount = driver.findElement(By.xpath("//tr[1]/td[5]/p[@class='amount']")).getText();
		String finalAmount = driver.findElement(By.cssSelector("span.discountAmt")).getText();
		int selectedVal = (int) (Integer.parseInt(selectedAmount) * 0.9);

		Assert.assertEquals(selectedVal, Integer.parseInt(finalAmount));

	}

	void addToCart() throws InterruptedException {

		driver.findElement(By.xpath("//h4[text()=\"Cucumber - 1 Kg\"]/following-sibling::div[2]")).click();
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).isDisplayed());

	}

	void SearchStringTest() {

		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='product']/h4"));
		int count = 0;
		for (int i = 0; i < allElements.size(); i++) {
			if (allElements.get(i).getText().contains("ber")) {
				count++;
			}
		}
		System.out.println(count);
		driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("ber");

		driver.findElements(By.xpath("//div[@class='product']")).size();
		Assert.assertEquals(count, driver.findElements(By.xpath("//div[@class='product']")).size());
	}

	void addToCartList() {
		String[] searchElements = { "Cucumber", "Brocolli" };
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='product']"));
		int count = 0;
		List searchItems = Arrays.asList(searchElements);

		for (int i = 0; i < allElements.size(); i++) {
			String[] elementName = allElements.get(i).getText().split(" ");
			if (searchItems.contains(elementName[0])) {
				count++;
				allElements.get(i).findElement(By.xpath("div[3]")).click();
			}

		}

	}

	void addToCartListAgain() {

		String[] searchItems = { "Cucumber", "Brocolli" };
		List<WebElement> allitems = driver.findElements(By.xpath("//h4[@class='product-name']"));
		List<String> searchListItems = Arrays.asList(searchItems);
		int count = 0;
		for (int i = 0; i < allitems.size(); i++) {
			String[] name = allitems.get(i).getText().split(" ");
			if (searchListItems.contains(name[0])) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (count == searchItems.length) {
					break;
				}
			}
		}

	}
}