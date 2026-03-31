package com.autoheal.demo.pages.healed;

import com.autoheal.core.AutoHealLocator;
import com.autoheal.demo.config.TestConfig;
import com.autoheal.demo.hooks.PlaywrightHooks;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Base page using AutoHeal locator for self-healing selectors.
 * When a selector breaks (e.g. data-testid renamed, ID changed),
 * AutoHeal will use AI to find the correct element.
 *
 * To use: set up AutoHeal in hooks and inject the instance here.
 *
 * Usage example:
 * <pre>
 *   AutoHealLocator autoHeal = AutoHealLocator.builder()
 *       .withPlaywrightPage(page)
 *       .withAIProvider(AIProvider.GOOGLE_GEMINI)
 *       .withStrategy(ExecutionStrategy.SMART_SEQUENTIAL)
 *       .build();
 *
 *   AutoHealBasePage.setAutoHeal(autoHeal);
 * </pre>
 */
public abstract class AutoHealBasePage {

    private static final ThreadLocal<AutoHealLocator> autoHealLocator = new ThreadLocal<>();

    public static void setAutoHeal(AutoHealLocator autoHeal) {
        autoHealLocator.set(autoHeal);
    }

    public static AutoHealLocator getAutoHeal() {
        return autoHealLocator.get();
    }

    public static void clearAutoHeal() {
        AutoHealLocator ah = autoHealLocator.get();
        if (ah != null) {
            ah.shutdown();
        }
        autoHealLocator.remove();
    }

    protected Page getPage() {
        return PlaywrightHooks.getPage();
    }

    protected void navigate(String path) {
        getPage().navigate(TestConfig.getBaseUrl() + path);
    }

    /**
     * Find an element using AutoHeal. If AutoHeal is configured, it will
     * attempt the selector first, then use AI to self-heal if broken.
     * Falls back to regular Playwright locator if AutoHeal is not set up.
     */
    protected Locator find(String selector, String description) {
        AutoHealLocator ah = autoHealLocator.get();
        if (ah != null) {
            return ah.find(getPage(), selector, description);
        }
        // Fallback to standard Playwright locator
        return getPage().locator(selector);
    }

    /**
     * Find by data-testid using AutoHeal.
     */
    protected Locator findByTestId(String testId, String description) {
        return find("[data-testid='" + testId + "']", description);
    }

    /**
     * Find by ID using AutoHeal.
     */
    protected Locator findById(String id, String description) {
        return find("#" + id, description);
    }
}
