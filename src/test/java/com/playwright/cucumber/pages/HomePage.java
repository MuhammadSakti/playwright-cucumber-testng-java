package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;

public class HomePage extends BasePage {

    public void open() {
        navigate("/");
    }

    // Hero section
    public Locator pageTitle() { return byTestId("page-title"); }
    public Locator pageSubtitle() { return byTestId("page-subtitle"); }

    // Search
    public Locator searchInput() { return byTestId("search-input"); }
    public Locator searchClearButton() { return byTestId("search-clear-button"); }

    // Stats bar
    public Locator statsBar() { return byTestId("stats-bar"); }
    public Locator totalCount() { return byTestId("total-count"); }
    public Locator showingCount() { return byTestId("showing-count"); }
    public Locator legendaryCount() { return byTestId("legendary-count"); }

    // Filter panel
    public Locator filterPanel() { return byTestId("filter-panel"); }
    public Locator filterToggle() { return byTestId("filter-toggle"); }
    public Locator filterContent() { return byTestId("filter-content"); }
    public Locator sortSelect() { return byTestId("sort-select"); }
    public Locator resetFiltersButton() { return byTestId("reset-filters-button"); }

    public Locator categoryCheckbox(String category) {
        return byTestId("category-checkbox-" + category);
    }

    public Locator rarityCheckbox(String rarity) {
        return byTestId("rarity-checkbox-" + rarity);
    }

    public Locator minLevelInput() { return byTestId("min-level-input"); }
    public Locator maxLevelInput() { return byTestId("max-level-input"); }

    // Items grid
    public Locator itemsGrid() { return byTestId("items-grid"); }
    public Locator emptyState() { return byTestId("empty-state"); }

    public Locator itemCard(String itemId) {
        return byTestId("item-card-" + itemId);
    }

    public Locator itemName(String itemId) {
        return byTestId("item-name-" + itemId);
    }

    public Locator itemPrice(String itemId) {
        return byTestId("item-price-" + itemId);
    }

    public Locator addToCartButton(String itemId) {
        return byTestId("add-to-cart-" + itemId);
    }

    public Locator viewDetailsButton(String itemId) {
        return byTestId("view-details-" + itemId);
    }

    public Locator rarityBadge(String itemId) {
        return byTestId("rarity-badge-" + itemId);
    }

    public Locator itemStats(String itemId) {
        return byTestId("item-stats-" + itemId);
    }

    // Item count in grid
    public int getDisplayedItemCount() {
        return itemsGrid().locator("[data-testid^='item-card-']").count();
    }

    // Modal
    public Locator modal() { return byTestId("item-detail-modal"); }
    public Locator modalItemName() { return byTestId("modal-item-name"); }
    public Locator modalItemDescription() { return byTestId("modal-item-description"); }
    public Locator modalItemRarity() { return byTestId("modal-item-rarity"); }
    public Locator modalCloseButton() { return byTestId("modal-close-button"); }
    public Locator modalAddToCart() { return byTestId("modal-add-to-cart"); }
    public Locator quantityIncrease() { return byTestId("quantity-increase"); }
    public Locator quantityDecrease() { return byTestId("quantity-decrease"); }
    public Locator quantityValue() { return byTestId("quantity-value"); }
    public Locator modalTotalPrice() { return byTestId("modal-total-price"); }
    public Locator modalEffectsList() { return byTestId("modal-effects-list"); }
    public Locator modalStatDamage() { return byTestId("modal-stat-damage"); }
    public Locator modalStatDefense() { return byTestId("modal-stat-defense"); }
    public Locator modalStatSpeed() { return byTestId("modal-stat-speed"); }

    // Toast
    public Locator toast() { return byTestId("toast-notification"); }
    public Locator toastMessage() { return byTestId("toast-message"); }
    public Locator toastClose() { return byTestId("toast-close"); }

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

    public void deselectCategory(String category) {
        categoryCheckbox(category).uncheck();
    }

    public void selectRarity(String rarity) {
        rarityCheckbox(rarity).check();
    }

    public void sortBy(String value) {
        sortSelect().selectOption(value);
    }

    public void setLevelRange(int min, int max) {
        if (min > 0) minLevelInput().fill(String.valueOf(min));
        if (max > 0) maxLevelInput().fill(String.valueOf(max));
    }

    public void openItemDetail(String itemId) {
        itemCard(itemId).click();
    }

    public void addItemToCart(String itemId) {
        addToCartButton(itemId).click();
    }
}
