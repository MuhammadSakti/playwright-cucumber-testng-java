@inventory
Feature: Inventory Page
  As a player managing my inventory
  I want to equip, unequip, and remove items
  So that I can optimize my character build

  Background:
    Given I am on the inventory page

  Scenario: Inventory page displays items
    Then the inventory title should be "YOUR INVENTORY"
    And the inventory list should be visible
    And the inventory should have 6 items

  Scenario: Equip an item
    When I equip the item "iron-sword"
    Then the item "iron-sword" should be equipped
    And the equip button for "iron-sword" should show "Equipped"

  Scenario: Unequip an item
    When I equip the item "iron-sword"
    And I equip the item "iron-sword"
    Then the item "iron-sword" should not be equipped
    And the equip button for "iron-sword" should show "Equip"

  Scenario: Remove an item from inventory
    When I remove the item "iron-sword"
    Then the inventory should have 5 items
    And the item "iron-sword" should not be in the inventory

  Scenario: Inventory summary updates when equipping
    When I equip the item "iron-sword"
    Then the equipped count should be "1"
    And the total damage should be greater than "0"

  Scenario: Inventory summary shows total items
    Then the total items count in summary should be "6"
