package org.MtsWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Duration;
import java.util.Locale;

public class BaseTest {
    public static final long IMPLICITLY_WAIT = 10;
    public static final long PAGE_LOAD_TIMEOUT = 3;
    public static final long SCRIPT_RUN_TIMEOUT = 3;

    static final DecimalFormat decimalFormat;
    static {
        Locale englishLocale = new Locale("en", "US");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(englishLocale);
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormat = new DecimalFormat("#.00", decimalFormatSymbols);
    }

    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_RUN_TIMEOUT));
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}