package org.Wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    }
    public static final long IMPLICITLY_WAIT = 10;
    public static final long PAGE_LOAD_TIMEOUT = 3;
    public static final long SCRIPT_RUN_TIMEOUT = 3;

    @BeforeMethod // так было в прошлом задании (метод!)
    // @BeforeClass
    protected void setUp() { // был public void
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_RUN_TIMEOUT));
        driver.get("www.wildberries.ru/");
        //driver.findElement(By.id("cookie-agree")).click();
        //driver.findElement(By.xpath("//button[@class='select__header']")).click();
    }

    @AfterMethod
    // @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}