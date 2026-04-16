package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.autoheal.ai.FailureContext;
import com.autoheal.config.AutoHealConfig;
import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Shared lifecycle for healer tests. Manages Playwright/browser setup,
 * PlaywrightAutoHeal creation, DOM capture + batch healing, and teardown
 * with failure analysis. Subclasses provide the report name, an optional
 * pre-healer setup step (e.g. login), and navigation to the target page.
 */
public abstract class HealerBaseTest {

    private static final AtomicBoolean DASHBOARD_GENERATED = new AtomicBoolean(false);

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected PlaywrightAutoHeal healer;
    protected String setupError;

    protected abstract String reportName();

    protected abstract void navigateToPage();

    /** Optional hook for work done before the healer is created (e.g. login). */
    protected void preSetup() {
        // no-op by default
    }

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
        context.setDefaultTimeout(30000);
        page = context.newPage();

        healer = PlaywrightAutoHeal.builder()
                .config(AutoHealConfig.load())
                .page(page)
                .reportName(reportName())
                .build();

        try {
            preSetup();
            navigateToPage();

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

    /**
     * Generates the cross-class AutoHeal dashboard once per suite run,
     * aggregating every {@code AutoHeal_*.json} produced by the healer
     * subclasses into a single {@code dashboard.html} in the same run folder.
     */
    @AfterSuite(alwaysRun = true)
    public void generateReportDashboard() {
        if (DASHBOARD_GENERATED.compareAndSet(false, true)) {
            PlaywrightAutoHeal.generateReportDashboard(AutoHealConfig.fromEnv());
        }
    }
}