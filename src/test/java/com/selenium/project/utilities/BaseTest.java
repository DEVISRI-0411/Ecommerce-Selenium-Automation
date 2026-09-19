package com.selenium.project.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        DriverFactory.initializeDriver();

        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            String testName =
                    result.getMethod().getMethodName();

            ScreenshotUtils.captureScreenshot(
                driver,
                testName
            );
        }

        DriverFactory.quitDriver();
    }
}