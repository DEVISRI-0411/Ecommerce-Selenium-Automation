package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.CheckoutPage;
import com.selenium.project.pages.ConfirmationPage;
import com.selenium.project.pages.ProductsPage;
import com.selenium.project.utilities.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        ProductsPage productsPage = new ProductsPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);

        // 1. Open Products page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/products.html"
        );

        // 2. Add first product to cart
        productsPage.addFirstProductToCart();

        // Accept product added alert
        driver.switchTo().alert().accept();

        // 3. Open Checkout page
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/checkout.html"
        );

        // 4. Verify checkout total is displayed
        String checkoutTotal = checkoutPage.getCheckoutTotal();

        Assert.assertNotNull(
            checkoutTotal,
            "Checkout total was not displayed"
        );

        System.out.println("Checkout Total: ₹" + checkoutTotal);

        // 5. Enter customer details and place order
        checkoutPage.completeCheckout(
            "Test User",
            "testuser@gmail.com",
            "9876543210",
            "123 Main Street",
            "Chennai",
            "600001"
        );

        // 6. Verify confirmation page
        Assert.assertTrue(
            driver.getCurrentUrl().contains("confirmation.html"),
            "Order confirmation page was not displayed"
        );

        // 7. Verify confirmation title
        Assert.assertEquals(
            confirmationPage.getConfirmationTitle(),
            "Order Confirmed!",
            "Confirmation title is incorrect"
        );

        // 8. Verify Order ID
        String orderId = confirmationPage.getOrderId();

        Assert.assertTrue(
            orderId.startsWith("SE"),
            "Invalid Order ID"
        );

        System.out.println("Order ID: " + orderId);

        // 9. Verify customer name
        Assert.assertEquals(
            confirmationPage.getCustomerName(),
            "Test User",
            "Customer name is incorrect"
        );

        // 10. Verify customer email
        Assert.assertEquals(
            confirmationPage.getCustomerEmail(),
            "testuser@gmail.com",
            "Customer email is incorrect"
        );

        // 11. Verify customer city
        Assert.assertEquals(
            confirmationPage.getCustomerCity(),
            "Chennai",
            "Customer city is incorrect"
        );

        // 12. Verify customer pincode
        Assert.assertEquals(
            confirmationPage.getCustomerPincode(),
            "600001",
            "Customer pincode is incorrect"
        );

        // 13. Verify payment method
        Assert.assertEquals(
            confirmationPage.getPaymentMethod(),
            "Cash on Delivery",
            "Payment method is incorrect"
        );

        // 14. Verify order total
        String orderTotal = confirmationPage.getOrderTotal();

        Assert.assertNotNull(
            orderTotal,
            "Order total is not displayed"
        );

        System.out.println("Order Total: ₹" + orderTotal);
    }
}