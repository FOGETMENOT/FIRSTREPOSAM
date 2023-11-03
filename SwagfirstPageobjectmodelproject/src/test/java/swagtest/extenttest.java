package swagtest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.SeleniumUtility;

public class extenttest extends SeleniumUtility {
	WebDriver driver;
	static ExtentReports report;
	 static ExtentTest test;
	@BeforeTest
	public void startReport(){
		//driver=setUp("chrome",  "https://www.saucedemo.com/v1/");
		report = new ExtentReports ("./ExtentReport/ExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		report
	            .addSystemInfo("Host Name", "SAM")
	            .addSystemInfo("Environment", "DEVLOPER")
	            .addSystemInfo("User Name", "TESTER TEST");
	}
	@Test
	public void testCase1(){
		//Starting test
		test = report.startTest("TestCase1");
		Assert.assertTrue(true);
		//To generate the log when the test case is passed
		test.log(LogStatus.PASS, "TestCase1 is pased");
	}
	
	@Test
	public void testCase2(){
		test = report.startTest("TestCase2");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "TestCase2 is failed");
	}
	
	@Test
	public void skipTest(){
		test = report.startTest("TestCase3");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed due to "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped due to "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		report.endTest(test);
	}
	@AfterTest
	public void endReport(){
		        report.flush();
                report.close();
    }
}
