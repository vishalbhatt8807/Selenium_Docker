package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected WebDriver driver;

    @BeforeTest
    public void setDriver(ITestContext context) throws MalformedURLException {
      //BROWSER -> Chrome, firefox
        // HUB_HOST = localhost/hostname

        String host = "localhost";
        MutableCapabilities mutableCapabilities;

        if(System.getProperty("BROWSER")!=null &&
        System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            mutableCapabilities = new FirefoxOptions();
        }else {
            mutableCapabilities = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST")!=null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = context.getCurrentXmlTest().getName();
        System.out.println("Running Test Case Name: "+testName);

        String completeUrl = "http://"+ host + ":4444";
        //String completeUrl = "http://"+ host + ":4444/ui";
        this.driver = new RemoteWebDriver(new URL(completeUrl),mutableCapabilities);

        WebDriverManager.chromedriver().setup();
        this.driver =  new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
