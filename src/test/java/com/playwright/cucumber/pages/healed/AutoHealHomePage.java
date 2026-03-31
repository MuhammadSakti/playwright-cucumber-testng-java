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

    // Hero section
    public Locator pageTitle() {
        return findByTestId("page-title", "Main page title 'RPG ITEMS FINDER'");
    }

    public Locator pageSubtitle() {
        return findByTestId("page-subtitle", "Page subtitle text below the main title");
    }

    // Search
    public Locator searchInput() {
        return findByTestId("search-input", "Search input field for filtering items");
    }

    public Locator searchClearButton() {
        return findByTestId("search-clear-button", "Clear/X button inside search input");
    }

    // Stats bar
    public Locator statsBar() {
        return findByTestId("stats-bar", "Stats bar showing item counts");
    }

    public Locator totalCount() {
        return findByTestId("total-count", "Total items count number in stats bar");
    }

    public Locator showingCount() {
        return findByTestId("showing-count", "Currently showing items count in stats bar");
    }

    public Locator legendaryCount() {
        return findByTestId("legendary-count", "Legendary items count in stats bar");
    }

    // Filter panel
    public Locator filterPanel() {
        return findByTestId("filter-panel", "Filter panel containing category, rarity, and level filters");
    }

    public Locator sortSelect() {
        return findByTestId("sort-select", "Sort by dropdown select");
    }

    public Locator resetFiltersButton() {
        return findByTestId("reset-filters-button", "Reset all filters button");
    }

    public Locator categoryCheckbox(String category) {
        return findByTestId("category-checkbox-" + category,
                "Checkbox to filter by " + category + " category");
    }

    public Locator rarityCheckbox(String rarity) {
        return findByTestId("rarity-checkbox-" + rarity,
                "Checkbox to filter by " + rarity + " rarity");
    }

    public Locator minLevelInput() {
        return findByTestId("min-level-input", "Minimum level filter input field");
    }

    public Locator maxLevelInput() {
        return findByTestId("max-level-input", "Maximum level filter input field");
    }

    // Items grid
    public Locator itemsGrid() {
        return findByTestId("items-grid", "Grid container displaying all item cards");
    }

    public Locator emptyState() {
        return findByTestId("empty-state", "Empty state message when no items match filters");
    }

    public Locator itemCard(String itemId) {
        return findByTestId("item-card-" + itemId,
                "Item card for " + itemId);
    }

    public Locator itemName(String itemId) {
        return findByTestId("item-name-" + itemId,
                "Item name heading for " + itemId);
    }

    public Locator itemPrice(String itemId) {
        return findByTestId("item-price-" + itemId,
                "Price display for item " + itemId);
    }

    public Locator addToCartButton(String itemId) {
        return findByTestId("add-to-cart-" + itemId,
                "Add to cart button for " + itemId);
    }

    public Locator viewDetailsButton(String itemId) {
        return findByTestId("view-details-" + itemId,
                "View details button for item " + itemId);
    }

    public Locator rarityBadge(String itemId) {
        return findByTestId("rarity-badge-" + itemId,
                "Rarity badge label for item " + itemId);
    }

    // Modal
    public Locator modal() {
        return findByTestId("item-detail-modal", "Item detail modal dialog");
    }

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

    public Locator modalTotalPrice() {
        return findByTestId("modal-total-price", "Total price display in item detail modal");
    }

    public Locator modalEffectsList() {
        return findByTestId("modal-effects-list", "List of item effects in detail modal");
    }

    public Locator modalStatDamage() {
        return findByTestId("modal-stat-damage", "Damage stat value in item detail modal");
    }

    public Locator modalStatDefense() {
        return findByTestId("modal-stat-defense", "Defense stat value in item detail modal");
    }

    public Locator modalStatSpeed() {
        return findByTestId("modal-stat-speed", "Speed stat value in item detail modal");
    }

    // Toast
    public Locator toast() {
        return findByTestId("toast-notification", "Toast notification container");
    }

    public Locator toastMessage() {
        return findByTestId("toast-message", "Toast notification message text");
    }

    // Header / Navigation
    public Locator header() {
        return findByTestId("header", "Page header containing navigation");
    }

    public Locator logoLink() {
        return findByTestId("logo-link", "Logo/brand link that navigates to home page");
    }

    public Locator navHome() {
        return findByTestId("nav-home", "Home navigation link in header");
    }

    public Locator navInventory() {
        return findByTestId("nav-inventory", "Inventory navigation link in header");
    }

    public Locator navAbout() {
        return findByTestId("nav-about", "About navigation link in header");
    }

    public Locator cartBadge() {
        return findByTestId("cart-badge", "Cart item count badge on cart icon");
    }

    public Locator footer() {
        return findByTestId("footer", "Page footer section");
    }

    // Actions
    public void searchFor(String query) {
        searchInput().fill(query);
    }

    public void clearSearch() {
        searchClearButton().click();
    }

    public void selectCategory(String category) {
        categoryCheckbox(category).check();
    }

    public void selectRarity(String rarity) {
        rarityCheckbox(rarity).check();
    }

    public void sortBy(String value) {
        sortSelect().selectOption(value);
    }

    public void openItemDetail(String itemId) {
        itemCard(itemId).click();
    }

    public void addItemToCart(String itemId) {
        addToCartButton(itemId).click();
    }

    public int getDisplayedItemCount() {
        return itemsGrid().locator("[data-testid^='item-card-']").count();
    }
}
