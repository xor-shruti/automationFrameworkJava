@all @LogintoorangeHRM
Feature: Login to OrangeHRM

  Background: 
    Given I am on OrangeHRM's landing page
    
  Scenario: To verify successfull login
    When I enter following Credentials
      | Admin | admin123 |
    Then The user is successfully logged in

  Scenario: To verify unsuccessfull login
    When I enter following Credentials
      | Administrator | administrator123 |
    Then "Invalid credentials" message is displayed
