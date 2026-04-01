package com.playwright.cucumber.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.autoheal.config.AutoHealConfig;
import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.pages.healer.HealerHomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Standalone TestNG test using AutoHeal v2 (PlaywrightAutoHeal).
 * Uses the new auto-heal library with Claude/OpenAI/Gemini providers.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerSaktiHomePageTest {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static PlaywrightAutoHeal healer;
    private HealerHomePage homePage;

    @BeforeClass
    public void launchBrowser() {
        playwright = Playwright.create();

        String browserType = TestConfig.getBrowser();
        boolean headless = TestConfig.isHeadless();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless);

        browser = switch (browserType.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(launchOptions);
            case "webkit" -> playwright.webkit().launch(launchOptions);
            default -> playwright.chromium().launch(launchOptions);
        };

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1440, 900));
        context.setDefaultTimeout(10000);
        page = context.newPage();

        healer = PlaywrightAutoHeal.builder()
                .config(AutoHealConfig.fromEnv())
                .page(page)
                .build();
    }

    @BeforeMethod
    public void setup() {
        homePage = new HealerHomePage(page, healer);
    }

    @AfterClass
    public void closeBrowser() {
        if (healer != null) healer.finish();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    // --- Page Structure ---

    @Test
    public void verifyPageTitle() {
        homePage.open();
        assertThat(homePage.healPageTitle()).isVisible();
        assertThat(homePage.healPageTitle()).hasText("RPG ITEMS FINDER");
    }

    @Test
    public void verifyHeaderAndFooter() {
        homePage.open();
        assertThat(homePage.healHeader()).isVisible();
        assertThat(homePage.healFooter()).isVisible();
    }

    @Test
    public void verifySearchInput() {
        homePage.open();
        assertThat(homePage.healSearchInput()).isVisible();
    }

    @Test
    public void verifyStatsBar() {
        homePage.open();
        assertThat(homePage.healStatsBar()).isVisible();
        assertThat(homePage.healTotalCount()).isVisible();
        assertThat(homePage.healShowingCount()).isVisible();
    }

    @Test
    public void verifyFilterPanel() {
        homePage.open();
        assertThat(homePage.healFilterPanel()).isVisible();
        assertThat(homePage.healSortSelect()).isVisible();
        assertThat(homePage.healResetFiltersButton()).isVisible();
    }

    @Test
    public void verifyItemsGrid() {
        homePage.open();
        assertThat(homePage.healItemsGrid()).isVisible();
    }

    // --- Search ---

    @Test
    public void searchByName() {
        homePage.open();
        homePage.healSearchInput().fill("Excalibur");
        assertThat(homePage.healItemCard("excalibur")).isVisible();
    }

    @Test
    public void clearSearch() {
        homePage.open();
        homePage.healSearchInput().fill("sword");
        homePage.healSearchClearButton().click();
        assertThat(homePage.healTotalCount()).isVisible();
    }

    // --- Filters ---

    @Test
    public void filterByCategory() {
        homePage.open();
        homePage.healCategoryCheckbox("sword").check();
        int count = homePage.getDisplayedItemCount();
        org.assertj.core.api.Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    public void filterByRarity() {
        homePage.open();
        homePage.healRarityCheckbox("legendary").check();
        int count = homePage.getDisplayedItemCount();
        org.assertj.core.api.Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    public void sortByName() {
        homePage.open();
        homePage.healSortSelect().selectOption("name-asc");
        assertThat(homePage.healItemsGrid()).isVisible();
    }

    // --- Cart ---

    @Test
    public void addToCart() {
        homePage.open();
        homePage.healAddToCartButton("excalibur").click();
        assertThat(homePage.healToastMessage()).isVisible();
        assertThat(homePage.healCartBadge()).hasText("1");
    }

    // --- Modal ---

    @Test
    public void openAndCloseModal() {
        homePage.open();
        homePage.healItemCard("excalibur").click();
        assertThat(homePage.healModal()).isVisible();
        assertThat(homePage.healModalItemName()).isVisible();
        homePage.healModalCloseButton().click();
    }

    @Test
    public void modalQuantityControls() {
        homePage.open();
        homePage.healItemCard("excalibur").click();
        assertThat(homePage.healQuantityValue()).hasText("1");
        homePage.healQuantityIncrease().click();
        assertThat(homePage.healQuantityValue()).hasText("2");
        homePage.healQuantityDecrease().click();
        assertThat(homePage.healQuantityValue()).hasText("1");
    }

    // --- Navigation ---

    @Test
    public void navigateToInventory() {
        homePage.open();
        homePage.healNavInventory().click();
        page.waitForURL("**/inventory");
        org.assertj.core.api.Assertions.assertThat(page.url()).contains("/inventory");
    }

    @Test
    public void navigateToAbout() {
        homePage.open();
        homePage.healNavAbout().click();
        page.waitForURL("**/about");
        org.assertj.core.api.Assertions.assertThat(page.url()).contains("/about");
    }

    @Test
    public void verifyLogoIsVisible() {
        homePage.open();
        assertThat(homePage.healLogoLink()).isVisible();
    }
}
