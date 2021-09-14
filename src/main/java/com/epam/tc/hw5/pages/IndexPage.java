package com.epam.tc.hw5.pages;


import com.epam.tc.hw4.utils.GetPropertiesValue;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
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
        PageFactory.initElements(webDriver, this);
    }

    @Step
    public IndexPage openLogin() {
        inputRowForLog.click();
        return this;
    }

    @Step
    public void login() {
        username.sendKeys(getPropertiesValue.getUserName());
        password.sendKeys(getPropertiesValue.getPassword());
        log.click();
    }
}
