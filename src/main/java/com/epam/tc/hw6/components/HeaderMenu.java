package com.epam.tc.hw6.components;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenu {
    WebDriverWait webDriverWait;
    WebDriver webDriver;
    @FindBy(xpath = "//ul[contains(@class,'uui-navigation nav navbar-nav m-')]/li/a")
    private List<WebElement> headerMenuElem;
    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElemPage;

    public HeaderMenu(WebDriver webDriver1) {
        webDriver = webDriver1;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public String getDisplayedOnHeaderItem(String item) {
        WebElement currentElement = headerMenuElem
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.isDisplayed();
        return currentElement.getText();
    }

    @Step
    public HeaderMenu clickOnHeaderItem(String item) {
        WebElement currentElement = headerMenuElem
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.click();
        return this;
    }

    @Step
    public HeaderMenu clickOnDiffElem() {
        differentElemPage.click();
        webDriverWait.until(ExpectedConditions.urlToBe(
            "https://jdi-testing.github.io/jdi-light/different-elements.html"));
        return this;
    }

    public String getDiffElemUrl() {
        return webDriver.getCurrentUrl();
    }
}
