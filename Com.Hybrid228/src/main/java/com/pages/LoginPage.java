package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

	WebDriver driver=null;
	
	//LoginPage lp= new LoginPage(driver);
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button")
	WebElement loginBtn;
	
	public DashBoardPage validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		loginBtn.click();
		return new DashBoardPage(driver);
	}
	
	public void loginToApplication(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginBtn.click();
	}
}
