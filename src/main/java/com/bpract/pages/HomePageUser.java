package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.WaitUtility;

public class HomePageUser {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	
	@FindBy(xpath="//*[contains(text(),\"Dashboard\")]")
	WebElement titleOfDashboard;
	
	@FindBy(xpath="//div[contains(text(),\"My Profile\")]")
	WebElement myProfile;
	
	@FindBy(xpath="//div[contains(text(), \"help Center\")]")
	WebElement helpCenter;
	@FindBy(xpath="//div[contains(text(), \"Support Tickets\")]")
	WebElement supportTicket;
	
	public HomePageUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String dashTitle() {
		waitutility.waitForAnElement(titleOfDashboard, driver);
		String tle = titleOfDashboard.getText();
		return tle;
	}
	public ProfilePage navigateToProfile() {
		waitutility.waitForAnElement(myProfile, driver);
		myProfile.click();
		return new ProfilePage(driver);
	}

	public void clickHelpCenter() {
		waitutility.waitForAnElement(helpCenter, driver);
		pageutility.scrollToElement(helpCenter, driver);
		helpCenter.click();
	}
	public void clickCreateTicket() {
		waitutility.waitForAnElement(supportTicket, driver);
//		pageutility.scrollToElement(createTicket, driver);
		supportTicket.click();
	}
	public void navigateToCreateTicket() {
		this.clickHelpCenter();
		this.clickCreateTicket();
	}
}
