package webpagesPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class dashboard extends SeleniumUtility{
	
	@FindBy (xpath="//div[@class='product_label']")
	private WebElement dasboardproduct;
	
	@FindBy(xpath="//button[contains(text(),'Open Menu')]")
	private WebElement openmenu;
	
	
	
	@FindBy (id="shopping_cart_container")
	private WebElement clickcart;
	
	@FindBy (xpath="//div[@class='inventory_item_name']")
	private List<WebElement> Inventoryiteamlist;
 public dashboard(WebDriver driver){
	 PageFactory.initElements(driver, this);
 } 
 
 public dashboard() {
	// TODO Auto-generated constructor stub
}

public WebElement getdashboadelement()
 {

return dasboardproduct;
 }


public WebElement getopenmenu()
{
	return dasboardproduct;
	}

public WebElement getclickcart()
{
	return clickcart;
	}
public List<WebElement> getinventorylist()
{
	return Inventoryiteamlist;
	}
}
