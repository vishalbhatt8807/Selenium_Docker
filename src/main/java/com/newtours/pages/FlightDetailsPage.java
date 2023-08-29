package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FlightDetailsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "passCount")
    private WebElement passangers;

    @FindBy(name = "findFlights")
    private WebElement continueBtn;

    public void selectPassangers(String numPassanger){
        this.wait.until(ExpectedConditions.visibilityOf(this.passangers));
        Select select = new Select(this.passangers);
        select.selectByValue(numPassanger);
    }

    public void clickOnContinueBtn(){
        this.continueBtn.click();
    }
}

