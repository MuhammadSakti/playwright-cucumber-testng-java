package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    // Hero section
    public final Locator pageTitle;
    public final Locator pageSubtitle;

    // Search
    public final Locator searchInput;
    public final Locator searchClearButton;

    // Stats bar
    public final Locator statsBar;
    public final Locator totalCount;
    public final Locator showingCount;
    public final Locator legendaryCount;

    // Filter panel
    public final Locator filterPanel;
    public final Locator filterToggle;
    public final Locator filterContent;
    public final Locator sortSelect;
    public final Locator resetFiltersButton;
    public final Locator minLevelInput;
    public final Locator maxLevelInput;

    // Items grid
    public final Locator itemsGrid;
    public final Locator emptyState;

    // Modal
    public final Locator modal;
    public final Locator modalItemName;
    public final Locator modalItemDescription;
    public final Locator modalItemRarity;
    public final Locator modalCloseButton;
    public final Locator modalAddToCart;
    public final Locator quantityIncrease;
    public final Locator quantityDecrease;
    public final Locator quantityValue;
    public final Locator modalTotalPrice;
    public final Locator modalEffectsList;
    public final Locator modalStatDamage;
    public final Locator modalStatDefense;
    public final Locator modalStatSpeed;

    // Toast
    public final Locator toast;
    public final Locator toastMessage;
    public final Locator toastClose;

    public HomePage(Page page) {
        super(page);

        // Hero
        this.pageTitle = byTestId("page-title");
        this.pageSubtitle = byTestId("page-subtitle");

        // Search
        this.searchInput = byTestId("search-input");
        this.searchClearButton = byTestId("search-clear-button");

        // Stats bar
        this.statsBar = byTestId("stats-bar");
        this.totalCount = byTestId("total-count");
        this.showingCount = byTestId("showing-count");
        this.legendaryCount = byTestId("legendary-count");

        // Filter panel
        this.filterPanel = byTestId("filter-panel");
        this.filterToggle = byTestId("filter-toggle");
        this.filterContent = byTestId("filter-content");
        this.sortSelect = byTestId("sort-select");
        this.resetFiltersButton = byTestId("reset-filters-button");
        this.minLevelInput = byTestId("min-level-input");
        this.maxLevelInput = byTestId("max-level-input");

        // Items grid
        this.itemsGrid = byTestId("items-grid");
        this.emptyState = byTestId("empty-state");

        // Modal
        this.modal = byTestId("item-detail-modal");
        this.modalItemName = byTestId("modal-item-name");
        this.modalItemDescription = byTestId("modal-item-description");
        this.modalItemRarity = byTestId("modal-item-rarity");
        this.modalCloseButton = byTestId("modal-close-button");
        this.modalAddToCart = byTestId("modal-add-to-cart");
        this.quantityIncrease = byTestId("quantity-increase");
        this.quantityDecrease = byTestId("quantity-decrease");
        this.quantityValue = byTestId("quantity-value");
        this.modalTotalPrice = byTestId("modal-total-price");
        this.modalEffectsList = byTestId("modal-effects-list");
        this.modalStatDamage = byTestId("modal-stat-damage");
        this.modalStatDefense = byTestId("modal-stat-defense");
        this.modalStatSpeed = byTestId("modal-stat-speed");

        // Toast
        this.toast = byTestId("toast-notification");
        this.toastMessage = byTestId("toast-message");
        this.toastClose = byTestId("toast-close");
    }

    public void open() {
        navigate("/");
    }

    // Dynamic locators (require parameter)
    public Locator categoryCheckbox(String category) {
        return byTestId("category-checkbox-" + category);
    }

    public Locator rarityCheckbox(String rarity) {
        return byTestId("rarity-checkbox-" + rarity);
    }

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

    public int getDisplayedItemCount() {
        return itemsGrid.locator("[data-testid^='item-card-']").count();
    }

    // Actions
    public void searchFor(String query) {
        searchInput.fill(query);
    }

    public void clearSearch() {
        searchClearButton.click();
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
        sortSelect.selectOption(value);
    }

    public void setLevelRange(int min, int max) {
        if (min > 0) minLevelInput.fill(String.valueOf(min));
        if (max > 0) maxLevelInput.fill(String.valueOf(max));
    }

    public void openItemDetail(String itemId) {
        itemCard(itemId).click();
    }

    public void addItemToCart(String itemId) {
        addToCartButton(itemId).click();
    }
}
