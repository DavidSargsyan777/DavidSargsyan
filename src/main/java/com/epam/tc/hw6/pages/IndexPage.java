package com.epam.tc.hw6.pages;


import com.epam.tc.hw6.utils.GetPropertiesValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage {
    GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
    WebDriverWait webDriverWait;
    WebDriver webDriver;
    @FindBy(id = "user-icon")
    private WebElement inputRowForLog;
    @FindBy(id = "name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement log;
    @FindBy(id = "user-name")
    private WebElement userNameLogged;

    public IndexPage(WebDriver webDriver1) {
        webDriver = webDriver1;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @Step
    public IndexPage openLogin() {
        inputRowForLog.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputRowForLog));
        return this;
    }

    @Step
    public IndexPage login() {
        username.sendKeys(getPropertiesValue.getUserName());
        password.sendKeys(getPropertiesValue.getPassword());
        log.click();
        webDriverWait.until(
            ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/index.html"));
        return this;
    }

    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    @Step
    public IndexPage checkDisplay() {
        userNameLogged.isDisplayed();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(userNameLogged, "ROMAN IOVLEV"));
        return this;
    }

    public String getFullUserName() {
        return userNameLogged.getText();
    }
}
