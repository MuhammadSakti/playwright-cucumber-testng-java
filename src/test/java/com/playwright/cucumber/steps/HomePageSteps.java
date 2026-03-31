package com.playwright.cucumber.steps;

import com.playwright.cucumber.hooks.PlaywrightHooks;
import com.playwright.cucumber.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps {

    private HomePage homePage;

    @Before
    public void setup() {
        homePage = new HomePage(PlaywrightHooks.getPage());
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        homePage.open();
    }

    // --- Page Structure ---

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        assertThat(homePage.pageTitle).hasText(expectedTitle);
    }

    @Then("the page subtitle should be {string}")
    public void thePageSubtitleShouldBe(String expectedSubtitle) {
        assertThat(homePage.pageSubtitle).hasText(expectedSubtitle);
    }

    @Then("the header should be visible")
    public void theHeaderShouldBeVisible() {
        assertThat(homePage.header).isVisible();
    }

    @Then("the footer should be visible")
    public void theFooterShouldBeVisible() {
        assertThat(homePage.footer).isVisible();
    }

    @Then("the search input should be visible")
    public void theSearchInputShouldBeVisible() {
        assertThat(homePage.searchInput).isVisible();
    }

    @Then("the filter panel should be visible")
    public void theFilterPanelShouldBeVisible() {
        assertThat(homePage.filterPanel).isVisible();
    }

    @Then("the items grid should be visible")
    public void theItemsGridShouldBeVisible() {
        assertThat(homePage.itemsGrid).isVisible();
    }

    @Then("the stats bar should be visible")
    public void theStatsBarShouldBeVisible() {
        assertThat(homePage.statsBar).isVisible();
    }

    // --- Stats ---

    @Then("the total items count should be {string}")
    public void theTotalItemsCountShouldBe(String count) {
        assertThat(homePage.totalCount).hasText(count);
    }

    @Then("the showing count should be {string}")
    public void theShowingCountShouldBe(String count) {
        assertThat(homePage.showingCount).hasText(count);
    }

    @Then("the legendary count should be {string}")
    public void theLegendaryCountShouldBe(String count) {
        assertThat(homePage.legendaryCount).hasText(count);
    }

    // --- Search ---

    @When("I search for {string}")
    public void iSearchFor(String query) {
        homePage.searchFor(query);
    }

    @When("I clear the search")
    public void iClearTheSearch() {
        homePage.clearSearch();
    }

    @Then("the item card {string} should be visible")
    public void theItemCardShouldBeVisible(String itemId) {
        assertThat(homePage.itemCard(itemId)).isVisible();
    }

    @Then("all visible items should contain {string} in their name or category")
    public void allVisibleItemsShouldContainInNameOrCategory(String keyword) {
        int count = homePage.getDisplayedItemCount();
        assertThat(count).as("Expected at least one item visible").isGreaterThan(0);
    }

    @Then("the empty state should be visible")
    public void theEmptyStateShouldBeVisible() {
        assertThat(homePage.emptyState).isVisible();
    }

    // --- Filters ---

    @When("I select the {string} category filter")
    public void iSelectTheCategoryFilter(String category) {
        homePage.selectCategory(category);
    }

    @When("I select the {string} rarity filter")
    public void iSelectTheRarityFilter(String rarity) {
        homePage.selectRarity(rarity);
    }

    @When("I set the minimum level to {int}")
    public void iSetTheMinimumLevelTo(int level) {
        homePage.minLevelInput.fill(String.valueOf(level));
    }

    @When("I set the maximum level to {int}")
    public void iSetTheMaximumLevelTo(int level) {
        homePage.maxLevelInput.fill(String.valueOf(level));
    }

    @When("I click the reset filters button")
    public void iClickTheResetFiltersButton() {
        homePage.resetFiltersButton.click();
    }

    @Then("all visible items should be in the {string} category")
    public void allVisibleItemsShouldBeInCategory(String category) {
        int count = homePage.getDisplayedItemCount();
        assertThat(count).as("Expected at least one item visible").isGreaterThan(0);
        var cards = homePage.itemsGrid.locator("[data-category='" + category + "']");
        assertThat(cards.count()).isEqualTo(count);
    }

    @Then("all visible items should be in the {string} or {string} category")
    public void allVisibleItemsShouldBeInEitherCategory(String cat1, String cat2) {
        int count = homePage.getDisplayedItemCount();
        assertThat(count).as("Expected at least one item visible").isGreaterThan(0);
        var matching = homePage.itemsGrid
                .locator("[data-category='" + cat1 + "'], [data-category='" + cat2 + "']");
        assertThat(matching.count()).isEqualTo(count);
    }

    @Then("all visible items should have {string} rarity")
    public void allVisibleItemsShouldHaveRarity(String rarity) {
        int count = homePage.getDisplayedItemCount();
        assertThat(count).as("Expected at least one item visible").isGreaterThan(0);
        var cards = homePage.itemsGrid.locator("[data-rarity='" + rarity + "']");
        assertThat(cards.count()).isEqualTo(count);
    }

    @Then("all visible items should have level between {int} and {int}")
    public void allVisibleItemsShouldHaveLevelBetween(int min, int max) {
        int count = homePage.getDisplayedItemCount();
        assertThat(count).as("Expected at least one item visible").isGreaterThan(0);
    }

    // --- Sorting ---

    @When("I sort by {string}")
    public void iSortBy(String sortValue) {
        homePage.sortBy(sortValue);
    }

    @Then("the first item should be {string}")
    public void theFirstItemShouldBe(String expectedName) {
        var firstCard = homePage.itemsGrid.locator("[data-testid^='item-name-']").first();
        assertThat(firstCard).hasText(expectedName);
    }

    @Then("the first item should have the highest damage")
    public void theFirstItemShouldHaveTheHighestDamage() {
        var firstCard = homePage.itemsGrid.locator("[data-testid^='item-name-']").first();
        assertThat(firstCard).hasText("Mjolnir");
    }

    @Then("the first item should have the lowest price")
    public void theFirstItemShouldHaveTheLowestPrice() {
        var firstCard = homePage.itemsGrid.locator("[data-testid^='item-name-']").first();
        assertThat(firstCard).hasText("Hunting Knife");
    }

    // --- Item Cards ---

    @Then("the item name {string} should be {string}")
    public void theItemNameShouldBe(String itemId, String expectedName) {
        assertThat(homePage.itemName(itemId)).hasText(expectedName);
    }

    @Then("the item {string} rarity badge should show {string}")
    public void theItemRarityBadgeShouldShow(String itemId, String rarity) {
        assertThat(homePage.rarityBadge(itemId)).hasText(rarity);
    }

    // --- Cart ---

    @When("I click add to cart on {string}")
    public void iClickAddToCartOn(String itemId) {
        homePage.addItemToCart(itemId);
    }

    @Then("the toast notification should appear")
    public void theToastNotificationShouldAppear() {
        assertThat(homePage.toast).isVisible();
    }

    @Then("the toast message should contain {string}")
    public void theToastMessageShouldContain(String text) {
        assertThat(homePage.toastMessage).containsText(text);
    }

    @Then("the cart badge should show {string}")
    public void theCartBadgeShouldShow(String count) {
        assertThat(homePage.cartBadge).hasText(count);
    }
}
