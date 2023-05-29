package com.exercise;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task08 extends TestBase {

    /*
    Given
        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
    When
        Fill the username, password and textArea comment:
    And
        Choose a file and upload it
    And
        Select all checkboxes, radio item 1 and dropdown 1
    And
        Click on submit
   Then
        Verify that uploaded file name is on the Form Details
     */

    @Test
    public void test(){

//        Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

//        Fill the username, password and textArea comment:
        driver.findElement(By.name("username")).sendKeys(Faker.instance().name().username());
        driver.findElement(By.name("password")).sendKeys(Faker.instance().internet().password());
        driver.findElement(By.name("comments")).sendKeys("Good");

//        Choose a file and upload it
        String pathOfFile = System.getProperty("user.home")+ "/Desktop/flower.jpeg";
        WebElement chooseFileInput = driver.findElement(By.name("filename"));
        chooseFileInput.sendKeys(pathOfFile);

//        Select all checkboxes, radio item 1 and dropdown 1
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for(int i = 0; i<checkboxes.size()-1; i++){
            checkboxes.get(i).click();
        }

        driver.findElement(By.xpath("(//input[@name='radioval'])[1]")).click();

       waitFor(1);
        driver.findElement(By.xpath("//option[@value='ms1']")).click();
        waitFor(2);

        WebElement dropdown = driver.findElement(By.name("dropdown"));
        Select options = new Select(dropdown);
        options.selectByVisibleText("Drop Down Item 1");

        takeScreenshotOfTheEntirePage();

//        Click on submit
        driver.findElement(By.xpath("//input[@value='submit']")).click();

//        Verify that uploaded file name is on the Form Details
        String fileName = driver.findElement(By.xpath("//li[@id='_valuefilename']")).getText();
        assertEquals("flower.jpeg",fileName);

    }
}
