/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
//import static com.crm.qa.base.TestBase.driver;
//import static com.crm.qa.base.TestBase.initialiazation;
//import static com.crm.qa.base.TestBase.prop;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Sergii 
 */
public class ContactsPageTest extends TestBase{
    
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    
    String sheetName = "contacts";
        
    public ContactsPageTest(){
        super();
    }
    
    
    @BeforeMethod
    public void setUp(){
        initialiazation();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    
    }
        
       @Test(priority=1)
       public void verifyContactsPageLableTest(){
           Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact Page is missing on the psge"); 
       }
       @Test(priority=2)
       public void selectSingleContactsTest(){
           contactsPage.selectContactsByName("test Test");
       }
       @Test(priority=3)
       public void selectMultipleContactsTest(){
           contactsPage.selectContactsByName("test Test");
           contactsPage.selectContactsByName("Test2 Test2");
       }
       
//       @Test(priority=4)
//       public void validateCreateNewContact(){
//           homePage.clickOnNewContactLink();
//           contactsPage.createNewContact("Mr.", "Tom", "Smith", "Google");
//       }
       @DataProvider
       public Object[][] getCRMTestData(){ //Object[][] - dimention array
           Object data[][] = TestUtil.getTestData(sheetName);
           return data;
       }
       @Test(priority=4, dataProvider="getCRMTestData")
       public void validateCreateNewContacts(String title, String firstName, String lastName, String companyName){
           homePage.clickOnNewContactLink();
           contactsPage.createNewContact(title, lastName, lastName, companyName);
       }
       
               
        @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
