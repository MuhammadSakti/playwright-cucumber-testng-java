package com.playwright.cucumber.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AboutPage extends BasePage {

    public final Locator aboutTitle;
    public final Locator aboutDescription;
    public final Locator featuresSection;
    public final Locator featureCatalog;
    public final Locator featureFilter;
    public final Locator featureInteractive;
    public final Locator featureA11y;
    public final Locator contactSection;
    public final Locator contactForm;
    public final Locator nameInput;
    public final Locator emailInput;
    public final Locator messageInput;
    public final Locator submitButton;
    public final Locator contactSuccess;
    public final Locator successMessage;

    public AboutPage(Page page) {
        super(page);

        this.aboutTitle = byTestId("about-title");
        this.aboutDescription = byTestId("about-description");
        this.featuresSection = byTestId("features-section");
        this.featureCatalog = byTestId("feature-catalog");
        this.featureFilter = byTestId("feature-filter");
        this.featureInteractive = byTestId("feature-interactive");
        this.featureA11y = byTestId("feature-a11y");
        this.contactSection = byTestId("contact-section");
        this.contactForm = byTestId("contact-form");
        this.nameInput = byTestId("contact-name-input");
        this.emailInput = byTestId("contact-email-input");
        this.messageInput = byTestId("contact-message-input");
        this.submitButton = byTestId("contact-submit-button");
        this.contactSuccess = byTestId("contact-success");
        this.successMessage = byTestId("success-message");
    }

    public void open() {
        navigate("/about");
    }

    public void fillContactForm(String name, String email, String message) {
        nameInput.fill(name);
        emailInput.fill(email);
        messageInput.fill(message);
    }

    public void submitContactForm() {
        submitButton.click();
    }
}
