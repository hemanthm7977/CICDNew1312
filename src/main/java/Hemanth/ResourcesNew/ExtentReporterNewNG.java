package Hemanth.ResourcesNew;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNewNG {

	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Auto Results");
		reporter.config().setDocumentTitle("New Test Results");

		ExtentReports extentR = new ExtentReports();
		extentR.attachReporter(reporter);

		extentR.setSystemInfo("TESTer", "HeMAn");
		extentR.createTest(path);

		return extentR;

	}

}
