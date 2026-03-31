package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;

public class InventoryPage extends BasePage {

    public void open() {
        navigate("/inventory");
    }

    public Locator inventoryTitle() { return byTestId("inventory-title"); }
    public Locator inventoryList() { return byTestId("inventory-list"); }
    public Locator inventoryEmpty() { return byTestId("inventory-empty"); }

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

    // Summary
    public Locator inventorySummary() { return byTestId("inventory-summary"); }
    public Locator summaryTotalItems() { return byTestId("summary-total-items"); }
    public Locator summaryEquipped() { return byTestId("summary-equipped"); }
    public Locator summaryTotalDamage() { return byTestId("summary-total-damage"); }
    public Locator summaryTotalDefense() { return byTestId("summary-total-defense"); }

    public int getInventoryItemCount() {
        return inventoryList().locator("[data-testid^='inventory-item-']").count();
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
