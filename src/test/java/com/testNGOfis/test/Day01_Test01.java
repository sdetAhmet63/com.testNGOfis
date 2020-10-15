package com.testNGOfis.test;

import com.testNGOfis.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day01_Test01 extends TestBase {
    @Test
    public void test1(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        //3. Login kutusuna “username” yazin
        WebElement usernameKutusu= driver.findElement(By.id("user_login"));
        usernameKutusu.sendKeys("username");
        //4. Password kutusuna “password” yazin
        WebElement passwordKutusu= driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDropDown= driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropDown);
        select.selectByValue("EUR");


        SoftAssert softAssert = new SoftAssert();
        String actualEuroZoneYazisi=select.getFirstSelectedOption().getText();
        String beklenenEuroZoneYazisi="Eurozone (euro)";
        softAssert.assertEquals(actualEuroZoneYazisi, beklenenEuroZoneYazisi,"Eurozone yazisi beklenen ile ayni degil, FAILED ");

        List<WebElement> dropDownWebelementleri = select.getOptions();
        List<String>aktuelDropDownStringList=new ArrayList<>();
        for (WebElement each: dropDownWebelementleri) {
            aktuelDropDownStringList.add(each.getText());

        }
        //10. DropDown listesinin su secenekleri oldugunu test edin {Select One, Australia (dollar),
        // Canada (dollar),Switzerland (franc),China (yuan),Denmark (krone),Eurozone (euro),
        // Great Britain (pound),Hong Kong (dollar),Japan (yen),Mexico (peso),Norway (krone),
        // New Zealand (dollar),Sweden (krona),Singapore (dollar),Thailand (baht)}


        List beklenenDropDownStringList = Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)","Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)",
                 "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)");
       softAssert.assertEquals(beklenenDropDownStringList, aktuelDropDownStringList);
        softAssert.assertAll();
    }

}
