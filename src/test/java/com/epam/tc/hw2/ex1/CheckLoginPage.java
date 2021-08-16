package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractBeforeAfter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckLoginPage extends AbstractBeforeAfter {
    WebDriverWait webDriverWait;
    static final SoftAssertions SOF = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @Test
    public void loginPageTest() {
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(EPAM_URL);
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        //Assert Browser title
        WebElement webElement = webDriver.findElement(By.name("main-title"));
        webDriverWait.until(ExpectedConditions.titleIs("Home Page"));
        SOF.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        //Assert performing login
        WebElement openLogin = webDriver.findElement(By.id("user-icon"));
        openLogin.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openLogin));
        WebElement username = webDriver.findElement(By.id("name"));
        WebElement password = webDriver.findElement(By.id("password"));
        WebElement log = webDriver.findElement(By.id("login-button"));
        username.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        log.click();
        webDriverWait.until(ExpectedConditions.urlToBe(EPAM_URL));
        SOF.assertThat(webDriver.getCurrentUrl()).isEqualTo(EPAM_URL);
        // Check loggined
        WebElement usernameLoged = webDriver.findElement(By.id("user-name"));
        usernameLoged.isDisplayed();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(usernameLoged, "ROMAN IOVLEV"));
        SOF.assertThat(usernameLoged.getText()).isEqualTo("ROMAN IOVLEV");
        //Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeOnTheHeader = webDriver.findElement(By.xpath("//a[@href='index.html']"));
        homeOnTheHeader.isDisplayed();
        SOF.assertThat(homeOnTheHeader.getText()).isEqualTo("HOME");
        WebElement contactFormOnTheHeader = webDriver.findElement(By.xpath("//a[@href='contacts.html']"));
        contactFormOnTheHeader.isDisplayed();
        SOF.assertThat(contactFormOnTheHeader.getText()).isEqualTo("CONTACT FORM");
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown-toggle"));
        serviceOnTheHeader.isDisplayed();
        SOF.assertThat(serviceOnTheHeader.getText()).isEqualTo("SERVICE");
        WebElement metalsAndColorsOnTheHead = webDriver.findElement(By.xpath("//a[@href='metals-colors.html']"));
        metalsAndColorsOnTheHead.isDisplayed();
        SOF.assertThat(metalsAndColorsOnTheHead.getText()).isEqualTo("METALS & COLORS");
        //Assert that there are 4 images on the Index Page and they are displayed
        WebElement icon1 = webDriver.findElement(By.className("icon-practise"));
        icon1.isDisplayed();
        WebElement icon2 = webDriver.findElement(By.className("icon-custom"));
        icon2.isDisplayed();
        WebElement icon3 = webDriver.findElement(By.className("icon-multi"));
        icon3.isDisplayed();
        WebElement icon4 = webDriver.findElement(By.className("icon-base"));
        icon4.isDisplayed();
        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        WebElement textUnder1 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To include')]"));
        textUnder1.isDisplayed();
        SOF.assertThat(textUnder1.getText()).isEqualTo("To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        WebElement textUnder2 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be flexible')]"));
        SOF.assertThat(textUnder2.getText()).isEqualTo("To be flexible and\n"
            + "customizable");
        textUnder2.isDisplayed();
        WebElement textUnder3 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'To be multiplatform')]"));
        SOF.assertThat(textUnder3.getText()).isEqualTo("To be multiplatform");
        textUnder3.isDisplayed();
        WebElement textUnder4 =
            webDriver.findElement(By.xpath("//div[@class='col-sm-3']//*[contains(text(),'Already')]"));
        SOF.assertThat(textUnder4.getText()).isEqualTo("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");
        textUnder4.isDisplayed();
        //Assert that there is the iframe with “Frame Button” exist
        WebElement frameWithButton = webDriver.findElement(By.id("frame"));
        frameWithButton.isDisplayed();
        //Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(frameWithButton);
        WebElement buttonFrame = webDriver.findElement(By.id("frame-button"));
        //Switch to original window back
        webDriver.switchTo().defaultContent();
        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement homeOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='index.html']"));
        homeOnLeftSection.isDisplayed();
        SOF.assertThat(homeOnLeftSection.getText()).isEqualTo("Home");
        WebElement contactFormOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='contacts.html']"));
        contactFormOnLeftSection.isDisplayed();
        SOF.assertThat(contactFormOnLeftSection.getText()).isEqualTo("Contact form");
        WebElement serviceFormOnLeftSection = webDriver.findElement(By.xpath("//span[contains(text(),'Service')]"));
        serviceFormOnLeftSection.isDisplayed();
        SOF.assertThat(serviceFormOnLeftSection.getText()).isEqualTo("Service");
        WebElement metalsAndColorsFormOnLeftSection =
            webDriver.findElement(By.xpath("//*[@class='sidebar-menu left']//a[@href='metals-colors.html']"));
        metalsAndColorsFormOnLeftSection.isDisplayed();
        SOF.assertThat(metalsAndColorsFormOnLeftSection.getText()).isEqualTo("Metals & Colors");
        WebElement elementPacksFormOnLeftSection =
            webDriver.findElement(By.xpath("//span[contains(text(),'Element')]"));
        elementPacksFormOnLeftSection.isDisplayed();
        SOF.assertThat(elementPacksFormOnLeftSection.getText()).isEqualTo("Elements packs");
        SOF.assertAll();
    }
}
