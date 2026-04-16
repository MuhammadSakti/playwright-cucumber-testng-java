package com.playwright.cucumber.pages.healer;

import com.autoheal.PlaywrightAutoHeal;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.cucumber.pages.AboutPage;

/**
 * Healer version of AboutPage that extends the original page object.
 * Reuses all inherited locators and wraps them with auto-heal.
 * Passes 'this' as pageObject so the library can resolve source file and line via reflection.
 */
public class HealerAboutPage extends AboutPage {

    private final PlaywrightAutoHeal healer;

    public HealerAboutPage(Page page, PlaywrightAutoHeal healer) {
        super(page);
        this.healer = healer;
    }

    // --- Heal static locators (inherited fields) ---

    public Locator healAboutTitle() {
        return healer.find(aboutTitle, "Main About page title heading", this);
    }

    public Locator healAboutDescription() {
        return healer.find(aboutDescription, "About page introductory description text", this);
    }

    public Locator healFeaturesSection() {
        return healer.find(featuresSection, "Features section listing the app's key capabilities", this);
    }

    public Locator healFeatureCatalog() {
        return healer.find(featureCatalog, "Catalog feature card in the features section", this);
    }

    public Locator healFeatureFilter() {
        return healer.find(featureFilter, "Filter feature card in the features section", this);
    }

    public Locator healFeatureInteractive() {
        return healer.find(featureInteractive, "Interactive feature card in the features section", this);
    }

    public Locator healFeatureA11y() {
        return healer.find(featureA11y, "Accessibility (a11y) feature card in the features section", this);
    }

    public Locator healContactSection() {
        return healer.find(contactSection, "Contact section containing the contact form", this);
    }

    public Locator healContactForm() {
        return healer.find(contactForm, "Contact form on the About page", this);
    }

    public Locator healNameInput() {
        return healer.find(nameInput, "Name input field on the contact form", this);
    }

    public Locator healEmailInput() {
        return healer.find(emailInput, "Email input field on the contact form", this);
    }

    public Locator healMessageInput() {
        return healer.find(messageInput, "Message textarea on the contact form", this);
    }

    public Locator healSubmitButton() {
        return healer.find(submitButton, "Submit button on the contact form", this);
    }

    // --- Heal header/nav locators (inherited from BasePage) ---

    public Locator healHeader() {
        return healer.find(header, "Page header containing navigation", this);
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
}
