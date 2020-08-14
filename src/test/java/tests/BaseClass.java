package tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import listener.ExtentReportFunctions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import static java.lang.System.getProperty;

public class BaseClass extends ExtentReportsDemo{

//	private static Object driver;6
//public static ExtentReports extentReport = new ExtentReports(System.getProperty("user.dir") + "/src/test/resources/reports/ExtentReportResults.html");
	public static ExtentTest extentTest;
public static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {
		
		try {
			
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		String platform = "android";
		
		if(platform.equalsIgnoreCase("android")) {

			capabilities.setCapability("BROWSER_NAME", "Android");
			capabilities.setCapability("deviceName","emulator-5554");
			capabilities.setCapability("platformName","Android");
		//	capabilities.setCapability("appPackage", "com.android.calculator2");
		//	capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			capabilities.setCapability("chromedriverExecutable","D:\\DEVA\\newTokyo\\newtokyo\\src\\main\\resources\\drivers\\chromedriver.exe");


		}
		
		else if(platform.equalsIgnoreCase("ios")) {

			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
			
		}
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url, capabilities);
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver = new AndroidDriver<MobileElement>(url, caps);
		//driver = new IOSDriver<MobileElement>(url, caps);
		
		
		}catch(Exception exp) {
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
			
		}
		
	}
	
	@Test
	public void sampleTest() {
		System.out.println("I am inside sample Test");
	}


//@AfterMethod(alwaysRun=true)
//public void endTest(ITestResult result){
//	if(!result.isSuccess()){
//		extentReport.endTest(extentTest);
//		extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(ExtentReportFunctions.getFilePath()));
//
//
//	}


//}

	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
