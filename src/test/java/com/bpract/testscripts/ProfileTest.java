package com.bpract.testscripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.HomePage;
import com.bpract.pages.HomePageUser;
import com.bpract.pages.LoginPage;
import com.bpract.pages.ProfilePage;

public class ProfileTest extends TestHelper{
	LoginPage loginpage;
	HomePage homepage;
	HomePageUser homepageuser;
	ProfilePage profilepage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@Test
	public void verifyProfileImageUpload() throws AWTException {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("namita+1@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToEditInfo();
		Assert.assertTrue(profilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are in Edit Info Page!!!", true);
		profilepage.uploadProfileImage("C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\cute-panda-with-coffee-cartoon-illustration-vector.jpg");
	}
//	@Test(priority=2)
	public void verifyEditInfoForUserWithValidData() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("katherine@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToEditInfo();
		Assert.assertTrue(profilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are in Edit Info Page!!!", true);
		profilepage.updateditInfo("Katherine", "Bpract", "female", "United States of America", "California", "San Fransisco", "670000", "0123456789");
		profilepage.clickOnProfile();
		Assert.assertTrue(profilepage.getNameFromProfile().contains("Katherine Bpract"));
		Reporter.log("Full Name Updated", true);
	}
	
//	@Test(priority=0)
	public void verifyEditInfoForUserWithBlankFields() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("katherine@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToEditInfo();
		Assert.assertTrue(profilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are in Edit Info Page!!!", true);
		profilepage.clickSaveChanges();
//		profilepage.editInfo(" ", " ", " ", " ", " ", " ", " ", " ");
		Assert.assertTrue(profilepage.getFirstNameRequiredMsg().contains("First Name is required field"));
		Reporter.log("First Name Required Msg found", true);
		Assert.assertTrue(profilepage.getLastNameRequiredMsg().contains("Last Name is a required field"));
		Reporter.log("Last Name Required Msg found", true);
		Assert.assertTrue(profilepage.getGenderRequiredMsg().contains("Gender is required"));
		Reporter.log("Gender Required Msg found", true);
		Assert.assertTrue(profilepage.getCountryRequiredMsg().contains("Country is required"));
		Reporter.log("Country Required Msg found", true);
		Assert.assertTrue(profilepage.getStateRequiredMsg().contains("State is required"));
		Reporter.log("State Required Msg found", true);
		Assert.assertTrue(profilepage.getCityRequiredMsg().contains("City is required"));
		Reporter.log("City Required Msg found", true);
		Assert.assertTrue(profilepage.getZipcodeRequiredMsg().contains("Zipcode is required"));
		Reporter.log("Zipcode Required Msg found", true);
		Assert.assertTrue(profilepage.getMobileRequiredMsg().contains("Mobile is required"));
		Reporter.log("Mobile Required Msg found", true);
	}
	
//	@Test(priority=1)
	public void verifyEditInfoForUserWithMobileValidation() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("katherine@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToEditInfo();
		Assert.assertTrue(profilepage.getEditInfoPageMsg().contains("Social Media Scope"));
		Reporter.log("You are in Edit Info Page!!!", true);
		profilepage.editInfo("Ryan", "Bpract", "male", "United States of America", "California", "San Fransisco", "923001", "01234567890123");
		Assert.assertTrue(profilepage.getMobileNumberNotValidMsg().contains("Enter a valid phone number"));
		Reporter.log("Valid Mobile Required Msg found", true);
	}
	
//	@Test(priority=5)
	public void verifyPasswordChangeWithValidData() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("katherine@bpract.com", "87654321");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToProfileSetting();
		Assert.assertTrue(profilepage.getSettingsPageMsg().contains("Account Settings"));
		Reporter.log("You are in Profile Settings Page!", true);
		profilepage.updatePassword("12345678", "12345678");
	}
	
//	@Test(priority=3)
	public void verifyPasswordChangeWithBlankData() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("namita@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToProfileSetting();
		Assert.assertTrue(profilepage.getSettingsPageMsg().contains("Account Settings"));
		Reporter.log("You are in Profile Settings Page!", true);
		profilepage.updatePassword("", "");
		Assert.assertTrue(profilepage.getBlankPasswordValidationMsg().contains("Password must be at least 8 characters"));
		Reporter.log("Blank Password Validation Msg found!", true);
	}
	
//	@Test(priority=4)
	public void verifyPasswordChangeWithMismatchingData() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("namita@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		profilepage = homepageuser.navigateToProfile();
		Assert.assertTrue(profilepage.getProfileText().contains("Profile"));
		Reporter.log("You are in Profile Page!", true);
		profilepage.navigateToProfileSetting();
		Assert.assertTrue(profilepage.getSettingsPageMsg().contains("Account Settings"));
		Reporter.log("You are in Profile Settings Page!", true);
		profilepage.updatePassword("12345678", "123456789");
		Assert.assertTrue(profilepage.getPasswordMismatchMsg().contains("Passwords must match"));
		Reporter.log("Password Mismatch Msg found!", true);
	}
}
