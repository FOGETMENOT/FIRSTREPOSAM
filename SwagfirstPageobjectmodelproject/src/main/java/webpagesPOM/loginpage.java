package webpagesPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class loginpage extends SeleniumUtility{
	
	@FindBy (id="user-name")
	private WebElement Usernameinputfield;
	
	@FindBy (id="password")
	private WebElement passwordinputfield;
	
	@FindBy(id="login-button")
	private WebElement loginbutton;
	public loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getUsernameInputField() {
		return Usernameinputfield;
	}

	public WebElement getPasswordInputField() {
		return passwordinputfield;
	}

	public WebElement getLoginButton() {
		return loginbutton;
	}
	public void loginInswagApplication(String username,String password) {
		typeInput(Usernameinputfield, username);
		typeInput(passwordinputfield, password);
		clickOnElement(loginbutton);
	}
}