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

        this.profilePage = byTestId("profile-page");
        this.profileTitle = byTestId("profile-title");

        this.profileNotLoggedIn = byTestId("profile-not-logged-in");
        this.goToLoginButton = byTestId("btn-go-to-login");

        this.userCard = byTestId("user-card");
        this.userAvatar = byTestId("header-user-avatar");
        this.profileDisplayName = byTestId("profile-display-name");
        this.profileStats = byTestId("profile-stats");
        this.profileRole = byTestId("profile-role");
        this.profileLevel = byTestId("profile-level");
        this.profileGuild = byTestId("profile-guild");
        this.profileJoinDate = byTestId("profile-join-date");
        this.profileBioSection = byTestId("profile-bio-section");
        this.profileBio = byTestId("profile-bio");
        this.logoutButton = byTestId("btn-logout");
    }

    public void open() {
        navigate("/profile");
    }
}
