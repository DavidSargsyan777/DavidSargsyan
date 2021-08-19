package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.AbstractBeforeAfter;
import com.epam.tc.hw3.driver.utils.Constants;
import com.epam.tc.hw3.pages.DifferentElementPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.IndexPage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CheckSelectionOnPage extends AbstractBeforeAfter {
    static final SoftAssertions SOF = new SoftAssertions();

    @Test
    public void selectionOnPageTest() {
        //Assert Browser title
        String titleName = new HomePage(webDriver)
            .openPage()
            .getTitleName();
        SOF.assertThat(titleName).isEqualTo(Constants.HOME_PAGE);
        //Assert performing login
        String ivanURL = new IndexPage(webDriver)
            .openLogin()
            .login()
            .getUrl();
        SOF.assertThat(ivanURL).isEqualTo(Constants.EPAM_URL);
        //        Assert User name in the left-top side of screen that user is loggined
        String fullUserName = new IndexPage(webDriver)
            .checkDisplay()
            .getFullUserName();
        SOF.assertThat(fullUserName).isEqualTo("ROMAN IOVLEV");
        //Open through the header menu Service -> Different Elements Page

        String differentElemPageUrl = new HomePage(webDriver).getHeaderMenu()
                                                             .clickOnHeaderItem(Constants.SERVICE)
                                                             .clickOnDiffElem()
                                                             .getDiffElemUrl();
        SOF.assertThat(differentElemPageUrl).isEqualTo(
            Constants.DIFFERENT_ELEMENTS_URL);
        //Select checkboxes
        String waterCheckBox = new DifferentElementPage(webDriver)
            .getCheckBoxRow()
            .clickOnCheckBoxRow(Constants.ITEM_WATER);
        SOF.assertThat(waterCheckBox).isEqualTo(Constants.ITEM_WATER);
        String windCheckBox = new DifferentElementPage(webDriver)
            .getCheckBoxRow()
            .clickOnCheckBoxRow(Constants.ITEM_WIND);
        SOF.assertThat(windCheckBox).isEqualTo(Constants.ITEM_WIND);
        //Select radio
        String selenRadio = new DifferentElementPage(webDriver)
            .getCheckBoxRow()
            .clickOnRadioRow(Constants.ITEM_SELEN);
        SOF.assertThat(selenRadio).isEqualTo(Constants.ITEM_SELEN);
        //Select in dropdown
        String yellowColorText = new DifferentElementPage(webDriver)
            .clickOnDropDown()
            .clickOnColor();
        SOF.assertThat(yellowColorText).isEqualTo(Constants.YELLOW_COLOR);
        new DifferentElementPage(webDriver).clickOnDropDown();
        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        String waterCheckBoxInfo = new DifferentElementPage(webDriver)
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_WATER);
        SOF.assertThat(waterCheckBoxInfo.substring(9)).isEqualTo("Water: condition changed to true");
        String windCheckBoxInfo = new DifferentElementPage(webDriver)
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_WIND);
        SOF.assertThat(windCheckBoxInfo.substring(9)).isEqualTo("Wind: condition changed to true");
        String selenRadioCheck = new DifferentElementPage(webDriver)
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.ITEM_SELEN);
        SOF.assertThat(selenRadioCheck.substring(9)).isEqualTo("metal: value changed to Selen");
        String yellowColor = new DifferentElementPage(webDriver)
            .getRightSideComponent()
            .getTextOfRightSideLog(Constants.YELLOW_COLOR);
        SOF.assertThat(yellowColor.substring(9)).isEqualTo("Colors: value changed to Yellow");

        SOF.assertAll();
    }
}
