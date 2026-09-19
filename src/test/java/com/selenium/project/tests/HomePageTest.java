package com.selenium.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.project.utilities.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void openHomePage() {

        driver.get(
            "file:///C:/Users/DEVI%20SRI/eclipse-workspace/EcommerceWebsite/index.html"
        );

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(
            actualTitle,
            "ShopEasy - Online Shopping"
        );
    }
}