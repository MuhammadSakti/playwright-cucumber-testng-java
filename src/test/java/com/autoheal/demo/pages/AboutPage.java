package com.autoheal.demo.pages;

import com.microsoft.playwright.Locator;

public class AboutPage extends BasePage {

    public void open() {
        navigate("/about");
    }

    public Locator aboutTitle() { return byTestId("about-title"); }
    public Locator aboutDescription() { return byTestId("about-description"); }
    public Locator featuresSection() { return byTestId("features-section"); }

    // Feature cards
    public Locator featureCatalog() { return byTestId("feature-catalog"); }
    public Locator featureFilter() { return byTestId("feature-filter"); }
    public Locator featureInteractive() { return byTestId("feature-interactive"); }
    public Locator featureA11y() { return byTestId("feature-a11y"); }

    // Contact form
    public Locator contactSection() { return byTestId("contact-section"); }
    public Locator contactForm() { return byTestId("contact-form"); }
    public Locator nameInput() { return byTestId("contact-name-input"); }
    public Locator emailInput() { return byTestId("contact-email-input"); }
    public Locator messageInput() { return byTestId("contact-message-input"); }
    public Locator submitButton() { return byTestId("contact-submit-button"); }
    public Locator contactSuccess() { return byTestId("contact-success"); }
    public Locator successMessage() { return byTestId("success-message"); }

    public void fillContactForm(String name, String email, String message) {
        nameInput().fill(name);
        emailInput().fill(email);
        messageInput().fill(message);
    }

    public void submitContactForm() {
        submitButton().click();
    }
}
