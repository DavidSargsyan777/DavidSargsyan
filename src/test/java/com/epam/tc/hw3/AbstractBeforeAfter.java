package com.epam.tc.hw3;

import com.epam.tc.hw3.driver.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBeforeAfter {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() {
        webDriver = new DriverManager().setupDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        webDriver.close();
    }
}
