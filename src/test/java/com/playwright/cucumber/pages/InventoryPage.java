package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage extends BasePage {

    public final Locator inventoryTitle;
    public final Locator inventoryList;
    public final Locator inventoryEmpty;
    public final Locator inventorySummary;
    public final Locator summaryTotalItems;
    public final Locator summaryEquipped;
    public final Locator summaryTotalDamage;
    public final Locator summaryTotalDefense;

    public InventoryPage(Page page) {
        super(page);

        this.inventoryTitle = byTestId("inventory-title");
        this.inventoryList = byTestId("inventory-list");
        this.inventoryEmpty = byTestId("inventory-empty");
        this.inventorySummary = byTestId("inventory-summary");
        this.summaryTotalItems = byTestId("summary-total-items");
        this.summaryEquipped = byTestId("summary-equipped");
        this.summaryTotalDamage = byTestId("summary-total-damage");
        this.summaryTotalDefense = byTestId("summary-total-defense");
    }

    public void open() {
        navigate("/inventory");
    }

    // Dynamic locators
    public Locator inventoryItem(String itemId) {
        return byTestId("inventory-item-" + itemId);
    }

    public Locator inventoryItemName(String itemId) {
        return byTestId("inventory-item-name-" + itemId);
    }

    public Locator equipButton(String itemId) {
        return byTestId("equip-button-" + itemId);
    }

    public Locator removeButton(String itemId) {
        return byTestId("remove-button-" + itemId);
    }

    public int getInventoryItemCount() {
        return inventoryList.locator("[data-testid^='inventory-item-']").count();
    }

    public boolean isItemEquipped(String itemId) {
        return "true".equals(inventoryItem(itemId).getAttribute("data-equipped"));
    }

    public void equipItem(String itemId) {
        equipButton(itemId).click();
    }

    public void removeItem(String itemId) {
        removeButton(itemId).click();
    }
}
