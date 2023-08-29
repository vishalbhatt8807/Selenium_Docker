package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FindFlightPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[@href='index.php'])[3]")
    private WebElement clickOnBackToHomeBtn;

    public void clickOnBackToHome(){
        this.wait.until(ExpectedConditions.visibilityOf(this.clickOnBackToHomeBtn));
        this.clickOnBackToHomeBtn.click();
    }
}
