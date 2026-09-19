package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.RegisterPage;
import com.selenium.project.utilities.BaseTest;

public class NegativeRegistrationTest extends BaseTest {

    @Test
    public void passwordMismatchRegistrationTest() {

        RegisterPage registerPage = new RegisterPage(driver);

        driver.get("file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/register.html");

        registerPage.enterName("Test Registration");
        registerPage.enterEmail("registrationtest@gmail.com");
        registerPage.enterPassword("Test@123");
        registerPage.enterConfirmPassword("Wrong@123");

        registerPage.clickRegister();

        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(
                alertMessage,
                "Passwords do not match.",
                "Incorrect password mismatch validation message"
        );

        driver.switchTo().alert().accept();
    }
}