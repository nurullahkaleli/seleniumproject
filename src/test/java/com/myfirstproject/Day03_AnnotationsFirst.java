package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Day03_AnnotationsFirst {

    /*
     ***. There are 6 junit annotations
        1. @Test : is used to create test case.
        * All test cases must be void cause test cases are created to do assertions
        2. @Before and @After : are used to run before or after EACH @TEST method
        * * 3. @BeforeClass and @AfterClass : are used to run before or after EACH CLASS ONLY ONCE
     */
    @Before
    public void setUp(){
        System.out.println("This is BEFORE method>>>>>RUNS BEFORE EACH TEST METHOD");
        /*
        Pre Conditions are put in this @Before method such as SET UP, create driver, maximaze window, implicit wait
         */
    }
    @After
    public void tearDown(){
        System.out.println("This is AFTER method>>>>>RUNS AFTER EACH TEST METHOD");
         /*
        After conditions are put in this method such as quit or close, reports generation,....
         */
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("This is BEFORE CLASS>>>>>RUNS BEFORE EACH CLASS ONCE");
    }
    @AfterClass
    public static void tearDownClass(){
        System.out.println("This is AFTER CLASS>>>>>RUNS AFTER EACH CLASS ONCE");
    }

    @Test
    public void test1(){
        System.out.println("This is test case 1");
    }
    @Test
    public void test2(){
        System.out.println("This is test case 2");
    }
    @Test
    public void test3(){
        System.out.println("This is test case 3");
    }
    @Test
    public void test4(){
        System.out.println("This is test case 4");
    }
    @Test
    public void test5(){
        System.out.println("This is test case 5");
    }
    @Test
    public void test6(){
        System.out.println("This is test case 6");
    }


    public static class Day03_Locators {
        /*
        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        And enter username
        And enter password
        And click on submit button
        Then verify the login is successful
        */

        WebDriver driver;

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void loginTest() throws InterruptedException {
    //        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    //        And enter username
            WebElement userNameBox = driver.findElement(By.name("username"));//Identify the element
            userNameBox.sendKeys("Admin");//Perform the action
            Thread.sleep(3000);//This is hard wait(Java wait). This waits in any condition. This will keep execution for 3 seconds.

    //        And enter password
            WebElement passwordBox = driver.findElement(By.name("password"));
            passwordBox.sendKeys("admin123");
            Thread.sleep(3000);

    //        And click on submit button
            WebElement loginButton = driver.findElement(By.tagName("button"));
            loginButton.click();

    //        Then verify the login is successful
            String url = driver.getCurrentUrl();
            assertEquals("Url did not match","https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index",url);
            Thread.sleep(3000);

        }

        @After
        public void tearDown(){
            driver.close();
        }

    }

    public static class Day04_Xpath_Css {

        /*
        When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        And enter username
        And enter password
        And click on submit button
        Then verify the login is successful
         */
        WebDriver driver;

        @Before
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @After
        public void tearDown() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

        @Test
        public void loginTestXpath(){

            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");//sendKeys("admin123"+ Keys.ENTER) ==> enter password and press ENTER
            driver.findElement(By.xpath("//*[@type='submit']")).click();

            assertTrue(driver.getCurrentUrl().contains("dashboard"));

        }

        @Test
        public void loginTestCss(){
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.findElement(By.cssSelector("input[name='username']"));
            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
            driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123"+ Keys.ENTER);

            assertTrue(driver.getCurrentUrl().contains("dashboard"));



        }


    }
}
