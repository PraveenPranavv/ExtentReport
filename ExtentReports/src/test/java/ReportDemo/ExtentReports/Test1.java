package ReportDemo.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test1 extends BaseClass{
	
	WebDriver driver;
	
	@Test
	public void initialDemo() {
		driver=initializeDriver();
		driver.get("https://www.google.com");
		driver.getTitle();
		driver.close();
		
	}
	
}
