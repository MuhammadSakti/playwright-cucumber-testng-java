package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.cucumber.pages.HomePage;

/**
 * Healer version of HomePage that extends the original page object.
 * Reuses all inherited locators and wraps them with auto-heal.
 */
public class HealerHomePage extends HomePage {

    private final PlaywrightAutoHeal healer;

    public HealerHomePage(Page page, PlaywrightAutoHeal healer) {
        super(page);
        this.healer = healer;
    }

    // --- Heal static locators (inherited fields) ---

    public Locator healPageTitle() {
        return healer.find(pageTitle, "Main page title 'RPG ITEMS FINDER'");
    }

    public Locator healPageSubtitle() {
        return healer.find(pageSubtitle, "Page subtitle text below the main title");
    }

    public Locator healSearchInput() {
        return healer.find(searchInput, "Search input field for filtering items");
    }

    public Locator healSearchClearButton() {
        return healer.find(searchClearButton, "Clear/X button inside search input");
    }

    public Locator healStatsBar() {
        return healer.find(statsBar, "Stats bar showing item counts");
    }

    public Locator healTotalCount() {
        return healer.find(totalCount, "Total items count number in stats bar");
    }

    public Locator healShowingCount() {
        return healer.find(showingCount, "Currently showing items count in stats bar");
    }

    public Locator healLegendaryCount() {
        return healer.find(legendaryCount, "Legendary items count in stats bar");
    }

    public Locator healFilterPanel() {
        return healer.find(filterPanel, "Filter panel containing category, rarity, and level filters");
    }

    public Locator healSortSelect() {
        return healer.find(sortSelect, "Sort by dropdown select");
    }

    public Locator healResetFiltersButton() {
        return healer.find(resetFiltersButton, "Reset all filters button");
    }

    public Locator healMinLevelInput() {
        return healer.find(minLevelInput, "Minimum level filter input field");
    }

    public Locator healMaxLevelInput() {
        return healer.find(maxLevelInput, "Maximum level filter input field");
    }

    public Locator healItemsGrid() {
        return healer.find(itemsGrid, "Grid container displaying all item cards");
    }

    public Locator healEmptyState() {
        return healer.find(emptyState, "Empty state message when no items match filters");
    }

    public Locator healModal() {
        return healer.find(modal, "Item detail modal dialog");
    }

    public Locator healModalItemName() {
        return healer.find(modalItemName, "Item name in detail modal");
    }

    public Locator healModalCloseButton() {
        return healer.find(modalCloseButton, "Close button (X) in item detail modal");
    }

    public Locator healModalAddToCart() {
        return healer.find(modalAddToCart, "Add to Cart button in item detail modal");
    }

    public Locator healQuantityIncrease() {
        return healer.find(quantityIncrease, "Plus/increase quantity button in modal");
    }

    public Locator healQuantityDecrease() {
        return healer.find(quantityDecrease, "Minus/decrease quantity button in modal");
    }

    public Locator healQuantityValue() {
        return healer.find(quantityValue, "Current quantity number display in modal");
    }

    public Locator healModalTotalPrice() {
        return healer.find(modalTotalPrice, "Total price display in item detail modal");
    }

    public Locator healModalEffectsList() {
        return healer.find(modalEffectsList, "List of item effects in detail modal");
    }

    public Locator healModalStatDamage() {
        return healer.find(modalStatDamage, "Damage stat value in item detail modal");
    }

    public Locator healModalStatDefense() {
        return healer.find(modalStatDefense, "Defense stat value in item detail modal");
    }

    public Locator healModalStatSpeed() {
        return healer.find(modalStatSpeed, "Speed stat value in item detail modal");
    }

    public Locator healToast() {
        return healer.find(toast, "Toast notification container");
    }

    public Locator healToastMessage() {
        return healer.find(toastMessage, "Toast notification message text");
    }

    // --- Heal header/nav locators (inherited from BasePage) ---

    public Locator healHeader() {
        return healer.find(header, "Page header containing navigation");
    }

    public Locator healFooter() {
        return healer.find(footer, "Page footer section");
    }

    public Locator healLogoLink() {
        return healer.find(logoLink, "Logo/brand link that navigates to home page");
    }

    public Locator healNavHome() {
        return healer.find(navHome, "Home navigation link in header");
    }

    public Locator healNavInventory() {
        return healer.find(navInventory, "Inventory navigation link in header");
    }

    public Locator healNavAbout() {
        return healer.find(navAbout, "About navigation link in header");
    }

    public Locator healCartBadge() {
        return healer.find(cartBadge, "Cart item count badge on cart icon");
    }

    // --- Heal dynamic locators ---

    public Locator healCategoryCheckbox(String category) {
        return healer.find(categoryCheckbox(category), "Checkbox to filter by " + category + " category");
    }

    public Locator healRarityCheckbox(String rarity) {
        return healer.find(rarityCheckbox(rarity), "Checkbox to filter by " + rarity + " rarity");
    }

    public Locator healItemCard(String itemId) {
        return healer.find(itemCard(itemId), "Item card for " + itemId);
    }

    public Locator healItemName(String itemId) {
        return healer.find(itemName(itemId), "Item name heading for " + itemId);
    }

    public Locator healItemPrice(String itemId) {
        return healer.find(itemPrice(itemId), "Price display for item " + itemId);
    }

    public Locator healAddToCartButton(String itemId) {
        return healer.find(addToCartButton(itemId), "Add to cart button for " + itemId);
    }

    public Locator healViewDetailsButton(String itemId) {
        return healer.find(viewDetailsButton(itemId), "View details button for item " + itemId);
    }

    public Locator healRarityBadge(String itemId) {
        return healer.find(rarityBadge(itemId), "Rarity badge label for item " + itemId);
    }
}
