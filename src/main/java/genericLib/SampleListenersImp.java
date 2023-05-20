package genericLib;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleListenersImp implements ITestListener {

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("OnStart");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("OnTestStart");
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("OnTestFailure");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("OnTestSkipped");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("OnTestSuccess");
	}

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("OnFinish");
	}
}
