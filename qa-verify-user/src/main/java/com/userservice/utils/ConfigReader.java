package com.userservice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getReqResApiKey() {
        return getProperty("reqres.api.key");
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }
}