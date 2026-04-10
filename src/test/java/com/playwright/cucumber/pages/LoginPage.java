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

        this.loginPage = byTestId("login-page");
        this.loginTitle = byTestId("login-title");

        this.loginForm = byTestId("login-form");
        this.usernameInput = byTestId("input-username");
        this.passwordInput = byTestId("input-password");
        this.togglePasswordButton = byTestId("btn-toggle-password");
        this.loginButton = byTestId("btn-login");
        this.loginError = byTestId("login-error");

        this.credentialsHint = byTestId("credentials-hint");

        this.headerUserName = byTestId("header-user-name");

        this.loggedInState = byTestId("logged-in-state");
        this.welcomeMessage = byTestId("welcome-message");
        this.logoutButton = byTestId("btn-logout");
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
        return byTestId("credential-" + username);
    }
}
