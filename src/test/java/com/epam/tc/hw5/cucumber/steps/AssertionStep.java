package com.epam.tc.hw5.cucumber.steps;

import static com.epam.tc.hw5.utils.Constants.DIFFERENT_ELEMENTS_URL;
import static com.epam.tc.hw5.utils.Constants.ITEM_SELEN;
import static com.epam.tc.hw5.utils.Constants.ITEM_WATER;
import static com.epam.tc.hw5.utils.Constants.ITEM_WIND;
import static com.epam.tc.hw5.utils.Constants.USER_TABLE_URL;
import static com.epam.tc.hw5.utils.Constants.VIP;
import static com.epam.tc.hw5.utils.Constants.YELLOW_COLOR;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;

public class AssertionStep extends AbstractStep {

    @Then("'Different Elements' page should be opened")
    public void differentElementPageIsOpened() {
        assertThat(headerMenu.getDiffElemUrl()).as("URL is not correct")
                                               .isEqualTo(DIFFERENT_ELEMENTS_URL.getConstant());
    }

    @Then("'Water' and 'Wind' checkboxes are selected")
    public void checkboxesAreSelected() {
        String actualWater = TestContext.getInstance().getTestObject("Water");
        String actualWind = TestContext.getInstance().getTestObject("Wind");
        assertThat(actualWater).as("Water is not selected").isEqualTo(ITEM_WATER.getConstant());
        assertThat(actualWind).as("Wind is not selected").isEqualTo(ITEM_WIND.getConstant());
    }

    @Then("'Selen' radio is selected")
    public void radioIsSelected() {
        String actualSelen = TestContext.getInstance().getTestObject("Selen");
        assertThat(actualSelen).as("Selen is not selected").isEqualTo(ITEM_SELEN.getConstant());
    }

    @Then("'Yellow' color is selected")
    public void colorIsSelected() {
        String actualYellowColor = TestContext.getInstance().getTestObject("Yellow");
        assertThat(actualYellowColor).as("Selected color isn't correct ").isEqualTo(YELLOW_COLOR.getConstant());
    }

    @Then("Log rows correspond to selected items")
    public void logRowsCorrespondToSelectedItems() {

        String waterCheckBoxInfo = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(ITEM_WATER.getConstant());
        assertThat(waterCheckBoxInfo.substring(9)).isEqualTo("Water: condition changed to true");
        String windCheckBoxInfo = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(ITEM_WIND.getConstant());
        assertThat(windCheckBoxInfo.substring(9)).isEqualTo("Wind: condition changed to true");
        String selenRadioCheck = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(ITEM_SELEN.getConstant());
        assertThat(selenRadioCheck.substring(9)).isEqualTo("metal: value changed to Selen");
        String yellowColor = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(YELLOW_COLOR.getConstant());
        assertThat(yellowColor.substring(9)).isEqualTo("Colors: value changed to Yellow");
    }

    @Then("'User Table' page should be opened")
    public void userTablePageIsOpened() {
        assertThat(headerMenu.getUserTableUrl()).as("URL is not correct").isEqualTo(USER_TABLE_URL.getConstant());
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void dropdownOnUserTablePageIsDisplayed() {
        int i = 0;
        for (i = 0; i < 6; i++) {
            assertThat(userTablePage.getMainContentOnUserTable().getAllDropdownList().get(i).isDisplayed()).as(
                "Dropdown is not displayed").isEqualTo(true);
        }
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void userNamesOnUserTablePageIsDisplayed() {
        int i = 0;
        for (i = 0; i < 6; i++) {
            assertThat(userTablePage.getMainContentOnUserTable().getAllUserNames().get(i).isDisplayed()).as(
                "Usernames is not displayed").isEqualTo(true);
        }
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionUnderImagesOnUserTablePageIsDisplayed() {
        int i = 0;
        for (i = 0; i < 6; i++) {
            assertThat(userTablePage.getMainContentOnUserTable().getDescriptionsUnderImage().get(i).isDisplayed()).as(
                "Description is not displayed").isEqualTo(true);
        }
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesOnUserTablePageIsDisplayed() {
        int i = 0;
        for (i = 0; i < 6; i++) {
            assertThat(userTablePage.getMainContentOnUserTable().getCheckboxes().get(i).isDisplayed()).as(
                "Checkboxes is not displayed").isEqualTo(true);
        }
    }

    @Then("User table should contain following values {string} {string} {string} :")
    public void valuesOnUserTablePage(String number, String users, String description) {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(number);
        expectedList.add(users);
        expectedList.add(description);
        switch (number) {
            case "1":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfFirstRowValues()).isEqualTo(expectedList);
                break;
            case "2":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfSecondRowValues()).isEqualTo(
                    expectedList);
                break;
            case "3":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfThirdRowValues()).isEqualTo(expectedList);
                break;
            case "4":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfFourthRowValues()).isEqualTo(
                    expectedList);
                break;
            case "5":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfFifthRowValues()).isEqualTo(expectedList);
                break;
            case "6":
                assertThat(userTablePage.getMainContentOnUserTable().getListOfSixthRowValues()).isEqualTo(expectedList);
                break;
            default:
                System.out.println("No matches");
                break;
        }
    }

    @Then("droplist should contain {string} values in column Type for user Roman :")
    public void valuesInDropdown(String values) {

        assertThat(userTablePage.getMainContentOnUserTable().getDropdownValue(values)).isEqualTo(values);
    }

    @Then("1 log row has \"Vip: condition changed to true\" text in log section")
    public void checkLogRow() {
        String waterCheckBoxInfo = userTablePage
            .getRightSideComponent()
            .getTextOfRightSideLog(VIP.getConstant());
        assertThat(waterCheckBoxInfo.substring(9)).isEqualTo("Vip: condition changed to true");
    }
}
