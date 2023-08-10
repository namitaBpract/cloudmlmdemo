package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.TableUtility;
import com.bpract.utilities.WaitUtility;

public class CommunicationPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(xpath="//span[contains(text(), \"Article Category\")]")
	WebElement articleCategory;
	@FindBy(xpath="//button[contains(text(), \"Article Category\")]")
	WebElement addArticleCategoryBtn;
	@FindBy(xpath="//h4[contains(text(), \"Articles\")]")
	WebElement articleMsg;
	@FindBy(name="add-article")
	WebElement addArticleBtn;
	@FindBy(xpath="//h2[contains(text(), \"Add Article Category\")]")
	WebElement addArticleCategoryPopupMsg;
	@FindBy(name="name")
	WebElement articleCategoryName;
	@FindBy(xpath="//p[contains(text(), \"Article Category Name is required\")]")
	WebElement articleCategoryNameRequiredMsg;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement articleCategoryDescription;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement articleCategoryDescriptionRequiredMsg;
	@FindBy(name="submit")
	WebElement articleCategorySubmitBtn;
	@FindBy(xpath="//h2[contains(text(), \"Create Article\")]")
	WebElement addArticlePopupMsg;
	@FindBy(name="title")
	WebElement articleName;
	@FindBy(xpath="//p[contains(text(), \"Title is required\")]")
	WebElement articleNameRequiredMsg;
	@FindBy(name="category_id")
	WebElement articleCategoryId;
	@FindBy(xpath="//p[contains(text(), \"Category is required\")]")
	WebElement articleCategoryIdRequiredMsg;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement articleDescription;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement articleDescriptionRequiredMsg;
	@FindBy(name="submit")
	WebElement articleSubmitBtn;

	public CommunicationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getArticleMsg() {
		waitutility.waitForAnElement(articleMsg, driver);
		String articleMsgText = articleMsg.getText();
		return articleMsgText;
	}
	public void clickArticleCategory() {
		waitutility.waitForAnElement(articleCategory, driver);
		articleCategory.click();
	}
	public void clickAddArticleCategoryBtn() {
		waitutility.waitForAnElement(addArticleCategoryBtn, driver);
		addArticleCategoryBtn.click();
	}
	public String getAddArticleCategoryPopupMsg() {
		waitutility.waitForAnElement(addArticleCategoryPopupMsg, driver);
		String addArticleCategoryPopupMsgText = addArticleCategoryPopupMsg.getText();
		return addArticleCategoryPopupMsgText;
	}
	public void enterArticleCategoryName(String strArticleCategoryName) {
		waitutility.waitForAnElement(articleCategoryName, driver);
		articleCategoryName.sendKeys(strArticleCategoryName);
	}
	public void enterArticleCategoryDescription(String strArticleCategoryDescription) {
		articleCategoryDescription.sendKeys(strArticleCategoryDescription);
	}
	public void clickArticleCategorySubmitBtn() {
		articleCategorySubmitBtn.click();
	}
	public String getArticleCategoryNameRequiredMsg() {
		waitutility.waitForAnElement(articleCategoryNameRequiredMsg, driver);
		String articleCategoryNameRequiredMsgText = articleCategoryNameRequiredMsg.getText();
		return articleCategoryNameRequiredMsgText;
	}
	public String getArticleCategoryDescriptionRequiredMsg() {
		waitutility.waitForAnElement(articleCategoryDescriptionRequiredMsg, driver);
		String articleCategoryDescriptionRequiredMsgText = articleCategoryDescriptionRequiredMsg.getText();
		return articleCategoryDescriptionRequiredMsgText;
	}
	public void addArticleCategory(String strArticleCategoryName, String strArticleCategoryDescription) {
		this.enterArticleCategoryName(strArticleCategoryName);
		this.enterArticleCategoryDescription(strArticleCategoryDescription);
		this.clickArticleCategorySubmitBtn();
	}
	public void clickaddArticleBtn() {
		waitutility.waitForAnElement(addArticleBtn, driver);
		addArticleBtn.click();
	}
	public String getAddArticlePopupMsg() {
		waitutility.waitForAnElement(addArticlePopupMsg, driver);
		String addArticlePopupMsgText = addArticlePopupMsg.getText();
		return addArticlePopupMsgText;
	}
	public void enterArticleName(String strArticleName) {
		waitutility.waitForAnElement(articleName, driver);
		articleName.sendKeys(strArticleName);
	}
	public void enterArticleCategoryId(String strArticleCategoryId) {
		waitutility.waitForAnElement(articleCategoryId, driver);
		pageutility.selectByValue(articleCategoryId, driver, strArticleCategoryId);
	}
	public void enterArticleDescription(String strArticleDescription) {
		waitutility.waitForAnElement(articleDescription, driver);
		articleDescription.sendKeys(strArticleDescription);
	}
	public void clickArticleSubmitBtn() {
		waitutility.waitForAnElement(articleSubmitBtn, driver);
		articleSubmitBtn.click();
	}
	public String getArticleNameRequiredMsg() {
		waitutility.waitForAnElement(articleNameRequiredMsg, driver);
		String articleNameRequiredMsgText = articleNameRequiredMsg.getText();
		return articleNameRequiredMsgText;
	}
	public String getArticleCategoryIdRequiredMsg() {
		String articleCategoryIdRequiredMsgText = articleCategoryIdRequiredMsg.getText();
		return articleCategoryIdRequiredMsgText;
	}
	public String getarticleDescriptionRequiredMsg() {
		String articleDescriptionRequiredMsgText = articleDescriptionRequiredMsg.getText();
		return articleDescriptionRequiredMsgText;
	}
	public void addArticle(String strArticleName, String strArticleCategoryId, String strArticleDescription) {
		this.enterArticleName(strArticleName);
		this.enterArticleCategoryId(strArticleCategoryId);
		this.enterArticleDescription(strArticleDescription);
		this.clickArticleSubmitBtn();
	}
}
