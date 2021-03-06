package HomePractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropdownPractice {

	enum month {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	}

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3);
		driver.manage().window().maximize();
		DropdownPractice ddp = new DropdownPractice();
		// ddp.CitySelection();
		// driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		// ddp.RoundTripDate();
		ddp.OptimizedRoundTripDate(8,"MARCH");
		ddp.OptimizedRoundTripArrivalDate(12,"APRIL");
		// ddp.currencySelection();
		Thread.sleep(3000);
		Assert.assertFalse(false);
		// driver.close();

	}

	public void OptimizedRoundTripDate(int date,String targetMonthInWords) {
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();

//	for (int i = 0; i < 6; i++) {
//		String s = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
//		if (s.equalsIgnoreCase("june")) {
//			driver.findElement(By.xpath("//a[text()='8']")).click();
//			break;
//		} else {
//			driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
//		}
//	}
		System.out.println(month.valueOf("JANUARY").ordinal());

		String s = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		int currentMonth = month.valueOf(s.toUpperCase()).ordinal();
		int targetMonth = month.valueOf(targetMonthInWords).ordinal();
		int clickCnt = targetMonth - currentMonth;
		String dateXpath2="(//a[text()="+date+"])[2]";
		String dateXpath1="//a[text()="+date+"]";
		if (clickCnt < 0)
			clickCnt = clickCnt + 12;
		if (clickCnt == 6) {
			for (int i = 0; i < clickCnt; i++) {
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			}
			
			driver.findElement(By.xpath(dateXpath2)).click();
		} else {
			for (int i = 0; i < clickCnt; i++) {
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			}

			driver.findElement(By.xpath(dateXpath1)).click();
		}

//	driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
//	for (int i = 0; i < 6; i++) {
//		String s = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
//		if (s.equalsIgnoreCase("july")) {
//			driver.findElement(By.xpath("(//a[text()='8'])[2]")).click();
//			break;
//		} else {
//			driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
//		}
//	}

	}

	public void OptimizedRoundTripArrivalDate(int date,String targetMonthInWords) {
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
		String s = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String s2 = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
		int currentMonth = month.valueOf(s.toUpperCase()).ordinal();
		int targetMonth = month.valueOf(targetMonthInWords).ordinal();
		
		
		int clickCnt = targetMonth - currentMonth;
		if (clickCnt < 0)
			clickCnt = clickCnt + 12;

		for (int i = 0; i < clickCnt; i++) {
			driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			s = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			s2 = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
		}

		if(s2.equalsIgnoreCase(targetMonthInWords))
			driver.findElement(By.xpath("(//a[text()='12'])[2]")).click();
		else
		driver.findElement(By.xpath("//a[text()='12']")).click();

	}

	public void CitySelection() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Type to Select']")).sendKeys("ind");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> dropdown = driver.findElements(By.cssSelector("li.ui-menu-item"));

		for (int i = 0; i < dropdown.size(); i++) {
			if (dropdown.get(i).getText().equals("India")) {
				dropdown.get(i).click();
			}
		}

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@text='Ahmedabad (AMD)']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='IXB']"))
				.click();
	}

	public void RoundTripDate() {
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();

		for (int i = 0; i < 6; i++) {
			String s = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			if (s.equalsIgnoreCase("june")) {
				driver.findElement(By.xpath("//a[text()='8']")).click();
				break;
			} else {
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			}
		}
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();

		for (int i = 0; i < 6; i++) {
			String s = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[2]")).getText();
			if (s.equalsIgnoreCase("july")) {
				driver.findElement(By.xpath("(//a[text()='8'])[2]")).click();
				break;
			} else {
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			}
		}

	}

	public void currencySelection() throws InterruptedException {

		System.out.println(driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected());
		Thread.sleep(3000);
		WebElement staticDropdown = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select currencyDropdown = new Select(staticDropdown);
		currencyDropdown.selectByVisibleText("AED");

		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//input[@value='Done']")).click();

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		System.out.println(
				driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isEnabled());
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
