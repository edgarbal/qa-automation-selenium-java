package com.company.qa.tests.login;

import com.company.qa.pages.InventoryPage;
import com.company.qa.pages.LoginPage;
import com.company.qa.tests.base.BaseTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {

        // PREPARATION

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // ACTIONS

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        // ASSERTIONS

        String actualTitle = inventoryPage.getPageTitle();
        String expectedTitle = "Products";
        Assert.assertEquals(actualTitle, expectedTitle, 
            "Login failed or incorrect page title.");
    }
}
