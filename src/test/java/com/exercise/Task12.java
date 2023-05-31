package com.exercise;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task12 extends TestBase {

    //We will make a roof of 5% of the height of the earliest built tower.
    //Find how many meters we will build.
     /*
    Given
        Go to https://www.techlistic.com/p/demo-selenium-practice.html
    When
        Put all built years into a list
    And
        Calculate min year
    And
        Put all heights into a list
    And
        Calculate the height to build
    Then
        Assert that build height is 25.45 meters
     */

    @Test
    public void test(){

//        Go to https://www.techlistic.com/p/demo-selenium-practice.html
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

//        Put all built years into a list

        List<WebElement> yearsElements = driver.findElements(By.xpath("//table[@summary]//tbody//tr//td[4]"));
        List<Integer> years = new ArrayList<>();

        for (WebElement element :yearsElements){
            String yearText = element.getText();
            int year = Integer.parseInt(yearText);
            years.add(year);
        }
        System.out.println("years = " + years);

//        Calculate min year

        int minYear = years.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Minimum Year: " + minYear);


//        Put all heights into a list
        List<WebElement> heightElements = driver.findElements(By.xpath("//table[@summary]//tbody//tr//td[3]"));
        List<Integer> heights = new ArrayList<>();
        for (WebElement element : heightElements) {
            heights.add(Integer.parseInt(element.getText().replaceAll("m", "")));
        }
        System.out.println("heights = " + heights);

//        Calculate the height to build
        String build = driver.findElement(By.xpath("//table[@summary]//tr[3]//td[3]")).getText();
        //System.out.println("build = " + build);
        Integer roofHeight = Integer.parseInt(build.replaceAll("m",""));
        //System.out.println("buildHeight = " + buildHeight);

        Double roof = roofHeight * 0.05;
        DecimalFormat df = new DecimalFormat("#.00");
        String formattedValue = df.format(roof);
        System.out.println(formattedValue);

//        Assert that build height is 25.45 meters
        assertEquals("25.45", formattedValue);



    }
}
