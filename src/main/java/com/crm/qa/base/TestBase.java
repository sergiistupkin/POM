/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 *
 * @author Sergii
 */
public class TestBase {
  public static WebDriver driver;
  public static Properties prop;
  public  static EventFiringWebDriver e_driver;
  public static WebEventListener eventListener;
  
    public TestBase() /*throws FileNotFoundException, IOException*/{
        
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("./src/main/java/com/crm/qa/config/config.properties");
            prop.load(ip);
        }catch(FileNotFoundException e){
        e.printStackTrace();
        }catch(IOException e){
        e.printStackTrace();
        }
    }

public static void initialiazation(){
String browserName = prop.getProperty("browser");
if(browserName.equals("chrome")){
    System.setProperty("webdriver.chrome.driver", "/Users/sergeystupkin/Selenium/chromedriver");
     driver = new ChromeDriver();
}else if(browserName.equals("Firefox")){
    System.setProperty("webdriver.gecko.driver", "/Users/sergeystupkin/Selenium/geckodriver");
    driver = new FirefoxDriver();
}

                e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

//driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

driver.get(prop.getProperty("url"));
}
}