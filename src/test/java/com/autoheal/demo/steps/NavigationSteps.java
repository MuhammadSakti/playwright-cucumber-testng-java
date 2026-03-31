package com.autoheal.demo.steps;

import com.autoheal.demo.config.TestConfig;
import com.autoheal.demo.hooks.PlaywrightHooks;
import com.autoheal.demo.pages.HomePage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationSteps {

    private final HomePage homePage = new HomePage();

    @When("I click the {string} navigation link")
    public void iClickTheNavigationLink(String linkText) {
        switch (linkText) {
            case "Home" -> homePage.navHome().click();
            case "Inventory" -> homePage.navInventory().click();
            case "About" -> homePage.navAbout().click();
        }
    }

    @When("I click the logo link")
    public void iClickTheLogoLink() {
        homePage.logoLink().click();
    }

    @Then("I should be on the home page")
    public void iShouldBeOnTheHomePage() {
        assertThat(PlaywrightHooks.getPage()).hasURL(TestConfig.getBaseUrl() + "/");
    }

    @Then("I should be on the inventory page")
    public void iShouldBeOnTheInventoryPage() {
        assertThat(PlaywrightHooks.getPage()).hasURL(TestConfig.getBaseUrl() + "/inventory");
    }

    @Then("I should be on the about page")
    public void iShouldBeOnTheAboutPage() {
        assertThat(PlaywrightHooks.getPage()).hasURL(TestConfig.getBaseUrl() + "/about");
    }
}
