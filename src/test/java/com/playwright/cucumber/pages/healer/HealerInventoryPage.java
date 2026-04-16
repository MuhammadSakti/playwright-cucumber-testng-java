package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.cucumber.pages.InventoryPage;

/**
 * Healer version of InventoryPage that extends the original page object.
 * Reuses all inherited locators and wraps them with auto-heal.
 * Passes 'this' as pageObject so the library can resolve source file and line via reflection.
 */
public class HealerInventoryPage extends InventoryPage {

    private final PlaywrightAutoHeal healer;

    public HealerInventoryPage(Page page, PlaywrightAutoHeal healer) {
        super(page);
        this.healer = healer;
    }

    // --- Heal static locators (inherited fields) ---

    public Locator healInventoryTitle() {
        return healer.find(inventoryTitle, "Inventory page title 'YOUR INVENTORY'", this);
    }

    public Locator healInventoryList() {
        return healer.find(inventoryList, "List container displaying all inventory items", this);
    }

    public Locator healInventoryEmpty() {
        return healer.find(inventoryEmpty, "Empty state message when inventory has no items", this);
    }

    public Locator healInventorySummary() {
        return healer.find(inventorySummary, "Inventory summary panel showing stats", this);
    }

    public Locator healSummaryTotalItems() {
        return healer.find(summaryTotalItems, "Total items count in inventory summary", this);
    }

    public Locator healSummaryEquipped() {
        return healer.find(summaryEquipped, "Equipped items count in inventory summary", this);
    }

    public Locator healSummaryTotalDamage() {
        return healer.find(summaryTotalDamage, "Total damage stat in inventory summary", this);
    }

    public Locator healSummaryTotalDefense() {
        return healer.find(summaryTotalDefense, "Total defense stat in inventory summary", this);
    }

    // --- Heal header/nav locators (inherited from BasePage) ---

    public Locator healHeader() {
        return healer.find(header, "Page header containing navigation", this);
    }

    public Locator healNavHome() {
        return healer.find(navHome, "Home navigation link in header", this);
    }

    public Locator healNavInventory() {
        return healer.find(navInventory, "Inventory navigation link in header", this);
    }

    public Locator healNavAbout() {
        return healer.find(navAbout, "About navigation link in header", this);
    }

    // --- Heal dynamic locators (no field match, source will be null) ---

    public Locator healInventoryItem(String itemId) {
        return healer.find(inventoryItem(itemId), "Inventory item card for " + itemId);
    }

    public Locator healInventoryItemName(String itemId) {
        return healer.find(inventoryItemName(itemId), "Item name label for " + itemId);
    }

    public Locator healEquipButton(String itemId) {
        return healer.find(equipButton(itemId), "Equip/unequip button for " + itemId);
    }

    public Locator healRemoveButton(String itemId) {
        return healer.find(removeButton(itemId), "Remove item button for " + itemId);
    }
}
