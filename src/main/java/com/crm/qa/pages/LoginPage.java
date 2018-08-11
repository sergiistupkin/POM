/*
d * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import static com.crm.qa.util.TestUtil.wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;




/**
 *
 * @author Sergii
 */
public class LoginPage extends TestBase{
    
   //Page factory - OR:
    @FindBy(name = "username")
    WebElement username;
    
    @FindBy(name="password")
    WebElement password;
    
    @FindBy(xpath="//input[@value='Login' and @type='submit']")
    WebElement loginBtn;
    
    @FindBy(xpath="//button[contains(text(), 'Sign')]")
    WebElement singUpBtn;
    
    @FindBy(xpath="//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;
    
    //Initializing the Page objects
    public LoginPage(){
        
    PageFactory.initElements(driver, this);
    }
    //Actions
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validateCRMImmage(){
        return crmLogo.isDisplayed();
    }
    
    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        
        //WebDriverWait wait=new WebDriverWait(driver,20); - moved to TestUtil
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        
        loginBtn.click();
        return new HomePage();//go to Home Page
    }
    
}
