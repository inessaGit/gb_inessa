package test;

import org.testng.annotations.*;
import temp.*;

import static org.testng.Assert.*;

public class ShiftZeroesTest {

    @BeforeMethod
    public void setUp() {
     System.out.println("beforeMethod");
        int [] arr={1,2,0,3,0};
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("afterMethod");

    }
    @Test
    @Parameters("Test#1: array shift zeroes left")
    public void testMain(String testName) {
        System.out.println(testName);
       // ShiftZeroes.shiftZeroesLeft(arr);
    }
    @DataProvider(name="test1")
    public Object[][] dataProviderMethod(){
     return new Object[][]{
             {"test 1 left rotate"},{ }
     };
    }
    @Test(dataProvider = "test1")
    public void testMain(String testName,int[]arr) {
        System.out.println(testName);
        // ShiftZeroes.shiftZeroesLeft(arr);
    }
}