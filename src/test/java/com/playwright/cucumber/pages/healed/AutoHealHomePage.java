package com.playwright.cucumber.pages.healed;

import com.microsoft.playwright.Locator;

/**
 * Home page with AutoHeal-powered locators.
 * Every locator has a human-readable description so the AI knows
 * what element to look for if the selector breaks.
 */
public class AutoHealHomePage extends AutoHealBasePage {

    public void open() {
        navigate("/");
    }

    // Hero
    public Locator pageTitle() {
        return findByTestId("page-title", "Main page title 'RPG ITEMS FINDER'");
    }

    // Search
    public Locator searchInput() {
        return findByTestId("search-input", "Search input field for filtering items");
    }

    public Locator searchClearButton() {
        return findByTestId("search-clear-button", "Clear/X button inside search input");
    }

    // Stats
    public Locator totalCount() {
        return findByTestId("total-count", "Total items count number in stats bar");
    }

    public Locator showingCount() {
        return findByTestId("showing-count", "Currently showing items count in stats bar");
    }

    // Filters
    public Locator sortSelect() {
        return findByTestId("sort-select", "Sort by dropdown select");
    }

    public Locator categoryCheckbox(String category) {
        return findByTestId("category-checkbox-" + category,
                "Checkbox to filter by " + category + " category");
    }

    public Locator rarityCheckbox(String rarity) {
        return findByTestId("rarity-checkbox-" + rarity,
                "Checkbox to filter by " + rarity + " rarity");
    }

    public Locator resetFiltersButton() {
        return findByTestId("reset-filters-button", "Reset all filters button");
    }

    // Items
    public Locator itemCard(String itemId) {
        return findByTestId("item-card-" + itemId,
                "Item card for " + itemId);
    }

    public Locator itemName(String itemId) {
        return findByTestId("item-name-" + itemId,
                "Item name heading for " + itemId);
    }

    public Locator addToCartButton(String itemId) {
        return findByTestId("add-to-cart-" + itemId,
                "Add to cart button for " + itemId);
    }

    // Modal
    public Locator modalItemName() {
        return findByTestId("modal-item-name", "Item name in detail modal");
    }

    public Locator modalCloseButton() {
        return findByTestId("modal-close-button", "Close button (X) in item detail modal");
    }

    public Locator modalAddToCart() {
        return findByTestId("modal-add-to-cart", "Add to Cart button in item detail modal");
    }

    public Locator quantityIncrease() {
        return findByTestId("quantity-increase", "Plus/increase quantity button in modal");
    }

    public Locator quantityDecrease() {
        return findByTestId("quantity-decrease", "Minus/decrease quantity button in modal");
    }

    public Locator quantityValue() {
        return findByTestId("quantity-value", "Current quantity number display in modal");
    }

    // Toast
    public Locator toastMessage() {
        return findByTestId("toast-message", "Toast notification message text");
    }

    // Cart
    public Locator cartBadge() {
        return findByTestId("cart-badge", "Cart item count badge on cart icon");
    }

    // Navigation
    public Locator navInventory() {
        return findByTestId("nav-inventory", "Inventory navigation link in header");
    }

    public Locator navAbout() {
        return findByTestId("nav-about", "About navigation link in header");
    }

    public Locator logoLink() {
        return findByTestId("logo-link", "Logo/brand link that navigates to home page");
    }
}
