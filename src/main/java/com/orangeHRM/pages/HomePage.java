package com.orangeHRM.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import io.qameta.allure.Step;

public class HomePage {
	WebDriver driver = null;
	
	@FindBy(how=How.XPATH,using="//a[@id='welcome']")
	WebElement AdminUserButton;

	@FindBy(how=How.XPATH,using="//a[text()='Logout']")
	WebElement LogoutButton;
	
	public HomePage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);

    }
	
	@Step("Navigate to Add Leave Entitlement")
	public void Logout() throws InterruptedException
	{
		AdminUserButton.click();
		Thread.sleep(2000);
		LogoutButton.click();
		
	}
}
