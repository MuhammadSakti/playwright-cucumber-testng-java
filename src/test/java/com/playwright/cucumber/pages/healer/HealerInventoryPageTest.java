package com.playwright.cucumber.pages.healer;

import com.playwright.cucumber.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Healer test for InventoryPage — logs in, navigates to inventory, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerInventoryPageTest extends HealerBaseTest {

    private HealerInventoryPage inventoryPage;

    @Override
    protected String reportName() {
        return "InventoryPage";
    }

    @Override
    protected void preSetup() {
        // Login first to access inventory
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();
        loginPage.loginAs("warrior", "sword123");
        // Verify login succeeded before proceeding
        loginPage.headerUserName.waitFor();
    }

    @Override
    protected void navigateToPage() {
        inventoryPage = new HealerInventoryPage(page, healer);
        // Navigate via nav link to preserve auth state
        inventoryPage.navInventory.click();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        inventoryPage.healHeader();
    }

    @Test
    public void healNavHome() {
        inventoryPage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        inventoryPage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        inventoryPage.healNavAbout();
    }

    // --- Inventory Page ---

    @Test
    public void healInventoryTitle() {
        inventoryPage.healInventoryTitle();
    }

    @Test
    public void healInventoryList() {
        inventoryPage.healInventoryList();
    }

    @Test
    public void healInventorySummary() {
        inventoryPage.healInventorySummary();
    }

    @Test
    public void healSummaryTotalItems() {
        inventoryPage.healSummaryTotalItems();
    }

    @Test
    public void healSummaryEquipped() {
        inventoryPage.healSummaryEquipped();
    }

    @Test
    public void healSummaryTotalDamage() {
        inventoryPage.healSummaryTotalDamage();
    }

    @Test
    public void healSummaryTotalDefense() {
        inventoryPage.healSummaryTotalDefense();
    }
}