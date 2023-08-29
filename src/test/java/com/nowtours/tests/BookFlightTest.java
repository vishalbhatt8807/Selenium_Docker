package com.nowtours.tests;

import com.newtours.pages.FindFlightPage;
import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegisterationConfirmationPage;
import com.newtours.pages.RegisterationPage;
import com.tests.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseClass {
    private String password;
    private String noOfPassangers;


    @Parameters({"password","noOfPassangers"})
    public BookFlightTest(String password, String noOfPassangers){
        this.noOfPassangers = noOfPassangers;
        this.password = password;
    }

    @Test
    public void registerationPageTest(){
        RegisterationPage registerationPage =  new RegisterationPage(driver);
        registerationPage.goTo();
        registerationPage.enterUserDetails("Selenium","Docker");
        registerationPage.userCredential("selenium",this.password);
        registerationPage.submit();
    }
    @Test(dependsOnMethods = "registerationPageTest")
    public void registerationConfirmationPage(){
        RegisterationConfirmationPage registerationConfirmationPage = new RegisterationConfirmationPage(driver);
        registerationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods="registerationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassangers(this.noOfPassangers);
        flightDetailsPage.clickOnContinueBtn();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.clickOnBackToHome();
    }

}
