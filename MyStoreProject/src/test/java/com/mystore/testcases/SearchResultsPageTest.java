package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultsPage;

public class SearchResultsPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultsPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		getdriver().quit();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		//Log.startTestCase("productAvailabilityTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		//Log.endTestCase("productAvailabilityTest");
	}

}
