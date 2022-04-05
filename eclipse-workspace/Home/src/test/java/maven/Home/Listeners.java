package maven.Home;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentReporterNG er = new ExtentReporterNG();
		extent = er.getReport(result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		System.out.println("started  "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extent.flush();
		System.out.println("On Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testName = result.getMethod().getMethodName();
		Base bs = new Base();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					
					.get(result.getInstance());
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			extenttest.get().addScreenCaptureFromPath(bs.getScreenShot(testName, driver), testName);
		  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extent.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
