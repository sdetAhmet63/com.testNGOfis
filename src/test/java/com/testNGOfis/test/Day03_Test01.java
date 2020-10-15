package com.testNGOfis.test;

import com.testNGOfis.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.ref.WeakReference;

public class Day03_Test01 extends TestBase {

//1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
  // 2.“Our Products” butonuna basin
//3.“Cameras product” I tiklayin
//4.Popup mesajini yazdirin
//5.“close” butonuna basin
//6."WebdriverUniversity.com (IFrame)" linkini tiklayin
//7."http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test1(){
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        WebElement iFrame = driver.findElement(By.id("frame"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.linkText("Our Products")).click();
        //"Cameras product" I tiklayin
        driver.findElement(By.id("camera-img")).click();
        WebElement popUpyazisi = driver.findElement(By.xpath("//div[@class='modal-body']/p"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(popUpyazisi.getText());
        //“close” butonuna basin

        driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.id("nav-title")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin

        String aktuelSayfaURL=driver.getCurrentUrl();
        String beklenenSayfaURL="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(aktuelSayfaURL, beklenenSayfaURL);






    }




}
