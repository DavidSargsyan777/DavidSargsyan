package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractBeforeAfter;
import com.epam.tc.hw3.driver.utils.Constants;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.IndexPage;
import java.util.Locale;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class CheckLoginPage extends AbstractBeforeAfter {
    static final SoftAssertions SOF = new SoftAssertions();

    @Test
    public void loginPageTest() {
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
        //        Assert Username in the left-top side of screen that user is loggined
        String fullUserName = new IndexPage(webDriver)
            .checkDisplay()
            .getFullUserName();
        SOF.assertThat(fullUserName).isEqualTo("ROMAN IOVLEV");
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        String homeOnTheHeader = new HomePage(webDriver).getHeaderMenu()
                                                        .getDisplayedOnHeaderItem(Constants.HOME);
        SOF.assertThat(homeOnTheHeader).isEqualTo(Constants.HOME.toUpperCase(Locale.ROOT));
        String contactFormOnTheHeader = new HomePage(webDriver).getHeaderMenu()
                                                               .getDisplayedOnHeaderItem(Constants.CONTACT_FORM);
        SOF.assertThat(contactFormOnTheHeader).isEqualTo(Constants.CONTACT_FORM.toUpperCase(Locale.ROOT));
        String serviceOnTheHeader = new HomePage(webDriver).getHeaderMenu()
                                                           .getDisplayedOnHeaderItem(Constants.SERVICE);
        SOF.assertThat(serviceOnTheHeader).isEqualTo(Constants.SERVICE.toUpperCase(Locale.ROOT));
        String metalsAndColorsOnTheHead = new HomePage(webDriver).getHeaderMenu()
                                                                 .getDisplayedOnHeaderItem(Constants.METALS_AND_COLORS);
        SOF.assertThat(metalsAndColorsOnTheHead).isEqualTo(Constants.METALS_AND_COLORS.toUpperCase(Locale.ROOT));
        //Assert that there are 4 images on the Index Page and they are displayed
        new HomePage(webDriver).iconsAreDisplayed();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        new HomePage(webDriver).textsUnderIconsAreDisplayed();
        String[] textsUnderIcon = new HomePage(webDriver).getArrayOfTexts();
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
        new HomePage(webDriver).frameWithButtonIsDisplayed();
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(new HomePage(webDriver).getFrameWithButton());
        SOF.assertThat(new HomePage(webDriver).getButtonFrame()).isEqualTo("Frame Button");
        //Switch to original window back
        webDriver.switchTo().defaultContent();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        SOF.assertThat(new HomePage(webDriver)
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.HOME))
            .isEqualTo(Constants.HOME);
        SOF.assertThat(new HomePage(webDriver)
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.CONTACT_FORM))
            .isEqualTo(Constants.CONTACT_FORM);
        SOF.assertThat(new HomePage(webDriver)
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.SERVICE))
            .isEqualTo(Constants.SERVICE);
        SOF.assertThat(new HomePage(webDriver)
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.METALS_AND_COLORS))
            .isEqualTo(Constants.METALS_AND_COLORS);
        SOF.assertThat(new HomePage(webDriver)
               .getLeftSideMenu()
               .getDisplayedElementFromLeftSide(Constants.ELEMENT_PACKS))
            .isEqualTo(Constants.ELEMENT_PACKS);
        SOF.assertAll();
    }
}
