package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.components.HeaderMenu;
import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.pages.DifferentElementPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.IndexPage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public class AbstractStep {

    protected HomePage homePage;
    protected IndexPage indexPage;
    protected HeaderMenu headerMenu;
    protected DifferentElementPage differentElementPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        WebDriver webDriver = TestContext.getInstance().getTestObject("webdriver");

        homePage = new HomePage(webDriver);
        indexPage = new IndexPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
        differentElementPage = new DifferentElementPage(webDriver);
        userTablePage = new UserTablePage(webDriver);
    }
}
