package com.playwright.cucumber.pages.healed;

import com.autoheal.core.AutoHealLocator;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.hooks.PlaywrightHooks;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

/**
 * Base page using AutoHeal locator for self-healing selectors.
 * Works both standalone (via setPage) and with Cucumber (via PlaywrightHooks).
 */
public abstract class AutoHealBasePage {

    private static final ThreadLocal<AutoHealLocator> autoHealLocator = new ThreadLocal<>();
    private static final ThreadLocal<Page> standalonePage = new ThreadLocal<>();

    public static void setAutoHeal(AutoHealLocator autoHeal) {
        autoHealLocator.set(autoHeal);
    }

    public static AutoHealLocator getAutoHeal() {
        return autoHealLocator.get();
    }

    public static void setPage(Page page) {
        standalonePage.set(page);
    }

    public static void clearAutoHeal() {
        AutoHealLocator ah = autoHealLocator.get();
        if (ah != null) {
            ah.shutdown();
        }
        autoHealLocator.remove();
        standalonePage.remove();
    }

    protected Page getPage() {
        Page p = standalonePage.get();
        if (p != null) return p;
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
        return getPage().locator(selector);
    }

    protected Locator findByTestId(String testId, String description) {
        return find("[data-testid='" + testId + "']", description);
    }

    protected Locator findById(String id, String description) {
        return find("#" + id, description);
    }
}
