
package com.bpract.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.HomePage;
import com.bpract.pages.HomePageUser;
import com.bpract.pages.LoginPage;
import com.bpract.pages.ResetPasswordPage;

public class LoginTest extends TestHelper{
	LoginPage loginpage;
	HomePage homepage;
	ResetPasswordPage resetpasswordpage;
	HomePageUser homepageuser;

	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
//	@DataProvider(name="ValidLogin")
//	public Object[][]getData(){
//		String excelpath = System.getProperty("user.dir");
//		ExcelDataProvider exceldataprovider = new ExcelDataProvider();
//		Object data[][] = exceldataprovider.testData(excelpath, "Sheet1");
//		return data;
//	}
	
	@Test(priority=0)
	public void verifyLoginWithValidDataUser() {
		loginpage = new LoginPage(driver);
		homepageuser = loginpage.loginUser("namita@bpract.com", "12345678");
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
	}
	
//	@Test(priority=1)
	public void verifyUserLoginWithInvalidData() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("namita@bpract.com", "112345678");
		Assert.assertTrue(loginpage.getWrongCredMsg().contains("Wrong credentials!"));
		Reporter.log("Entered Credentials are wrong!!!",true);
	}

//	@Test(priority=3)
	public void verifyUserLoginWithInvalidEmailFormat() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("tester@bpract", "123456");
		Assert.assertTrue(loginpage.getInvalidEmailMsg().contains("Email must be a valid email address"));
		Reporter.log("Entered emaild id is invalid!!!", true);
	}

//	@Test(priority=2)
	public void verifyUserLoginWithBlankEmailPassword() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("", "");
		Assert.assertTrue(loginpage.getBlankEmailMsg().contains("Email is required"));
		Reporter.log("Email ID field is blank!!!", true);
		Assert.assertTrue(loginpage.getBlankPasswordMsg().contains("Password is required"));
		Reporter.log("Password field is blank!!!", true);
	}
	
//	@Test
	public void verifyResetPassword() {
		loginpage = new LoginPage(driver);
		resetpasswordpage = loginpage.forgorPassword();
		Assert.assertTrue(resetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("Password Reset Page!!!", true);
		resetpasswordpage.resetPassword("namita@bpract.com");
		Assert.assertTrue(resetpasswordpage.getEmailSentMsgPasswordReset().contains("Request sent successfully"));
		Reporter.log("Link sent to email!!!", true);
	}
	
//	@Test
	public void verifyBlankEmailForResetPassword() {
		loginpage = new LoginPage(driver);
		resetpasswordpage = loginpage.forgorPassword();
		Assert.assertTrue(resetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("Password Reset Page!!!", true);
		resetpasswordpage.resetPassword("");
		Assert.assertTrue(resetpasswordpage.getEmailRequiredMsg().contains("Email is required"));
		Reporter.log("Email id required msg found!", true);
	}
//	@Test
	public void verifyInvalidEmailForResetPassword() {
		loginpage = new LoginPage(driver);
		resetpasswordpage = loginpage.forgorPassword();
		Assert.assertTrue(resetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("Password Reset Page!!!", true);
		resetpasswordpage.resetPassword("namita@bpract");
		Assert.assertTrue(resetpasswordpage.getInvalidEmailFormatMsg().contains("Email must be a valid email address"));
		Reporter.log("Email format wrong message found", true);
	}
//	@Test
	public void verifyNotRegisteredEmailForResetPassword() {
		loginpage = new LoginPage(driver);
		resetpasswordpage = loginpage.forgorPassword();
		Assert.assertTrue(resetpasswordpage.getpasswordResetPageMsg().contains("Forgot your password?"));
		Reporter.log("Password Reset Page!!!", true);
		resetpasswordpage.resetPassword("namitaaaa@bpract.com");
		Assert.assertTrue(resetpasswordpage.getNotRegisteredEmailMsg().contains("Not a registered user mail"));
		Reporter.log("Not registered email msg found", true);
	}
	
}
