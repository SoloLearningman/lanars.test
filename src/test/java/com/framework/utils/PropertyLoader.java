package com.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static Logger log = LoggerFactory.getLogger(PropertyLoader.class);
    private static final String CONFIG_LOCATION = "C:/Users/ser1k/IdeaProjects/cd/test_task_larnas/src/test/resources/prod.properties";

    public static Properties loadTestSettings() { return loadConfig("prod.properties"); }

    public static Properties loadConfig(String name) throws RuntimeException {

        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(CONFIG_LOCATION + name));
            System.out.println(prop.toString());
        } catch (Exception e) {
            //e.printStackTrace();
            try {
                prop.load(PropertyLoader.class.getClassLoader().getResourceAsStream(name));
            } catch (IOException ex) {
                log.error("config {} not found", name, ex);
                throw new RuntimeException("failed to init config");
            }
        }
        return prop;
    }
}
