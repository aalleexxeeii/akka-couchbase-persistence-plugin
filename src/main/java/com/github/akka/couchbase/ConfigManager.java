package com.github.akka.couchbase;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by youseff on 3/22/2015.
 */
public class ConfigManager {
    private static ConfigManager _instance;

    public static ConfigManager getInstance() {
        if (_instance == null) {
            synchronized (ConfigManager.class) {
                if (_instance == null) {
                    _instance = new ConfigManager();
                }
            }
        }
        return _instance;
    }

    private final Logger log = LoggerFactory.getLogger(ConfigManager.class);

    Config  config;

    private ConfigManager() {

        config = ConfigFactory.load();
    }

    public String getString(String key) {
        String value = null;
        try {
            value = config.getString(key);

        } catch (Exception e) {
            log.warn("key {} is not found in config", key);
        }
        return value;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            value = config.getBoolean(key);

        } catch (Exception e) {
            log.warn("key {} is not found in config", key);
        }
        return value;
    }

    public int getInt(String key, int defaultValue) {
        int value = defaultValue;
        try {
            value = config.getInt(key);

        } catch (Exception e) {
            log.warn("key {} is not found in config", key);
        }
        return value;
    }
}
