package com.epam.tc.hw4.ex2;

import static io.qameta.allure.Allure.step;

import com.epam.tc.hw4.AbstractBeforeAfter;
import com.epam.tc.hw4.pages.DifferentElementPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.IndexPage;
import com.epam.tc.hw4.utils.Constants;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CheckSelectionOnPage extends AbstractBeforeAfter {
    static final SoftAssertions SOF = new SoftAssertions();

    @Feature("Epam website")
    @Story("Ivan Iovlev")
    @Test
    public void selectionOnPageTest() {
        HomePage homePage = new HomePage(webDriver);
        //Assert Browser title
        String titleName = homePage
            .openPage()
            .getTitleName();
        step("Title name assertion");
        SOF.assertThat(titleName).isEqualTo(Constants.HOME_PAGE.getConstant());
        //Assert performing login
        String ivanURL = new IndexPage(webDriver)
            .openLogin()
            .login()
            .getUrl();
        SOF.assertThat(ivanURL).isEqualTo(Constants.EPAM_URL.getConstant());
        //        Assert User name in the left-top side of screen that user is loggined
        String fullUserName = new IndexPage(webDriver)
            .checkDisplay()
            .getFullUserName();
        step("User name assertion");
        SOF.assertThat(fullUserName).isEqualTo("ROMAN IOVLEV");
        //Open through the header menu Service -> Different Elements Page
        String differentElemPageUrl = homePage.getHeaderMenu()
                                                             .clickOnHeaderItem(Constants.SERVICE.getConstant())
                                                             .clickOnDiffElem()
                                                             .getDiffElemUrl();
        step("Different Elements Page URL assertion");
        SOF.assertThat(differentElemPageUrl).isEqualTo(
            Constants.DIFFERENT_ELEMENTS_URL.getConstant());
        //Select checkboxes
        DifferentElementPage differentElementPage = new DifferentElementPage(webDriver);
        step("Selected checkbox assertions");
        String waterCheckBox = differentElementPage
            .getCheckBoxRow()
            .clickOnCheckBoxRow(Constants.ITEM_WATER.getConstant());
        SOF.assertThat(waterCheckBox).isEqualTo(Constants.ITEM_WATER.getConstant());
        String windCheckBox = differentElementPage
            .getCheckBoxRow()
            .clickOnCheckBoxRow(Constants.ITEM_WIND.getConstant());
        SOF.assertThat(windCheckBox).isEqualTo(Constants.ITEM_WIND.getConstant());
        //Select radio
        step("Selected radio assertion");
        String selenRadio = differentElementPage
            .getCheckBoxRow()
            .clickOnRadioRow(Constants.ITEM_SELEN.getConstant());
        SOF.assertThat(selenRadio).isEqualTo(Constants.ITEM_SELEN.getConstant());
        //Select in dropdown
        step("Selected color assertion");
        String yellowColorText = differentElementPage
            .clickOnDropDown()
            .clickOnColor();
        SOF.assertThat(yellowColorText).isEqualTo(Constants.YELLOW_COLOR.getConstant());
        differentElementPage.clickOnDropDown();
        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        step("Selected corresponding items assertions");
        String waterCheckBoxInfo = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_WATER.getConstant());
        SOF.assertThat(waterCheckBoxInfo.substring(9)).isEqualTo("Water: condition changed to true");
        String windCheckBoxInfo = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_WIND.getConstant());
        SOF.assertThat(windCheckBoxInfo.substring(9)).isEqualTo("Wind: condition changed to true");
        String selenRadioCheck = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_SELEN.getConstant());
        SOF.assertThat(selenRadioCheck.substring(9)).isEqualTo("metal: value changed to Selen");
        String yellowColor = differentElementPage
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.YELLOW_COLOR.getConstant());
        SOF.assertThat(yellowColor.substring(9)).isEqualTo("Colors: value changed to Yellow");

        SOF.assertAll();
    }
}
