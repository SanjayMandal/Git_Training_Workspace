package sa.unitTestClass;




import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import sa.pageClass.LoginPage;

public class LoginPageTest {

	LoginPage loginPage;
	
	@BeforeClass
	public void initPage(){
		loginPage =new LoginPage();
	}
	
	@Test
	public void txtUsernameTest(){
		loginPage.setTxtUsername("sanjay31786");
		Assert.assertEquals(loginPage.getTxtUsername(),"sanjay3178");
		
	}
	
}
