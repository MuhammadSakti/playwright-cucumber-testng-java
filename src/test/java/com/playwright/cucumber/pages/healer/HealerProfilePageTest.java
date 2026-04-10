package com.playwright.cucumber.pages.healer;

import com.playwright.cucumber.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Healer test for ProfilePage — logs in, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerProfilePageTest extends HealerBaseTest {

    private HealerProfilePage profilePage;

    @Override
    protected String reportName() {
        return "ProfilePage";
    }

    @Override
    protected void preSetup() {
        // Login first to access profile
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();
        loginPage.loginAs("warrior", "sword123");
    }

    @Override
    protected void navigateToPage() {
        profilePage = new HealerProfilePage(page, healer);
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        profilePage.healHeader();
    }

    @Test
    public void healFooter() {
        profilePage.healFooter();
    }

    @Test
    public void healNavHome() {
        profilePage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        profilePage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        profilePage.healNavAbout();
    }

    // --- Profile Page ---

    @Test
    public void healProfilePage() {
        profilePage.healProfilePage();
    }

    @Test
    public void healProfileTitle() {
        profilePage.healProfileTitle();
    }

    @Test
    public void healUserCard() {
        profilePage.healUserCard();
    }

    @Test
    public void healUserAvatar() {
        profilePage.healUserAvatar();
    }

    @Test
    public void healProfileDisplayName() {
        profilePage.healProfileDisplayName();
    }

    @Test
    public void healProfileStats() {
        profilePage.healProfileStats();
    }

    @Test
    public void healProfileRole() {
        profilePage.healProfileRole();
    }

    @Test
    public void healProfileLevel() {
        profilePage.healProfileLevel();
    }

    @Test
    public void healProfileGuild() {
        profilePage.healProfileGuild();
    }

    @Test
    public void healProfileJoinDate() {
        profilePage.healProfileJoinDate();
    }

    @Test
    public void healProfileBioSection() {
        profilePage.healProfileBioSection();
    }

    @Test
    public void healProfileBio() {
        profilePage.healProfileBio();
    }

    @Test
    public void healLogoutButton() {
        profilePage.healLogoutButton();
    }
}
