package ReportDemo.ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test3 extends BaseClass{

	WebDriver driver;
	@Test
	public void textBoxValidation() {
		driver=initializeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hello");
		driver.getTitle();
		driver.close();
		
	}


}
