package webpagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class youCartwebpage extends SeleniumUtility {
@FindBy (xpath="//div[@class='subheader']")
private WebElement youcartheading;



@FindBy (xpath="//a[contains(text(),'Continue Shopping')]")
private WebElement continueshopingbutton;

@FindBy(xpath="//button[contains(text(),'REMOVE')]")
private WebElement removeitembutton;

@FindBy (xpath="//a[contains(text(),'CHECKOUT')]")
private WebElement checkoutbutton;



@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
private WebElement cartiteamcount;




public youCartwebpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public WebElement getyoucartheader()
{
	return youcartheading;
	}



public WebElement getcontinueshopingbutton()
{
	return continueshopingbutton ;
	}

public WebElement getremoveElementbutton()
{
	return removeitembutton;
	}



public WebElement getcheckoutbutton()
{
	return checkoutbutton;
	}


public WebElement getcartiteamcount()
{
	return cartiteamcount;
	}

}
