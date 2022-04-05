package resources;

import java.io.FileInputStream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public ExtentReports getReport(String testname) {
		String path	=System.getProperty("user.dir")+"\\reports\\"+testname+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Results");
		reporter.config().setReportName(testname);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo(testname, path);
		return extent;
	}
}



