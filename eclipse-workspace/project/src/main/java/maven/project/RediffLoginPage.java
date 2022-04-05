package maven.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	WebDriver driver;
	public RediffLoginPage(WebDriver driver) {
		this.driver = driver;
	}
By username = By.xpath("");

public WebElement uname() {
	return driver.findElement(username);
}
}
