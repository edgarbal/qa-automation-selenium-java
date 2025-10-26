package com.company.qa.tests.login;

import com.company.qa.tests.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {

        // STEPS

        // Enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Click on login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // ASSERTIONS

        // Verify successful login by checking the presence of the products page title
        String actual = driver.findElement(By.className("title")).getText();
        String expected = "Products";
        Assert.assertEquals(actual, expected, 
            "Login failed or incorrect page title."
        );
    }
}
