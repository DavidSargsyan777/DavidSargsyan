package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.AbstractBeforeAfter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckSelectionOnPage extends AbstractBeforeAfter {
    WebDriverWait webDriverWait;
    static final SoftAssertions SOF = new SoftAssertions();
    static final String EPAM_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    static final String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";

    @Test
    public void selectionOnPageTest() {
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
        //        Assert User name in the left-top side of screen that user is loggined
        WebElement usernameLoged = webDriver.findElement(By.id("user-name"));
        usernameLoged.isDisplayed();
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(usernameLoged, "ROMAN IOVLEV"));
        SOF.assertThat(usernameLoged.getText()).isEqualTo("ROMAN IOVLEV");
        //Open through the header menu Service -> Different Elements Page
        WebElement serviceOnTheHeader = webDriver.findElement(By.cssSelector(".dropdown-toggle"));
        serviceOnTheHeader.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(serviceOnTheHeader));
        WebElement differentElemPage = webDriver.findElement(By.xpath("//a[@href='different-elements.html']"));
        differentElemPage.click();
        webDriverWait.until(ExpectedConditions.urlToBe(
            DIFFERENT_ELEMENTS_URL));
        SOF.assertThat(webDriver.getCurrentUrl()).isEqualTo(
            DIFFERENT_ELEMENTS_URL);
        //Select checkboxes
        WebElement waterCheck = webDriver.findElement(By.xpath(
            "//*[text()[contains(.,'Water')]]"));
        WebElement windCheck = webDriver.findElement(By.xpath(
            "//*[text()[contains(.,'Wind')]]"));
        waterCheck.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(waterCheck));
        windCheck.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(windCheck));
        //Select radio
        WebElement selenRadio = webDriver.findElement(By.xpath(
            "//*[text()[contains(.,'Selen')]]"));
        selenRadio.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selenRadio));
        //Select in dropdown
        WebElement dropDown = webDriver.findElement(By.className("colors"));
        dropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dropDown));
        WebElement yellowColorFromDropDown = webDriver.findElement(By.xpath("//*[contains(text(),'Yellow')]"));
        yellowColorFromDropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(yellowColorFromDropDown));
        dropDown.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(dropDown));
        WebElement waterCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Water')]"));
        SOF.assertThat(waterCheckBox.getText()).isEqualTo(waterCheckBox.getText().substring(0, 9)
            + "Water: condition changed to true");
        WebElement windCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        SOF.assertThat(windCheckBox.getText()).isEqualTo(windCheckBox.getText().substring(0, 9)
            + "Wind: condition changed to true");
        WebElement selenRadioCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Selen')]"));
        SOF.assertThat(selenRadioCheck.getText()).isEqualTo(selenRadioCheck.getText().substring(0, 9)
            + "metal: value changed to Selen");
        WebElement yellowColor = webDriver.findElement(By.xpath("//li[contains(text(),'Yellow')]"));
        SOF.assertThat(yellowColor.getText()).isEqualTo(yellowColor.getText().substring(0, 9)
            + "Colors: value changed to Yellow");
        SOF.assertAll();
    }
}
