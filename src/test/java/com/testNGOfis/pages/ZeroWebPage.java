package com.testNGOfis.pages;

import com.testNGOfis.utulities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeroWebPage {
    WebDriver driver;
    public  ZeroWebPage(WebDriver driver){
        this.driver=driver;
     PageFactory.initElements(driver, this);
    }
    @FindBy (id = "signin_button")
    public WebElement signInButonu;
    @FindBy (id = "user_login")
    public WebElement loginKutusu;
    @FindBy (id = "user_password")
    public WebElement passWordKutusu;
    @FindBy (xpath = " //input[@name='submit']")
    public WebElement loginIkinci;

    public void zeroWebLogin(){
        signInButonu.click();
        loginKutusu.sendKeys(ConfigReader.getProperty("user_login"));
        passWordKutusu.sendKeys(ConfigReader.getProperty("user_password"));
        loginIkinci.click();

    }






}
