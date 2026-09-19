package com.selenium.project.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.ConfirmationPage;
import com.selenium.project.pages.LoginPage;
import com.selenium.project.pages.RegisterPage;
import com.selenium.project.utilities.BaseTest;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        RegisterPage registerPage =
                new RegisterPage(driver);

        LoginPage loginPage =
                new LoginPage(driver);

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        // Open registration page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/register.html"
        );

        // Register user
        registerPage.registerUser(
            "Logout User",
            "logoutuser@gmail.com",
            "Test@123"
        );

        // Accept registration alert
        driver.switchTo().alert().accept();

        // Login
        loginPage.login(
            "logoutuser@gmail.com",
            "Test@123"
        );

        // Accept login alert
        driver.switchTo().alert().accept();

        // Verify successful login
        Assert.assertEquals(
            driver.getTitle(),
            "ShopEasy - Online Shopping"
        );

        // Open confirmation page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/confirmation.html"
        );

        // Click logout using Page Object
        confirmationPage.clickLogout();

        // Accept logout alert
        driver.switchTo().alert().accept();

        // Verify redirect to login page
        Assert.assertTrue(
            driver.getCurrentUrl().contains("login.html"),
            "User was not redirected to Login page after logout"
        );
    }
}