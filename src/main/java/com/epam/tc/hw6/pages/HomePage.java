package com.epam.tc.hw6.pages;

import com.epam.tc.hw6.components.HeaderMenu;
import com.epam.tc.hw6.components.LeftSideMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    HeaderMenu headerMenu;
    LeftSideMenu leftSideMenu;
    @FindBy(name = "main-title")
    private WebElement title;
    @FindBy(className = "icon-practise")
    private WebElement icon1;
    @FindBy(className = "icon-custom")
    private WebElement icon2;
    @FindBy(className = "icon-multi")
    private WebElement icon3;
    @FindBy(className = "icon-base")
    private WebElement icon4;
    @FindBy(xpath = "//div[@class='col-sm-3']//*[contains(text(),'To include')]")
    private WebElement textUnder1;
    @FindBy(xpath = "//div[@class='col-sm-3']//*[contains(text(),'To be flexible')]")
    private WebElement textUnder2;
    @FindBy(xpath = "//div[@class='col-sm-3']//*[contains(text(),'To be multiplatform')]")
    private WebElement textUnder3;
    @FindBy(xpath = "//div[@class='col-sm-3']//*[contains(text(),'Already')]")
    private WebElement textUnder4;
    @FindBy(id = "frame")
    private WebElement frameWithButton;
    @FindBy(id = "frame-button")
    private WebElement buttonFrame;

    public HomePage(WebDriver webDriver1) {
        webDriver = webDriver1;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
        leftSideMenu = new LeftSideMenu(webDriver);
        headerMenu = new HeaderMenu(webDriver);
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step
    public HomePage openPage() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriverWait.until(
            ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/index.html"));
        return this;
    }

    public String getTitleName() {
        String getTitle = webDriver.getTitle();
        webDriverWait.until(ExpectedConditions.titleIs("Home Page"));
        return getTitle;
    }

    @Step
    public void iconsAreDisplayed() {
        icon1.isDisplayed();
        icon2.isDisplayed();
        icon3.isDisplayed();
        icon4.isDisplayed();
    }

    @Step
    public void textsUnderIconsAreDisplayed() {
        textUnder1.isDisplayed();
        textUnder2.isDisplayed();
        textUnder3.isDisplayed();
        textUnder4.isDisplayed();
    }

    public String[] getArrayOfTexts() {
        String[] texts =
            new String[] {textUnder1.getText(), textUnder2.getText(), textUnder3.getText(), textUnder4.getText()};
        return texts;
    }

    @Step
    public void frameWithButtonIsDisplayed() {
        frameWithButton.isDisplayed();
    }

    @Step
    public WebElement getFrameWithButton() {
        return frameWithButton;
    }

    public String getButtonFrame() {
        return buttonFrame.getAttribute("value");
    }
}
