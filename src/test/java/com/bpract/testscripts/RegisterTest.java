package com.bpract.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.HomePage;
import com.bpract.pages.HomePageUser;
import com.bpract.pages.LoginPage;
import com.bpract.pages.ProfilePage;
import com.bpract.pages.RegisterNewMemberPage;

public class RegisterTest extends TestHelper{
	
	LoginPage loginpage;
	RegisterNewMemberPage registernewmemberpage;
	HomePageUser homepageuser;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@Test
	public void verifyRegisterationWithValidData() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		homepageuser = registernewmemberpage.register("evelyn@bpract.com", "evelyn", "12345678", "12345678", "");
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Registeration Successful!!!", true);
		
	}
//	@Test
	public void verifyRegisterationWithBlankData() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		registernewmemberpage.register("", "", "", "", "");
		Assert.assertTrue(registernewmemberpage.getRegisterEmailRequiredMsg().contains("Email is required"));
		Reporter.log("Email Required Message found,", true);
		Assert.assertTrue(registernewmemberpage.getRegisterUsernameRequiredMsg().contains("User Name is required"));
		Reporter.log("Username Required Message found,", true);
		Assert.assertTrue(registernewmemberpage.getRegisterPasswordRequiredMsg().contains("Password must be at least 8 characters"));
		Reporter.log("Password Required Message found,", true);
	}
//	@Test
	public void verifyRegisterationForPasswordMismatch() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		registernewmemberpage.register("namita+1@bpract.com", "namita1", "123456789", "12345678", "");
		Assert.assertTrue(registernewmemberpage.getRegisterPasswordMismatchMsg().contains("Password must match"));
		Reporter.log("Password Mistmatch message found", true);
	}
//	@Test
	public void verifyRegistrationForEmailAlreadyTaken() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		registernewmemberpage.register("namita@bpract.com", "namita1", "12345678", "12345678", "");
		Assert.assertTrue(registernewmemberpage.getRegisterEmailAlreadyTakenMsg().contains("The email has already been taken."));
		Reporter.log("Email Already Taken Message found", true);
	}
//	@Test
	public void verifyRegistrationForUsernameAlreadyTaken() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		registernewmemberpage.register("namita+2@bpract.com", "namita", "12345678", "12345678", "");
		Assert.assertTrue(registernewmemberpage.getRegisterUsernameAlreadyTakenMsg().contains("The username has already been taken."));
		Reporter.log("Username Already Taken Message found", true);
	}
	
//	@Test
	public void verifyRegistrationForInvalidReferral() {
		loginpage = new LoginPage(driver);
		registernewmemberpage = loginpage.getStarted();
		registernewmemberpage.register("namita+2@bpract.com", "namita2", "12345678", "12345678", "mlm");
		Assert.assertTrue(registernewmemberpage.getRegisterInvalidReferralMsg().contains("The selected referral is invalid."));
		Reporter.log("Invalid referral Message found", true);
	}
	
}
