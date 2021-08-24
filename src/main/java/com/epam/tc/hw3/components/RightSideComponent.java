package com.epam.tc.hw3.components;

import java.util.List;
import java.util.Locale;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSideComponent {
    WebDriver webDriver;
    @FindBy(xpath = "//li[contains(text(),'changed')]")
    private List<WebElement> logRows;

    public RightSideComponent(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
    }

    public String getTextOfRightSideLog(String rowName) {
        WebElement currentElement = logRows
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().toLowerCase(Locale.ROOT).contains(rowName.toLowerCase(
                Locale.ROOT)))
            .findAny()
            .orElse(null);
        return currentElement.getText();
    }
}
