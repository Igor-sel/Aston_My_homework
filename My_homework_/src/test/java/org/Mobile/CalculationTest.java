package org.Mobile;

import org.Mobile.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculationTest extends BaseTest {

    @DataProvider
    public Object[][] calculationData() {
        return new String[][] {
                {"12", "+", "34", "46"},
                {"90", "-", "0", "90"},
                {"8", "*", "5", "40"},
                {"77", "/", "1", "77"}
        };
    }

    @Test(dataProvider = "calculationData", testName = "Checking calculation")
    public void testCalculation(String firstNumber, String operation, String secondNumber, String expectedResult){
        String actualResult = mainPageApp
                .enterSpecifiedNumber(firstNumber)
                .clickSelectedOperation(operation)
                .enterSpecifiedNumber(secondNumber)
                .getFinalResult();
        Assert.assertEquals(expectedResult, actualResult);
    }
}