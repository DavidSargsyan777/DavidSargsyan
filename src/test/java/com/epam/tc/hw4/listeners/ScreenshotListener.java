package com.epam.tc.hw4.listeners;

import com.epam.tc.hw4.utils.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object webdriver = result.getTestContext().getAttribute("webdriver");
        if (webdriver != null) {
            byte[] screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeScreenshotAttachment("David",
                screenshot);
        }
    }
}
