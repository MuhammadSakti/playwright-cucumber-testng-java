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

        this.aboutTitle = page.getByTestId("about-title");
        this.aboutDescription = page.getByTestId("about-description");
        this.featuresSection = page.getByTestId("features-section");
        this.featureCatalog = page.getByTestId("feature-catalog");
        this.featureFilter = page.getByTestId("feature-filter");
        this.featureInteractive = page.getByTestId("feature-interactive");
        this.featureA11y = page.getByTestId("feature-a11y");
        this.contactSection = page.getByTestId("contact-section");
        this.contactForm = page.getByTestId("contact-form");
        this.nameInput = page.getByTestId("contact-name-input");
        this.emailInput = page.getByTestId("contact-email-input");
        this.messageInput = page.getByTestId("contact-message-input");
        this.submitButton = page.getByTestId("contact-submit-button");
        this.contactSuccess = page.getByTestId("contact-success");
        this.successMessage = page.getByTestId("success-message");
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
