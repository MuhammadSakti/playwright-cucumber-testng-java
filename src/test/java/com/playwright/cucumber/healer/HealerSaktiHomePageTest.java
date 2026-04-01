package com.playwright.cucumber.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.autoheal.config.AutoHealConfig;
import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.pages.healer.HealerHomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * Healer test for HomePage — navigates once, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerSaktiHomePageTest {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static PlaywrightAutoHeal healer;
    private static HealerHomePage homePage;

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

        homePage = new HealerHomePage(page, healer);
        homePage.open();

        // Capture DOM once, then batch heal all broken locators in one AI call
        healer.captureDom();
        healer.startBatch();
    }

    @AfterClass
    public void closeBrowser() {
        // Flush batch — sends one AI call for all broken locators
        healer.flushBatch();
        if (healer != null) healer.finish();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        homePage.healHeader();
    }

    @Test
    public void healFooter() {
        homePage.healFooter();
    }

    @Test
    public void healLogoLink() {
        homePage.healLogoLink();
    }

    @Test
    public void healNavHome() {
        homePage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        homePage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        homePage.healNavAbout();
    }

    @Test
    public void healCartBadge() {
        homePage.healCartBadge();
    }

    // --- Hero ---

    @Test
    public void healPageTitle() {
        homePage.healPageTitle();
    }

    @Test
    public void healPageSubtitle() {
        homePage.healPageSubtitle();
    }

    // --- Search ---

    @Test
    public void healSearchInput() {
        homePage.healSearchInput();
    }

    // --- Stats Bar ---

    @Test
    public void healStatsBar() {
        homePage.healStatsBar();
    }

    @Test
    public void healTotalCount() {
        homePage.healTotalCount();
    }

    @Test
    public void healShowingCount() {
        homePage.healShowingCount();
    }

    // --- Filter Panel ---

    @Test
    public void healFilterPanel() {
        homePage.healFilterPanel();
    }

    @Test
    public void healSortSelect() {
        homePage.healSortSelect();
    }

    @Test
    public void healResetFiltersButton() {
        homePage.healResetFiltersButton();
    }

    @Test
    public void healMinLevelInput() {
        homePage.healMinLevelInput();
    }

    @Test
    public void healMaxLevelInput() {
        homePage.healMaxLevelInput();
    }

    // --- Items Grid ---

    @Test
    public void healItemsGrid() {
        homePage.healItemsGrid();
    }
}
