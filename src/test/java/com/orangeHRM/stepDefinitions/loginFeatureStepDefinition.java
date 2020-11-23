package com.orangeHRM.stepDefinitions;




import java.util.List;

//import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class loginFeatureStepDefinition extends Common{
	
private Common common;
	
	public loginFeatureStepDefinition(Common comm)
	{
		this.common = comm;
	}
	
	@Test(description = "Logging into the application")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify whether user is able to login with valid credentials")
    @Story("Login to application")
	@Given("^I am on OrangeHRM's landing page$")
	public void i_am_on_OrangeHRM_s_landing_page() throws Exception {
		common.driver_Common.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login"); 
	 }
	 

	@Test(description = "Logging into the application")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify whether user is able to login with valid credentials")
    @Story("Login to application")
	@When("^I enter following Credentials$")
	public void i_enter_following_Credentials(DataTable dt) throws Exception {
		List<List<String>> Credentials = dt.asLists();
		for(int i=0;i<Credentials.size();i++){
		common.lpg.logintoapplication(Credentials.get(i).get(0),Credentials.get(i).get(1));  }
	}

	@Test(description = "Logging into the applications")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify whether user is able to login with valid credentials")
    @Story("Login to application")
	@Then("^The user is successfully logged in$")
	public void the_user_is_successfully_logged_in() throws InterruptedException {
		common.lpg.VerifyPageTitle();   
		common.hmpg.Logout();
	}
	
	@Test(description = "Invalid login credentials test ")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify Invalid Credentials Message displayed")
    @Story("Login to application")
	@Then("^\"([^\"]*)\" message is displayed$")
	public void message_is_displayed(String message) {
		common.lpg.VerifyErrorOnUnsuccessfulLogin(message); 
	}
	  
	    
}
	
	
	

