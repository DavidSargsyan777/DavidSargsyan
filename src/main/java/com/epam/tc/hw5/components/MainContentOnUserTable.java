package com.epam.tc.hw5.components;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainContentOnUserTable {
    WebDriver webDriver;
    @FindBy(xpath = "//select")
    List<WebElement> dropdown;
    @FindBy(xpath = "//td/a")
    List<WebElement> userNames;
    @FindBy(xpath = "//td//span")
    List<WebElement> descriptionsUnderImage;
    @FindBy(xpath = "//td//input")
    List<WebElement> checkboxes;
    @FindBy(xpath = "//select/option")
    List<WebElement> dropdownTest;
    @FindBy(xpath = "//td[text()[contains(.,'1')]]")
    WebElement number1;
    @FindBy(xpath = "//td[text()[contains(.,'2')]]")
    WebElement number2;
    @FindBy(xpath = "//td[text()[contains(.,'3')]]")
    WebElement number3;
    @FindBy(xpath = "//td[text()[contains(.,'4')]]")
    WebElement number4;
    @FindBy(xpath = "//td[text()[contains(.,'5')]]")
    WebElement number5;
    @FindBy(xpath = "//td[text()[contains(.,'6')]]")
    WebElement number6;
    @FindBy(xpath = "//*[@id='ivan']")
    private WebElement checkboxIvan;

    public MainContentOnUserTable(WebDriver webDriver1) {
        webDriver = webDriver1;
        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> getAllDropdownList() {
        return dropdown;
    }

    public List<WebElement> getAllUserNames() {
        return userNames;
    }

    public List<WebElement> getDescriptionsUnderImage() {
        return descriptionsUnderImage;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<String> getListOfFirstRowValues() {

        List<String> listOfFirstRowValues = new ArrayList<>();
        listOfFirstRowValues.add(number1.getText());
        listOfFirstRowValues.add(userNames.get(0).getText());
        listOfFirstRowValues.add(descriptionsUnderImage.get(0).getText());
        return listOfFirstRowValues;
    }

    public List<String> getListOfSecondRowValues() {

        List<String> listOfSecondRowValues = new ArrayList<>();
        listOfSecondRowValues.add(number2.getText());
        listOfSecondRowValues.add(userNames.get(1).getText());
        listOfSecondRowValues.add(descriptionsUnderImage.get(1).getText());
        return listOfSecondRowValues;
    }

    public List<String> getListOfThirdRowValues() {

        List<String> listOfThirdRowValues = new ArrayList<>();
        listOfThirdRowValues.add(number3.getText());
        listOfThirdRowValues.add(userNames.get(2).getText());
        listOfThirdRowValues.add(descriptionsUnderImage.get(2).getText());
        return listOfThirdRowValues;
    }

    public List<String> getListOfFourthRowValues() {

        List<String> listOfFourthRowValues = new ArrayList<>();
        String description = descriptionsUnderImage.get(3).getText().replaceAll("\\R", " ");
        listOfFourthRowValues.add(number4.getText());
        listOfFourthRowValues.add(userNames.get(3).getText());
        listOfFourthRowValues.add(description);
        return listOfFourthRowValues;
    }

    public List<String> getListOfFifthRowValues() {

        List<String> listOfFifthRowValues = new ArrayList<>();
        String description = descriptionsUnderImage.get(4).getText().replaceAll("\\R", " ");
        listOfFifthRowValues.add(number5.getText());
        listOfFifthRowValues.add(userNames.get(4).getText());
        listOfFifthRowValues.add(description);
        return listOfFifthRowValues;
    }

    public List<String> getListOfSixthRowValues() {

        List<String> listOfSixthRowValues = new ArrayList<>();
        String description = descriptionsUnderImage.get(5).getText().replaceAll("\\R", " ");
        listOfSixthRowValues.add(number6.getText());
        listOfSixthRowValues.add(userNames.get(5).getText());
        listOfSixthRowValues.add(description);
        return listOfSixthRowValues;
    }

    public String getDropdownValue(String value) {
        WebElement dropdownValue = dropdownTest.stream()
                                               .filter(
                                                   foundWebElement -> foundWebElement.getText().equalsIgnoreCase(value))
                                               .findAny()
                                               .orElse(null);
        return dropdownValue.getText();
    }

    public void clickOnVipCheckbox() {
        checkboxIvan.click();
    }
}
