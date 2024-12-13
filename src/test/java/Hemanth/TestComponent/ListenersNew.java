package Hemanth.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Hemanth.ResourcesNew.ExtentReporterNewNG;

public class ListenersNew extends BaseTestNew implements ITestListener {

	ExtentTest test;
	ExtentReports extentR = ExtentReporterNewNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extentR.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().log(Status.PASS, "Test is passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		// test.fail(result.getThrowable());

		extentTest.get().fail(result.getThrowable());
		// test.log(Status.FAIL, "Test is Failed");

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String filePath = null;
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentR.flush();
	}

}
