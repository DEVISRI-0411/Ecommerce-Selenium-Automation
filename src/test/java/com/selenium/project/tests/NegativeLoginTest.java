package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.LoginPage;
import com.selenium.project.pages.RegisterPage;
import com.selenium.project.utilities.BaseTest;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/register.html"
        );

        // Register a valid user
        registerPage.registerUser(
                "Negative Test User",
                "negativeuser@gmail.com",
                "Test@123"
        );

        driver.switchTo().alert().accept();

        // Attempt login using incorrect password
        loginPage.login(
                "negativeuser@gmail.com",
                "Wrong@123"
        );

        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(
                alertMessage,
                "Invalid email or password.",
                "Incorrect login validation message"
        );

        driver.switchTo().alert().accept();
    }
}