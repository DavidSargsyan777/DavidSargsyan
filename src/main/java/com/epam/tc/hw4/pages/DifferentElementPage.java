package com.epam.tc.hw4.pages;

import com.epam.tc.hw4.components.CheckBoxRow;
import com.epam.tc.hw4.components.RightSideComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementPage {
    WebDriverWait webDriverWait;
    WebDriver webDriver;
    private CheckBoxRow checkBoxRow;
    private RightSideComponent rightSideComponent;
    @FindBy(className = "colors")
    private WebElement dropDown;
    @FindBy(xpath = "//*[contains(text(),'Yellow')]")
    private WebElement yellowColorFromDropDown;

    public DifferentElementPage(WebDriver webDriver1) {
        webDriver = webDriver1;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
        checkBoxRow = new CheckBoxRow(webDriver);
        rightSideComponent = new RightSideComponent(webDriver);
    }

    public CheckBoxRow getCheckBoxRow() {
        return checkBoxRow;
    }

    public RightSideComponent getRightSideComponent() {
        return rightSideComponent;
    }

    @Step
    public DifferentElementPage clickOnDropDown() {
        dropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dropDown));
        return this;
    }

    @Step
    public String clickOnColor() {
        yellowColorFromDropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(yellowColorFromDropDown));
        return yellowColorFromDropDown.getText();
    }
}
