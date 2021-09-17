package com.epam.tc.hw6;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class AbstractBeforeAfter {
    protected WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setupDriver(String browser) {
        webDriver = WebDriverSingleton.getDriver(browser);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        WebDriverSingleton.closeDriver();
    }
}
