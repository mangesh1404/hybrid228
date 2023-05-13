package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	WebDriver driver=null;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3")// 4 elements
	List<WebElement> courses;
	@FindBy(xpath="//span[text()='Users']")
	WebElement userBtn;
	
	public ArrayList<String> verifyCourses() {
		ArrayList<String> actualCourses=new ArrayList<String>();
		for(WebElement course : courses) {
			String text= course.getText();
			actualCourses.add(text);
		}
		return actualCourses;
	}
	
	public UserPage clickUser() {
		userBtn.click();
		return new UserPage(driver);
	}
	
	
	
}
