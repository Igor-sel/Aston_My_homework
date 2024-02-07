package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.*;

public class MtsWebsiteTest {
    private WebDriver driver;

    @Deprecated
    public WebDriver.Timeouts implicitlyWait(long time, TimeUnit unit) {
        return null;
    }

    @BeforeClass
    public void StartTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
    }

    @Test
    public void testPaidSectionTitle() {
        WebElement paidSectionTitle = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        String headerWindows = paidSectionTitle.getText().replaceAll("\n", " ");
        Assert.assertEquals(headerWindows, "Онлайн пополнение без комиссии");
    }

    @DataProvider(name = "paymentSystemsLogos")
    public static Object[] paymentSystemsData() {
        return new Object[] {"Visa", "MasterCard", "МИР", "Белкарт"};
    }

    @Test(dataProvider = "paymentSystemsLogos")
    public void testPaymentSysLogos(String paymentSystem) {
        boolean logoPresent = driver.findElement(By.cssSelector("img[alt='" + paymentSystem + "']")).isDisplayed();
        Assert.assertTrue(logoPresent, "Отсутствует логотип " + paymentSystem);
    }

    @Test
    public void testServiceLink() {
        WebElement serviceLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        serviceLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    @Test (dependsOnMethods = {"testServiceLink"})
    public void testCommunicationServiceButton() {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
    }

    @Test (dependsOnMethods = {"testCommunicationServiceButton"})
    public void testPhoneNumberInput() {
        WebElement phoneInput = driver.findElement(By.id("connection-phone"));
        phoneInput.sendKeys("297777777");
        String enteredNumber = phoneInput.getAttribute("value");
        Assert.assertEquals(enteredNumber, "(29)777-77-77", "Phone number entered incorrectly");
    }

    @Test (dependsOnMethods = {"testPhoneNumberInput"})
    public void testPaymentSumInput() {
        WebElement paymentSumInput = driver.findElement(By.id("connection-sum"));
        paymentSumInput.sendKeys("150");
        String enteredSum = paymentSumInput.getAttribute("value");
        Assert.assertEquals(enteredSum, "150", "Payment amount is incorrect");
    }

    @Test (dependsOnMethods = {"testPaymentSumInput"})
    public void testContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement headerFrame = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        Assert.assertEquals(deleteWhitespace(headerFrame.getAttribute("textContent")), "Оплата:УслугисвязиНомер:375297777777");
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}