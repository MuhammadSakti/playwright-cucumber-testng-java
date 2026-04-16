package com.playwright.cucumber.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final Properties props = new Properties();

    static {
        try (InputStream is = TestConfig.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            if (is != null) {
                props.load(is);
            }
        } catch (IOException e) {
            // ignore — properties file is optional
        }
    }

    private static String resolve(String envKey, String propKey, String defaultValue) {
        String sysEnv = System.getenv(envKey);
        if (sysEnv != null && !sysEnv.isEmpty()) return sysEnv;
        String sysProp = System.getProperty(propKey);
        if (sysProp != null && !sysProp.isEmpty()) return sysProp;
        String val = props.getProperty(propKey);
        if (val != null && !val.isEmpty()) return val;
        return defaultValue;
    }

    public static String getBaseUrl() {
        return resolve("BASE_URL", "base.url", "http://localhost:3000");
    }

    public static String getBrowser() {
        return resolve("BROWSER", "browser", "chromium");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(resolve("HEADLESS", "headless", "false"));
    }
}
