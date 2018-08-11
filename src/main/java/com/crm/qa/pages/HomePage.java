/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Sergii
 */
public class HomePage extends TestBase {
    @FindBy(xpath="//td[contains(text(), 'Sergii Stupkin')]")
    WebElement userNameLable;
    @FindBy(xpath="//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;
    @FindBy(xpath="//a[contains(text(), 'New Contact')]")
    WebElement newContactLink;
    @FindBy(xpath="//a[contains(text(), 'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath="//a[contains(text(), 'Tasks')]")
    WebElement tasksLink;
    
    //Initialazing the Page objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    public boolean verifyUserName(){
       return userNameLable.isDisplayed();
    }
    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
    public void clickOnNewContactLink(){
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();//-mouse movement
        newContactLink.click();
    }        
            
            
            
}
