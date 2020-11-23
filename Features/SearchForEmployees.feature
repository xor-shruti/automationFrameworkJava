@all @VerifyEmployeeInfo
Feature: Search for Employees in OrangeHRM

  Background:
    Given I am on OrangeHRM's landing page

  Scenario: Verify that the Employee is part of the organisation
  
  	When I enter following Credentials
      | Admin | admin123 |
    Then Retrieve Employee Information using folllowing data
    |Goutam Ganesh|0235|Full-Time Permanent|
    |David Morris|0066|Full-Time Permanent|
    |Anthony Nolan|0070|Full-Time Probation|
	 
    
