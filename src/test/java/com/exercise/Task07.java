package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task07 extends TestBase {

    /*
    Given
        Go to https://demo.guru99.com/test/drag_drop.html
    When
        Drag orange elements on proper boxes below them
    Then
        Verify they are dropped.
  */

    @Test
    public void test(){
    //1.way

//        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");

//        Drag orange elements on proper boxes below them

        WebElement source1 = driver.findElement(By.xpath("//a[text()=' SALES ']"));
        WebElement target1 = driver.findElement(By.xpath("//*[@id='loan']"));

        dragAndDropActions(source1,target1);

        WebElement source2 = driver.findElement(By.xpath("//a[text()=' BANK ']"));
        WebElement target2 = driver.findElement(By.xpath("//*[@id='bank']"));

        dragAndDropActions(source2,target2);

        WebElement source3 = driver.findElement(By.xpath("//a[text()=' 5000']"));
        WebElement target3 = driver.findElement(By.xpath("//*[@id='amt7']"));

        dragAndDropActions(source3,target3);

        WebElement source4 = driver.findElement(By.xpath("//a[text()=' 5000']"));
        WebElement target4 = driver.findElement(By.xpath("//*[@id='amt8']"));

        dragAndDropActions(source4,target4);


//        new Actions(driver).dragAndDrop(source1,target1).perform();
//        new Actions(driver).dragAndDrop(source2,target2).perform();
//        new Actions(driver).dragAndDrop(source3,target3).perform();
//        new Actions(driver).dragAndDrop(source4,target4).perform();

//        Verify they are dropped.
        WebElement perfect = driver.findElement(By.xpath("(//div[@id='equal'])[1]"));
        assertTrue(perfect.isDisplayed());

    }
    //2.Way
    @Test
    public void task07(){
/*
  Given
      Go to https://demo.guru99.com/test/drag_drop.html
  When
      Drag orange elements on proper boxes below them
  Then
      Verify they are dropped.
*/
        //        Go to https://demo.guru99.com/test/drag_drop.html
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        scrollAllTheWayDownJS();
        //        Drag orange elements on proper boxes below them
        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(waitForVisibility(By.id("credit2"),2),waitForVisibility(By.id("bank"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("fourth"),2),waitForVisibility(By.id("amt7"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("credit1"),2),waitForVisibility(By.id("loan"),2)).release()
                .dragAndDrop(waitForVisibility(By.id("fourth"),2),waitForVisibility(By.id("amt8"),2)).release()
                .perform();
        //        Verify they are dropped.
       assertEquals("Perfect!",waitForVisibility(By.xpath("//a[.='Perfect!']"),2).getText());
    }

}
