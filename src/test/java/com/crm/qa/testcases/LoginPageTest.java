/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sergii
 */
public class LoginPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest(){
        super(); //-calling to TestBase Class -> try....
    }
    
    @BeforeMethod
    public void setUp(){
        initialiazation();
        loginPage = new LoginPage();
    }
    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }
    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImmage();
        Assert.assertTrue(flag);
    }
    @Test(priority=3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    
    
    
    
}
