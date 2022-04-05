package maven.project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class rediffHomePage {
	WebDriver driver;

	public rediffHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By searchCss = By.cssSelector("input#srchquery_tbox");
	By searchclickcss = By.xpath("//form[@name='newsrchform']/input[2]");
	By money = By.xpath("//a[contains(@href,'money.rediff.com')]");
	By topstoriesLinksXpath = By.xpath("//div[@id='topdiv_0']/h2/a");
	
	public WebElement search() {
		return driver.findElement(searchCss);
	}
	
	public WebElement searchclick() {
		return driver.findElement(searchclickcss);
	}
	
	public List<WebElement> topstorieslinks() {
		return driver.findElements(topstoriesLinksXpath);
	}
	
	
}
