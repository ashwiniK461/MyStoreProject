package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultsPage extends BaseClass {
	
Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public void SearchResultPage() {
		
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		
		return Action.isDisplayed(getdriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		
		Action.click(getdriver(), productResult);
		return new AddToCartPage();
	}
	
}