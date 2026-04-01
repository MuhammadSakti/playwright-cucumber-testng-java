# Playwright Cucumber TestNG Java

A BDD test automation framework using **Playwright**, **Cucumber**, and **TestNG** for the RPG Items Finder web
application, with AI-powered self-healing locators
via [automation-auto-heal-java](https://github.com/MuhammadSakti/automation-auto-heal-java).

## Tech Stack

- **Java 17**
- **Playwright** 1.49.0
- **Cucumber** 7.18.0
- **TestNG** 7.10.2
- **Auto-Heal** 1.0.8
- **AssertJ** 3.26.0
- **Maven**

## Prerequisites

- Java 17+
- Maven 3.8+
- The RPG Items Finder app running at `http://localhost:3000`

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/MuhammadSakti/playwright-cucumber-testng-java.git
   cd playwright-cucumber-testng-java
   ```

2. Copy and configure environment variables:
   ```bash
   cp .env.example .env
   ```

3. Install Playwright browsers:
   ```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
   ```

## Running Tests

```bash
# Run all tests
mvn clean test

# Run with visible browser
mvn clean test -Pheaded

# Run a specific feature
mvn clean test -Dcucumber.features=src/test/resources/features/home_page.feature

# Run by tag
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Project Structure

```
src/test/
├── java/com/autoheal/demo/
│   ├── config/          # Test configuration (URL, browser, headless)
│   ├── hooks/           # Playwright lifecycle hooks (browser, context, screenshots)
│   ├── pages/           # Page Object Model classes
│   │   └── healer/      # AutoHeal v2-enabled page objects with self-healing locators
│   ├── steps/           # Cucumber step definitions
│   └── runner/          # TestNG Cucumber runner
└── resources/
    └── features/        # Gherkin feature files
```

## Test Reports

| Report              | Path                                    |
|---------------------|-----------------------------------------|
| Cucumber HTML       | `target/cucumber-reports/cucumber.html` |
| Cucumber JSON       | `target/cucumber-reports/cucumber.json` |
| Failure Screenshots | `target/screenshots/`                   |
| AutoHeal Reports    | `./target/autoheal-reports/`            |

## Configuration

Configure via `.env` file or system properties:

| Variable               | Default                 | Description                                          |
|------------------------|-------------------------|------------------------------------------------------|
| `BASE_URL`             | `http://localhost:3000` | Application URL                                      |
| `BROWSER`              | `chromium`              | `chromium`, `firefox`, or `webkit`                   |
| `HEADLESS`             | `true`                  | Run browser in headless mode                         |
| `AUTOHEAL_AI_PROVIDER` | `claude`                | AI provider: `claude`, `openai`, or `gemini`         |
| `AUTOHEAL_AI_API_KEY`  | -                       | API key for the AI provider                          |
| `AUTOHEAL_CACHE_ENABLED`| `true`                 | Enable/disable selector cache                        |
