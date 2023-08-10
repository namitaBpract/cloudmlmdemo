package com.bpract.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BlogTest extends TestHelper{

	@BeforeMethod
	@Parameters({"browser"})
	public void initialization(String browser) {
	driver = lauchBrowser(browser);
	} 
	
	public void verifyCreateBlog() {
		
	}
}
