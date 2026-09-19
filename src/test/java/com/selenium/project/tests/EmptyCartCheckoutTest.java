package com.selenium.project.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.CheckoutPage;
import com.selenium.project.utilities.BaseTest;

public class EmptyCartCheckoutTest extends BaseTest {

    @Test
    public void emptyCartCheckoutTest() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // 1. Open Products page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/products.html"
        );

        // 2. Clear the cart completely
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "localStorage.removeItem('cart');"
        );

        // 3. Open Checkout page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/checkout.html"
        );

        // 4. Enter customer details
        checkoutPage.enterName("Empty Cart User");
        checkoutPage.enterEmail("emptycart@gmail.com");
        checkoutPage.enterPhone("9876543210");
        checkoutPage.enterAddress("123 Main Street");
        checkoutPage.enterCity("Chennai");
        checkoutPage.enterPincode("600001");

        // 5. Select a payment method
        checkoutPage.selectCashOnDelivery();

        // 6. Click Place Order
        checkoutPage.clickPlaceOrder();

        // 7. Verify empty cart alert
        String alertMessage = driver.switchTo().alert().getText();

        Assert.assertEquals(
            alertMessage,
            "Your cart is empty.",
            "Incorrect empty cart validation message"
        );

        // 8. Accept alert
        driver.switchTo().alert().accept();

        // 9. Verify redirection to Products page
        Assert.assertTrue(
            driver.getCurrentUrl().contains("products.html"),
            "User should be redirected to products page"
        );
    }
}