package swagtest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.SeleniumUtility;
import webpagesPOM.checkoutwebpage;
import webpagesPOM.dashboard;
import webpagesPOM.loginpage;
import webpagesPOM.youCartwebpage;

public class swagcarttestTest extends SeleniumUtility  {
	loginpage login;
	dashboard dash;
	checkoutwebpage checkout;
	youCartwebpage youcart;
	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	
	
	@BeforeTest
	public void startreport()
	{
		report = new ExtentReports ("./ExtentReport/ExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		report
	            .addSystemInfo("Host Name", "SAM")
	            .addSystemInfo("Environment", "DEVLOPER")
	            .addSystemInfo("User Name", "TESTER TEST");
	
	}
	@BeforeMethod
	public void precondition()
	{
		driver=setUp("chrome",  "https://www.saucedemo.com/v1/");
		login=new  loginpage(driver);
		dash=new dashboard(driver);
		youcart =new youCartwebpage(driver);
		 checkout=new checkoutwebpage(driver);
 	}
	
	
	public static String screenShot(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../Screenshots/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
	//donetest sucessfully
  @Test
  public void testcartwithvaliddata() throws IOException {
	  test = report.startTest("SwagPageValidation-Valid");
	  login.loginInswagApplication("standard_user", "secret_sauce");
	  clickOnElement(dash.getclickcart());
	  Assert.assertEquals(isElementExist(youcart.getyoucartheader()),true);
			test.log(LogStatus.PASS,test.addScreenCapture(screenShot(driver)), "userdedirexted to your cart page succesfully");
			// Assert.assertEquals(isElementExist(youcart.getyoucartheader()),false);	
			
			//test.log(LogStatus.FAIL,test.addScreenCapture(screenShot(driver)), "userde not direxted to your cart page succesfully");
			
		}
		//cleanUp();
	//  Assert.assertTrue(isElementExist(youcart.getyoucartheader()),"userdedirexted to your cart page succesfully");
  
  
  @Test
  public void testcheckout() throws IOException {
	  test = report.startTest("TestCase2:swagcheckout");
	  login.loginInswagApplication("standard_user", "secret_sauce");
	  clickOnElement(dash.getclickcart());
	  clickOnElement(youcart.getcheckoutbutton());
	  Assert.assertEquals(isElementExist(checkout.getinfofirstnamefield()), true);
	  test.log(LogStatus.PASS, test.addScreenCapture(screenShot(driver)),"user get reditrected shoping");
  }
  
  
 // @Test
  public void testcontinueshoping()
  {
	  test = report.startTest("TestCase3:continueshopping");
	  login.loginInswagApplication("standard_user", "secret_sauce");
	  clickOnElement(dash.getclickcart());
	  clickOnElement(youcart.getcontinueshopingbutton());
	  Assert.assertTrue(isElementExist(dash.getdashboadelement()),"continueshoping button stop working or product on dashboard change ");
	  
  }
  
  
  @Test
  public void addtocart() throws IOException
  {
	  test = report.startTest("TestCase4:addtocart");
	  login.loginInswagApplication("standard_user", "secret_sauce");
	  dash.getlistofitem(dash.getinventorylist());
	Assert.assertEquals(isElementExist(dash.getdashboadelement()), true);
	  test.log(LogStatus.PASS,test.addScreenCapture(screenShot(driver)),"user get list of product in inventory ");
 
		  } 
  
 // @Test
  public void testremoveiteam() throws IOException
  {
	  test = report.startTest("TestCase5:test remove item");
  login.loginInswagApplication("standard_user", "secret_sauce");
  clickOnElement(dash.getclickcart());
 // boolean asd=youcart.getcartiteamcount().isDisplayed();
  Assert.assertEquals(isElementExist(dash.getdashboadelement()),true);
  
  test.log(LogStatus.PASS,test.addScreenCapture(screenShot(driver)),"continueshoping button stop working or product on dashboard change ");
  }
 // @Test
  public void testcartiteamcount()
  {
	  login.loginInswagApplication("standard_user", "secret_sauce");
	  clickOnElement(dash.getclickcart());
	  
  }
  
  
  // TEST ON cart elemrnt  name quanlity count 
  // test on continue shopping 
  // complete end to end test on  cart
  
  @AfterMethod
  public void getResult(ITestResult result){
	
		driver.close();
		
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
  public void  endReport(){
      report.flush();
      report.close();
}
	}
  

