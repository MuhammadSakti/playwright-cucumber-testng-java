package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.playwright.cucumber.config.TestConfig;

public abstract class BasePage {

    protected final Page page;

    // Header elements (shared across all pages)
    public final Locator header;
    public final Locator logoLink;
    public final Locator navHome;
    public final Locator navInventory;
    public final Locator navAbout;
    public final Locator cartButton;
    public final Locator cartBadge;
    public final Locator profileButton;
    public final Locator mobileMenuToggle;
    public final Locator mobileMenu;
    public final Locator footer;

    public BasePage(Page page) {
        this.page = page;

        this.header = byTestId("header");
        this.logoLink = byTestId("logo-link");
        this.navHome = byTestId("nav-home");
        this.navInventory = byTestId("nav-inventory");
        this.navAbout = byTestId("nav-about");
        this.cartButton = byTestId("cart-button");
        this.cartBadge = byTestId("cart-badge");
        this.profileButton = byTestId("profile-button");
        this.mobileMenuToggle = byTestId("mobile-menu-toggle");
        this.mobileMenu = byTestId("mobile-menu");
        this.footer = byTestId("footer");
    }

    protected void navigate(String path) {
        page.navigate(TestConfig.getBaseUrl() + path);
    }

    protected Locator byTestId(String testId) {
        return page.getByTestId(testId);
    }

    protected Locator byRole(AriaRole role, String name) {
        return page.getByRole(role, new Page.GetByRoleOptions().setName(name));
    }

    protected Locator byId(String id) {
        return page.locator("#" + id);
    }

    protected Locator byCss(String css) {
        return page.locator(css);
    }

    protected Locator byLabel(String label) {
        return page.getByLabel(label);
    }

    protected Locator byText(String text) {
        return page.getByText(text);
    }

    protected Locator byPlaceholder(String placeholder) {
        return page.getByPlaceholder(placeholder);
    }
}
