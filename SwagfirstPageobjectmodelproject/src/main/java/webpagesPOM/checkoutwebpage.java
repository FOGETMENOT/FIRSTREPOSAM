package webpagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutwebpage {
@FindBy (id="first-name")
private WebElement infofirstnamefield;
@FindBy (id="last-name")
private WebElement infolastnamefield;
@FindBy (id="postal-code")
private WebElement infozipcode;

@FindBy (xpath="//a[contains(text(),'CANCEL')]")
private WebElement cancelbutton;
@FindBy (xpath="//input[@type='submit']")
private WebElement continuebutton;


public checkoutwebpage(WebDriver driver)
{
	
PageFactory.initElements(driver,this);
}
 public WebElement getinfofirstnamefield()
 {
	return infofirstnamefield;
	 
 }
 public WebElement getinfolastnamefield()
 {
	return infolastnamefield;
	 
 }
 public WebElement getinfozipcode()
 {
	return infozipcode;
	 
 }
 
 
 
 public WebElement getcancelbutton()
 {
	return cancelbutton;
	
	 
 }
 
 public WebElement getcontinuebutton()
 {
	return continuebutton;
	
	 
 }




}
