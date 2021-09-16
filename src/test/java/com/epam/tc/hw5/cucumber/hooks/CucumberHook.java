package com.epam.tc.hw5.cucumber.hooks;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CucumberHook {
    protected WebDriver webDriver;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        TestContext.getInstance().addTestObject("webdriver", webDriver);
    }

    @After
    public void tearDownDriver() {
        webDriver.quit();
        TestContext.getInstance().clean();
    }
}
