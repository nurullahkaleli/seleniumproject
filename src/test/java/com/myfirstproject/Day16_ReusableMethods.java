package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day16_ReusableMethods extends TestBase {

    /*
     When user goes to https://www.automationexercise.com/
     And click on Sing up link
     And enter credentials and click sign up button
     And enter the information
     Then verify the account creating is successful. Account Created! Element is displayed
     */
    @Test
    public void registerTest() throws IOException {
//        When user goes to https://www.automationexercise.com/
        LoggerUtils.info("Starting the test ...");
        openURL("https://www.automationexercise.com/");
        extentTest.pass("On homepage...").addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
//        And click on Sing up link
        //driver.findElement(By.partialLinkText("Signup / Login")).click();//This one works but not very good!!!
        clickWithTimeOut(waitForClickablility(driver.findElement(By.partialLinkText("Signup / Login")), 5), 5);//This works..

//        And enter credentials and click sign up button
        sendKeysWithTimeout(waitForVisibility(By.name("name"), 5), Faker.instance().name().fullName(), 6);
        sendKeysWithTimeout(waitForVisibility(By.xpath("//input[@data-qa='signup-email']"), 5), Faker.instance().internet().emailAddress(), 6);
        clickWithTimeOut(waitForClickablility(By.xpath("//button[@data-qa='signup-button']"), 5), 5);
        extentTest.pass("On form page...").addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
//        And enter the information
        //gender
        clickWithTimeOut(waitForVisibility(By.id("id_gender1"), 5), 5);
        //password
        sendKeysWithTimeout(waitForVisibility(By.id("password"), 5), "123", 10);
        LoggerUtils.info("Password added ...");

        //day
        selectByVisibleText(waitForVisibility(By.id("days"), 8), "10");
        //month
        selectByVisibleText(waitForClickablility(By.id("months"), 6), "May");
        //year
        selectByVisibleText(waitForVisibility(By.id("years"), 7), "2000");
        //first name
        sendKeysWithTimeout(waitForVisibility(By.id("first_name"), 7), "John", 5);
        //last name
        sendKeysWithTimeout(waitForVisibility(By.id("last_name"), 7), "Doe", 5);
        //company
        sendKeysWithTimeout(waitForVisibility(By.id("company"), 7), "TechPro", 5);
        //address
        sendKeysWithTimeout(waitForVisibility(By.id("address1"), 7), "New York 123", 5);
        //address2
        sendKeysWithTimeout(waitForVisibility(By.id("address2"), 7), "Harlem", 5);
        //country
        selectByValue(waitForVisibility(By.id("country"), 5), "Singapore");
        //state
        sendKeysWithTimeout(waitForVisibility(By.id("state"), 7), "New York", 5);
        //city
        sendKeysWithTimeout(waitForVisibility(By.id("city"), 7), "Long Island", 5);
        //zipcode
        sendKeysWithTimeout(waitForVisibility(By.id("zipcode"), 7), "123", 5);
        //mobile_number
        sendKeysWithTimeout(waitForVisibility(By.id("mobile_number"), 7), "0987654", 5);
        extentTest.pass("Form finished...").addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        //Click Submit
        clickWithTimeoutByJS(waitForVisibility(By.xpath("//button[.='Create Account']"), 5));
        LoggerUtils.info("Finished ...");

//        Then verify the account creating is successful. Account Created! Element is displayed
        verifyElementDisplayed(waitForVisibility(By.xpath("//b[.='Account Created!']"), 6));
        extentTest.pass("Success...").addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());

    }
}
