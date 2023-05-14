package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q1{
     /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */
    WebDriver driver;

     @Before
     public void setUp(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
    @Test
    public void test1(){

//        Go to ebay page
        driver.get("https://www.ebay.com/");

//        Click on electronics section
        driver.findElement(By.linkText("Electronics")).click();

//        Click on all the images with a Width of 225 and a Length of 225
        driver.findElement(By.cssSelector("img[width='225'][height='225']")).click();

//        Print the page title of each page
//        List<String> titleOfEachPage = driver.findElements(By.xpath("//*[@class='dne-pattern-title']"));
//        System.out.println("titleOfEachPage = " + titleOfEachPage);


//        Close the page


    }
//    @After
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//    }

    }
