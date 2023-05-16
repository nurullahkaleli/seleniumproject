package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class Task03 extends TestBase {
    @Test
    public void amazonTest() throws InterruptedException {

//    Go to https://amazon.com
        driver.get("https://amazon.com");

//    Print all the options in the 'Departments' dropdown on the left side of the search box
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(dropDown);
        options.selectByVisibleText("All Departments");

//    Search for each first five options and print titles
//        for (int i=1;i<6 ;i++){
//            Thread.sleep(2000);
//            WebElement firstFiveOptions = driver.findElement(By.xpath("(//div[@role='button'])["+i+"]"));
//            System.out.println("firstFiveOptions titles = " + firstFiveOptions.getText());
//
//        }
        for (int i=1;i<6 ;i++){
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
            Thread.sleep(2000);
            WebElement firstFiveOptions = driver.findElement(By.xpath("(//div[@role='button'])["+i+"]"));
            Thread.sleep(2000);
            clickByJS(firstFiveOptions);
            Thread.sleep(2000);
            System.out.println("firstFiveOptions titles = " + driver.getTitle());
            Thread.sleep(2000);
            driver.findElement(By.id("nav-logo-sprites")).click();
        }
    }
}
