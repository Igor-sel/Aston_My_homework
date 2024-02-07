package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MtsWebsite {
    private WebDriver driver;

    @Deprecated
    public WebDriver.Timeouts implicitlyWait(long time, java.util.concurrent.TimeUnit unit) {
        return null;
    }


}