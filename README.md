ShopEasy - Selenium E-Commerce Automation



 Project Overview



ShopEasy is a sample e-commerce web application developed to practice

end-to-end web application testing using Selenium WebDriver, Java,

TestNG, and Maven.



The project follows the Page Object Model (POM) design pattern and

includes reusable utilities for WebDriver management, explicit waits,

and failure screenshot capture.



 Features Automated



- Home Page validation

- User Registration

- User Login

- Product Search

- Add Product to Cart

- Increase Product Quantity

- Decrease Product Quantity

- Remove Product from Cart

- Checkout

- Order Confirmation

- User Logout



Technologies Used



- Java

- Selenium WebDriver

- TestNG

- Maven

- Git

- GitHub

- Eclipse IDE

- HTML

- CSS

- JavaScript



Framework Structure





Ecommerce

│

├── src

│   └── test

│       └── java

│           └── com.selenium.project

│               │

│               ├── pages

│               │   ├── LoginPage.java

│               │   ├── RegisterPage.java

│               │   ├── ProductsPage.java

│               │   ├── CartPage.java

│               │   ├── CheckoutPage.java

│               │   └── ConfirmationPage.java

│               │

│               ├── tests

│               │   ├── HomePageTest.java

│               │   ├── LoginTest.java

│               │   ├── ProductTest.java

│               │   ├── CartTest.java

│               │   ├── CheckoutTest.java

│               │   └── LogoutTest.java

│               │

│               └── utilities

│                   ├── BaseTest.java

│                   ├── DriverFactory.java

│                   ├── WaitUtils.java

│                   └── ScreenshotUtils.java

│

├── pom.xml

├── testng.xml

└── .gitignore