package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.project.utilities.WaitUtils;

public class LoginPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private By emailField = By.id("loginEmail");

    private By passwordField = By.id("loginPassword");

    private By loginButton = By.cssSelector(
        "#loginForm button[type='submit']"
    );

    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterEmail(String email) {

        waitUtils
            .waitForElementVisible(emailField)
            .sendKeys(email);
    }

    public void enterPassword(String password) {

        waitUtils
            .waitForElementVisible(passwordField)
            .sendKeys(password);
    }

    public void clickLogin() {

        waitUtils
            .waitForElementClickable(loginButton)
            .click();
    }

    public void login(
            String email,
            String password) {

        enterEmail(email);

        enterPassword(password);

        clickLogin();
    }
}