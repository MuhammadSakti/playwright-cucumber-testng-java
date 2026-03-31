package com.playwright.cucumber.config;

public class TestConfig {

    public static String getBaseUrl() {
        return System.getProperty("base.url",
                System.getenv().getOrDefault("BASE_URL", "http://localhost:3000"));
    }

    public static String getBrowser() {
        return System.getProperty("browser",
                System.getenv().getOrDefault("BROWSER", "chromium"));
    }

    public static boolean isHeadless() {
        String headless = System.getProperty("headless",
                System.getenv().getOrDefault("HEADLESS", "true"));
        return Boolean.parseBoolean(headless);
    }
}
