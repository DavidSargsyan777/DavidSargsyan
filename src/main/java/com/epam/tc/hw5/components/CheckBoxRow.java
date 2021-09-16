package com.epam.tc.hw5.components;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxRow {
    WebDriver webDriver;
    WebElement currentElement;
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkBoxItems;
    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioItems;

    public CheckBoxRow(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
    }

    @Step
    public void clickOnCheckBoxRow(String item) {
        currentElement = checkBoxItems
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.click();
    }

    public String getCheckboxText() {
        return currentElement.getText();
    }

    @Step
    public void clickOnRadioRow(String item) {
        currentElement = radioItems
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.click();
    }

    public String getRadioText() {
        return currentElement.getText();
    }
}
