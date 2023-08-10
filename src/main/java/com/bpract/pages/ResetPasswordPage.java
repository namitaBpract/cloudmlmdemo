package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.WaitUtility;

public class ResetPasswordPage {
	WebDriver driver;
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement emailForPasswordReset;
	@FindBy(xpath="//*[contains(text(),\"Forgot your password?\")]")
	WebElement passwordResetPageMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Reset Password\")]")
	WebElement resetPasswordBtn;
	@FindBy(xpath="//*[contains(text(),\"Request sent successfully\")]")
	WebElement emailSentMsgPasswordReset;
	@FindBy(xpath="//*[contains(text(),\"Email is required\")]")
	WebElement emailRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Email must be a valid email address\")]")
	WebElement invalidEmailFormatMsg;
	@FindBy(xpath="//p[contains(text(), \"Not a registered user mail\")]")
	WebElement notRegisteredEmailMsg;
	
	
	WaitUtility waitutility = new WaitUtility();
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailIdForPwdReset(String strEmailPwdReset) {
		emailForPasswordReset.sendKeys(strEmailPwdReset);
	}
	public void clickResetPwdBtn() {
		resetPasswordBtn.click();
	}
	public void resetPassword(String strEmailPwdReset) {
		this.enterEmailIdForPwdReset(strEmailPwdReset);
		this.clickResetPwdBtn();
	}
	
	public String getpasswordResetPageMsg() {
		waitutility.waitForAnElement(passwordResetPageMsg, driver);
		String passwordResetPageMsgText = passwordResetPageMsg.getText();
		return passwordResetPageMsgText;
	}
	
	public String getEmailSentMsgPasswordReset() {
		waitutility.waitForAnElement(emailSentMsgPasswordReset, driver);
		String emailSentMsgPasswordResetText = emailSentMsgPasswordReset.getText();
		return emailSentMsgPasswordResetText;
	}
	
	public String getEmailRequiredMsg() {
		waitutility.waitForAnElement(emailRequiredMsg, driver);
		String emailRequiredMsgText = emailRequiredMsg.getText();
		return emailRequiredMsgText;
	}
	
	public String getInvalidEmailFormatMsg() {
		waitutility.waitForAnElement(invalidEmailFormatMsg, driver);
		String invalidEmailFormatMsgText = invalidEmailFormatMsg.getText();
		return invalidEmailFormatMsgText;
	}
	
	public String getNotRegisteredEmailMsg() {
		waitutility.waitForAnElement(notRegisteredEmailMsg, driver);
		String notRegisteredEmailMsgText = notRegisteredEmailMsg.getText();
		return notRegisteredEmailMsgText;
	}
}
