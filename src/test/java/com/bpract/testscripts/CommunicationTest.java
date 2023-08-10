package com.bpract.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bpract.pages.CommunicationPage;
import com.bpract.pages.HomePage;
import com.bpract.pages.LoginPage;

public class CommunicationTest extends TestHelper{
	LoginPage loginpage;
	HomePage homepage;
	CommunicationPage communicationpage;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
		driver = lauchBrowser(browser);
	}
//	@Test
	public void verifyCreateArticleCategoryWithValidData() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		communicationpage = homepage.navigateToArticles();
		Assert.assertTrue(communicationpage.getArticleMsg().contains("Articles"));
		Reporter.log("You are in Articles Page", true);
		communicationpage.clickArticleCategory();
		communicationpage.clickAddArticleCategoryBtn();
		Assert.assertTrue(communicationpage.getAddArticleCategoryPopupMsg().contains("Add Article Category"));
		Reporter.log("You are in Add Article Category Pop up", true);
		communicationpage.addArticleCategory("New Article Category", "New Article Category Description");
	}
//	@Test
	public void verifyCreateArticleCategoryWithBlankData() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		communicationpage = homepage.navigateToArticles();
		Assert.assertTrue(communicationpage.getArticleMsg().contains("Articles"));
		Reporter.log("You are in Articles Page", true);
		communicationpage.clickArticleCategory();
		communicationpage.clickAddArticleCategoryBtn();
		Assert.assertTrue(communicationpage.getAddArticleCategoryPopupMsg().contains("Add Article Category"));
		Reporter.log("You are in Add Article Category Pop up", true);
		communicationpage.clickArticleCategorySubmitBtn();
		Assert.assertTrue(communicationpage.getArticleCategoryNameRequiredMsg().contains("Article Category Name is required"));
		Reporter.log("Article Category Name Required Msg found", true);
		Assert.assertTrue(communicationpage.getArticleCategoryDescriptionRequiredMsg().contains("Description Is Required"));
		Reporter.log("Description Required Msg found", true);
	}
//	@Test
	public void verifyCreateArticleWithValidData() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		communicationpage = homepage.navigateToArticles();
		Assert.assertTrue(communicationpage.getArticleMsg().contains("Articles"));
		Reporter.log("You are in Articles Page", true);
		communicationpage.clickaddArticleBtn();
		Assert.assertTrue(communicationpage.getAddArticlePopupMsg().contains("Create Article"));
		Reporter.log("You are in Add Article Pop up", true);
		communicationpage.addArticle("Article One", "2", "Article Description goes here.......");
		
	}
	@Test
	public void verifyCreateArticleWithBlankData() {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginAdmin("info@cloudlumen.com", "12345678");
		Assert.assertTrue(homepage.getDashboardTitle().contains("Dashboard"));
		Reporter.log("Login Successful!", true);
		communicationpage = homepage.navigateToArticles();
		Assert.assertTrue(communicationpage.getArticleMsg().contains("Articles"));
		Reporter.log("You are in Articles Page", true);
		communicationpage.clickaddArticleBtn();
		Assert.assertTrue(communicationpage.getAddArticlePopupMsg().contains("Create Article"));
		Reporter.log("You are in Add Article Pop up", true);
		communicationpage.clickArticleSubmitBtn();
		Assert.assertTrue(communicationpage.getArticleNameRequiredMsg().contains("Title is required"));
		Reporter.log("Article Name Required Msg found", true);
		Assert.assertTrue(communicationpage.getArticleCategoryIdRequiredMsg().contains("Category is required"));
		Reporter.log("Article Id Required Msg found", true);
		Assert.assertTrue(communicationpage.getarticleDescriptionRequiredMsg().contains("Description Is Required"));
		Reporter.log("Article Description Required Msg found", true);
	}
}
