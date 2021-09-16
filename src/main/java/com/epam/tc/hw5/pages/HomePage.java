package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.HeaderMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver webDriver;
    HeaderMenu headerMenu;

    public HomePage(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
        headerMenu = new HeaderMenu(webDriver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step
    public HomePage openPage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }
}
