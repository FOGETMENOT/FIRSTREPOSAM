package swagtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;

public class fulltest extends SeleniumUtility{
@Test
public void tc2()
{
	driver=setUp("chrome", "https://www.saucedemo.com/v1/");
	WebElement asd=driver.findElement(By.id("user-name"));
	asd.sendKeys("standard_user");
	System.out.println(asd.isDisplayed());
	WebElement dffv=driver.findElement(By.id("password"));
	System.out.println(dffv.isDisplayed());
	dffv.sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.findElement(By.xpath("//div[@class='product_label']")).isDisplayed();
	}

}
