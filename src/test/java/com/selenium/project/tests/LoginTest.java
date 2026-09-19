package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.LoginPage;
import com.selenium.project.pages.RegisterPage;
import com.selenium.project.utilities.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/register.html"
        );

        registerPage.registerUser(
            "Test User",
            "testuser@gmail.com",
            "Test@123"
        );

        // Accept registration alert
        driver.switchTo().alert().accept();

        loginPage.login(
            "testuser@gmail.com",
            "Test@123"
        );

        // Accept login alert
        driver.switchTo().alert().accept();

        Assert.assertEquals(
            driver.getTitle(),
            "ShopEasy - Online Shopping"
        );
    }
}