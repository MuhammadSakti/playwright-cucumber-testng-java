package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    // Login page container
    public final Locator loginPage;
    public final Locator loginTitle;

    // Login form
    public final Locator loginForm;
    public final Locator usernameInput;
    public final Locator passwordInput;
    public final Locator togglePasswordButton;
    public final Locator loginButton;
    public final Locator loginError;

    // Credentials hint
    public final Locator credentialsHint;

    // Header user info (shown when authenticated)
    public final Locator headerUserName;

    // Logged-in state (shown when already authenticated)
    public final Locator loggedInState;
    public final Locator welcomeMessage;
    public final Locator logoutButton;

    public LoginPage(Page page) {
        super(page);

        this.loginPage = page.getByTestId("auth-page");
        this.loginTitle = page.getByTestId("auth-heading");

        this.loginForm = page.getByTestId("authentication-form");
        this.usernameInput = page.getByTestId("user-field");
        this.passwordInput = page.getByTestId("pass-field");
        this.togglePasswordButton = page.getByTestId("toggle-pass-visibility");
        this.loginButton = page.getByTestId("submit-login");
        this.loginError = page.getByTestId("login-error");

        this.credentialsHint = page.getByTestId("test-accounts-info");

        this.headerUserName = page.getByTestId("header-user-name");

        this.loggedInState = page.getByTestId("logged-in-state");
        this.welcomeMessage = page.getByTestId("welcome-message");
        this.logoutButton = page.getByTestId("btn-logout");
    }

    public void open() {
        navigate("/login");
    }

    public void loginAs(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public Locator credentialRow(String username) {
        return page.getByTestId("credential-" + username);
    }
}
