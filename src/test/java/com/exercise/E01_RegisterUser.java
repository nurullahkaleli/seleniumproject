package com.exercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class E01_RegisterUser {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @After
//    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
//        driver.quit();
//    }


    @Test

    public void registerUser(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

        //3. Verify that home page is visible successfully
        String url = driver.getCurrentUrl();
        assertEquals("https://automationexercise.com/",url);

        //4. Click on 'Signup / Login' button
        //5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        String verifyLogin = driver.findElement(By.xpath("//*[.='New User Signup!']")).getText();

        assertEquals("New User Signup!", verifyLogin);

        //6. Enter name and email address
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address = faker.address().fullAddress();
        String address2 = faker.address().secondaryAddress();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        System.out.println("email = " + email);
        System.out.println("password = " + password);

        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstName);
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String verifySign = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText();
        assertEquals("ENTER ACCOUNT INFORMATION", verifySign);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//label[@class='top']")).click();
        //driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(name);

        //driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(email);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

        WebElement dayDown = driver.findElement(By.xpath("//select[@id='days']"));
        Select selectDay = new  Select(dayDown);
        selectDay.selectByVisibleText("10");


        WebElement mountDown = driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMount = new Select(mountDown);
        selectMount.selectByVisibleText("February");


        WebElement yearDown = driver.findElement(By.xpath("//select[@id='years']"));
        Select selectYear =new Select(yearDown);
        selectYear.selectByVisibleText("1990");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//label[@for='newsletter']")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//label[@for='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(company);
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(address2);

        WebElement countryDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select selectCountry = new Select(countryDown);
        selectCountry.selectByVisibleText("Singapore");

        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Abc");

        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Chinatown");

        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("23401");

        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys(phoneNumber);

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();


        //14. Verify that 'ACCOUNT CREATED!' is visible
        String account = driver.findElement(By.xpath("//*[@data-qa='account-created']")).getText();
        assertEquals("ACCOUNT CREATED!",account );

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("var ads = document.getElementsByClassName('adsbygoogle');" +
//                "for (var i = 0; i < ads.length; i++) { " +
//                "   var ad = ads[i]; " +
//                "   ad.remove(); " +
//                "}");

//        List<WebElement> ads = driver.findElements(By.className("adsbygoogle"));
//        for (WebElement ad : ads) {
//            ad.s;
//        }


        //driver.findElement(By.xpath("//*[@id='card']"));
       // WebElement ad = driver.findElement(By.id("//*[@id='ad_iframe']"));


        WebElement iframeElement = driver.findElement(By.xpath("//*[@id='ad_iframe']"));

        driver.switchTo().frame(iframeElement);

        driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

        driver.switchTo().defaultContent();

//        WebElement element = driver.findElement(By.xpath("//*[@id='dismiss-button']/div/svg"));
//        element.click();
//
//
//*[@id="card"]

//        16. Verify that 'Logged in as username' is visible
//        String login = driver.findElement(By.xpath("//i[@class='fa fa-user']")).getText();
//        assertTrue(login.contains("Logged in as"));

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
//
//        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        String delete = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
//        assertEquals("ACCOUNT DELETED!",delete);
//
//        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a")).click();
//
//
//        //Note: I didn't handle open advertise.



    }




}
