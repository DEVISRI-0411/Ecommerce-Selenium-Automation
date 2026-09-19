package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.project.utilities.WaitUtils;

public class RegisterPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private By nameField = By.id("registerName");

    private By emailField = By.id("registerEmail");

    private By passwordField = By.id("registerPassword");

    private By confirmPasswordField = By.id("confirmPassword");

    private By registerButton = By.cssSelector(
        "#registerForm button[type='submit']"
    );

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterName(String name) {

        waitUtils
            .waitForElementVisible(nameField)
            .sendKeys(name);
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

    public void enterConfirmPassword(String password) {

        waitUtils
            .waitForElementVisible(confirmPasswordField)
            .sendKeys(password);
    }

    public void clickRegister() {

        waitUtils
            .waitForElementClickable(registerButton)
            .click();
    }

    public void registerUser(
            String name,
            String email,
            String password) {

        enterName(name);

        enterEmail(email);

        enterPassword(password);

        enterConfirmPassword(password);

        clickRegister();
    }
}