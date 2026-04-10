package com.playwright.cucumber.steps;

import com.playwright.cucumber.hooks.PlaywrightHooks;
import com.playwright.cucumber.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemDetailSteps {

    private HomePage homePage;

    @Before(order = 1)
    public void setup() {
        homePage = new HomePage(PlaywrightHooks.getPage());
    }

    @When("I click on the item card {string}")
    public void iClickOnTheItemCard(String itemId) {
        homePage.openItemDetail(itemId);
    }

    @Then("the item detail modal should be visible")
    public void theItemDetailModalShouldBeVisible() {
        assertThat(homePage.modal).isVisible();
    }

    @Then("the modal item name should be {string}")
    public void theModalItemNameShouldBe(String name) {
        assertThat(homePage.modalItemName).hasText(name);
    }

    @Then("the modal item rarity should be {string}")
    public void theModalItemRarityShouldBe(String rarity) {
        assertThat(homePage.modalItemRarity).hasText(rarity);
    }

    @Then("the modal item description should not be empty")
    public void theModalItemDescriptionShouldNotBeEmpty() {
        assertThat(homePage.modalItemDescription).not().hasText("");
    }

    @Then("the modal damage stat should be visible")
    public void theModalDamageStatShouldBeVisible() {
        assertThat(homePage.modalStatDamage).isVisible();
    }

    @Then("the modal defense stat should be visible")
    public void theModalDefenseStatShouldBeVisible() {
        assertThat(homePage.modalStatDefense).isVisible();
    }

    @Then("the modal speed stat should be visible")
    public void theModalSpeedStatShouldBeVisible() {
        assertThat(homePage.modalStatSpeed).isVisible();
    }

    @Then("the modal effects list should be visible")
    public void theModalEffectsListShouldBeVisible() {
        assertThat(homePage.modalEffectsList).isVisible();
    }

    @Then("the modal should show {int} effects")
    public void theModalShouldShowEffects(int count) {
        var effects = homePage.modalEffectsList.locator("[data-testid^='modal-effect-']");
        assertThat(effects.count()).isEqualTo(count);
    }

    // --- Quantity ---

    @Then("the quantity value should be {string}")
    public void theQuantityValueShouldBe(String value) {
        assertThat(homePage.quantityValue).hasText(value);
    }

    @When("I click the increase quantity button")
    public void iClickTheIncreaseQuantityButton() {
        homePage.quantityIncrease.click();
    }

    @When("I click the decrease quantity button")
    public void iClickTheDecreaseQuantityButton() {
        homePage.quantityDecrease.click();
    }

    @Then("the decrease quantity button should be disabled")
    public void theDecreaseQuantityButtonShouldBeDisabled() {
        assertThat(homePage.quantityDecrease).isDisabled();
    }

    @Then("the modal total price should be {string}")
    public void theModalTotalPriceShouldBe(String price) {
        assertThat(homePage.modalTotalPrice).hasText(price);
    }

    // --- Modal actions ---

    @When("I click modal add to cart")
    public void iClickModalAddToCart() {
        homePage.modalAddToCart.click();
    }

    @When("I click the modal close button")
    public void iClickTheModalCloseButton() {
        homePage.modalCloseButton.click();
    }

    @Then("the modal should be closed")
    public void theModalShouldBeClosed() {
        assertThat(homePage.modal).isHidden();
    }
}
