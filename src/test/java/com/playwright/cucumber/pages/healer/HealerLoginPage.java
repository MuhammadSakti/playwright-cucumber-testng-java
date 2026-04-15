package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.cucumber.pages.LoginPage;

/**
 * Healer version of LoginPage that extends the original page object.
 * Reuses all inherited locators and wraps them with auto-heal.
 * Passes 'this' as pageObject so the library can resolve source file and line via reflection.
 */
public class HealerLoginPage extends LoginPage {

    private final PlaywrightAutoHeal healer;

    public HealerLoginPage(Page page, PlaywrightAutoHeal healer) {
        super(page);
        this.healer = healer;
    }

    // --- Heal static locators (inherited fields) ---

    public Locator healLoginPage() {
        return healer.find(loginPage, "Login page container", this);
    }

    public Locator healLoginTitle() {
        return healer.find(loginTitle, "Login page title heading", this);
    }

    public Locator healLoginForm() {
        return healer.find(loginForm, "Login form container", this);
    }

    public Locator healUsernameInput() {
        return healer.find(usernameInput, "Username input field on login form", this);
    }

    public Locator healPasswordInput() {
        return healer.find(passwordInput, "Password input field on login form", this);
    }

    public Locator healTogglePasswordButton() {
        return healer.find(togglePasswordButton, "Toggle password visibility button", this);
    }

    public Locator healLoginButton() {
        return healer.find(loginButton, "Login submit button", this);
    }

    public Locator healLoginError() {
        return healer.find(loginError, "Login error message display", this);
    }

    public Locator healCredentialsHint() {
        return healer.find(credentialsHint, "Credentials hint section showing available users", this);
    }

    public Locator healHeaderUserName() {
        return healer.find(headerUserName, "Header user name display when authenticated", this);
    }

    public Locator healLoggedInState() {
        return healer.find(loggedInState, "Logged-in state container shown when authenticated", this);
    }

    public Locator healWelcomeMessage() {
        return healer.find(welcomeMessage, "Welcome message shown when already logged in", this);
    }

    public Locator healLogoutButton() {
        return healer.find(logoutButton, "Logout button on login page", this);
    }

    // --- Heal header/nav locators (inherited from BasePage) ---

    public Locator healHeader() {
        return healer.find(header, "Page header containing navigation", this);
    }

    public Locator healFooter() {
        return healer.find(footer, "Page footer section", this);
    }

    public Locator healLogoLink() {
        return healer.find(logoLink, "Logo/brand link that navigates to home page", this);
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

    // --- Heal dynamic locators ---

    public Locator healCredentialRow(String username) {
        return healer.find(credentialRow(username), "Credential hint row for " + username);
    }
}
