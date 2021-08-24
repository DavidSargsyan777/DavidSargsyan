package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractBeforeAfter;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.IndexPage;
import com.epam.tc.hw3.utils.Constants;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CheckLoginPage extends AbstractBeforeAfter {
    static final SoftAssertions SOF = new SoftAssertions();

    @Test
    public void loginPageTest() {
        HomePage homePage = new HomePage(webDriver);
        //Assert Browser title
        String titleName = homePage
            .openPage()
            .getTitleName();
        SOF.assertThat(titleName).isEqualTo(Constants.HOME_PAGE.getConstant());
        //Assert performing login
        String ivanURL = new IndexPage(webDriver)
            .openLogin()
            .login()
            .getUrl();
        SOF.assertThat(ivanURL).isEqualTo(Constants.EPAM_URL.getConstant());
        //        Assert Username in the left-top side of screen that user is loggined
        String fullUserName = new IndexPage(webDriver)
            .checkDisplay()
            .getFullUserName();
        SOF.assertThat(fullUserName).isEqualTo("ROMAN IOVLEV");
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        String homeOnTheHeader = homePage.getHeaderMenu()
                                         .getDisplayedOnHeaderItem(Constants.HOME.toString());
        SOF.assertThat(homeOnTheHeader).isEqualTo(Constants.HOME.toString());
        String contactFormOnTheHeader = homePage.getHeaderMenu()
                                                .getDisplayedOnHeaderItem(Constants.CONTACT_FORM.toString());
        SOF.assertThat(contactFormOnTheHeader).isEqualTo(Constants.CONTACT_FORM.toString());
        String serviceOnTheHeader = homePage.getHeaderMenu()
                                            .getDisplayedOnHeaderItem(Constants.SERVICE.toString());
        SOF.assertThat(serviceOnTheHeader).isEqualTo(Constants.SERVICE.toString());
        String metalsAndColorsOnTheHead = homePage.getHeaderMenu()
                                                  .getDisplayedOnHeaderItem(Constants.METALS_AND_COLORS.toString());
        SOF.assertThat(metalsAndColorsOnTheHead).isEqualTo(Constants.METALS_AND_COLORS.toString());
        //Assert that there are 4 images on the Index Page and they are displayed
        homePage.iconsAreDisplayed();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePage.textsUnderIconsAreDisplayed();
        String[] textsUnderIcon = homePage.getArrayOfTexts();
        SOF.assertThat(textsUnderIcon[0]).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        SOF.assertThat(textsUnderIcon[1]).isEqualTo("To be flexible and\n"
            + "customizable");
        SOF.assertThat(textsUnderIcon[2]).isEqualTo("To be multiplatform");
        SOF.assertThat(textsUnderIcon[3]).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");
        //Assert that there is the iframe with “Frame Button” exist
        homePage.frameWithButtonIsDisplayed();
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getFrameWithButton());
        SOF.assertThat(homePage.getButtonFrame()).isEqualTo("Frame Button");
        //Switch to original window back
        webDriver.switchTo().defaultContent();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        SOF.assertThat(homePage
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.HOME.getConstant()))
            .isEqualTo(Constants.HOME.getConstant());
        SOF.assertThat(homePage
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.CONTACT_FORM.getConstant()))
            .isEqualTo(Constants.CONTACT_FORM.getConstant());
        SOF.assertThat(homePage
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.SERVICE.getConstant()))
            .isEqualTo(Constants.SERVICE.getConstant());
        SOF.assertThat(homePage
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.METALS_AND_COLORS.getConstant()))
            .isEqualTo(Constants.METALS_AND_COLORS.getConstant());
        SOF.assertThat(homePage
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.ELEMENT_PACKS.getConstant()))
            .isEqualTo(Constants.ELEMENT_PACKS.getConstant());
        SOF.assertAll();
    }
}
