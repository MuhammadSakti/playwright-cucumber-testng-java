@contact
Feature: Contact Form
  As a visitor on the about page
  I want to submit a contact form
  So that I can reach out to the team

  Background:
    Given I am on the about page

  Scenario: Contact form is visible
    Then the contact form should be visible
    And the name input should be visible
    And the email input should be visible
    And the message input should be visible
    And the submit button should be visible

  Scenario: Submit contact form successfully
    When I fill in the name with "John Doe"
    And I fill in the email with "john@example.com"
    And I fill in the message with "Great collection of RPG items!"
    And I submit the contact form
    Then the success message should be visible
    And the success message should contain "Thank you for your message"

  Scenario: About page shows feature cards
    Then the feature catalog card should be visible
    And the feature filter card should be visible
    And the feature interactive card should be visible
    And the feature accessibility card should be visible
