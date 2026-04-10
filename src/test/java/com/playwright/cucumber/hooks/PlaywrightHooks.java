package com.playwright.cucumber.hooks;

import com.microsoft.playwright.*;
import com.playwright.cucumber.config.TestConfig;
import io.cucumber.java.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;

public class PlaywrightHooks {

    private static final Logger log = LoggerFactory.getLogger(PlaywrightHooks.class);

    private static Playwright playwright;
    private static Browser browser;

    private static final ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    @BeforeAll
    public static void launchBrowser() {
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

        log.info("Launched {} browser (headless={})", browserType, headless);
    }

    @Before(order = 0)
    public void createContext(Scenario scenario) {
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setViewportSize(1440, 900);

        BrowserContext ctx = browser.newContext(contextOptions);
        ctx.setDefaultTimeout(10000);

        Page p = ctx.newPage();
        context.set(ctx);
        page.set(p);

        log.info("Started scenario: {}", scenario.getName());
    }

    @After
    public void closeContext(Scenario scenario) {
        Page p = page.get();
        if (p != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = p.screenshot(new Page.ScreenshotOptions()
                        .setFullPage(true)
                        .setPath(Paths.get("target/screenshots",
                                scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + ".png")));
                scenario.attach(screenshot, "image/png", scenario.getName());
                log.warn("Scenario FAILED: {}", scenario.getName());
            }
            p.close();
        }

        BrowserContext ctx = context.get();
        if (ctx != null) {
            ctx.close();
        }

        page.remove();
        context.remove();
    }

    @AfterAll
    public static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
        log.info("Browser closed");
    }

    public static Page getPage() {
        return page.get();
    }

    public static BrowserContext getContext() {
        return context.get();
    }
}
