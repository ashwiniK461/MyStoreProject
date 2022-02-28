package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getdriver(), this);
	}
	public LoginPage clickOnSignIn() throws Throwable {
		Action.fluentWait(getdriver(), signInBtn, 10);
		Action.click(getdriver(), signInBtn);
		return new LoginPage();
	}
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getdriver(), myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=getdriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultsPage searchProduct(String productName) throws Throwable {
		Action.type(searchProductBox, productName);
		Action.scrollByVisibilityOfElement(getdriver(), searchButton);
		Action.click(getdriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultsPage();
	}
	
}
