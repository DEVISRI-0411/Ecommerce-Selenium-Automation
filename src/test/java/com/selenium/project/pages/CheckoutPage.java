package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.project.utilities.WaitUtils;

public class CheckoutPage {

    WebDriver driver;
    WaitUtils waitUtils;


    // Customer fields

    private By nameField =
            By.id("customerName");

    private By emailField =
            By.id("customerEmail");

    private By phoneField =
            By.id("phone");

    private By addressField =
            By.id("address");

    private By cityField =
            By.id("city");

    private By pincodeField =
            By.id("pincode");


    // Payment options

    private By cashOnDelivery =
            By.cssSelector(
                "input[name='payment'][value='Cash on Delivery']"
            );

    private By upiPayment =
            By.cssSelector(
                "input[name='payment'][value='UPI']"
            );

    private By cardPayment =
            By.cssSelector(
                "input[name='payment'][value='Credit/Debit Card']"
            );


    // Checkout elements

    private By checkoutTotal =
            By.id("checkoutTotal");

    private By placeOrderButton =
            By.id("placeOrderButton");


    public CheckoutPage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils =
                new WaitUtils(driver);

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


    public void enterPhone(String phone) {

        waitUtils
            .waitForElementVisible(phoneField)
            .sendKeys(phone);

    }


    public void enterAddress(String address) {

        waitUtils
            .waitForElementVisible(addressField)
            .sendKeys(address);

    }


    public void enterCity(String city) {

        waitUtils
            .waitForElementVisible(cityField)
            .sendKeys(city);

    }


    public void enterPincode(String pincode) {

        waitUtils
            .waitForElementVisible(pincodeField)
            .sendKeys(pincode);

    }


    public void selectCashOnDelivery() {

        waitUtils
            .waitForElementClickable(cashOnDelivery)
            .click();

    }


    public void selectUPI() {

        waitUtils
            .waitForElementClickable(upiPayment)
            .click();

    }


    public void selectCardPayment() {

        waitUtils
            .waitForElementClickable(cardPayment)
            .click();

    }


    public String getCheckoutTotal() {

        return waitUtils
                .waitForElementVisible(checkoutTotal)
                .getText();

    }


    public void clickPlaceOrder() {

        waitUtils
            .waitForElementClickable(placeOrderButton)
            .click();

    }


    public void completeCheckout(
            String name,
            String email,
            String phone,
            String address,
            String city,
            String pincode) {

        enterName(name);

        enterEmail(email);

        enterPhone(phone);

        enterAddress(address);

        enterCity(city);

        enterPincode(pincode);

        selectCashOnDelivery();

        clickPlaceOrder();

    }

}