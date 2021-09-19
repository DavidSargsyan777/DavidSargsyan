package com.epam.tc.hw6;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBeforeAfter {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        WebDriverSingleton.closeDriver();
    }
}
