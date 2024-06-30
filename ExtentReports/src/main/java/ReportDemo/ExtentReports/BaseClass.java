package ReportDemo.ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	WebDriver driver; 
	public WebDriver initializeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRAVEEN SEVANTHU\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"report\\"+testcaseName+".png";
		File desPath=new File(path);
		FileUtils.copyFile(src,desPath);
		return path;
		
	}
}
