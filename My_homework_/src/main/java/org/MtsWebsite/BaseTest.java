package org.MtsWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public static final long IMPLICITLY_WAIT = 10;
    public static final long PAGE_LOAD_TIMEOUT = 3;
    public static final long SCRIPT_RUN_TIMEOUT = 3;

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    
    @BeforeClass
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_RUN_TIMEOUT));
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}