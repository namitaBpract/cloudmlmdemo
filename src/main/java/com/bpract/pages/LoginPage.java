package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	@FindBy(id="mui-1")
	WebElement emailidLogin;
	@FindBy(id="mui-2")
	WebElement passwordLogin;
	@FindBy(name="remember")
	WebElement rememberme;
	@FindBy(xpath="//button[@id=\"mui-3\"]")
	WebElement loginButton;
	@FindBy(xpath="/html/head/title")
	WebElement titleOfPage;

	@FindBy(xpath="//*[contains(text(),\"Wrong credentials!\")]")
	WebElement wrongCredentialsMsg;

	@FindBy(xpath="//*[contains(text(),\"Email must be a valid email address\")]")
	WebElement invalidEmailMsg;

	@FindBy(xpath="//*[contains(text(),\"Email is required\")]")
	WebElement blankEmailMsg;

	@FindBy(xpath="//*[contains(text(),\"Password is required\")]")
	WebElement blankPasswordMsg;
	
	@FindBy(xpath="//*[contains(text(),\"Forgot password?\")]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//*[contains(text(),\"Get started\")]")
	WebElement getStartedLink;

	WaitUtility waitutility = new WaitUtility();

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmailId(String strEid) {
		emailidLogin.sendKeys(strEid);
	}
	public void enterPassword(String strPwd) {
		passwordLogin.sendKeys(strPwd);
	}
	public void checkRememberMe() {
		rememberme.click();
	}
	
	public String pageTitle() {
		return titleOfPage.getText();
	}
	public HomePageUser loginUser(String strEid, String strPwd) {
		this.enterEmailId(strEid);
		this.enterPassword(strPwd);
		//this.checkRememberMe();
		this.loginButton.click();
		return new HomePageUser(driver);
	}
	
	public HomePage loginAdmin(String strEid, String strPwd) {
		this.enterEmailId(strEid);
		this.enterPassword(strPwd);
		//this.checkRememberMe();
		this.loginButton.click();
		return new HomePage(driver);
	}

	public String getWrongCredMsg() {
		waitutility.waitForAnElement(wrongCredentialsMsg, driver);
		String wrngCredMsg = wrongCredentialsMsg.getText();
		return wrngCredMsg;
	}

	public String getInvalidEmailMsg() {
		waitutility.waitForAnElement(invalidEmailMsg, driver);
		String invalidEmailMsgText = invalidEmailMsg.getText();
		return invalidEmailMsgText;
	}

	public String getBlankEmailMsg() {
		waitutility.waitForAnElement(blankEmailMsg, driver);
		String blankEmailMsgText = blankEmailMsg.getText();
		return blankEmailMsgText;
	}

	public String getBlankPasswordMsg() {
		waitutility.waitForAnElement(blankPasswordMsg, driver);
		String blankPasswordMsgText = blankPasswordMsg.getText();
		return blankPasswordMsgText;
	}
	
	public void clickGetStarted() {
		getStartedLink.click();
	}
	
	public RegisterNewMemberPage getStarted() {
		this.clickGetStarted();
		return new RegisterNewMemberPage(driver);
	}
	
	public void clickForgotPassword() {
		forgotPasswordLink.click();
	}
	
	public ResetPasswordPage forgorPassword() {
		this.clickForgotPassword();
		return new ResetPasswordPage(driver);
	}
	
}
