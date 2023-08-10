package com.bpract.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bpract.utilities.PageUtility;
import com.bpract.utilities.TableUtility;
import com.bpract.utilities.WaitUtility;

public class CreateTicketPageAdmin {
	WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility = new PageUtility();
	TableUtility tableutility = new TableUtility();
	
	@FindBy(xpath="//h4[contains(text(),\"Help Center\")]")
	WebElement createTicketMsg;
	@FindBy(xpath="//a[contains(text(),\"Create Ticket\")]")
	WebElement createTicketBtn;
	
	@FindBy(xpath="//span[contains(text(), \"Departments\")]")
	WebElement departmentMenu;
	@FindBy(name="department")
	WebElement addDepartmentBtn;
	@FindBy(xpath="//span[contains(text(), \"Add Department\")]")
	WebElement addDepartmentMsg;
	
	@FindBy(xpath="//span[contains(text(), \"Categories\")]")
	WebElement categoriesMenu;
	@FindBy(name="category")
	WebElement addCategoryBtn;
	@FindBy(xpath="//span[contains(text(), \"Add Category\")]")
	WebElement addCategoryMsg;
	
	@FindBy(xpath="//span[contains(text(), \"Canned Responses\")]")
	WebElement cannedResponseMenu;
	@FindBy(name="canned-response")
	WebElement addCannedResponseBtn;
	@FindBy(xpath="//span[contains(text(), \"Add Canned Response\")]")
	WebElement addCannedResponseMsg;
	
	@FindBy(xpath="//span[contains(text(), \"Priorities\")]")
	WebElement prioritiesMenu;
	@FindBy(name="priority")
	WebElement addPriority;
	@FindBy(xpath="//span[contains(text(), \"Add Priority\")]")
	WebElement addPriorityMsg;
	
	@FindBy(name="user-search")
	WebElement searchUser;
	@FindBy(name="subject")
	WebElement ticketSubject;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement description;
	@FindBy(name="priority_id")
	WebElement priority;
	@FindBy(name="department_id")
	WebElement department;
	@FindBy(name="category_id")
	WebElement category;
	@FindBy(name="status")
	WebElement status;
	@FindBy(name="attachments_url")
	WebElement documents;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Add\")]")
	WebElement addBtn;
	
	@FindBy(xpath="//button[contains(text(), \"Submit\") and @type=\"submit\"]")
	WebElement addDocSubmitBtn;
	
	@FindBy(name="name")
	WebElement addDeptName;
	@FindBy(xpath="//p[contains(text(), \"Department Name is required\")]")
	WebElement addDeptNameRequiredMsg;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div[1]/div[2]/div/textarea[1]")
	WebElement addDeptDescription;
	@FindBy(xpath="//p[contains(text(), \"Department Description is required\")]")
	WebElement addDeptDescriptionRequiredMsg;
	@FindBy(name="active")
	WebElement addDeptStatus;
	@FindBy(xpath="//p[contains(text(), \"Status is required\")]")
	WebElement addDeptStatusRequiredMsg;
	@FindBy(name="sort_order")
	WebElement addDeptSortOrder;
	@FindBy(xpath="//p[contains(text(), \"Sort Order is required\")]")
	WebElement addDeptSortRequiredMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Submit\")]")
	WebElement addDeptSubmitBtn;
	@FindBy(xpath="//table[@name=\"department-table\"]/tbody")
	WebElement departmentTable;
	
	@FindBy(name="name")
	WebElement addCategoryName;
	@FindBy(xpath="//p[contains(text(), \"Name is required\")]")
	WebElement addCategoryNameRequiredMsg;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div/div[2]/div/textarea[1]")
	WebElement addCategoryDescription;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement addCategoryDescriptionRequiredMsg;
	@FindBy(name="active")
	WebElement addCategoryStatus;
	@FindBy(xpath="//p[contains(text(), \"Status is required\")]")
	WebElement addCategoryStatusRequiredMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Submit\")]")
	WebElement addCategorySubmitBtn;
	@FindBy(xpath="//table[@name=\"category-table\"]/tbody/tr[1]/td[2]")
	WebElement addCategoryTableNameCol;
	
	@FindBy(name="title")
	WebElement addCannedResponseTitle;
	@FindBy(xpath="//p[contains(text(), \"Title Name is required\")]")
	WebElement addCannedResponseTitleRequiredMsg;
	@FindBy(name="subject")
	WebElement addCannedResponseSubject;
	@FindBy(xpath="//p[contains(text(), \"Subject is required\")]")
	WebElement addCannedResponseSubjectRequiredMsg;
	@FindBy(xpath="//*[@id=\"description\"]/div/div[1]")
	WebElement addCannedResponseDescription;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement addCannedResponseDescriptionRequiredMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Submit\")]")
	WebElement addCannedResponseSubmitBtn;
	@FindBy(xpath="//*[@name=\"canned-table\"]/tbody/tr[1]/td[2]")
	WebElement addCannedResponseTableNameCol;
	
	@FindBy(xpath="//input[@name=\"name\" and @type=\"text\"]")
	WebElement addPriorityName;
	@FindBy(xpath="//p[contains(text(), \"Name is required\")]")
	WebElement addPriorityNameRequiredMsg;
	@FindBy(name="color")
	WebElement addPriorityColor;
	@FindBy(xpath="//p[contains(text(), \"Color is required\")]")
	WebElement addPriorityColorRequiredMsg;
	@FindBy(xpath="/html/body/div[2]/div[3]/div/form/div[1]/p/div[2]/div/div/textarea[1]")
	WebElement addPriorityDescription;
	@FindBy(xpath="//p[contains(text(), \"Description is required\")]")
	WebElement addPriorityDescriptionRequiredMsg;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(), \"Submit\")]")
	WebElement addPrioritySubmitBtn;
	
	public CreateTicketPageAdmin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCreateTicketMsg() {
		waitutility.waitForAnElement(createTicketMsg, driver);
		String createTicketMsgText = createTicketMsg.getText();
		return createTicketMsgText;
	}
	
	public void clickCreateTicketBtn() {
		waitutility.waitForAnElement(createTicketBtn, driver);
		createTicketBtn.click();
	}
	public void selectUsername(String strUsername) throws InterruptedException{
		waitutility.waitForAnElement(searchUser, driver);
		pageutility.selectFromAutoSuggestion(searchUser, driver, strUsername);
	}
	public void enterSubject(String strSubject) {
		ticketSubject.sendKeys(strSubject);
	}
	public void enterDescription(String strDescription) {
		description.sendKeys(strDescription);
	}
	public void selectPriority(String strPriority) {
		waitutility.waitForAnElement(priority, driver);
		pageutility.selectByVisibleText(priority, driver, strPriority);
	}
	public void selectDepartment(String strDepartment) {
		pageutility.selectByVisibleText(department, driver, strDepartment);
	}
	public void selectCategory(String strCategory) {
		pageutility.selectByVisibleText(category, driver, strCategory);
	}
	public void selectStatus(String strStatus) {
		pageutility.selectByVisibleText(status, driver, strStatus);
	}
	public void uploadDocuments(String strDocument){
		waitutility.waitForAnElement(documents, driver);
		pageutility.uploadFiles(documents, driver, strDocument);
	}
	public void clickAddBtn() {
		addBtn.click();
	}
	public void createTicket(String strUsername, String strSubject, String strDescription, String strPriority, String strDepartment, String strCategory, String strStatus, String strDocument) throws InterruptedException {
		this.selectUsername(strUsername);
		this.enterSubject(strSubject);
		this.enterDescription(strDescription);
		this.selectPriority(strPriority);
		this.selectDepartment(strDepartment);
		this.selectCategory(strCategory);
		this.selectStatus(strStatus);
		this.uploadDocuments(strDocument);
		this.clickAddBtn();
	}
	
	public void clickDepartments() {
		departmentMenu.click();
	}
	public void clickAddDepartment() {
		waitutility.waitForAnElement(addDepartmentBtn, driver);
		addDepartmentBtn.click();
	}
	public String getAddDepartmentMsg() {
		waitutility.waitForAnElement(addDepartmentMsg, driver);
		String addDepartmentMsgText = addDepartmentMsg.getText();
		return addDepartmentMsgText;
	}
	public void enterAddDeptName(String strAddDeptName) {
		waitutility.waitForAnElement(addDeptName, driver);
		addDeptName.sendKeys(strAddDeptName);
	}
	public void enterAddDeptDescription(String strAddDeptDescription) {
		addDeptDescription.sendKeys(strAddDeptDescription);
	}
	public void selectAddDeptStatus(String strAddDeptStatus) {
		pageutility.selectByVisibleText(addDeptStatus, driver, strAddDeptStatus);
	}
	public void enterAddDeptSortOrder(String strAddDeptSortOrder) {
		addDeptSortOrder.sendKeys(strAddDeptSortOrder);
	}
	public void clickAddDeptSubmitBtn() {
		addDeptSubmitBtn.click();
	}
	public void addDepartment(String strAddDeptName, String strAddDeptDescription, String strAddDeptStatus, String strAddDeptSortOrder) {
		this.enterAddDeptName(strAddDeptName);
		this.enterAddDeptDescription(strAddDeptDescription);
		this.selectAddDeptStatus(strAddDeptStatus);
		this.enterAddDeptSortOrder(strAddDeptSortOrder);
		this.clickAddDeptSubmitBtn();
	}
	public void searchingForDepartment(String strDeptName) {
		driver.navigate().refresh();
		waitutility.waitForAnElement(departmentTable, driver);
		tableutility.searchInDepartmentTable(departmentTable, driver, strDeptName);
	}
	public String getAddDeptNameRequiredMsg() {
		waitutility.waitForAnElement(addDeptNameRequiredMsg, driver);
		String addDeptNameRequiredMsgText = addDeptNameRequiredMsg.getText();
		return addDeptNameRequiredMsgText;
	}
	public String getAddDeptDescriptionRequiredMsg() {
		waitutility.waitForAnElement(addDeptDescriptionRequiredMsg, driver);
		String addDeptDescriptionRequiredMsgText = addDeptDescriptionRequiredMsg.getText();
		return addDeptDescriptionRequiredMsgText;
	}
	public String getAddDeptStatusRequiredMsg() {
		waitutility.waitForAnElement(addDeptStatusRequiredMsg, driver);
		String addDeptStatusRequiredMsgText = addDeptStatusRequiredMsg.getText();
		return addDeptStatusRequiredMsgText;
	}
	public String getAddDeptSortRequiredMsg() {
		waitutility.waitForAnElement(addDeptSortRequiredMsg, driver);
		String addDeptSortRequiredMsgText = addDeptSortRequiredMsg.getText();
		return addDeptSortRequiredMsgText;
	}
	
	public void clickCategories() {
		categoriesMenu.click();
	}
	public void clickAddCategories() {
		waitutility.waitForAnElement(addCategoryBtn, driver);
		addCategoryBtn.click();
	}
	public String getAddCategoriesMsg() {
		waitutility.waitForAnElement(addCategoryMsg, driver);
		String addCategoryMsgText = addCategoryMsg.getText();
		return addCategoryMsgText;
	}
	public void enterAddCategoryName(String strAddCategoryName){
		waitutility.waitForAnElement(addCategoryName, driver);
		addCategoryName.sendKeys(strAddCategoryName);
	}
	public void enterAddCategoryDescription(String strAddCategoryDescription) {
		addCategoryDescription.sendKeys(strAddCategoryDescription);
	}
	public void selectAddCategoryStatus(String strAddCategoryStatus) {
		pageutility.selectByVisibleText(addCategoryStatus, driver, strAddCategoryStatus);
	}
	public void clickAddCategorySubmitBtn() {
		waitutility.waitForAnElement(addCategorySubmitBtn, driver);
		addCategorySubmitBtn.click();
	}
	public String getAddCategoryNameRequiredMsg() {
		waitutility.waitForAnElement(addCategoryNameRequiredMsg, driver);
		String addCategoryNameRequiredMsgText = addCategoryNameRequiredMsg.getText();
		return addCategoryNameRequiredMsgText;
	}
	public String getAddCategoryDescriptionRequiredMsg() {
		String addCategoryDescriptionRequiredMsgText = addCategoryDescriptionRequiredMsg.getText();
		return addCategoryDescriptionRequiredMsgText;
	}
	public String getAddCategoryStatusRequiredMsg() {
		String addCategoryStatusRequiredMsgText = addCategoryStatusRequiredMsg.getText();
		return addCategoryStatusRequiredMsgText;
	}
	public void addCategory(String strAddCategoryName, String strAddCategoryDescription, String strAddCategoryStatus) {
		this.enterAddCategoryName(strAddCategoryName);
		this.enterAddCategoryDescription(strAddCategoryDescription);
		this.selectAddCategoryStatus(strAddCategoryStatus);
		this.clickAddCategorySubmitBtn();
	}
	public String searchInAddCategoryTable() {
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(addCategoryTableNameCol, driver);
		String addCategoryTableNameColText = addCategoryTableNameCol.getText();
		return addCategoryTableNameColText;
	}

	public void clickCannedResponse() {
		cannedResponseMenu.click();
	}
	public void clickAddCannedResponse() {
		waitutility.waitForAnElement(addCannedResponseBtn, driver);
		addCannedResponseBtn.click();
	}
	public String getAddCannedResponseMsg() {
		waitutility.waitForAnElement(addCannedResponseMsg, driver);
		String addCannedResponseMsgText = addCannedResponseMsg.getText();
		return addCannedResponseMsgText;
	}
	public void enterAddCannedResponseTitle(String strAddCannedResponseTitle) {
		waitutility.waitForAnElement(addCannedResponseTitle, driver);
		addCannedResponseTitle.sendKeys(strAddCannedResponseTitle);
	}
	public void enterAddCannedResponseSubject(String strAddCannedResponseSubject) {
		addCannedResponseSubject.sendKeys(strAddCannedResponseSubject);
	}
	public void enteraddCannedResponseDescription(String straddCannedResponseDescription) {
		addCannedResponseDescription.sendKeys(straddCannedResponseDescription);
	}
	public void clickAddCannedResponseSubmitBtn() {
		addCannedResponseSubmitBtn.click();
	}
	public String getAddCannedResponseTitleRequiredMsg() {
		waitutility.waitForAnElement(addCannedResponseTitleRequiredMsg, driver);
		String addCannedResponseTitleRequiredMsgText = addCannedResponseTitleRequiredMsg.getText();
		return addCannedResponseTitleRequiredMsgText;
	}
	public String getAddCannedResponseSubjectRequiredMsg() {
		String addCannedResponseSubjectRequiredMsgText = addCannedResponseSubjectRequiredMsg.getText();
		return addCannedResponseSubjectRequiredMsgText;
	}
	public String getAddCannedResponseDescriptionRequiredMsg() {
		String addCannedResponseDescriptionRequiredMsgText = addCannedResponseDescriptionRequiredMsg.getText();
		return addCannedResponseDescriptionRequiredMsgText;
	}
	public void addCannedResponse(String strAddCannedResponseTitle, String strAddCannedResponseSubject, String straddCannedResponseDescription) {
		this.enterAddCannedResponseTitle(strAddCannedResponseTitle);
		this.enterAddCannedResponseSubject(strAddCannedResponseSubject);
		this.enteraddCannedResponseDescription(straddCannedResponseDescription);
		this.clickAddCannedResponseSubmitBtn();
	}
	public String getAddCannedResponseTableNameCol() {
		driver.navigate().to(driver.getCurrentUrl());
		waitutility.waitForAnElement(addCannedResponseTableNameCol, driver);
		String addCannedResponseTableNameColText = addCannedResponseTableNameCol.getText();
		return addCannedResponseTableNameColText;
	}
	
	public void clickPriorities() {
		prioritiesMenu.click();
	}
	public void clickAddPriority() {
		waitutility.waitForAnElement(addPriority, driver);
		addPriority.click();
	}
	public String getAddPriorityMsg() {
		waitutility.waitForAnElement(addPriorityMsg, driver);
		String addPriorityMsgText = addPriorityMsg.getText();
		return addPriorityMsgText;
	}
	public void enterAddPriorityName(String strAddPriorityName) {
		waitutility.waitForAnElement(addPriorityName, driver);
		addPriorityName.sendKeys(strAddPriorityName);
	}
	public void enterAddPriorityColor(String strAddPriorityColor) {
		pageutility.pickColor(addPriorityColor, driver, strAddPriorityColor);
		addPriorityColor.sendKeys(strAddPriorityColor);
	}
	public void enterAddPriorityDescription(String strAddPriorityDescription) {
		addPriorityDescription.sendKeys(strAddPriorityDescription);
	}
	public void clickAddPrioritySubmitBtn() {
		addPrioritySubmitBtn.click();
	}
	public void addPriority(String strAddPriorityName, String strAddPriorityColor, String strAddPriorityDescription) {
		this.enterAddPriorityName(strAddPriorityName);
		this.enterAddPriorityColor(strAddPriorityColor);
		this.enterAddPriorityDescription(strAddPriorityDescription);
		this.clickAddPrioritySubmitBtn();
	}
	public String getAddPriorityNameRequiredMsg() {
		waitutility.waitForAnElement(addPriorityNameRequiredMsg, driver);
		String addPriorityNameRequiredMsgText = addPriorityNameRequiredMsg.getText();
		return addPriorityNameRequiredMsgText;
	}
	public String getAddPriorityColorRequiredMsg() {
		waitutility.waitForAnElement(addPriorityColorRequiredMsg, driver);
		String addPriorityColorRequiredMsgText = addPriorityColorRequiredMsg.getText();
		return addPriorityColorRequiredMsgText;
	}
	
	public String getAddPriorityDescriptionRequiredMsg() {
		waitutility.waitForAnElement(addPriorityDescriptionRequiredMsg, driver);
		String addPriorityDescriptionRequiredMsgText = addPriorityDescriptionRequiredMsg.getText();
		return addPriorityDescriptionRequiredMsgText;
	}
}
