package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WindowType;

import static org.junit.Assert.assertTrue;

public class Day07_WindowHandle2 extends TestBase {

    @Test
    public void newTabTest() throws InterruptedException {

        //Amazon title test
        driver.get("https://amazon.com");
        assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //LinkedIn title test
        driver.switchTo().newWindow(WindowType.TAB);//This will open an empty tab and driver will be switched automatically.
        driver.get("https://linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //eBay title test
        driver.switchTo().newWindow(WindowType.TAB).get("https://ebay.com");
        assertTrue(driver.getTitle().contains("eBay"));
        String aBayWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //Go back to Amazon you opened in first tab and print the title
        driver.switchTo().window(amazonWindowHandle);//This will take driver to another page by using window handle
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //Go back to LinkedIn you opened in second tab and print the title
        driver.switchTo().window(linkedInWindowHandle);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //Go back to eBay you opened in third tab and print the title
        driver.switchTo().window(aBayWindowHandle);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

    }

    @Test
    public void newWindowTest() throws InterruptedException {

        //Amazon title test
        driver.get("https://amazon.com");
        assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //LinkedIn title test
        driver.switchTo().newWindow(WindowType.TAB);//This will open an empty tab and driver will be switched automatically.
        driver.get("https://linkedin.com");
        assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //eBay title test
        driver.switchTo().newWindow(WindowType.TAB).get("https://ebay.com");
        assertTrue(driver.getTitle().contains("eBay"));
        String aBayWindowHandle = driver.getWindowHandle();
        Thread.sleep(3000);

        //Go back to Amazon you opened in first tab and print the title
        driver.switchTo().window(amazonWindowHandle);//This will take driver to another page by using window handle
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //Go back to LinkedIn you opened in second tab and print the title
        driver.switchTo().window(linkedInWindowHandle);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        //Go back to eBay you opened in third tab and print the title
        driver.switchTo().window(aBayWindowHandle);
        System.out.println(driver.getTitle());
        Thread.sleep(3000);

    }
}
