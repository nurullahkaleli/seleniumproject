package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day05_RadioButton extends TestBase {

    //      https://testcenter.techproeducation.com/index.php?page=radio-buttons
//      Click on red
//      Click on Football
    @Test
    public void radioButtonTest(){
//      go to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
//      locating red
        WebElement red = driver.findElement(By.id("red"));
//      clicking on red
        red.click();
//      verifying if red is checked
        Assert.assertTrue(red.isSelected());
//      locating Football
        WebElement football = driver.findElement(By.id("football"));
//      clicking on Football
        football.click();
//      verifying if football is checked
        Assert.assertTrue(football.isSelected());




    }
}