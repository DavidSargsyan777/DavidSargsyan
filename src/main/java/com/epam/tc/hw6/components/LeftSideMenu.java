package com.epam.tc.hw6.components;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideMenu {
    WebDriver webDriver;
    @FindBy(xpath = "//*[@class='sidebar-menu left']/li[@index]")
    private List<WebElement> leftSideMenu;

    public LeftSideMenu(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
    }

    public String getDisplayedElementFromLeftSide(String element) {
        WebElement currentElement = leftSideMenu
            .stream()
            .filter(foundWebElement -> foundWebElement.getText().equalsIgnoreCase(element))
            .findAny()
            .orElse(null);
        currentElement.isDisplayed();
        return currentElement.getText();
    }
}
