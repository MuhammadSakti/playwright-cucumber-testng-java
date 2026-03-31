package com.autoheal.demo.pages;

import com.autoheal.demo.config.TestConfig;
import com.autoheal.demo.hooks.PlaywrightHooks;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public abstract class BasePage {

    protected Page getPage() {
        return PlaywrightHooks.getPage();
    }

    protected void navigate(String path) {
        getPage().navigate(TestConfig.getBaseUrl() + path);
    }

    protected Locator byTestId(String testId) {
        return getPage().getByTestId(testId);
    }

    protected Locator byRole(AriaRole role, String name) {
        return getPage().getByRole(role, new Page.GetByRoleOptions().setName(name));
    }

    protected Locator byId(String id) {
        return getPage().locator("#" + id);
    }

    protected Locator byCss(String css) {
        return getPage().locator(css);
    }

    protected Locator byLabel(String label) {
        return getPage().getByLabel(label);
    }

    protected Locator byText(String text) {
        return getPage().getByText(text);
    }

    protected Locator byPlaceholder(String placeholder) {
        return getPage().getByPlaceholder(placeholder);
    }

    // Header elements (shared across all pages)
    public Locator header() { return byTestId("header"); }
    public Locator logoLink() { return byTestId("logo-link"); }
    public Locator navHome() { return byTestId("nav-home"); }
    public Locator navInventory() { return byTestId("nav-inventory"); }
    public Locator navAbout() { return byTestId("nav-about"); }
    public Locator cartButton() { return byTestId("cart-button"); }
    public Locator cartBadge() { return byTestId("cart-badge"); }
    public Locator profileButton() { return byTestId("profile-button"); }
    public Locator mobileMenuToggle() { return byTestId("mobile-menu-toggle"); }
    public Locator mobileMenu() { return byTestId("mobile-menu"); }
    public Locator footer() { return byTestId("footer"); }
}
