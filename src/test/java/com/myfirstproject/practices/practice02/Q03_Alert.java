package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class Q03_Alert extends TestBase {

       /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click "CLICK ME" of JavaScript Alert
    And
        Get the Alert text
    Then
        Verify that message is "I am an alert box!"
    When
        Accept Alert
     */
    @Test
    public void test(){

        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        //Click "CLICK ME" of JavaScript Alert
        driver.findElement(By.id("button1")).click();

        //Get the Alert text
        String alertText = driver.switchTo().alert().getText();
        System.out.println("alertText = " + alertText);

        //Verify that message is "I am an alert box!"
        assertTrue(alertText.contains("I am an alert box!"));

        //Accept Alert
        driver.switchTo().alert().accept();


    }

}
