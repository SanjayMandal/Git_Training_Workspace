package sa.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sa.pageClass.LoginPage;
import sa.pageClass.SearchHotelPage;

public class LoginPageTestCase {
	
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	
	@BeforeClass
	void beforeClass(){
		loginPage = new LoginPage();
	}

	@Test
	void test1(){
		loginPage.setTxtUsername("");
		loginPage.setTxtPassword("");
		loginPage.setBtnLogin();
		Assert.assertEquals("Enter Username", loginPage.getEmptyUsernameError());
	}
	
	@Test
	void test2(){
		loginPage.setTxtUsername("sanjay31786");
		loginPage.setTxtPassword("mandal");
		loginPage.setBtnLogin();
		
	}
}
