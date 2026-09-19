package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.project.utilities.WaitUtils;

import java.util.List;

public class CartPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private By cartItems = By.cssSelector(".cart-item");

    private By cartTotal = By.id("cartTotal");

    private By checkoutButton = By.id("checkoutButton");

    public CartPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public int getCartItemCount() {

        return driver.findElements(cartItems).size();
    }

    public String getCartTotal() {

        return waitUtils
            .waitForElementVisible(cartTotal)
            .getText();
    }

    public String getFirstProductQuantity() {

        WebElement firstItem =
                waitUtils
                    .waitForElementVisible(cartItems);

        return firstItem.findElement(
            By.cssSelector(".quantity")
        ).getText();
    }

    public void increaseFirstProductQuantity() {

        WebElement firstItem =
                waitUtils
                    .waitForElementVisible(cartItems);

        List<WebElement> quantityButtons =
                firstItem.findElements(
                    By.cssSelector(".quantity-button")
                );

        // Second button is +
        quantityButtons.get(1).click();
    }

    public void decreaseFirstProductQuantity() {

        WebElement firstItem =
                waitUtils
                    .waitForElementVisible(cartItems);

        List<WebElement> quantityButtons =
                firstItem.findElements(
                    By.cssSelector(".quantity-button")
                );

        // First button is -
        quantityButtons.get(0).click();
    }

    public void removeFirstProduct() {

        WebElement firstItem =
                waitUtils
                    .waitForElementVisible(cartItems);

        firstItem.findElement(
            By.cssSelector(".remove-button")
        ).click();
    }

    public void clickCheckout() {

        waitUtils
            .waitForElementClickable(checkoutButton)
            .click();
    }
}