@home
Feature: Home Page - RPG Items Catalog
  As a player browsing the RPG Items Finder
  I want to search, filter, and browse game items
  So that I can find the equipment I need

  Background:
    Given I am on the home page

  # --- Page Structure ---

  Scenario: Page displays main elements
    Then the page title should be "RPG ITEMS FINDER"
    And the page subtitle should be "Discover legendary weapons and gear for your adventure"
    And the header should be visible
    And the footer should be visible
    And the search input should be visible
    And the filter panel should be visible
    And the items grid should be visible
    And the stats bar should be visible

  Scenario: Stats bar shows correct counts
    Then the total items count should be "24"
    And the showing count should be "24"
    And the legendary count should be "5"

  # --- Search ---

  Scenario: Search items by name
    When I search for "Excalibur"
    Then the showing count should be "1"
    And the item card "excalibur" should be visible

  Scenario: Search items by category keyword
    When I search for "bow"
    Then all visible items should contain "bow" in their name or category

  Scenario: Search with no results shows empty state
    When I search for "xyznonexistent"
    Then the empty state should be visible
    And the showing count should be "0"

  Scenario: Clear search resets results
    When I search for "Excalibur"
    And I clear the search
    Then the showing count should be "24"

  # --- Filters ---

  Scenario: Filter by single category
    When I select the "sword" category filter
    Then all visible items should be in the "sword" category

  Scenario: Filter by multiple categories
    When I select the "sword" category filter
    And I select the "bow" category filter
    Then all visible items should be in the "sword" or "bow" category

  Scenario: Filter by rarity
    When I select the "legendary" rarity filter
    Then all visible items should have "legendary" rarity
    And the showing count should be "5"

  Scenario: Filter by level range
    When I set the minimum level to 30
    And I set the maximum level to 50
    Then all visible items should have level between 30 and 50

  Scenario: Reset filters clears all selections
    When I select the "sword" category filter
    And I select the "legendary" rarity filter
    And I click the reset filters button
    Then the showing count should be "24"

  # --- Sorting ---

  Scenario: Sort items by name A-Z
    When I sort by "name-asc"
    Then the first item should be "Aegis of Light"

  Scenario: Sort items by damage high to low
    When I sort by "damage-desc"
    Then the first item should have the highest damage

  Scenario: Sort items by price low to high
    When I sort by "price-asc"
    Then the first item should have the lowest price

  # --- Item Cards ---

  Scenario: Item card displays correct information
    Then the item card "excalibur" should be visible
    And the item name "excalibur" should be "Excalibur"
    And the item "excalibur" rarity badge should show "legendary"

  Scenario: Add item to cart from card
    When I click add to cart on "iron-sword"
    Then the toast notification should appear
    And the toast message should contain "Iron Sword added to cart"
    And the cart badge should show "1"

  Scenario: Add multiple items to cart
    When I click add to cart on "iron-sword"
    And I click add to cart on "wooden-bow"
    Then the cart badge should show "2"
