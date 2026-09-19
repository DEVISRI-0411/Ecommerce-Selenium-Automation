package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.project.utilities.WaitUtils;

public class ConfirmationPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private By confirmationTitle = By.cssSelector(
        ".confirmation-container h2"
    );

    private By orderId = By.id("orderId");

    private By customerName = By.id("customerName");

    private By customerEmail = By.id("customerEmail");

    private By customerPhone = By.id("customerPhone");

    private By customerAddress = By.id("customerAddress");

    private By customerCity = By.id("customerCity");

    private By customerPincode = By.id("customerPincode");

    private By paymentMethod = By.id("paymentMethod");

    private By orderTotal = By.id("orderTotal");

    private By logoutButton = By.id("logoutButton");


    public ConfirmationPage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils = new WaitUtils(driver);
    }


    public String getConfirmationTitle() {

        return waitUtils
            .waitForElementVisible(confirmationTitle)
            .getText();
    }


    public String getOrderId() {

        return waitUtils
            .waitForElementVisible(orderId)
            .getText();
    }


    public String getCustomerName() {

        return waitUtils
            .waitForElementVisible(customerName)
            .getText();
    }


    public String getCustomerEmail() {

        return waitUtils
            .waitForElementVisible(customerEmail)
            .getText();
    }


    public String getCustomerPhone() {

        return waitUtils
            .waitForElementVisible(customerPhone)
            .getText();
    }


    public String getCustomerAddress() {

        return waitUtils
            .waitForElementVisible(customerAddress)
            .getText();
    }


    public String getCustomerCity() {

        return waitUtils
            .waitForElementVisible(customerCity)
            .getText();
    }


    public String getCustomerPincode() {

        return waitUtils
            .waitForElementVisible(customerPincode)
            .getText();
    }


    public String getPaymentMethod() {

        return waitUtils
            .waitForElementVisible(paymentMethod)
            .getText();
    }


    public String getOrderTotal() {

        return waitUtils
            .waitForElementVisible(orderTotal)
            .getText();
    }


    public void clickLogout() {

        waitUtils
            .waitForElementClickable(logoutButton)
            .click();
    }
}