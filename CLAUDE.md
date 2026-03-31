# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Playwright + Cucumber BDD test automation suite for an "RPG Items Finder" web application. Uses Java 17, Maven, and includes an AutoHeal feature that uses AI to self-heal broken locators.

## Build & Test Commands

```bash
# Run all tests
mvn clean test

# Run with visible browser (not headless)
mvn clean test -Pheaded

# Run a specific feature file
mvn clean test -Dcucumber.features=src/test/resources/features/home_page.feature

# Run scenarios by tag
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Configuration

Environment variables (see `.env.example`), also configurable via system properties:
- `BASE_URL` — target application URL (default: `http://localhost:3000`)
- `BROWSER` — `chromium`, `firefox`, or `webkit`
- `HEADLESS` — `true`/`false`

`TestConfig.java` reads these with system properties taking precedence over env vars.

## Architecture

**Page Object Model with AutoHeal variant:**

- `BasePage` — abstract base providing Playwright helper methods (`findByTestId`, `findByRole`, `clickButton`, `waitForElement`, etc.). All page objects extend this.
- `pages/healed/AutoHealBasePage` — parallel base that wraps locators with AI-powered self-healing. Each locator takes a human-readable description string used as AI context when healing.
- Concrete page objects: `HomePage`, `InventoryPage`, `AboutPage`, and `healed/AutoHealHomePage`.

**Cucumber wiring:**

- **Runner:** `RunCucumberTest.java` — JUnit Platform suite entry point.
- **Hooks:** `PlaywrightHooks.java` — manages browser lifecycle with `@BeforeAll`/`@AfterAll` (browser launch/close) and `@Before`/`@After` (context creation per scenario, screenshot on failure). Uses `ThreadLocal` for page/context isolation.
- **Glue packages:** `com.playwright.cucumber.steps` and `com.playwright.cucumber.hooks`.
- **Features:** `src/test/resources/features/` — 5 feature files covering home page, inventory, navigation, contact form, and item detail modal.

**Step definitions** inject page objects by getting the current `Page` from `PlaywrightHooks.getPage()` and constructing page objects in `@Before`-annotated setup methods.

## Test Reports

- HTML: `target/cucumber-reports/cucumber.html`
- JSON: `target/cucumber-reports/cucumber.json`
- Failure screenshots: `target/screenshots/`

## Key Dependencies

- Playwright 1.49.0
- Cucumber 7.18.0 + JUnit Platform
- AutoHeal Locator 1.0.0 (local/custom dependency)
- AssertJ for fluent assertions
