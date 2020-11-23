@all @LeaveEntitlement
Feature: Search for Employees in OrangeHRM

  Background:
    Given I am on OrangeHRM's landing page

  Scenario: Add Leave Entitlement
  	When I enter following Credentials
      | Admin | admin123 |
    And User navigates to Add Leave Entitlement
    And User enters "Russel Hamilton" as Employee
    And User selects "CAN - Personal" as Leave Type
    And User enters "2" as Entitlement
    Then The Leave entitlement is added successfully
