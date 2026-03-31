package com.playwright.cucumber.steps;

import com.playwright.cucumber.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class InventorySteps {

    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("I am on the inventory page")
    public void iAmOnTheInventoryPage() {
        inventoryPage.open();
    }

    @Then("the inventory title should be {string}")
    public void theInventoryTitleShouldBe(String title) {
        assertThat(inventoryPage.inventoryTitle()).hasText(title);
    }

    @Then("the inventory list should be visible")
    public void theInventoryListShouldBeVisible() {
        assertThat(inventoryPage.inventoryList()).isVisible();
    }

    @Then("the inventory should have {int} items")
    public void theInventoryShouldHaveItems(int count) {
        assertThat(inventoryPage.getInventoryItemCount()).isEqualTo(count);
    }

    @When("I equip the item {string}")
    public void iEquipTheItem(String itemId) {
        inventoryPage.equipItem(itemId);
    }

    @Then("the item {string} should be equipped")
    public void theItemShouldBeEquipped(String itemId) {
        assertThat(inventoryPage.isItemEquipped(itemId)).isTrue();
    }

    @Then("the item {string} should not be equipped")
    public void theItemShouldNotBeEquipped(String itemId) {
        assertThat(inventoryPage.isItemEquipped(itemId)).isFalse();
    }

    @Then("the equip button for {string} should show {string}")
    public void theEquipButtonShouldShow(String itemId, String text) {
        assertThat(inventoryPage.equipButton(itemId)).hasText(text);
    }

    @When("I remove the item {string}")
    public void iRemoveTheItem(String itemId) {
        inventoryPage.removeItem(itemId);
    }

    @Then("the item {string} should not be in the inventory")
    public void theItemShouldNotBeInInventory(String itemId) {
        assertThat(inventoryPage.inventoryItem(itemId)).isHidden();
    }

    // --- Summary ---

    @Then("the equipped count should be {string}")
    public void theEquippedCountShouldBe(String count) {
        var equippedEl = inventoryPage.summaryEquipped().locator("span.text-lg");
        assertThat(equippedEl).hasText(count);
    }

    @Then("the total damage should be greater than {string}")
    public void theTotalDamageShouldBeGreaterThan(String value) {
        var damageEl = inventoryPage.summaryTotalDamage().locator("span.text-lg");
        String text = damageEl.textContent().trim();
        assertThat(Integer.parseInt(text)).isGreaterThan(Integer.parseInt(value));
    }

    @Then("the total items count in summary should be {string}")
    public void theTotalItemsCountInSummaryShouldBe(String count) {
        var totalEl = inventoryPage.summaryTotalItems().locator("span.text-lg");
        assertThat(totalEl).hasText(count);
    }
}
