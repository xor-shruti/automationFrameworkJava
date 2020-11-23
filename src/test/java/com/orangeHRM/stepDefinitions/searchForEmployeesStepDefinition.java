package com.orangeHRM.stepDefinitions;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.pages.Common;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;




public class searchForEmployeesStepDefinition extends Common{

	String EmployeeFullName;
	
	
private Common common;
	
	public searchForEmployeesStepDefinition(Common comm)
	{
		this.common = comm;
	}
	
	
	
	@Test(description = "Verify user has logged in successfully")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Verify whether user is able to login with valid credentials")
    @Story("Login to application with valid credentials")
	@Given("The user has successfully logged in")
	public void the_user_has_successfully_logged_in() throws Exception {
		
		common.lpg.logintoapplication("Admin","admin123");
		Thread.sleep(1000);
		common.lpg.VerifyPageTitle();
	}
	
	
	@Test(description = "Retrieve employee information")
	@Severity(SeverityLevel.NORMAL)
	@Description("Retrieve employee information")
    @Story("Retrieve employee information based on values passed from the feature file")
	@Then("Retrieve Employee Information using folllowing data")
	public void retrieve_Employee_Information_using_folllowing_data(DataTable dt) throws Exception {
	   List<List<String>> data = dt.asLists();
	   for(int i=0;i<data.size();i++)
	   {
		   try
		   {
		   List<String> employee_data = common.emp.retriveEmployees(data.get(i).get(0));
		   String EmployeeFullName = employee_data.get(2) + " "+employee_data.get(3);
		   System.out.println("Name of the Employee whose records are being verified is: "+EmployeeFullName); 
		   Assert.assertEquals(data.get(i).get(0), EmployeeFullName);
		   System.out.println("Employee Found in OrangeHRM Records!!");
		   employee_data.clear();
		   }
		   
		   catch(Exception e)
			{	
				
				Assert.fail("Could not find the requested employee!!");
				
			}
		   
		   	   
	   }
	   
	}

	
	
	

}
