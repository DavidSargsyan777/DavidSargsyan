package com.epam.tc.hw4.utils;

import io.qameta.allure.Step;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesValue {
    InputStream inputStream;
    private String username;
    private String password;

    public Properties getProperties() throws IOException {
        Properties properties = new Properties();
        try {
            properties = new Properties();
            String propFileName = "user.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException();
            }
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (Exception e) {
            System.out.println("Exception" + e);
        } finally {
            inputStream.close();
        }
        return properties;
    }

    @Step
    public String getUserName() {
        try {
            username = getProperties().getProperty("username");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return username;
    }

    @Step
    public String getPassword() {
        try {
            password = getProperties().getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return password;

    }
}
