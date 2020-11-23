package com.orangeHRM.stepDefinitions;

import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;

import io.cucumber.java.en.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class leaveEntitlementStepDefinition extends Common{
private Common common;
	
	public leaveEntitlementStepDefinition(Common comm)
	{
		this.common = comm;
	}
	  
	
	   @Test(description = "Verify user is able Add Leave Entitlement")
	   @Severity(SeverityLevel.NORMAL)
	   @Description("Verify whether user is able to Add Leave Entitlement")
       @Story("Add Leave Entitlement")
	   @Then("^Navigate to Add Leave Entitlement$")
	    public void navigate_to_add_leave_entitlement()  {
		   common.leapg.navigate_to_add_entitlement();
	    }
	   
	   @When("^User navigates to Add Leave Entitlement$")
	    public void user_navigates_to_add_leave_entitlement() {
		   common.leapg.navigate_to_add_entitlement();
	    }

	    @And("^User enters \"([^\"]*)\" as Employee$")
	    public void user_enters_employee(String emp_name) throws Exception {
	    	common.leapg.add_employee_name(emp_name);
	    }

	    @And("^User selects \"([^\"]*)\" as Leave Type$")
	    public void select_leave_type(String leave_type) throws Throwable {
	    	common.leapg.select_leave_type(leave_type);
	    }

	    @And("^User enters \"([^\"]*)\" as Entitlement$")
	    public void user_enters_something_as_entitlement(String entitlement) throws Throwable {
	    	common.leapg.add_entitlement(entitlement);
	    }
	    
	    @Then("^The Leave entitlement is added successfully$")
	    public void the_leave_entitlement_is_added_successfully() throws Throwable {
	    	common.leapg.verify_entitlement_submitted();
	    }

	

}
