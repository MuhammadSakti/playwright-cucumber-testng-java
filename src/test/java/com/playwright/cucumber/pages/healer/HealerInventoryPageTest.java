package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.autoheal.ai.FailureContext;
import com.autoheal.config.AutoHealConfig;
import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Healer test for InventoryPage — logs in, navigates to inventory, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerInventoryPageTest {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static PlaywrightAutoHeal healer;
    private static HealerInventoryPage inventoryPage;
    private static String setupError;

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

        // Login first to access inventory
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();
        loginPage.loginAs("warrior", "sword123");

        healer = PlaywrightAutoHeal.builder()
                .config(AutoHealConfig.fromEnv())
                .page(page)
                .reportName("InventoryPage")
                .build();

        try {
            inventoryPage = new HealerInventoryPage(page, healer);
            // Navigate via nav link to preserve auth state
            inventoryPage.navInventory.click();

            // Capture DOM once, then batch heal all broken locators in one AI call
            healer.captureDom();
            healer.startBatch();
        } catch (Exception e) {
            setupError = e.toString();
            throw e;
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (healer != null) {
            if (setupError == null) healer.flushBatch();
            if (setupError != null) {
                try {
                    healer.analyzeFailure(setupError);
                } catch (Exception e) {
                    System.err.println("[AutoHeal] Screenshot failed, analyzing error log only: " + e.getMessage());
                    healer.analyzeFailure(FailureContext.builder().errorLog(setupError).build());
                }
            }
            healer.finish();
        }
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        inventoryPage.healHeader();
    }

    @Test
    public void healFooter() {
        inventoryPage.healFooter();
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
