package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.CheckoutPage;
import com.selenium.project.pages.ProductsPage;
import com.selenium.project.utilities.BaseTest;

public class NegativeCheckoutTest extends BaseTest {

    @Test
    public void paymentMethodValidationTest() {

        ProductsPage productsPage = new ProductsPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // 1. Open Products page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/products.html"
        );

        // 2. Add a product to the cart
        productsPage.addFirstProductToCart();

        // Accept "Product has been added to your cart!" alert
        driver.switchTo().alert().accept();

        // 3. Open Checkout page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/checkout.html"
        );

        // 4. Enter customer details
        checkoutPage.enterName("Test User");
        checkoutPage.enterEmail("testuser@gmail.com");
        checkoutPage.enterPhone("9876543210");
        checkoutPage.enterAddress("123 Main Street");
        checkoutPage.enterCity("Chennai");
        checkoutPage.enterPincode("600001");

        // IMPORTANT:
        // Do NOT select any payment method.

        // 5. Click Place Order
        checkoutPage.clickPlaceOrder();

        // 6. Verify validation alert
        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(
            alertMessage,
            "Please select a payment method.",
            "Incorrect payment validation message"
        );

        // 7. Accept alert
        driver.switchTo().alert().accept();

        // 8. User should remain on checkout page
        Assert.assertTrue(
            driver.getCurrentUrl().contains("checkout.html"),
            "User should remain on checkout page"
        );
    }
}