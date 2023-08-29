package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="q")
    private WebElement searchTxt;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitBtn;

    @FindBy(linkText = "Videos")
    private WebElement videolink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public void goTo(){
        driver.get("https://duckduckgo.com/");
    }


    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
        searchTxt.sendKeys(keyword);
        submitBtn.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videolink));
        videolink.click();
    }

    public int allVideos(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allVideos.size());
        return this.allVideos.size();
    }
}
