package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		Action.scrollByVisibilityOfElement(getdriver(), userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getdriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		Action.scrollByVisibilityOfElement(getdriver(), userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getdriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getdriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}

