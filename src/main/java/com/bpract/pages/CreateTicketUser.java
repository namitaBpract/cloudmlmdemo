package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.TableUtility;
import com.bpract.utilities.WaitUtility;

public class CreateTicketUser {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(xpath="//a[contains(text(), \"Create Ticket\")]")
	WebElement createTicketBtn;
	@FindBy(name="department_id")
	WebElement department;
	@FindBy(name="priority_id")
	WebElement priority;
	@FindBy(name="category_id")
	WebElement category;
	@FindBy(name="subject")
	WebElement subject;
	@FindBy(name="attachments_url")
	WebElement attachmentFile;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement description;
	@FindBy(xpath="//button[@name=\"sent-request\" and @type=\"submit\"]")
	WebElement sendRequestBtn;
	@FindBy(xpath="//p[contains(text(), \"Please Select a department\")]")
	WebElement documentRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Please Select a priority\")]")
	WebElement priorityRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Please Select a category\")]")
	WebElement categoryRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Subject is required\")]")
	WebElement subjectRequiredMsg;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement descriptionRequiredMsg;
	
	@FindBy(xpath="//table[@name=\"all-tickets\"]/tbody")
	WebElement userTicketTable;
	@FindBy(xpath="//*[@name=\"all-tickets\"]/tbody/tr[1]/td[2]")
	WebElement subjectFromTable;
	@FindBy(xpath="//*[@name=\"all-tickets\"]/tbody/tr[1]/td[4]")
	WebElement priorityFromTable;
	@FindBy(xpath="//*[@name=\"all-tickets\"]/tbody/tr[1]/td[5]")
	WebElement departmentFromTable;
	@FindBy(xpath="//*[@name=\"all-tickets\"]/tbody/tr[1]/td[6]")
	WebElement categoryFromTable;
	
	public CreateTicketUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateTicket() {
		waitutility.waitForAnElement(createTicketBtn, driver);
		createTicketBtn.click();
	}
	public void enterDepartment(String strDepartment) {
		waitutility.waitForAnElement(department, driver);
		pageutility.selectByVisibleText(department, driver, strDepartment);
	}
	public void enterPriority(String strPriority) {
		pageutility.selectByVisibleText(priority, driver, strPriority);
	}
	public void enterCategory(String strCategory) {
		pageutility.selectByVisibleText(category, driver, strCategory);
	}
	public void enterSubject(String strSubject) {
		subject.sendKeys(strSubject);
	}
	public void enterDescription(String strDescription) {
		description.sendKeys(strDescription);
	}
	public void uploadAttachment(String strPath) {
		waitutility.waitUntilClickable(attachmentFile, driver);
		pageutility.uploadFiles(attachmentFile, driver, strPath);
	}
	public void clickSendRequestBtn() {
		waitutility.waitForAnElement(sendRequestBtn, driver);
		sendRequestBtn.click();
	}
	public void createTicket(String strDepartment, String strPriority, String strCategory, String strSubject, String strPath,  String strDescription) {
		this.enterDepartment(strDepartment);
		this.enterPriority(strPriority);
		this.enterCategory(strCategory);
		this.enterSubject(strSubject);
		this.uploadAttachment(strPath);
		this.enterDescription(strDescription);
		this.clickSendRequestBtn();
	}
	
	public void searchingForCreatedTicket(String strSubjectCreated) {
		waitutility.waitForAnElement(userTicketTable, driver);
		tableutility.searchInUserTicketTable(userTicketTable, driver, strSubjectCreated);
	}
	public String getDocumentRequiredMsg() {
		waitutility.waitForAnElement(documentRequiredMsg, driver);
		String documentRequiredMsgText = documentRequiredMsg.getText();
		return documentRequiredMsgText;
	}
	public String getPriorityRequiredMsg() {
		waitutility.waitForAnElement(priorityRequiredMsg, driver);
		String priorityRequiredMsgText = priorityRequiredMsg.getText();
		return priorityRequiredMsgText;
	}
	public String getCategoryRequiredMsg() {
		waitutility.waitForAnElement(categoryRequiredMsg, driver);
		String categoryRequiredMsgText = categoryRequiredMsg.getText();
		return categoryRequiredMsgText;
	}
	public String getSubjectRequiredMsg() {
		waitutility.waitForAnElement(subjectRequiredMsg, driver);
		String subjectRequiredMsgText = subjectRequiredMsg.getText();
		return subjectRequiredMsgText;
	}
	public String getDescriptionRequiredMsg() {
		waitutility.waitForAnElement(descriptionRequiredMsg, driver);
		String descriptionRequiredMsgText = descriptionRequiredMsg.getText();
		return descriptionRequiredMsgText;
	}
	public String getSubjectFromTable() {
		waitutility.waitForAnElement(subjectFromTable, driver);
		String strSubjectValue = subjectFromTable.getText();
		return strSubjectValue;
	}
	public String getPriorityFromTable() {
		waitutility.waitForAnElement(priorityFromTable, driver);
		String strPriorityValue = priorityFromTable.getText();
		return strPriorityValue;
	}
	public String getDepartmentFromTable() {
		waitutility.waitForAnElement(departmentFromTable, driver);
		String strDepartmentValue = departmentFromTable.getText();
		return strDepartmentValue;
	}
	public String getCategoryFromTable() {
		waitutility.waitForAnElement(categoryFromTable, driver);
		String strCategoryValue = categoryFromTable.getText();
		return strCategoryValue;
	}
}
