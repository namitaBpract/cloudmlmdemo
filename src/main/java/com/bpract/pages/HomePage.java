package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();

	@FindBy(xpath="//div[contains(text(),\"Dashboard\")]")
	WebElement titleOfDashboard;
	
	@FindBy(xpath="//div[contains(text(),\"My Profile\")]")
	WebElement myProfile;
	@FindBy(xpath="//h4[starts-with(text(),\"Profile\")]")
	WebElement profileMsg;

	@FindBy(xpath="//button[contains(text(),\"Edit Info\")]")
	WebElement editInfoButton;
	@FindBy(xpath="//button[contains(text(),\"Settings\")]")
	WebElement myProfileSettings;
	
	@FindBy(xpath="//div[contains(text(),\"Communication\")]")
	WebElement communication;
	@FindBy(xpath="//div[contains(text(),\"Blog\")]")
	WebElement blog;
	@FindBy(xpath="//div[contains(text(), \"Help Center\")]")
	WebElement helpCenter;
	@FindBy(xpath="//div[contains(text(),\"Articles\")]")
	WebElement articles;
	
	
	@FindBy(xpath="//div[contains(text(), \"Tools\")]")
	WebElement tools;
	@FindBy(xpath="//div[contains(text(), \"Documents\")]")
	WebElement documents;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getDashboardTitle() {
		waitutility.waitForAnElement(titleOfDashboard, driver);
		String tle = titleOfDashboard.getText();
		return tle;
	}
	
	public void navigateToProfile() {
		waitutility.waitForAnElement(myProfile, driver);
		myProfile.click();
	}
	public String getProfileText() {
		waitutility.waitForAnElement(profileMsg, driver);
		String profileMsgTxt = profileMsg.getText();
		return profileMsgTxt;
	}
	public void navigateToEditInfo() {
		waitutility.waitForAnElement(editInfoButton, driver);
		editInfoButton.click();
	}
	public ProfilePage goToEditInfo() {
		this.navigateToProfile();
		this.navigateToEditInfo();
		return new ProfilePage(driver);
	}
	
	public void clickCommunication() {
		communication.click();
	}
	public void clickHelpCenter() {
		waitutility.waitForAnElement(helpCenter, driver);
		pageutility.scrollToElement(helpCenter, driver);
		helpCenter.click();
	}
	public CreateTicketPageAdmin navigateToCreateTicket() {
		this.clickCommunication();
		this.clickHelpCenter();
		return new CreateTicketPageAdmin(driver);
	}
	public void clickArticles() {
		waitutility.waitForAnElement(articles, driver);
		pageutility.scrollToElement(articles, driver);
		articles.click();
	}
	public CommunicationPage navigateToArticles() {
		this.clickCommunication();
		this.clickArticles();
		return new CommunicationPage(driver);
	}
	
	public void clickTools() {
		tools.click();
	}
	public void clickDocuments() {
		waitutility.waitForAnElement(documents, driver);
		documents.click();
	}
	public ToolsPage navigateToToolsDocuments() {
		this.clickTools();
		this.clickDocuments();
		return new ToolsPage(driver);
	}
	
}
