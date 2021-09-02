package com.epam.tc.hw4.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerImpl implements DriverService {

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver setupDriver() {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    }
}
