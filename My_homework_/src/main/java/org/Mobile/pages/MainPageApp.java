package org.Mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.Map;

public class MainPageApp extends BasePage{
    private static final String commonIdNumerics = "com.google.android.calculator:id/digit_";
    private static final String commonIdOperations = "com.google.android.calculator:id/";
    private static final Map<String, String> operationsIdsMap = Map.of
            ("+", "op_add",
            "-", "op_sub",
            "*", "op_mul",
            "/", "op_div");

    public MainPageApp(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public MainPageApp enterSpecifiedNumber(String numbers){
        char[] numbersList = numbers.toCharArray();
        for(char num : numbersList){
            driver.findElementById(commonIdNumerics + num).click();
        }
        return this;
    }

    public MainPageApp clickSelectedOperation(String operationSymbol){
        driver.findElementById(commonIdOperations + operationsIdsMap.get(operationSymbol)).click();
        return this;
    }

    public String getFinalResult(){
        driver.findElementById(commonIdOperations + "eq").click();
        return driver.findElementById(commonIdOperations + "result_final").getText();
    }
}