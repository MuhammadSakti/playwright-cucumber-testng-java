package com.playwright.cucumber.steps;

import com.playwright.cucumber.hooks.PlaywrightHooks;
import com.playwright.cucumber.pages.AboutPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactFormSteps {

    private AboutPage aboutPage;

    @Before
    public void setup() {
        aboutPage = new AboutPage(PlaywrightHooks.getPage());
    }

    @Given("I am on the about page")
    public void iAmOnTheAboutPage() {
        aboutPage.open();
    }

    // --- Visibility ---

    @Then("the contact form should be visible")
    public void theContactFormShouldBeVisible() {
        assertThat(aboutPage.contactForm).isVisible();
    }

    @Then("the name input should be visible")
    public void theNameInputShouldBeVisible() {
        assertThat(aboutPage.nameInput).isVisible();
    }

    @Then("the email input should be visible")
    public void theEmailInputShouldBeVisible() {
        assertThat(aboutPage.emailInput).isVisible();
    }

    @Then("the message input should be visible")
    public void theMessageInputShouldBeVisible() {
        assertThat(aboutPage.messageInput).isVisible();
    }

    @Then("the submit button should be visible")
    public void theSubmitButtonShouldBeVisible() {
        assertThat(aboutPage.submitButton).isVisible();
    }

    // --- Form Fill ---

    @When("I fill in the name with {string}")
    public void iFillInTheNameWith(String name) {
        aboutPage.nameInput.fill(name);
    }

    @When("I fill in the email with {string}")
    public void iFillInTheEmailWith(String email) {
        aboutPage.emailInput.fill(email);
    }

    @When("I fill in the message with {string}")
    public void iFillInTheMessageWith(String message) {
        aboutPage.messageInput.fill(message);
    }

    @When("I submit the contact form")
    public void iSubmitTheContactForm() {
        aboutPage.submitContactForm();
    }

    // --- Success ---

    @Then("the success message should be visible")
    public void theSuccessMessageShouldBeVisible() {
        assertThat(aboutPage.contactSuccess).isVisible();
    }

    @Then("the success message should contain {string}")
    public void theSuccessMessageShouldContain(String text) {
        assertThat(aboutPage.successMessage).containsText(text);
    }

    // --- Feature Cards ---

    @Then("the feature catalog card should be visible")
    public void theFeatureCatalogCardShouldBeVisible() {
        assertThat(aboutPage.featureCatalog).isVisible();
    }

    @Then("the feature filter card should be visible")
    public void theFeatureFilterCardShouldBeVisible() {
        assertThat(aboutPage.featureFilter).isVisible();
    }

    @Then("the feature interactive card should be visible")
    public void theFeatureInteractiveCardShouldBeVisible() {
        assertThat(aboutPage.featureInteractive).isVisible();
    }

    @Then("the feature accessibility card should be visible")
    public void theFeatureAccessibilityCardShouldBeVisible() {
        assertThat(aboutPage.featureA11y).isVisible();
    }
}
