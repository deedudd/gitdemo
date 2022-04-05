package maven.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropRetrieval {
@Test
	public Properties propFileReading() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\deepi\\eclipse-workspace\\project\\src\\main\\java\\maven\\project\\data.properties");
	Properties prop = new Properties();
	prop.load(fis);
	return prop;
}
}
