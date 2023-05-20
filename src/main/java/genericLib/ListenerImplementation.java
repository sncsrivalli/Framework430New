package genericLib;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener {

	public ExtentReports report;
	public ExtentTest test;
	@Override
	public void onStart(ITestContext arg0) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Vtiger CRM Extent Reports");
		spark.config().setReportName("Vtiger");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Srivalli");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		
	}
	
	@Override
	public void onTestStart(ITestResult arg0) {
		Capabilities cap = ((RemoteWebDriver)BaseClass.sdriver).getCapabilities();
		report.setSystemInfo("Browser", cap.getBrowserName()+" "+cap.getVersion());
		test = report.createTest(arg0.getMethod().getMethodName());		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		test.pass(arg0.getMethod().getMethodName()+ " Pass");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test.fail(arg0.getMethod().getMethodName()+ " Fail");
		test.fail(arg0.getThrowable());
		WebDriverUtility web = new WebDriverUtility();
//		String screenshotPath = web.getScreenshot(arg0.getMethod().getMethodName(),
//												BaseClass.sdriver, BaseClass.sjUtil);
//		test.addScreenCaptureFromPath(screenshotPath);
		
		test.addScreenCaptureFromBase64String(web.getScreenshot(BaseClass.sdriver));
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		test.skip(arg0.getMethod().getMethodName()+ " Skipped");
		test.fail(arg0.getThrowable());		
	}

	
	@Override
	public void onFinish(ITestContext arg0) {
		report.flush();
	}


}
