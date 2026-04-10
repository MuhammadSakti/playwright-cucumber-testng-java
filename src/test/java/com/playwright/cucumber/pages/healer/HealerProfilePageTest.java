package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.autoheal.ai.FailureContext;
import com.autoheal.config.AutoHealConfig;
import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import com.playwright.cucumber.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Healer test for ProfilePage — logs in, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerProfilePageTest {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static PlaywrightAutoHeal healer;
    private static HealerProfilePage profilePage;
    private static String setupError;

    @BeforeClass
    public void launchBrowser() {
        playwright = Playwright.create();

        String browserType = TestConfig.getBrowser();
        boolean headless = TestConfig.isHeadless();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(headless);

        browser = switch (browserType.toLowerCase()) {
            case "firefox" -> playwright.firefox().launch(launchOptions);
            case "webkit" -> playwright.webkit().launch(launchOptions);
            default -> playwright.chromium().launch(launchOptions);
        };

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1440, 900));
        context.setDefaultTimeout(10000);
        page = context.newPage();

        // Login first to access profile
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();
        loginPage.loginAs("warrior", "sword123");

        healer = PlaywrightAutoHeal.builder()
                .config(AutoHealConfig.fromEnv())
                .page(page)
                .reportName("ProfilePage")
                .build();

        try {
            profilePage = new HealerProfilePage(page, healer);

            // Capture DOM once, then batch heal all broken locators in one AI call
            healer.captureDom();
            healer.startBatch();
        } catch (Exception e) {
            setupError = e.toString();
            throw e;
        }
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        if (healer != null) {
            if (setupError == null) healer.flushBatch();
            if (setupError != null) {
                try {
                    healer.analyzeFailure(setupError);
                } catch (Exception e) {
                    System.err.println("[AutoHeal] Screenshot failed, analyzing error log only: " + e.getMessage());
                    healer.analyzeFailure(FailureContext.builder().errorLog(setupError).build());
                }
            }
            healer.finish();
        }
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
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
