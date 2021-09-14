package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.CheckBoxRow;
import com.epam.tc.hw5.components.RightSideComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementPage {
    WebDriver webDriver;
    private CheckBoxRow checkBoxRow;
    private RightSideComponent rightSideComponent;
    @FindBy(className = "colors")
    private WebElement dropDown;
    @FindBy(xpath = "//*[contains(text(),'Yellow')]")
    private WebElement yellowColorFromDropDown;

    public DifferentElementPage(WebDriver webDriver1) {
        webDriver = webDriver1;
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
    public void clickOnColor() {
        yellowColorFromDropDown.click();
    }

    public String getColorText() {
        return yellowColorFromDropDown.getText();
    }
}
