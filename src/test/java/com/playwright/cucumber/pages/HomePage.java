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
        this.pageTitle = page.getByTestId("page-title");
        this.pageSubtitle = page.getByTestId("page-subtitle");

        // Search
        this.searchInput = page.getByTestId("search-input");
        this.searchClearButton = page.getByTestId("search-clear-button");

        // Stats bar
        this.statsBar = page.getByTestId("stats-bar");
        this.totalCount = page.getByTestId("total-count");
        this.showingCount = page.getByTestId("showing-count");
        this.legendaryCount = page.getByTestId("legendary-count");

        // Filter panel
        this.filterPanel = page.getByTestId("filter-panel");
        this.filterToggle = page.getByTestId("filter-toggle");
        this.filterContent = page.getByTestId("filter-content");
        this.sortSelect = page.getByTestId("sort-select");
        this.resetFiltersButton = page.getByTestId("reset-filters-button");
        this.minLevelInput = page.getByTestId("min-level-input");
        this.maxLevelInput = page.getByTestId("max-level-input");

        // Items grid
        this.itemsGrid = page.getByTestId("items-grid");
        this.emptyState = page.getByTestId("empty-state");

        // Modal
        this.modal = page.getByTestId("item-detail-modal");
        this.modalItemName = page.getByTestId("modal-item-name");
        this.modalItemDescription = page.getByTestId("modal-item-description");
        this.modalItemRarity = page.getByTestId("modal-item-rarity");
        this.modalCloseButton = page.getByTestId("modal-close-button");
        this.modalAddToCart = page.getByTestId("modal-add-to-cart");
        this.quantityIncrease = page.getByTestId("quantity-increase");
        this.quantityDecrease = page.getByTestId("quantity-decrease");
        this.quantityValue = page.getByTestId("quantity-value");
        this.modalTotalPrice = page.getByTestId("modal-total-price");
        this.modalEffectsList = page.getByTestId("modal-effects-list");
        this.modalStatDamage = page.getByTestId("modal-stat-damage");
        this.modalStatDefense = page.getByTestId("modal-stat-defense");
        this.modalStatSpeed = page.getByTestId("modal-stat-speed");

        // Toast
        this.toast = page.getByTestId("toast-notification");
        this.toastMessage = page.getByTestId("toast-message");
        this.toastClose = page.getByTestId("toast-close");
    }

    public void open() {
        navigate("/");
    }

    // Dynamic locators (require parameter)
    public Locator categoryCheckbox(String category) {
        return page.getByTestId("category-checkbox-" + category);
    }

    public Locator rarityCheckbox(String rarity) {
        return page.getByTestId("rarity-checkbox-" + rarity);
    }

    public Locator itemCard(String itemId) {
        return page.getByTestId("item-card-" + itemId);
    }

    public Locator itemName(String itemId) {
        return page.getByTestId("item-name-" + itemId);
    }

    public Locator itemPrice(String itemId) {
        return page.getByTestId("item-price-" + itemId);
    }

    public Locator addToCartButton(String itemId) {
        return page.getByTestId("add-to-cart-" + itemId);
    }

    public Locator viewDetailsButton(String itemId) {
        return page.getByTestId("view-details-" + itemId);
    }

    public Locator rarityBadge(String itemId) {
        return page.getByTestId("rarity-badge-" + itemId);
    }

    public Locator itemStats(String itemId) {
        return page.getByTestId("item-stats-" + itemId);
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
