package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BeforeAfter;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise2 extends BeforeAfter {
    WebDriverWait webDriverWait;
    private WebElement webElement;
    static final SoftAssertions SOF = new SoftAssertions();

    @Test
    public void exercise2() {
        webDriverWait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        webDriverWait.until(ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/index.html"));
        //Assert Browser title
        webElement = webDriver.findElement(By.name("main-title"));
        webDriverWait.until(ExpectedConditions.titleIs("Home Page"));
        SOF.assertThat(webDriver.getTitle()).isEqualTo("Home page");
        //Assert performing login
        WebElement openLogin = webDriver.findElement(By.id("user-icon"));
        openLogin.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openLogin));
        WebElement username = webDriver.findElement(By.id("name"));
        WebElement password = webDriver.findElement(By.id("password"));
        final WebElement LOG = webDriver.findElement(By.id("login-button"));
        username.sendKeys("Roman");
        password.sendKeys("Jdi1234");
        LOG.click();
        webDriverWait.until(ExpectedConditions.urlToBe("https://jdi-testing.github.io/jdi-light/index.html"));
        SOF.assertThat(webDriver.getCurrentUrl()).isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");
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
            "https://jdi-testing.github.io/jdi-light/different-elements.html"));
        SOF.assertThat(webDriver.getCurrentUrl()).isEqualTo(
            "https://jdi-testing.github.io/jdi-light/different-elements.html");
        //Select checkboxes
        WebElement waterCheck = webDriver.findElement(By.xpath(
            "//label[@class='label-checkbox'][1]//input[@type='checkbox']"));
        WebElement windCheck = webDriver.findElement(By.xpath(
            "//label[@class='label-checkbox'][3]//input[@type='checkbox']"));
        waterCheck.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(waterCheck));
        windCheck.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(windCheck));
        //Select radio
        WebElement selenRadio = webDriver.findElement(By.xpath(
            "//label[@class='label-radio'][4]//input[@type='radio']"));
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
        SOF.assertThat(waterCheckBox.getText()).isEqualTo("Water: condition changed to true");
        WebElement windCheckBox = webDriver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        SOF.assertThat(windCheckBox.getText()).isEqualTo("Wind: condition changed to true");
        WebElement selenRadioCheck = webDriver.findElement(By.xpath("//li[contains(text(),'Selen')]"));
        SOF.assertThat(selenRadioCheck.getText()).isEqualTo("metal: value changed to Selen");
        WebElement yellowColor = webDriver.findElement(By.xpath("//li[contains(text(),'Yellow')]"));
        SOF.assertThat(yellowColor.getText()).isEqualTo("Colors: value changed to Yellow");
    }
}
