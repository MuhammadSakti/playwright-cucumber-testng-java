package com.playwright.cucumber.pages.healer;

import org.testng.annotations.Test;

/**
 * Healer test for AboutPage — navigates once, heals all locators in one batch AI call.
 * Run separately after test failures to fix broken selectors.
 * <p>
 * Run with: mvn test -DsuiteXmlFile=testng-healersakti.xml
 */
public class HealerAboutPageTest extends HealerBaseTest {

    private HealerAboutPage aboutPage;

    @Override
    protected String reportName() {
        return "AboutPage";
    }

    @Override
    protected void navigateToPage() {
        aboutPage = new HealerAboutPage(page, healer);
        aboutPage.open();
    }

    // --- Header / Navigation ---

    @Test
    public void healHeader() {
        aboutPage.healHeader();
    }

    @Test
    public void healLogoLink() {
        aboutPage.healLogoLink();
    }

    @Test
    public void healNavHome() {
        aboutPage.healNavHome();
    }

    @Test
    public void healNavInventory() {
        aboutPage.healNavInventory();
    }

    @Test
    public void healNavAbout() {
        aboutPage.healNavAbout();
    }

    // --- Hero / Description ---

    @Test
    public void healAboutTitle() {
        aboutPage.healAboutTitle();
    }

    @Test
    public void healAboutDescription() {
        aboutPage.healAboutDescription();
    }

    // --- Features ---

    @Test
    public void healFeaturesSection() {
        aboutPage.healFeaturesSection();
    }

    @Test
    public void healFeatureCatalog() {
        aboutPage.healFeatureCatalog();
    }

    @Test
    public void healFeatureFilter() {
        aboutPage.healFeatureFilter();
    }

    @Test
    public void healFeatureInteractive() {
        aboutPage.healFeatureInteractive();
    }

    @Test
    public void healFeatureA11y() {
        aboutPage.healFeatureA11y();
    }

    // --- Contact Form ---

    @Test
    public void healContactSection() {
        aboutPage.healContactSection();
    }

    @Test
    public void healContactForm() {
        aboutPage.healContactForm();
    }

    @Test
    public void healNameInput() {
        aboutPage.healNameInput();
    }

    @Test
    public void healEmailInput() {
        aboutPage.healEmailInput();
    }

    @Test
    public void healMessageInput() {
        aboutPage.healMessageInput();
    }

    @Test
    public void healSubmitButton() {
        aboutPage.healSubmitButton();
    }
}
