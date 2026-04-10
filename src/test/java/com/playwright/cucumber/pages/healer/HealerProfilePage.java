package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.cucumber.pages.ProfilePage;

/**
 * Healer version of ProfilePage that extends the original page object.
 * Reuses all inherited locators and wraps them with auto-heal.
 * Passes 'this' as pageObject so the library can resolve source file and line via reflection.
 */
public class HealerProfilePage extends ProfilePage {

    private final PlaywrightAutoHeal healer;

    public HealerProfilePage(Page page, PlaywrightAutoHeal healer) {
        super(page);
        this.healer = healer;
    }

    // --- Heal static locators (inherited fields) ---

    public Locator healProfilePage() {
        return healer.find(profilePage, "Profile page container", this);
    }

    public Locator healProfileTitle() {
        return healer.find(profileTitle, "Profile page title 'ADVENTURER PROFILE'", this);
    }

    // --- Not logged in state ---

    public Locator healProfileNotLoggedIn() {
        return healer.find(profileNotLoggedIn, "Not logged in state container", this);
    }

    public Locator healGoToLoginButton() {
        return healer.find(goToLoginButton, "Go to login button when not logged in", this);
    }

    // --- User card ---

    public Locator healUserCard() {
        return healer.find(userCard, "User profile card container", this);
    }

    public Locator healUserAvatar() {
        return healer.find(userAvatar, "User avatar image in header", this);
    }

    public Locator healProfileDisplayName() {
        return healer.find(profileDisplayName, "User display name on profile", this);
    }

    public Locator healProfileStats() {
        return healer.find(profileStats, "Profile stats container with role, level, guild", this);
    }

    public Locator healProfileRole() {
        return healer.find(profileRole, "User role text (e.g. Warrior, Mage)", this);
    }

    public Locator healProfileLevel() {
        return healer.find(profileLevel, "User level number", this);
    }

    public Locator healProfileGuild() {
        return healer.find(profileGuild, "User guild name", this);
    }

    public Locator healProfileJoinDate() {
        return healer.find(profileJoinDate, "User join date on profile", this);
    }

    public Locator healProfileBioSection() {
        return healer.find(profileBioSection, "Bio section container on profile", this);
    }

    public Locator healProfileBio() {
        return healer.find(profileBio, "User bio text content", this);
    }

    public Locator healLogoutButton() {
        return healer.find(logoutButton, "Logout button on profile page", this);
    }

    // --- Heal header/nav locators (inherited from BasePage) ---

    public Locator healHeader() {
        return healer.find(header, "Page header containing navigation", this);
    }

    public Locator healFooter() {
        return healer.find(footer, "Page footer section", this);
    }

    public Locator healNavHome() {
        return healer.find(navHome, "Home navigation link in header", this);
    }

    public Locator healNavInventory() {
        return healer.find(navInventory, "Inventory navigation link in header", this);
    }

    public Locator healNavAbout() {
        return healer.find(navAbout, "About navigation link in header", this);
    }
}
