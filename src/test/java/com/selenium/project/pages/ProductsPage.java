package com.selenium.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.project.utilities.WaitUtils;

public class ProductsPage {

    WebDriver driver;
    WaitUtils waitUtils;

    private By searchBox = By.id("productSearch");

    private By searchButton = By.id("productSearchButton");

    private By productCards = By.cssSelector(".product-card");

    private By addCartButtons = By.cssSelector(".add-cart");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void searchProduct(String productName) {

        waitUtils
            .waitForElementVisible(searchBox)
            .clear();

        waitUtils
            .waitForElementVisible(searchBox)
            .sendKeys(productName);

        waitUtils
            .waitForElementClickable(searchButton)
            .click();
    }

    public int getProductCount() {

        waitUtils.waitForElementPresent(productCards);

        return driver.findElements(productCards).size();
    }

    public void addFirstProductToCart() {

        waitUtils
            .waitForElementClickable(addCartButtons)
            .click();
    }
}