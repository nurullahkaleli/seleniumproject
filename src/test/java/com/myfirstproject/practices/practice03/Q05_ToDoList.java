package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q05_ToDoList extends TestBase {

    /*
        Given
            Go to http://webdriveruniversity.com/To-Do-List/index.html
        When
            Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        And
            Strikethrough all todos.
        And
            Delete all todos.
        Then
            Assert that all todos deleted.
     */

    @Test
    public void toDoListTest() {
//        Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

//        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> toDoList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby", "Help your kid's homework", "Study Selenium", "Sleep"));
        System.out.println("toDoList = " + toDoList);
        WebElement toDoInput = driver.findElement(By.xpath("//input[@type='text']"));

        for (String w : toDoList) {
            waitFor(1);
            toDoInput.sendKeys(w + Keys.ENTER);

        }

        //Rest is homework...

//        Strikethrough all todos.
        List<WebElement> strikethrough = driver.findElements(By.xpath("//li"));

        for (WebElement w : strikethrough){
            w.click();
        }

//        Delete all todos.
        List<WebElement> delete = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));

        for (WebElement w : delete){
            w.click();
        }

//        Assert that all todos deleted.
        driver.findElement(By.xpath("//i[@id='plus-icon']")).click();
        WebElement emptyList = driver.findElement(By.xpath("//input[@style='display: none;']"));
        emptyList.isDisplayed();


    }
}
