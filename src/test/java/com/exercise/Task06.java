package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Task06 extends TestBase {

    //Task06:

     /*
    Go to http://szimek.github.io/signature_pad/
    Draw the line or shape you want on the screen
    Press the clear button after drawing
    Close the page
     */

    @Test
    public void test(){

//        Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");

//        Draw the line or shape you want on the screen
        WebElement canvas = driver.findElement(By.cssSelector("canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(canvas ,50,20)
                .clickAndHold()
                .moveByOffset(100,20)
                .moveByOffset(200,100)
                .moveByOffset(300,140)
                .release()
                .perform();

        waitFor(1);
        takeScreenshotOfTheEntirePage();

        waitFor(3);

//        Press the clear button after drawing
        driver.findElement(By.xpath("//button[@class='button clear']")).click();

//        Close the page
        //I'm using testbase class for close the page




    }

}
