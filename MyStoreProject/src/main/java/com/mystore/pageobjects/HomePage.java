package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getdriver(), this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(getdriver(), myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return Action.isDisplayed(getdriver(), orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getdriver());
		return homePageURL;
	}
}
