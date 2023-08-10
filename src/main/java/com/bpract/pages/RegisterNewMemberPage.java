package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.WaitUtility;

public class RegisterNewMemberPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),\"Register New Member\")]")
	WebElement newMemeberRegisterPageMsg;
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement emailIdRegister;
	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement usernameRegister;
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement passwordRegister;
	@FindBy(xpath="//input[@name=\"repassword\"]")
	WebElement rePasswordRegister;
	@FindBy(xpath="//input[@name=\"referral\"]")
	WebElement referralIdRegister;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Register\")]")
	WebElement registerButton;
	@FindBy(xpath="//p[contains(text(), \"Email is required\")]")
	WebElement registerEmailRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"User Name is required\")]")
	WebElement registerUsernameRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Password must be at least 8 characters\")]")
	WebElement registerPasswordRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Password must match\")]")
	WebElement registerPasswordMismatchMsg;
	@FindBy(xpath="//p[contains(text(), \"The email has already been taken.\")]")
	WebElement registerEmailAlreadyTakenMsg;
	@FindBy(xpath="//p[contains(text(), \"The username has already been taken.\")]")
	WebElement registerUsernameAlreadyTakenMsg;
	@FindBy(xpath="//p[contains(text(), \"The selected referral is invalid.\")]")
	WebElement registerInvalidReferralMsg;
	
	
	WaitUtility waitutility = new WaitUtility();
	
	public RegisterNewMemberPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailIdForRegister(String strRegEid) {
		waitutility.waitForAnElement(newMemeberRegisterPageMsg, driver);
		emailIdRegister.sendKeys(strRegEid);
	}
	public void enterUsernameForRegister(String strRefUName) {
		usernameRegister.sendKeys(strRefUName);
	}
	public void enterPasswordForRegister(String strRegPwd) {
		passwordRegister.sendKeys(strRegPwd);
	}
	public void reenterPasswordForRegister(String strRegRePwd) {
		rePasswordRegister.sendKeys(strRegRePwd);
	}
	public void enterReferralIdForReg(String strRegRefId) {
		//referralIdRegister.clear();
		referralIdRegister.sendKeys(strRegRefId);
	}
	public HomePageUser register(String strRegEid, String strRefUName, String strRegPwd, String strRegRePwd, String strRegRefId){
		this.enterEmailIdForRegister(strRegEid);
		this.enterUsernameForRegister(strRefUName);
		this.enterPasswordForRegister(strRegPwd);
		this.reenterPasswordForRegister(strRegRePwd);
		this.enterReferralIdForReg(strRegRefId);
		this.registerButton.click();
		return new HomePageUser(driver);
	}
	
	public String getRegisterEmailRequiredMsg() {
		String registerEmailRequiredMsgText = registerEmailRequiredMsg.getText();
		return registerEmailRequiredMsgText;
	}
	public String getRegisterUsernameRequiredMsg() {
		String registerUsernameRequiredMsgText = registerUsernameRequiredMsg.getText();
		return registerUsernameRequiredMsgText;
	}
	public String getRegisterPasswordRequiredMsg() {
		String registerPasswordRequiredMsgText = registerPasswordRequiredMsg.getText();
		return registerPasswordRequiredMsgText;
	}
	public String getRegisterPasswordMismatchMsg() {
		String registerPasswordMismatchMsgText = registerPasswordMismatchMsg.getText();
		return registerPasswordMismatchMsgText;
	}
	public String getRegisterEmailAlreadyTakenMsg() {
		waitutility.waitForAnElement(registerEmailAlreadyTakenMsg, driver);
		String registerEmailAlreadyTakenMsgText = registerEmailAlreadyTakenMsg.getText();
		return registerEmailAlreadyTakenMsgText;
	}
	public String getRegisterUsernameAlreadyTakenMsg() {
		waitutility.waitForAnElement(registerUsernameAlreadyTakenMsg, driver);
		String registerUsernameAlreadyTakenMsgText = registerUsernameAlreadyTakenMsg.getText();
		return registerUsernameAlreadyTakenMsgText;
	}
	public String getRegisterInvalidReferralMsg() {
		waitutility.waitForAnElement(registerInvalidReferralMsg, driver);
		String registerInvalidReferralMsgText = registerInvalidReferralMsg.getText();
		return registerInvalidReferralMsgText;
	}
}
