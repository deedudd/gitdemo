package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PORedbusLandingPage {

	public WebDriver driver;
	
	public PORedbusLandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By fromStationXpath = By.xpath("//input[@id='src']");
	By toStationXpath = By.xpath("//input[@id='dest']");
	By dateId         = By.id("onward_cal");
	By fromStationList = By.xpath("//li[@class=\"sub-city\"]");
	By searchButton = By.id("search_btn");
	
	
	public WebElement fromStation() {
		return driver.findElement(fromStationXpath);
		
	}
	
	public WebElement toStation() {
		return driver.findElement(toStationXpath);
	}
	
	public WebElement date() {
		return driver.findElement(dateId);
	}
	
	public List<WebElement> froStationList() {
		return driver.findElements(fromStationList);
	}
	public WebElement searchBuses() {
		return driver.findElement(searchButton);
	}
}
