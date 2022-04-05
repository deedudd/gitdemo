package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POSignInPage {
	WebDriver driver;
 public POSignInPage(WebDriver driver) {
	 this.driver = driver;
 }
 By emailId = By.id("user_email");
 By pwdId = By.id("user_password");
 By submitXpath = By.xpath("//input[@type='submit']");
 
 
 public WebElement email() {
	 return driver.findElement(emailId);
 }
 public WebElement pwd() {
	 return driver.findElement(pwdId);
 }
 public WebElement submit() {
	return driver.findElement(submitXpath);
	 
 }
}
