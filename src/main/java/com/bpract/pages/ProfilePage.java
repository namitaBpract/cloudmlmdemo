package com.bpract.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.WaitUtility;

public class ProfilePage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	@FindBy(name="edit-info")
	WebElement editInfoButton;
	@FindBy(name="settings")
	WebElement myProfileSettings;
	@FindBy(xpath="//h4[starts-with(text(),\"Profile\")]")
	WebElement profileMsg;
	@FindBy(id="profile-image-upload")
	WebElement uploadPhotoBtn;
	
	@FindBy(xpath="//h6[contains(text(), \"Social Media Scope\")]")
	WebElement editInfoPageMsg;
	@FindBy(name="first_name")
	WebElement firstName;
	@FindBy(name="last_name")
	WebElement lastName;
	@FindBy(name="gender")
	WebElement gender;
	@FindBy(name="country")
	WebElement country;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="zipcode")
	WebElement zipcode;
	@FindBy(name="mobile")
	WebElement phoneNumber;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),\"Save Changes\")]")
	WebElement saveChangesBtn;
	
	@FindBy(xpath="//p[contains(text(), \"First Name is  required field\")]")
	WebElement firstNameRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Last Name is a required field\")]")
	WebElement lastNameRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Gender is required\")]")
	WebElement genderRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Country is required\")]")
	WebElement countryRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"State is required\")]")
	WebElement stateRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"City is required\")]")
	WebElement cityRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Zipcode is required\")]")
	WebElement zipcodeRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Mobile is required\")]")
	WebElement mobileRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Enter a valid phone number\")]")
	WebElement mobileNumberNotValidMsg;
	
	@FindBy(name="userName")
	WebElement usernameFromProfile;
	@FindBy(name="firstnameLastname")
	WebElement nameFromProfile;
	@FindBy(name="gender")
	WebElement genderFromProfile;
	@FindBy(name="mobile")
	WebElement mobileFromProfile;
	@FindBy(name="city")
	WebElement cityFromProfile;
	@FindBy(name="zipcode")
	WebElement zipcodeFromProfile;
	
	@FindBy(xpath="//h4[contains(text(), \"Profile\")]")
	WebElement profileTextOnTopOfPage;
	@FindBy(name="profile")
	WebElement profileButton;
	
	@FindBy(xpath="//h6[contains(text(), \"Account Settings\")]")
	WebElement settingsPageMsg;
	@FindBy(name="password")
	WebElement accountSettingsPassword;
	@FindBy(name="confirmNewPassword")
	WebElement accountSettingsConfirmPassword;
	@FindBy(name="submit")
	WebElement saveChangesAccountSettings;
	@FindBy(xpath="//p[contains(text(), \"Password must be at least 8 characters\")]")
	WebElement blankPasswordValidationMsg;
	@FindBy(xpath="//p[contains(text(), \"Passwords must match\")]")
	WebElement passwordMismatchMsg;
	
	
	public ProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToEditInfo() {
		waitutility.waitForAnElement(editInfoButton, driver);
		editInfoButton.click();
	}
	public void navigateToProfileSetting() {
		waitutility.waitForAnElement(myProfileSettings, driver);
		myProfileSettings.click();
	}
	public String getProfileText() {
		waitutility.waitForAnElement(profileMsg, driver);
		String profileMsgTxt = profileMsg.getText();
		return profileMsgTxt;
	}
	
	public String getEditInfoPageMsg() {
		waitutility.waitForAnElement(editInfoPageMsg, driver);
		String editInfoPageMsgText = editInfoPageMsg.getText();
		return editInfoPageMsgText;
	}
		
	public void uploadProfileImage(String strPath) throws AWTException {
		pageutility.scrollToElement(editInfoButton, driver);
//		waitutility.waitUntilClickable(uploadPhotoBtn, driver);
		pageutility.uploadImage(uploadPhotoBtn, driver, strPath);
	}
	
	public void enterFirstName(String strFirstName) {
		waitutility.waitForAnElement(phoneNumber, driver);
		pageutility.scrollToElement(phoneNumber, driver);
		firstName.sendKeys(strFirstName);
	}
	public void enterLastName(String strLastName) {
		lastName.sendKeys(strLastName);
	}
	public void enterGender(String strGender) {
		pageutility.selectByVisibleText(gender, driver, strGender);
	}
	public void enterCountry(String strCountry) {
		pageutility.selectByVisibleText(country, driver, strCountry);
	}
	public void enterState(String strState) {
		state.sendKeys(strState);
	}
	public void enterCity(String strCity) {
		city.sendKeys(strCity);
	}
	public void enterZipcode(String strZipcode) {
		zipcode.sendKeys(strZipcode);
	}
	public void enterPhoneNumber(String strPhoneNumber) {
		phoneNumber.sendKeys(strPhoneNumber);
	}
	public void clickSaveChanges() {
		waitutility.waitForAnElement(saveChangesBtn, driver);
		pageutility.scrollToElement(saveChangesBtn, driver);
		saveChangesBtn.click();
	}
	public void clearFirstName() {
		waitutility.waitForAnElement(phoneNumber, driver);
		pageutility.clearWebField(firstName);
	}
	public void clearLastName() {
		pageutility.clearWebField(lastName);
	}
	public void clearState() {
		pageutility.clearWebField(state);
	}
	public void clearCity() {
		pageutility.clearWebField(city);
	}
	public void clearZipCode() {
		pageutility.clearWebField(zipcode);
	}
	public void clearPhoneNumber() {
		pageutility.clearWebField(phoneNumber);
	}
	public ProfilePage editInfo(String strFirstName, String strLastName, String strGender, String strCountry, String strState, String strCity, String strZipcode, String strPhoneNumber) {
		this.enterFirstName(strFirstName);
		this.enterLastName(strLastName);
		this.enterGender(strGender);
		this.enterCountry(strCountry);
		this.enterState(strState);
		this.enterCity(strCity);
		this.enterZipcode(strZipcode);
		this.enterPhoneNumber(strPhoneNumber);
		this.clickSaveChanges();
		return new ProfilePage(driver);
	}	
	public ProfilePage updateditInfo(String strFirstName, String strLastName, String strGender, String strCountry, 
			String strState, String strCity, String strZipcode, String strPhoneNumber) {
		this.clearFirstName();
		this.enterFirstName(strFirstName);
		this.clearLastName();
		this.enterLastName(strLastName);
		this.enterGender(strGender);
		this.enterCountry(strCountry);
		this.clearState();
		this.enterState(strState);
		this.clearCity();
		this.enterCity(strCity);
		this.clearZipCode();
		this.enterZipcode(strZipcode);
		this.clearPhoneNumber();
		this.enterPhoneNumber(strPhoneNumber);
		this.clickSaveChanges();
		return new ProfilePage(driver);
	}	
	public String getFirstNameRequiredMsg() {
		waitutility.waitForAnElement(firstNameRequiredMsg, driver);
		String firstNameRequiredMsgText = firstNameRequiredMsg.getText();
		return firstNameRequiredMsgText;		
	}
	public String getLastNameRequiredMsg() {
		waitutility.waitForAnElement(lastNameRequiredMsg, driver);
		String lastNameRequiredMsgText = lastNameRequiredMsg.getText();
		return lastNameRequiredMsgText;
	}
	public String getGenderRequiredMsg() {
		waitutility.waitForAnElement(genderRequiredMsg, driver);
		String genderRequiredMsgText = genderRequiredMsg.getText();
		return genderRequiredMsgText;
	}
	public String getCountryRequiredMsg() {
		waitutility.waitForAnElement(countryRequiredMsg, driver);
		String countryRequiredMsgText = countryRequiredMsg.getText();
		return countryRequiredMsgText;
	}
	public String getStateRequiredMsg() {
		waitutility.waitForAnElement(stateRequiredMsg, driver);
		String stateRequiredMsgText = stateRequiredMsg.getText();
		return stateRequiredMsgText;
	}
	public String getCityRequiredMsg() {
		waitutility.waitForAnElement(cityRequiredMsg, driver);
		String cityRequiredMsgText = cityRequiredMsg.getText();
		return cityRequiredMsgText;
	}
	public String getZipcodeRequiredMsg() {
		waitutility.waitForAnElement(zipcodeRequiredMsg, driver);
		String zipcodeRequiredMsgText = zipcodeRequiredMsg.getText();
		return zipcodeRequiredMsgText;
	}
	public String getMobileRequiredMsg() {
		waitutility.waitForAnElement(mobileRequiredMsg, driver);
		String mobileRequiredMsgText = mobileRequiredMsg.getText();
		return mobileRequiredMsgText;
	}
	public String getMobileNumberNotValidMsg() {
		waitutility.waitForAnElement(mobileNumberNotValidMsg, driver);
		String mobileNumberNotValidMsgText = mobileNumberNotValidMsg.getText();
		return mobileNumberNotValidMsgText;
	}
	public void clickOnProfile() {
		pageutility.scrollToElement(profileTextOnTopOfPage, driver);
		profileButton.click();
	}
	public String getNameFromProfile() {
		waitutility.waitForAnElement(nameFromProfile, driver);
		String nameFromProfileText = nameFromProfile.getText();
		return nameFromProfileText;
	}
	public String getSettingsPageMsg() {
		waitutility.waitForAnElement(settingsPageMsg, driver);
		String settingsPageMsgText = settingsPageMsg.getText();
		return settingsPageMsgText;
	}
	public void enterNewPassword(String strAccountSettingsPassword) {
		waitutility.waitForAnElement(accountSettingsConfirmPassword, driver);
		accountSettingsPassword.sendKeys(strAccountSettingsPassword);
	}
	public void enterNewConfirmPassword(String strAccountSettingsConfirmPassword) {
		accountSettingsConfirmPassword.sendKeys(strAccountSettingsConfirmPassword);
	}
	public void clickSaveChangesAccountSettings() {
		saveChangesAccountSettings.click();
	}
	public void updatePassword(String strAccountSettingsPassword, String strAccountSettingsConfirmPassword) {
		this.enterNewPassword(strAccountSettingsPassword);
		this.enterNewConfirmPassword(strAccountSettingsConfirmPassword);
		this.clickSaveChangesAccountSettings();
	}
	public String getBlankPasswordValidationMsg() {
		waitutility.waitForAnElement(blankPasswordValidationMsg, driver);
		String blankPasswordValidationMsgText = blankPasswordValidationMsg.getText();
		return blankPasswordValidationMsgText;
	}
	public String getPasswordMismatchMsg() {
		waitutility.waitForAnElement(passwordMismatchMsg, driver);
		String passwordMismatchMsgText = passwordMismatchMsg.getText();
		return passwordMismatchMsgText;
	}
}

