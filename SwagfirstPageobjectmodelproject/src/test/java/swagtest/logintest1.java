package swagtest;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

import webpagesPOM.loginpage;

import webpagesPOM.dashboard;
public class logintest1 extends SeleniumUtility {
	loginpage login;
	dashboard dash;
	WebDriver driver;
	
	@BeforeMethod
	 public void precondition(){
	driver=setUp("chrome", "https://www.saucedemo.com/v1/");
	login=new loginpage(driver);
	dash=new dashboard(driver);
	
	}
	@Test
	public void tc1()
	{
typeInput(login.getUsernameInputField(),"standard_user");
typeInput(login.getPasswordInputField(), "secret_sauce");
clickOnElement(login.getLoginButton());	

	}
	
	
	@Test
	public void tc2(){
		login.loginInswagApplication("standard_user", "secret_sauce");
	
		Assert.assertTrue(isElementExist(dash.getdashboadelement()),"Either login failed or dasboard product heading change");
	}
	
	@Test
	public void tc2invalid_usename_password()
	{
		login.loginInswagApplication("dummy", "dummypassword");
		Assert.assertTrue(isElementExist(dash.getdashboadelement()),"Even after entering unvalid usernaem and password user is able to login");
	}
	
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
	}
}
