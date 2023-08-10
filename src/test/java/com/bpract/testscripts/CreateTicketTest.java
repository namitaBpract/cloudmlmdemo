package com.bpract.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.CreateTicketPageAdmin;
import com.bpract.pages.CreateTicketUser;
import com.bpract.pages.HomePage;
import com.bpract.pages.HomePageUser;
import com.bpract.pages.LoginPage;

public class CreateTicketTest extends TestHelper{
	LoginPage loginpage;
	HomePage homepage;
	CreateTicketPageAdmin createticketpageadmin;
	CreateTicketUser createticketuser;
	HomePageUser homepageuser;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
//	@Test
	public void verifyValidCreateTicketForUser() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("anya@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		homepageuser.navigateToCreateTicket();
		createticketuser = new CreateTicketUser(driver);
		createticketuser.clickCreateTicket();
		createticketuser.createTicket("IT", "high", "bug", "not able to do fund transfer", "C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\Sample.pdf", "not able to do fund transfer to other users");
		createticketuser.searchingForCreatedTicket("not able to do fund transfer");
//		Assert.assertTrue(createticketuser.getSubjectFromTable().contains("testing"));
//		Reporter.log("Subject found!", true);
//		Assert.assertTrue(createticketuser.getPriorityFromTable().contains("low"));
//		Reporter.log("Priority found!", true);
//		Assert.assertTrue(createticketuser.getDepartmentFromTable().contains("IT"));
//		Reporter.log("Priority found!", true);
//		Assert.assertTrue(createticketuser.getCategoryFromTable().contains("category"));
//		Reporter.log("Priority found!", true);
	}
	
//	@Test
	public void verifyBlankCreateTicketForUser() {
		loginpage = new LoginPage(driver);
		loginpage.loginUser("namita@bpract.com", "12345678");
		homepageuser = new HomePageUser(driver);
		Assert.assertTrue(homepageuser.dashTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		homepageuser.navigateToCreateTicket();
		createticketuser = new CreateTicketUser(driver);
		createticketuser.clickCreateTicket();
//		createticketuser.clickSendRequestBtn();
		createticketuser.createTicket("HR", "normal", "bug", "bug report", "C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\Sample.pdf", "");
		Assert.assertTrue(createticketuser.getDocumentRequiredMsg().contains("Please Select a department"));
		Reporter.log("Document is required msg found", true);
		Assert.assertTrue(createticketuser.getPriorityRequiredMsg().contains("Please Select a priority"));
		Reporter.log("Priority is required msg found", true);
		Assert.assertTrue(createticketuser.getCategoryRequiredMsg().contains("Please Select a category"));
		Reporter.log("Category is required msg found", true);
		Assert.assertTrue(createticketuser.getSubjectRequiredMsg().contains("Subject is required"));
		Reporter.log("Subject is required msg found", true);
		Assert.assertTrue(createticketuser.getDescriptionRequiredMsg().contains("Description Is Required"));
		Reporter.log("Description is required msg found", true);
	}
	
	@Test
	public void verifyValidCreateTicketForAdmin() throws InterruptedException{
		loginpage = new LoginPage(driver);
		loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin =homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickCreateTicketBtn();
		createticketpageadmin.createTicket("namita", "Photo Uploading Issue", "test description", "high", "IT", "bug", "Open", "C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\Sample.pdf");
	}
	
//	@Test
	public void verifyCreateDepartmentsInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Create Ticket Page!", true);
		createticketpageadmin.clickDepartments();
		createticketpageadmin.clickAddDepartment();
		Assert.assertTrue(createticketpageadmin.getAddDepartmentMsg().contains("Add Department"));
		Reporter.log("You are in Add Department Pop up", true);
		createticketpageadmin.addDepartment("Operation", "Operation dept Description", "Yes", "3");
		createticketpageadmin.searchingForDepartment("Operation");
	}
//	@Test
	public void verifyBlankFieldsForCreateDepartmentsInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Create Ticket Page!", true);
		createticketpageadmin.clickDepartments();
		createticketpageadmin.clickAddDepartment();
		Assert.assertTrue(createticketpageadmin.getAddDepartmentMsg().contains("Add Department"));
		Reporter.log("You are in Add Department Pop up", true);
		createticketpageadmin.clickAddDeptSubmitBtn();
		Assert.assertTrue(createticketpageadmin.getAddDeptNameRequiredMsg().contains("Department Name is required"));
		Reporter.log("Name required Msg Found", true);
		Assert.assertTrue(createticketpageadmin.getAddDeptDescriptionRequiredMsg().contains("Department Description is required"));
		Reporter.log("Description required Msg Found", true);
		Assert.assertTrue(createticketpageadmin.getAddDeptStatusRequiredMsg().contains("Status is required"));
		Reporter.log("Status required Msg Found", true);
		Assert.assertTrue(createticketpageadmin.getAddDeptSortRequiredMsg().contains("Sort Order is required"));
		Reporter.log("Sort Order required Msg Found", true);
	}
//	@Test
	public void verifyCreateCategoryInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickCategories();
		createticketpageadmin.clickAddCategories();
		Assert.assertTrue(createticketpageadmin.getAddCategoriesMsg().contains("Add Category"));
		Reporter.log("You are in Add Category Pop up", true);
		createticketpageadmin.addCategory("Cat", "cat Description", "Yes");
		Assert.assertTrue(createticketpageadmin.searchInAddCategoryTable().contains("Cat"));
		Reporter.log("New category created found", true);
	}
//	@Test
	public void verifyBlankFieldsForCreateCategoryInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickCategories();
		createticketpageadmin.clickAddCategories();
		Assert.assertTrue(createticketpageadmin.getAddCategoriesMsg().contains("Add Category"));
		Reporter.log("You are in Add Category Pop up", true);
		createticketpageadmin.clickAddCategorySubmitBtn();
		Assert.assertTrue(createticketpageadmin.getAddCategoryNameRequiredMsg().contains("Name is required"));
		Reporter.log("Name Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddCategoryDescriptionRequiredMsg().contains("Description is required"));
		Reporter.log("Description Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddCategoryStatusRequiredMsg().contains("Status is required"));
		Reporter.log("Status Required msg found", true);
	}
//	@Test
	public void verifyCreateCannedResponsesInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickCannedResponse();
		createticketpageadmin.clickAddCannedResponse();
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseMsg().contains("Add Canned Response"));
		Reporter.log("You are in Add Canned Response Pop up", true);
		createticketpageadmin.addCannedResponse("Canned Res Eg", "Sub for Add Canned Response", "Description for Add Canned Response");
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseTableNameCol().contains("Canned Res Eg"));
		Reporter.log("Created Canned Response found", true);
	}
//	@Test
	public void verifyCreateCannedResponsesInTicketForBlankField() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickCannedResponse();
		createticketpageadmin.clickAddCannedResponse();
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseMsg().contains("Add Canned Response"));
		Reporter.log("You are in Add Canned Response Pop up", true);
		createticketpageadmin.clickAddCannedResponseSubmitBtn();
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseTitleRequiredMsg().contains("Title Name is required"));
		Reporter.log("Title Name Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseSubjectRequiredMsg().contains("Subject is required"));
		Reporter.log("Subject Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddCannedResponseDescriptionRequiredMsg().contains("Description Is Required"));
		Reporter.log("Description Required msg found", true);
	}
	
	@Test
	public void verifyCreatePrioritiesInTicket() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickPriorities();
		createticketpageadmin.clickAddPriority();
		Assert.assertTrue(createticketpageadmin.getAddPriorityMsg().contains("Add Priority"));
		Reporter.log("You are in Add Priority Pop up", true);
		createticketpageadmin.addPriority("Critical", "#a40a0a", "critical priority description.....");
	}
//	@Test
	public void verifyCreatePrioritiesInTicketForBlankData() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		createticketpageadmin = homepage.navigateToCreateTicket();
		Assert.assertTrue(createticketpageadmin.getCreateTicketMsg().contains("Help Center"));
		Reporter.log("You are in Help Center Page!", true);
		createticketpageadmin.clickPriorities();
		createticketpageadmin.clickAddPriority();
		Assert.assertTrue(createticketpageadmin.getAddPriorityMsg().contains("Add Priority"));
		Reporter.log("You are in Add Priority Pop up", true);
		createticketpageadmin.addPriority("", "", "");
		Assert.assertTrue(createticketpageadmin.getAddPriorityNameRequiredMsg().contains("Name is required"));
		Reporter.log("Priority Name Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddPriorityColorRequiredMsg().contains("Color is required"));
		Reporter.log("Priority Color Required msg found", true);
		Assert.assertTrue(createticketpageadmin.getAddPriorityDescriptionRequiredMsg().contains("Description is required"));
		Reporter.log("Priority Description Required msg found", true);
	}
}
