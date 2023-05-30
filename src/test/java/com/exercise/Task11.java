package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Task11 extends TestBase {

    /*
        Given
           Go to https://testpages.herokuapp.com/
        When
           Click on File Downloads
        And
           Click on Server Download
        Then
           Verify that file is downloaded
        */
    @Test
    public void test(){

//        Go to https://testpages.herokuapp.com/
        driver.get("https://testpages.herokuapp.com/");

//        Click on File Downloads
        clickWithTimeOut(driver.findElement(By.xpath("//*[@id='download']")), 5);

//        Click on Server Download
        clickWithTimeoutByJS(driver.findElement(By.xpath("//*[@id='server-download']")));

//        Verify that file is downloaded
        String userHome = System.getProperty("user.home");
        assertTrue(Files.exists(Paths.get(userHome+"/Downloads/textfile.txt")));



    }
}
