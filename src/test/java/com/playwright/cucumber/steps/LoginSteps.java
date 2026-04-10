package com.playwright.cucumber.steps;

import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.hooks.PlaywrightHooks;
import com.playwright.cucumber.pages.LoginPage;
import com.playwright.cucumber.pages.ProfilePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginSteps {

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before(order = 1)
    public void setup() {
        loginPage = new LoginPage(PlaywrightHooks.getPage());
        profilePage = new ProfilePage(PlaywrightHooks.getPage());
    }

    // --- Navigation ---

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.open();
    }

    @When("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage.open();
    }

    // --- Page Structure ---

    @Then("the login page should be visible")
    public void theLoginPageShouldBeVisible() {
        assertThat(loginPage.loginPage).isVisible();
    }

    @Then("the login title should be {string}")
    public void theLoginTitleShouldBe(String title) {
        assertThat(loginPage.loginTitle).hasText(title);
    }

    @Then("the login form should be visible")
    public void theLoginFormShouldBeVisible() {
        assertThat(loginPage.loginForm).isVisible();
    }

    @Then("the username input should be visible")
    public void theUsernameInputShouldBeVisible() {
        assertThat(loginPage.usernameInput).isVisible();
    }

    @Then("the password input should be visible")
    public void thePasswordInputShouldBeVisible() {
        assertThat(loginPage.passwordInput).isVisible();
    }

    @Then("the login button should be visible")
    public void theLoginButtonShouldBeVisible() {
        assertThat(loginPage.loginButton).isVisible();
    }

    @Then("the credentials hint should be visible")
    public void theCredentialsHintShouldBeVisible() {
        assertThat(loginPage.credentialsHint).isVisible();
    }

    // --- Form Input ---

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.usernameInput.fill(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.passwordInput.fill(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.loginButton.click();
    }

    // --- Error ---

    @Then("the login error should be visible")
    public void theLoginErrorShouldBeVisible() {
        assertThat(loginPage.loginError).isVisible();
    }

    @Then("the login error should contain {string}")
    public void theLoginErrorShouldContain(String text) {
        assertThat(loginPage.loginError).containsText(text);
    }

    // --- Redirect Assertions ---

    @Then("I should be on the profile page")
    public void iShouldBeOnTheProfilePage() {
        assertThat(PlaywrightHooks.getPage()).hasURL(TestConfig.getBaseUrl() + "/profile");
    }

    @Then("I should be on the login page")
    public void iShouldBeOnTheLoginPageUrl() {
        assertThat(PlaywrightHooks.getPage()).hasURL(TestConfig.getBaseUrl() + "/login");
    }

    // --- Profile Assertions ---

    @Then("the profile title should be {string}")
    public void theProfileTitleShouldBe(String title) {
        assertThat(profilePage.profileTitle).hasText(title);
    }

    @Then("the profile display name should be {string}")
    public void theProfileDisplayNameShouldBe(String name) {
        assertThat(profilePage.profileDisplayName).hasText(name);
    }

    @Then("the profile role should be {string}")
    public void theProfileRoleShouldBe(String role) {
        assertThat(profilePage.profileRole).hasText(role);
    }

    @Then("the profile level should be {string}")
    public void theProfileLevelShouldBe(String level) {
        assertThat(profilePage.profileLevel).hasText(level);
    }

    @Then("the profile guild should be {string}")
    public void theProfileGuildShouldBe(String guild) {
        assertThat(profilePage.profileGuild).hasText(guild);
    }

    @Then("the profile bio should contain {string}")
    public void theProfileBioShouldContain(String text) {
        assertThat(profilePage.profileBio).containsText(text);
    }

    // --- Logout ---

    @When("I click the logout button")
    public void iClickTheLogoutButton() {
        profilePage.logoutButton.click();
    }

    // --- Header User Name ---

    @Then("the header user name should be {string}")
    public void theHeaderUserNameShouldBe(String name) {
        assertThat(loginPage.headerUserName).hasText(name);
    }

    // --- Password Toggle ---

    @When("I toggle password visibility")
    public void iTogglePasswordVisibility() {
        loginPage.togglePasswordButton.click();
    }

    @Then("the password input type should be {string}")
    public void thePasswordInputTypeShouldBe(String type) {
        assertThat(loginPage.passwordInput).hasAttribute("type", type);
    }
}
