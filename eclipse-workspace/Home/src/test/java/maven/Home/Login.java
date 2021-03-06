package maven.Home;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.POLandingPage;
import pageObject.POSignInPage;
import resources.Base;

public class Login extends Base {

	@Test(dataProvider = "getdata")
public void HomePageNavigation(String email, String password, String text) throws IOException, InterruptedException {
	driver=initializer();
	driver.get(prop.getProperty("url"));
	POLandingPage lp = new POLandingPage(driver);

	JavascriptExecutor js = ((JavascriptExecutor)(driver));
	WebElement ele = 	lp.getlogin();
	js.executeScript("arguments[0].click();",ele);
	POSignInPage sp = new POSignInPage(driver);
	sp.email().sendKeys(email);
	sp.pwd().sendKeys(password);
	sp.submit();
	Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/sign_in/");

	
	}
@DataProvider
public Object[][] getdata(){
	Object[][] data = new Object[2][3];
	data[0][0] = "deepalalu@gmail.com";
	data[0][1] = "password1";
	data[0][2] = "restricted user";
	
	data[1][0]= "deepika@gmail.com";
	data[1][1] = "password2";
	data[1][2] = "invalid user";
	return data;
	
}
}
