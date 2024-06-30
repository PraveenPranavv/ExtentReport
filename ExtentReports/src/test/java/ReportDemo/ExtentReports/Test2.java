package ReportDemo.ExtentReports;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test2 extends BaseClass{
	
	WebDriver driver;
	@Test
	public void googleTitleValidation() {
		driver=initializeDriver();
		driver.get("https://www.google.com");
		driver.getTitle();
		Assert.assertTrue(false);
		driver.close();
		
	}
}
