package com.avianca.automation.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SpecialMetods {

    public static Properties properties;

    public static void configProperties() {

        properties = new Properties();
        try {
            properties.load(new FileReader("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
