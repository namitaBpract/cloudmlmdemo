package com.bpract.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.HomePage;
import com.bpract.pages.LoginPage;
import com.bpract.pages.ToolsPage;

public class ToolsTest extends TestHelper{
	LoginPage loginpage;
	HomePage homepage;
	ToolsPage toolspage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
	
	@Test
	public void verifyValidAddDocument() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		toolspage = homepage.navigateToToolsDocuments();
		Assert.assertTrue(toolspage.getDocumentsPageTitle().contains("Documents"));
		Reporter.log("You are in Documents Page", true);
		toolspage.clickFileUploadBtn();
		Assert.assertTrue(toolspage.getaddDocumentPopUpTile().contains("Add Document"));
		Reporter.log("Add Document Pop Up!", true);
		toolspage.addDocument("Doc40", "40", "C:\\Users\\Bpract\\Desktop\\Namita\\Test Data\\Sample.pdf");
		toolspage.searchInTableForDocument("Doc40", "40");
		
	}
//	@Test
	public void verifyInvalidAddDocument() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!!!", true);
		toolspage = homepage.navigateToToolsDocuments();
		Assert.assertTrue(toolspage.getDocumentsPageTitle().contains("Documents"));
		Reporter.log("You are in Documents Page", true);
		toolspage.clickFileUploadBtn();
		Assert.assertTrue(toolspage.getaddDocumentPopUpTile().contains("Add Document"));
		Reporter.log("You are in Add Document Pop Up", true);
		toolspage.clickAddDocumentSubmitBtn();
		Assert.assertTrue(toolspage.getAddDocumentTitleRequiredMsg().contains("title is a required field"));
		Reporter.log("Title Required Msg found", true);
		Assert.assertTrue(toolspage.getAddDocumentSortOrderRequiredMsg().contains("Sort order is required"));
		Reporter.log("Sort Order Msg found", true);
		Assert.assertTrue(toolspage.getAddDocumentUrlRequiredMsg().contains("Select an Doc"));
		Reporter.log("Document Required Msg found", true);
		
	}
}
