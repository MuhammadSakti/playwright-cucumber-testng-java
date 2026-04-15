package com.playwright.cucumber.pages.healer;

import org.testng.annotations.Test;

/**
 * Healer test for LoginPage — navigates once, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerLoginPageTest extends HealerBaseTest {

    private HealerLoginPage loginPage;

    @Override
    protected String reportName() {
        return "LoginPage";
    }

    @Override
    protected void navigateToPage() {
        loginPage = new HealerLoginPage(page, healer);
        loginPage.open();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        loginPage.healHeader();
    }

    @Test
    public void healFooter() {
        loginPage.healFooter();
    }

    @Test
    public void healLogoLink() {
        loginPage.healLogoLink();
    }

    @Test
    public void healNavHome() {
        loginPage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        loginPage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        loginPage.healNavAbout();
    }

    // --- Login Page ---

    @Test
    public void healLoginPage() {
        loginPage.healLoginPage();
    }

    @Test
    public void healLoginTitle() {
        loginPage.healLoginTitle();
    }

    @Test
    public void healLoginForm() {
        loginPage.healLoginForm();
    }

    @Test
    public void healUsernameInput() {
        loginPage.healUsernameInput();
    }

    @Test
    public void healPasswordInput() {
        loginPage.healPasswordInput();
    }

    @Test
    public void healTogglePasswordButton() {
        loginPage.healTogglePasswordButton();
    }

    @Test
    public void healLoginButton() {
        loginPage.healLoginButton();
    }

    @Test
    public void healCredentialsHint() {
        loginPage.healCredentialsHint();
    }
}
