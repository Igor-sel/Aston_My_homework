package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lesson12junit5Test {

    @DataProvider(name = "number")
    public static Integer[][] number() {
        return new Integer[][]{{-1, 1}, {0, 1}, {1, 1}, {8, 40320}, {12, 479001600}};
    }

    @Test(dataProvider = "number")
    public void calculateCheckFactorialNumber (long number, long expected) {
        Assert.assertEquals(expected, Lesson12junit5.getFactorial(number));
    }
}