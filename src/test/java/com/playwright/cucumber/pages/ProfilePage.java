package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProfilePage extends BasePage {

    // Profile page container
    public final Locator profilePage;
    public final Locator profileTitle;

    // Not logged in state
    public final Locator profileNotLoggedIn;
    public final Locator goToLoginButton;

    // User card
    public final Locator userCard;
    public final Locator userAvatar;
    public final Locator profileDisplayName;
    public final Locator profileStats;
    public final Locator profileRole;
    public final Locator profileLevel;
    public final Locator profileGuild;
    public final Locator profileJoinDate;
    public final Locator profileBioSection;
    public final Locator profileBio;
    public final Locator logoutButton;

    public ProfilePage(Page page) {
        super(page);

        this.profilePage = page.getByTestId("profile-page");
        this.profileTitle = page.getByTestId("profile-title");

        this.profileNotLoggedIn = page.getByTestId("profile-not-logged-in");
        this.goToLoginButton = page.getByTestId("btn-go-to-login");

        this.userCard = page.getByTestId("user-card");
        this.userAvatar = page.getByTestId("header-user-avatar");
        this.profileDisplayName = page.getByTestId("profile-display-name");
        this.profileStats = page.getByTestId("profile-stats");
        this.profileRole = page.getByTestId("profile-role");
        this.profileLevel = page.getByTestId("profile-level");
        this.profileGuild = page.getByTestId("profile-guild");
        this.profileJoinDate = page.getByTestId("profile-join-date");
        this.profileBioSection = page.getByTestId("profile-bio-section");
        this.profileBio = page.getByTestId("profile-bio");
        this.logoutButton = page.getByTestId("btn-logout");
    }

    public void open() {
        navigate("/profile");
    }
}
