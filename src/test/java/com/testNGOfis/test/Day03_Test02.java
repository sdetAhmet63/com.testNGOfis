package com.testNGOfis.test;

import com.testNGOfis.utulities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day03_Test02 extends TestBase {
    @Test
    public void test1(){
        driver.get("https://www.mediawiki.org/wiki/Download");
        driver.findElement(By.linkText("Download MediaWiki 1.35.0")).click();
        String kullaniciDosyaYolu = System.getProperty("user.home")+"\\Downloads\\mediawiki-1.35.0.tar.gz";
        System.out.println(kullaniciDosyaYolu);
        // C:\Users\DELL LATITUDE 7300\Downloads\mediawiki-1.35.0.tar.gz
        boolean varMi= Files.exists(Paths.get(kullaniciDosyaYolu));
        Assert.assertTrue(varMi);

    }
    }

