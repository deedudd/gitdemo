package maven.Home;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.POLandingPage;
import resources.Base;

public class ValidateNavigationbar extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializer();
		//driver.get(prop.getProperty("url"));
		
	}
	
	@Test
	
public void navigationBar() throws IOException {
		driver.get(prop.getProperty("url"));
		
		System.out.println(driver.getCurrentUrl());
	POLandingPage lp =new POLandingPage(driver);
	Assert.assertTrue(lp.getNavigation().isDisplayed());
	System.out.println("second done");
}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
}
