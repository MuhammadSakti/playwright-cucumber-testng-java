@detail
Feature: Item Detail Modal
  As a player viewing item details
  I want to see full stats, effects, and purchase options
  So that I can make informed decisions

  Background:
    Given I am on the home page

  Scenario: Open item detail modal
    When I click on the item card "excalibur"
    Then the item detail modal should be visible
    And the modal item name should be "Excalibur"
    And the modal item rarity should be "Legendary"
    And the modal item description should not be empty

  Scenario: Modal shows stat bars
    When I click on the item card "excalibur"
    Then the modal damage stat should be visible
    And the modal defense stat should be visible
    And the modal speed stat should be visible

  Scenario: Modal shows special effects
    When I click on the item card "excalibur"
    Then the modal effects list should be visible
    And the modal should show 4 effects

  Scenario: Adjust quantity in modal
    When I click on the item card "iron-sword"
    Then the quantity value should be "1"
    When I click the increase quantity button
    Then the quantity value should be "2"
    When I click the decrease quantity button
    Then the quantity value should be "1"

  Scenario: Quantity cannot go below 1
    When I click on the item card "iron-sword"
    Then the decrease quantity button should be disabled

  Scenario: Total price updates with quantity
    When I click on the item card "iron-sword"
    And I click the increase quantity button
    And I click the increase quantity button
    Then the modal total price should be "150 gold"

  Scenario: Add to cart from modal
    When I click on the item card "iron-sword"
    And I click the increase quantity button
    And I click modal add to cart
    Then the modal should be closed
    And the cart badge should show "2"
    And the toast message should contain "Iron Sword added to cart"

  Scenario: Close modal with close button
    When I click on the item card "iron-sword"
    And I click the modal close button
    Then the modal should be closed
