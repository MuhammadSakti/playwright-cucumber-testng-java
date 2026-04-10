@login
Feature: Login Page
  As a user I want to sign in so I can access protected pages

  Background:
    Given I am on the login page

  # --- Page Structure ---

  Scenario: Login page displays main elements
    Then the login page should be visible
    And the login title should be "SIGN IN"
    And the login form should be visible
    And the username input should be visible
    And the password input should be visible
    And the login button should be visible
    And the credentials hint should be visible

  # --- Invalid Login ---

  Scenario: Show error on invalid credentials
    When I enter username "wronguser"
    And I enter password "wrongpass"
    And I click the login button
    Then the login error should be visible
    And the login error should contain "Invalid username or password"

  # --- Successful Login - Warrior ---

  Scenario: Login as warrior and redirect to profile
    When I enter username "warrior"
    And I enter password "sword123"
    And I click the login button
    Then I should be on the profile page
    And the profile title should be "ADVENTURER PROFILE"
    And the profile display name should be "Thorin Ironforge"
    And the profile role should be "Warrior"
    And the profile level should be "42"
    And the profile guild should be "The Iron Vanguard"
    And the profile bio should contain "battle-hardened warrior"

  # --- Successful Login - Mage ---

  Scenario: Login as mage and verify profile
    When I enter username "mage"
    And I enter password "spell456"
    And I click the login button
    Then I should be on the profile page
    And the profile display name should be "Elara Moonwhisper"
    And the profile role should be "Mage"
    And the profile level should be "38"
    And the profile guild should be "Arcane Circle"

  # --- Successful Login - Ranger ---

  Scenario: Login as ranger and verify profile
    When I enter username "ranger"
    And I enter password "arrow789"
    And I click the login button
    Then I should be on the profile page
    And the profile display name should be "Sylvan Windwalker"
    And the profile role should be "Ranger"
    And the profile level should be "35"
    And the profile guild should be "Shadow Stalkers"

  # --- Logout ---

  Scenario: Logout from profile returns to login page
    When I enter username "warrior"
    And I enter password "sword123"
    And I click the login button
    Then I should be on the profile page
    When I click the logout button
    Then I should be on the login page
    And the login form should be visible

  # --- Header Shows User After Login ---

  Scenario: Header shows user name after login
    When I enter username "warrior"
    And I enter password "sword123"
    And I click the login button
    Then I should be on the profile page
    And the header user name should be "Thorin Ironforge"

  # --- Password Toggle ---

  Scenario: Toggle password visibility
    When I enter password "sword123"
    And I toggle password visibility
    Then the password input type should be "text"
    When I toggle password visibility
    Then the password input type should be "password"
