package utils;

import constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        String env = System.getProperty("env", String.valueOf(EnvType.DEFAULT));
        switch(EnvType.valueOf(env)) {
            case PROD -> properties = PropertyUtils.propertyLoader("src/test/resources/prod_config.properties");
            case STAGE -> properties = PropertyUtils.propertyLoader("src/test/resources/stage_config.properties");
            case DEFAULT -> properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
            default -> throw new IllegalStateException("Invalid env: "+env);
        }
    }

    public static ConfigLoader getInstance() {
        if(configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl != null) {
            return baseUrl;
        }
        else {
            throw new RuntimeException("property 'baseUrl' is not set in the 'config.properties' file");
        }
    }
}
