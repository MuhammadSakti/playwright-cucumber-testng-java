package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
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

        this.header = page.getByTestId("app-header");
        this.logoLink = page.getByTestId("brand-link");
        this.navHome = page.getByTestId("link-home");
        this.navInventory = page.getByTestId("link-inventory");
        this.navAbout = page.getByTestId("link-about");
        this.cartButton = page.getByTestId("cart-button");
        this.cartBadge = page.getByTestId("btn-shopping-cart");
        this.profileButton = page.getByTestId("profile-button");
        this.mobileMenuToggle = page.getByTestId("mobile-menu-toggle");
        this.mobileMenu = page.getByTestId("mobile-menu");
        this.footer = page.getByTestId("footer");
    }

    protected void navigate(String path) {
        page.navigate(TestConfig.getBaseUrl() + path);
    }

}
