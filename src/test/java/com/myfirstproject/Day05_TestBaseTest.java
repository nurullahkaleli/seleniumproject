package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;

public class Day05_TestBaseTest extends TestBase {

    @Test
    public void testBaseTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    }
}
