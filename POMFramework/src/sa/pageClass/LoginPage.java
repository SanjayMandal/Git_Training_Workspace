package sa.pageClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="username")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement btnLogin;
	
	@FindBy(id="username_span")
	WebElement emptyUsernameError;
	
	public LoginPage(){
		Base.openBrowser();
		PageFactory.initElements(Base.driver, this);
		Base.navigateToUrl();
	}

	public String getTxtUsername() {
		return txtUsername.getAttribute("value");
	}

	public void setTxtUsername(String text) {
		txtUsername.clear();
		txtUsername.sendKeys(text);
	}

	public String getTxtPassword() {
		return txtPassword.getAttribute("value");
	}

	public void setTxtPassword(String text) {
		txtPassword.clear(); 
		txtPassword.sendKeys(text);
	}

	public void setBtnLogin() {
		btnLogin.click();
	}

	public String getEmptyUsernameError() {
		return emptyUsernameError.getText();
	}

		
	
}
