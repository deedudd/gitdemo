package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POLandingPage {
	public WebDriver driver;

	
	public  POLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By signin = By.xpath("//span[contains(text(),'Login')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	
	
	public WebElement getlogin() {
		return driver.findElement(signin);
	}
	public WebElement gettitle() {
		return driver.findElement(title);
	}
	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}
}
