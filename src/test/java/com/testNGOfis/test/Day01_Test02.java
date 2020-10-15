package com.testNGOfis.test;

import com.testNGOfis.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
// 1."http://webdriveruniversity.com/Actions" sayfasina gidin
// 2."Hover over Me First" kutusunun ustune gelin
// 3."Link 1" e tiklayin
// 4.Popup mesajini yazdirin
// 5.Popup'i tamam diyerek kapatin
// 6."Click and hold" kutusuna basili tutun
// 7. "Click and hold" kutusunda cikan yaziyi yazdirin
// 8. "Double click me" butonunu cift tiklayin


public class Day01_Test02 extends TestBase {
    @Test
    public void test1(){
// 1."http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
// 2."Hover over Me First" kutusunun ustune gelin

        WebElement hoverOverLink =driver.findElement(By.xpath("//div[@class='dropdown hover']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(hoverOverLink).perform();

      driver.findElement(By.xpath("//a[@class='list-alert'][1]")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();




    }

}
