package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.pages.ProductsPage;
import com.selenium.project.utilities.BaseTest;

public class ProductTest extends BaseTest {

    @Test
    public void searchAndAddProductTest() {

        ProductsPage productsPage =
                new ProductsPage(driver);

        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/products.html"
        );

        productsPage.searchProduct("Headphones");

        int productCount =
                productsPage.getProductCount();

        Assert.assertTrue(
            productCount > 0,
            "No products found for the search"
        );

        productsPage.addFirstProductToCart();

        // Accept "product added to cart" alert
        driver.switchTo().alert().accept();
    }
}