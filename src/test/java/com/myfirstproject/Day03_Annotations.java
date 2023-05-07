package com.myfirstproject;

import org.junit.*;

import static org.junit.Assert.*;

public class Day03_Annotations {

    /*
        There are 6 JUnit annotations
        1.@Test ==> used to create test case
          Test methods must have @Test annotation. They must be public and void because they are created to do assertions

        2.@Before and @After ==> Used to run before and after EACH @Test method
        3.@BeforeClass and @AfterClass ==> Used  run before and after EACH Class only ONCE. These methods must be static
        4.@Ignore ==> used to SKIP a test case

     */
    @Before
    public void setUp(){
        System.out.println("This is BEFORE method. This RUNS before EACH @Test method");
        //Pre-conditions are put in this @Before method such as SET UP, create driver, Maximize window,implicit wait
    }

    @After
    public void tearDown(){
        System.out.println("This is AFTER method. This RUNS after EACH @Test method");
        //Pre-conditions are put in this @After method such as quit and close driver, reports..
    }

    @BeforeClass
    public static void setUpClass(){
        System.out.println("This is BEFORE CLASS method. This RUNS before EACH Class only ONCE");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("This is AFTER CLASS method. This RUNS after EACH Class only ONCE");
    }



    @Test

    public void test01(){
        System.out.println("This is test case 1");

    } @Test
    public void test02(){
        System.out.println("This is test case 2");

    } @Test

    public void test03(){
        System.out.println("This is test case 3");

    } @Test    @Ignore //This method will be ignored in  group run!

    public void test04(){
        System.out.println("This is test case 4");

    } @Test

    public void test05(){
        System.out.println("This is test case 5");

    } @Test

    public void test06(){
        System.out.println("This is test case 6");

    }


    public static class Day03_Assertions {

        /*
          What is assertion?
        Assertion is done to make sure expected status and actual status are equal
        Without assertion there will be no automation test. Assertions are mandatory in testing
        Assertion is done  to improve the quality of the application and to create bug-free applications
        expected = actual ==> PASS
        expected != actual ==> FAIL
        __________________________

        assertEquals(expected, actual); If expected = actual PASS(Data Types are important)
        assertEquals(expected, actual); If expected != actual FAIL
        assertTrue(true) ==> PASS
        assertTrue(false) ==> FAIL
        assertFalse(false) ==> PASS
        assertFalse(true) ==> FAIL

        ___________________________

        These assertions are hard assertions
        If one of them fails Java will stop executions and rest of the tests will not be executed.
        For ex: if line 45 fails the rests will not be executed

        ---------------------------
        * Assertion VS Verification?
        * Assertion = Hard assertion which means test case stops if this assertion fails
        * Verification = soft assertion = Not hard assertion which means the test case continue to execute even after FAILURE. Eg : if else

         */

        @Test
        public void test01(){

            assertEquals(2,2);
            assertEquals("Expected and Actual data did not match",1,1);
            assertTrue("".isEmpty());
            assertFalse("John".endsWith("s")); //Mostly used for negative tests

        }
    }
}
