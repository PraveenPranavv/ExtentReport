package ReportDemo.ExtentReports;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Listeners extends BaseClass implements ITestListener{
	
	ExtentReports extent=ExtentReporterNG.extentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> thread=new ThreadLocal<ExtentTest>();//all objects will get stored in thread object. Dead lock will not happen
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		//in parallel mode all test objects will be overriden and the results will be inconsistent and incorrect.It will not be thread safe 
		//Thread Local-this class is used to maintain thread safe for all objects
		test=extent.createTest(result.getMethod().getMethodName());//create one entry for each testcase in html file
		thread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		thread.get().log(Status.PASS,"Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		WebDriver driver=null;
		thread.get().fail(result.getThrowable());//getThrowable() extract the error message of failed testcase
		//take Screenshot and attach to report
		Object testObject=result.getInstance();
		//to get access to all variables present in test3 class-getrealclass()
		Class cls=result.getTestClass().getRealClass();
		try {
			driver=(WebDriver)cls.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			thread.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}
		
	
}
