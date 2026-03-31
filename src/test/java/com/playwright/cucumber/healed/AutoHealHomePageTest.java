package com.playwright.cucumber.healed;

import com.autoheal.core.AutoHealLocator;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.pages.healed.AutoHealBasePage;
import com.playwright.cucumber.pages.healed.AutoHealHomePage;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Standalone TestNG test that runs AutoHeal locators directly.
 * No Cucumber needed — just Playwright + AutoHeal + TestNG.
 *
 * Run with: mvn test -DsuiteXmlFile=testng-autoheal.xml
 */
public class AutoHealHomePageTest {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static AutoHealLocator autoHeal;
    private AutoHealHomePage homePage;

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

        // Initialize AutoHeal once — reads AI provider and API key from .env
        autoHeal = AutoHealLocator.builder()
                .withPlaywrightPage(page)
                .build();

        AutoHealBasePage.setPage(page);
        AutoHealBasePage.setAutoHeal(autoHeal);
    }

    @BeforeMethod
    public void setup() {
        homePage = new AutoHealHomePage();
    }

    @AfterClass
    public void closeBrowser() {
        // Shutdown AutoHeal once — generates one consolidated report
        AutoHealBasePage.clearAutoHeal();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();

        // Apply healed selectors to page object source files
        try {
            PageObjectUpdater.applyFromLatestReport();
        } catch (Exception e) {
            System.err.println("Failed to update page objects: " + e.getMessage());
        }
    }

    // --- Page Structure ---

    @Test
    public void verifyPageTitle() {
        homePage.open();
        assertThat(homePage.pageTitle()).isVisible();
        assertThat(homePage.pageTitle()).hasText("RPG ITEMS FINDER");
    }

    @Test
    public void verifyHeaderAndFooter() {
        homePage.open();
        assertThat(homePage.header()).isVisible();
        assertThat(homePage.footer()).isVisible();
    }

    @Test
    public void verifySearchInput() {
        homePage.open();
        assertThat(homePage.searchInput()).isVisible();
    }

    @Test
    public void verifyStatsBar() {
        homePage.open();
        assertThat(homePage.statsBar()).isVisible();
        assertThat(homePage.totalCount()).isVisible();
        assertThat(homePage.showingCount()).isVisible();
    }

    @Test
    public void verifyFilterPanel() {
        homePage.open();
        assertThat(homePage.filterPanel()).isVisible();
        assertThat(homePage.sortSelect()).isVisible();
        assertThat(homePage.resetFiltersButton()).isVisible();
    }

    @Test
    public void verifyItemsGrid() {
        homePage.open();
        assertThat(homePage.itemsGrid()).isVisible();
    }

    // --- Search ---

    @Test
    public void searchByName() {
        homePage.open();
        homePage.searchFor("Excalibur");
        assertThat(homePage.itemCard("excalibur")).isVisible();
    }

    @Test
    public void clearSearch() {
        homePage.open();
        homePage.searchFor("sword");
        homePage.clearSearch();
        assertThat(homePage.totalCount()).isVisible();
    }

    // --- Filters ---

    @Test
    public void filterByCategory() {
        homePage.open();
        homePage.selectCategory("sword");
        int count = homePage.getDisplayedItemCount();
        org.assertj.core.api.Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    public void filterByRarity() {
        homePage.open();
        homePage.selectRarity("legendary");
        int count = homePage.getDisplayedItemCount();
        org.assertj.core.api.Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    public void sortByName() {
        homePage.open();
        homePage.sortBy("name-asc");
        assertThat(homePage.itemsGrid()).isVisible();
    }

    // --- Cart ---

    @Test
    public void addToCart() {
        homePage.open();
        homePage.addItemToCart("excalibur");
        assertThat(homePage.toastMessage()).isVisible();
        assertThat(homePage.cartBadge()).hasText("1");
    }

    // --- Modal ---

    @Test
    public void openAndCloseModal() {
        homePage.open();
        homePage.openItemDetail("excalibur");
        assertThat(homePage.modal()).isVisible();
        assertThat(homePage.modalItemName()).isVisible();
        homePage.modalCloseButton().click();
    }

    @Test
    public void modalQuantityControls() {
        homePage.open();
        homePage.openItemDetail("excalibur");
        assertThat(homePage.quantityValue()).hasText("1");
        homePage.quantityIncrease().click();
        assertThat(homePage.quantityValue()).hasText("2");
        homePage.quantityDecrease().click();
        assertThat(homePage.quantityValue()).hasText("1");
    }

    // --- Navigation ---

    @Test
    public void navigateToInventory() {
        homePage.open();
        homePage.navInventory().click();
        page.waitForURL("**/inventory");
        org.assertj.core.api.Assertions.assertThat(page.url()).contains("/inventory");
    }

    @Test
    public void navigateToAbout() {
        homePage.open();
        homePage.navAbout().click();
        page.waitForURL("**/about");
        org.assertj.core.api.Assertions.assertThat(page.url()).contains("/about");
    }

    @Test
    public void verifyLogoIsVisible() {
        homePage.open();
        assertThat(homePage.logoLink()).isVisible();
    }
}
