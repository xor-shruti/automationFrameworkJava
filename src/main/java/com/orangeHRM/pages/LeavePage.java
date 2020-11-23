package com.orangeHRM.pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LeavePage {
	


	WebDriver driver = null;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id, 'empName')]")
	WebElement Emp_Name;
	
	@FindBy(how=How.XPATH, using = "//a[contains(@id,'leave') and @class = 'firstLevelMenu']")
	WebElement Leave_Menu;
	
	@FindBy(xpath = "//a[text() = 'Entitlements']")
	WebElement Entitlements_Option;
	
	
	@FindBy(how=How.XPATH,using = "//a[text() = 'Entitlements']//following::li")
	List<WebElement> select_entitlement;
	
	@FindBy(xpath = "//input[@type='checkbox' and contains(@id,'bulk_assign')]")
	WebElement Bulk_assign_checkbox;
	
	
	@FindBy(how=How.NAME,using = "entitlements[filters][location]")
	WebElement Location_Dropdown;
	
	@FindBy(how=How.NAME,using = "entitlements[filters][subunit]")
	WebElement SubUnit_Dropdown;
	
	
	@FindBy(how=How.XPATH,using = "//input[@id='entitlements_entitlement']")
	WebElement Entitlement_input;
	
	
	@FindBy(xpath = "//input[contains(@id,'Save')]")
	WebElement Save_Entitlement;
	
	@FindBy(how=How.XPATH,using = "//*[@id= 'dialogUpdateEntitlementConfirmBtn']")
	WebElement Confirm_Button;
	
	@FindBy(xpath = "//ol[@id = 'employee_entitlement_update']")
	WebElement employee_entitlement_update;
	
	@FindBy(xpath = "//ol[@id = 'employee_entitlement_update']//following::input[@value = 'Confirm']")
	WebElement employee_entitlement_update_confirm;
	
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	List<WebElement> Result_Table;
	
	
	
	public LeavePage(WebDriver driver){

        this.driver = driver;
        
        PageFactory.initElements(driver, this);

    }
	
	@Step("Navigate to Add Leave Entitlement")
	public void navigate_to_add_entitlement()
	{
		
		Actions builder = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Leave_Menu));
		builder.moveToElement(Leave_Menu).build().perform();
		wait.until(ExpectedConditions.visibilityOf(Entitlements_Option));
		builder.moveToElement(Entitlements_Option).build().perform();
		
		
		  List <WebElement> entitlement_options = select_entitlement; 
		  for (WebElement ele:entitlement_options) 
		  { 
			  try
			  {
				  if(ele.getText().equals("Add Entitlements")) 
				  
					  ele.click();
				  	  break;  
				  
			  }
			  
				 
			  catch(Exception e)
			  {
				  System.out.println("Unable to select Add Entitlements option.Please check manually!!");
			  }
		  
			  
		  }
		  Assert.assertTrue(Save_Entitlement.isDisplayed());
	}
	
	@Step("Add Employee Name for Leave Entitlement")
	public void add_employee_name(String emp_name) throws Exception
	{
		Boolean isOptionSelected = null;
		Emp_Name.sendKeys(emp_name);
		String optionToSelect = emp_name;
		List<WebElement> options = driver.findElements(By.className("ac_even"));
		for (WebElement webElement : options) {
		    if (webElement.getText().equalsIgnoreCase(optionToSelect)) {
		        webElement.click();
		        isOptionSelected = Boolean.TRUE;
		    }
		}

		if (isOptionSelected) {
		    System.out.println(optionToSelect + " has been selected");
		} 
		
		else {
			System.out.println(optionToSelect + " could not be selected");
		}
	
	}

	@Step("Select Leave Type for Leave Entitlement")
	public void select_leave_type(String leave_type) throws Exception
	{
		Select 	Leave_Type = new Select(driver.findElement(By.id("entitlements_leave_type")));
		Leave_Type.selectByVisibleText(leave_type);
	}
	
	
	@Step("Select Leave Type for Leave Entitlement")
	public void add_entitlement(String entitlement) throws Exception{
		
		Entitlement_input.sendKeys(entitlement);
		
		Save_Entitlement.click();
		if(employee_entitlement_update.isDisplayed()){
			employee_entitlement_update_confirm.click();
		}
		
	}
	
	@Step("Verify Leave Entitlement")
	public void verify_entitlement_submitted()
	{
		System.out.println("In Verify Leave Entilement Method");
		List <WebElement> Added_Entitlement = Result_Table;
		for(WebElement ele : Added_Entitlement)
			System.out.println("Values in the result table are:" + ele.getText());
	}
		 
}

