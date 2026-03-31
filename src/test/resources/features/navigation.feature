@navigation
Feature: Navigation
  As a user of the RPG Items Finder
  I want to navigate between pages
  So that I can access different features

  Scenario: Navigate from home to inventory
    Given I am on the home page
    When I click the "Inventory" navigation link
    Then I should be on the inventory page

  Scenario: Navigate from home to about
    Given I am on the home page
    When I click the "About" navigation link
    Then I should be on the about page

  Scenario: Navigate back to home via logo
    Given I am on the inventory page
    When I click the logo link
    Then I should be on the home page

  Scenario: Header is present on all pages
    Given I am on the home page
    Then the header should be visible
    When I click the "Inventory" navigation link
    Then the header should be visible
    When I click the "About" navigation link
    Then the header should be visible
