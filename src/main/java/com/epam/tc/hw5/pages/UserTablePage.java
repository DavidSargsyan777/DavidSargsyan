package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.MainContentOnUserTable;
import com.epam.tc.hw5.components.RightSideComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage {
    WebDriver webDriver;
    private MainContentOnUserTable mainContentOnUserTable;
    private RightSideComponent rightSideComponent;
    @FindBy(xpath = "//*[@id='ivan']")
    private WebElement checkboxIvan;

    public UserTablePage(WebDriver webDriver1) {
        webDriver = webDriver1;
        mainContentOnUserTable = new MainContentOnUserTable(webDriver);
        rightSideComponent = new RightSideComponent(webDriver);
    }

    public RightSideComponent getRightSideComponent() {
        return rightSideComponent;
    }

    public MainContentOnUserTable getMainContentOnUserTable() {
        return mainContentOnUserTable;
    }
}
