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

        this.inventoryTitle = page.getByTestId("inventory-title");
        this.inventoryList = page.getByTestId("inventory-list");
        this.inventoryEmpty = page.getByTestId("inventory-empty");
        this.inventorySummary = page.getByTestId("inventory-summary");
        this.summaryTotalItems = page.getByTestId("summary-total-items");
        this.summaryEquipped = page.getByTestId("summary-equipped");
        this.summaryTotalDamage = page.getByTestId("summary-total-damage");
        this.summaryTotalDefense = page.getByTestId("summary-total-defense");
    }

    public void open() {
        navigate("/inventory");
    }

    // Dynamic locators
    public Locator inventoryItem(String itemId) {
        return page.getByTestId("inventory-item-" + itemId);
    }

    public Locator inventoryItemName(String itemId) {
        return page.getByTestId("inventory-item-name-" + itemId);
    }

    public Locator equipButton(String itemId) {
        return page.getByTestId("equip-button-" + itemId);
    }

    public Locator removeButton(String itemId) {
        return page.getByTestId("remove-button-" + itemId);
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
