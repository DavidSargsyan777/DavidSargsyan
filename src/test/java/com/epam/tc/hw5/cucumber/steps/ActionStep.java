package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.components.HeaderMenu;
import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    protected HeaderMenu headerMenu;

    @When("I click on {string} button in Header")
    public void openCategory(String category) {
        headerMenu = homePage.getHeaderMenu();
        headerMenu.clickOnHeaderItem(category);
    }

    @When("I click on Different Elements button in Service dropdown")
    public void openDifferentElementsPage() {
        headerMenu.clickOnDiffElem();
    }

    @When("I click to select checkbox {string} and {string}")
    public void selectItemFromCheckbox(String checkbox1, String checkbox2) {
        differentElementPage.getCheckBoxRow().clickOnCheckBoxRow(checkbox1);
        TestContext.getInstance().addTestObject("Water", differentElementPage.getCheckBoxRow().getCheckboxText());
        differentElementPage.getCheckBoxRow().clickOnCheckBoxRow(checkbox2);
        TestContext.getInstance().addTestObject("Wind", differentElementPage.getCheckBoxRow().getCheckboxText());
    }

    @When("I click to select radio {string}")
    public void selectItemFromRadio(String radio) {
        differentElementPage.getCheckBoxRow().clickOnRadioRow(radio);
        TestContext.getInstance().addTestObject("Selen", differentElementPage.getCheckBoxRow().getRadioText());
    }

    @When("I click on dropdown to select 'Yellow' color")
    public void selectYellowColor() {
        differentElementPage.clickOnColor();
        TestContext.getInstance().addTestObject("Yellow", differentElementPage.getColorText());
    }

    @When("I click on User Table button in Service dropdown")
    public void openUserTablePage() {
        headerMenu.clickOnUserTable();
    }

    @When("I select 'vip' checkbox for Sergey Ivan")
    public void clickOnCheckBox() {
        userTablePage.getMainContentOnUserTable().clickOnVipCheckbox();
    }
}
