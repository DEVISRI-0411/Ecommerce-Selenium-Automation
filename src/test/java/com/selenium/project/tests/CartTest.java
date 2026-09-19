package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.CartPage;
import com.selenium.project.pages.ProductsPage;
import com.selenium.project.utilities.BaseTest;

public class CartTest extends BaseTest {

    @Test
    public void cartOperationsTest() {

        ProductsPage productsPage =
                new ProductsPage(driver);

        CartPage cartPage =
                new CartPage(driver);

        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/products.html"
        );

        // Add first product to cart
        productsPage.addFirstProductToCart();

        // Accept "product added" alert
        driver.switchTo().alert().accept();

        // Open cart
        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/cart.html"
        );

        int itemCount =
                cartPage.getCartItemCount();

        Assert.assertTrue(
            itemCount > 0,
            "Product was not added to cart"
        );

        // Verify initial quantity
        String initialQuantity =
                cartPage.getFirstProductQuantity();

        Assert.assertEquals(
            initialQuantity,
            "1",
            "Initial quantity should be 1"
        );

        // Increase quantity
        cartPage.increaseFirstProductQuantity();

        String increasedQuantity =
                cartPage.getFirstProductQuantity();

        Assert.assertEquals(
            increasedQuantity,
            "2",
            "Quantity was not increased to 2"
        );

        // Decrease quantity
        cartPage.decreaseFirstProductQuantity();

        String decreasedQuantity =
                cartPage.getFirstProductQuantity();

        Assert.assertEquals(
            decreasedQuantity,
            "1",
            "Quantity was not decreased to 1"
        );

        System.out.println(
            "Cart Total: " + cartPage.getCartTotal()
        );

        // Remove product
        cartPage.removeFirstProduct();

        // Accept remove confirmation alert
        driver.switchTo().alert().accept();

        int finalItemCount =
                cartPage.getCartItemCount();

        Assert.assertEquals(
            finalItemCount,
            0,
            "Product was not removed from cart"
        );
    }
}