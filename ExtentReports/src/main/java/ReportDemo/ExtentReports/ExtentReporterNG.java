package ReportDemo.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {
	
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);//helper class to create some configurations and report to main class(ExtentReport)
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");
	
	extent=new ExtentReports();//class which is responsible to create and consolidate all test executions
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Sevanthika");
	return extent;
	}
}
