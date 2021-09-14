package com.epam.tc.hw4.components;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxRow {
    WebDriverWait webDriverWait;
    WebDriver webDriver;
    @FindBy(xpath = "//label[@class='label-checkbox']")
    private List<WebElement> checkBoxItems;
    @FindBy(xpath = "//label[@class='label-radio']")
    private List<WebElement> radioItems;

    public CheckBoxRow(WebDriver webDriver1) {
        webDriver = webDriver1;
        webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    @Step
    public String clickOnCheckBoxRow(String item) {
        WebElement currentElement = checkBoxItems
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentElement));
        return currentElement.getText();
    }

    @Step
    public String clickOnRadioRow(String item) {
        WebElement currentElement = radioItems
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(item))
            .findAny()
            .orElse(null);
        currentElement.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentElement));
        return currentElement.getText();
    }
}
