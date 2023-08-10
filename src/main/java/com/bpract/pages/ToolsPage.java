package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.TableUtility;
import com.bpract.utilities.WaitUtility;

public class ToolsPage {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(xpath="//h4[contains(text(), \"Documents \")]")
	WebElement documentsPageTitle;
	@FindBy(name="add")
	WebElement fileUploadBtn;
	@FindBy(xpath="//h2[contains(text(), \"Add Document\")]")
	WebElement addDocumentPopUpTile;
	@FindBy(name="title")
	WebElement addDocumentTitle;
	@FindBy(name="sort_order")
	WebElement addDocumentSortOrder;
	@FindBy(name="document_url")
	WebElement addDocumentUrl;
	@FindBy(name="submit")
	WebElement addDocumentSubmitBtn;
	@FindBy(xpath="//p[contains(text(), \"title is a required field\")]")
	WebElement addDocumentTitleRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Sort order is required\")]")
	WebElement addDocumentSortOrderRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Select an Doc\")]")
	WebElement addDocumentUrlRequiredMsg;
	@FindBy(xpath="//*[@name=\"tools-documents\"]/tbody")
	WebElement documentTable;
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/main/div/div/div[3]/nav/ul/li[2]/button")
	WebElement endOfDocPage;
	
	public ToolsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDocumentsPageTitle() {
		waitutility.waitForAnElement(documentsPageTitle, driver);
		String documentsPageTitleText = documentsPageTitle.getText();
		return documentsPageTitleText;
	}
	public void clickFileUploadBtn() {
		fileUploadBtn.click();
	}
	public String getaddDocumentPopUpTile() {
		waitutility.waitForAnElement(addDocumentPopUpTile, driver);
		String addDocumentPopUpTileText = addDocumentPopUpTile.getText();
		return addDocumentPopUpTileText;
	}
	public void enterAddDocumentTitle(String strAddDocumentTitle) {
		waitutility.waitForAnElement(addDocumentTitle, driver);
		addDocumentTitle.sendKeys(strAddDocumentTitle);
	}
	public void enterAddDocumentSortOrder(String strAddDocumentSortOrder) {
		addDocumentSortOrder.sendKeys(strAddDocumentSortOrder);
	}
	public void uploadAddDocumentUrl(String strAddDocumentUrl) {
		pageutility.uploadFiles(addDocumentUrl, driver, strAddDocumentUrl);
	}
	public void clickAddDocumentSubmitBtn() {
		addDocumentSubmitBtn.click();
	}
	public void addDocument(String strAddDocumentTitle, String strAddDocumentSortOrder, String strAddDocumentUrl) {
		this.enterAddDocumentTitle(strAddDocumentTitle);
		this.enterAddDocumentSortOrder(strAddDocumentSortOrder);
		this.uploadAddDocumentUrl(strAddDocumentUrl);
		this.clickAddDocumentSubmitBtn();
	}
	public void searchInTableForDocument(String strDocName, String strSortOrder) {
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(documentTable, driver);
		tableutility.searchInDocumentsTable(documentTable, driver, strDocName, strSortOrder);
	}
	public String getAddDocumentTitleRequiredMsg() {
		waitutility.waitForAnElement(addDocumentTitleRequiredMsg, driver);
		String addDocumentTitleRequiredMsgText = addDocumentTitleRequiredMsg.getText();
		return addDocumentTitleRequiredMsgText;
	}
	public String getAddDocumentSortOrderRequiredMsg() {
		waitutility.waitForAnElement(addDocumentSortOrderRequiredMsg, driver);
		String addDocumentSortOrderRequiredMsgText = addDocumentSortOrderRequiredMsg.getText();
		return addDocumentSortOrderRequiredMsgText;
	}
	public String getAddDocumentUrlRequiredMsg() {
		waitutility.waitForAnElement(addDocumentUrlRequiredMsg, driver);
		String addDocumentUrlRequiredMsgText = addDocumentUrlRequiredMsg.getText();
		return addDocumentUrlRequiredMsgText;
	}
	
}
