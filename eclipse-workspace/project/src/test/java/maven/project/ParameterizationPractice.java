package maven.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationPractice {
	@Parameters({"username"})
	@Test
	public void method1(String username) {
		System.out.println(username);
	}
	
	@DataProvider
	public Object[][] getdata(){
		Object[][] data = new Object[2][2];
		data[0][0] = "deedudd1";
		data[0][1] = "password1";
		data[1][0] = "deedudd2";
		data[1][1] = "password2";
		return data;
		
	}
	
	@Test(dataProvider = "getdata")
	public void method2(String username, String password) {
		System.out.println(username+"\n"+password);
	}
	@Test
	public void propertiesPractice() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String urlname = System.getProperty("url"); 
		System.out.println(urlname);
	}
}
