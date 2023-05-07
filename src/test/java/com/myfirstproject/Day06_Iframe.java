package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day06_Iframe extends TestBase {

    //    https://testcenter.techproeducation.com/index.php?page=iframe
//    click on the Back to TechProEducation.com
    @Test
    public void iframeTest() {
//        going to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
//        location the element inside the frame and trying to click
        driver.findElement(By.xpath("//a[@type='button']")).click();


    }
}
