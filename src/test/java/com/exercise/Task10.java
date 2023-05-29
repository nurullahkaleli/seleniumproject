package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Task10 extends TestBase {
       /*
  Given
      Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
  When
      Click on "click me" button
  Then
      Verify that "Event Triggered"
   */
    @Test
    public void test(){

//        Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

//        Click on "click me" button
        waitFor(8);
        driver.findElement(By.xpath("//button[@id='growbutton']")).click();



//        Verify that "Event Triggered"
        waitFor(2);
        String text = driver.findElement(By.xpath("//p[text()='Event Triggered']")).getText();
        assertEquals("Event Triggered", text);

    }
}
