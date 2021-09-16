package com.epam.tc.hw5.components;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
    WebDriver webDriver;
    @FindBy(xpath = "//ul[contains(@class,'uui-navigation nav navbar-nav m-')]/li/a")
    private List<WebElement> headerMenuElem;
    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElemPage;
    @FindBy(xpath = "//a[@href='user-table.html']")
    private WebElement userTablePage;

    public HeaderMenu(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
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
    public void clickOnDiffElem() {
        differentElemPage.click();
    }

    @Step
    public void clickOnUserTable() {
        userTablePage.click();
    }

    public String getDiffElemUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getUserTableUrl() {
        return webDriver.getCurrentUrl();
    }
}
