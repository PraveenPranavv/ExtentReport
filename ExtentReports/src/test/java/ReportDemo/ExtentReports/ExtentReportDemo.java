package ReportDemo.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo extends BaseClass {
	 
	 	WebDriver driver;
		@Test
		public void demo()  {
			
			//ExtentTest test=extent.createTest("demo");
			driver=initializeDriver();
			driver.get("https://rahulshettyacademy.com");
			System.out.println(driver.getTitle());
			//test.fail("Result do not match");
			//test.addScreenCaptureFromBase64String("Failed");
			//extent.flush();
			
		}
}
