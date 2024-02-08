package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.StringUtils.*;

public class MtsWebsiteTest {
    private WebDriver driver;

    @Deprecated
    public WebDriver.Timeouts implicitlyWait(long time, TimeUnit unit) {
        return null;
    }

    @BeforeClass
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
    }
    
    @Test
    public void testConnectionServiceModule() {
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        connectionPhoneInput.sendKeys("297777777");
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        connectionPaymentSumInput.sendKeys("150");
        WebElement connectionContinueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        Assert.assertEquals(connectionContinueButton.getText(), "Продолжить");
        connectionContinueButton.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Проверка заполненных полей платежного фрейма.
        // Поле "Сумма к оплате".
        WebElement headerPaymentAmountFrame = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        Assert.assertEquals(deleteWhitespace(headerPaymentAmountFrame.getAttribute("textContent")), "150.00BYN");
        // Кнопка "Сумма к оплате".
        WebElement paymentButtonFrame = driver.findElement(By.xpath("//app-card-page/div/div[1]/button"));
        Assert.assertEquals(deleteWhitespace(paymentButtonFrame.getAttribute("textContent")), "Оплатить150.00BYN");
        // Общее поле "Услуги связи и номер телефона".
        WebElement headerPaymentInfoFrame = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        Assert.assertEquals(deleteWhitespace(headerPaymentInfoFrame.getAttribute("textContent")), "Оплата:УслугисвязиНомер:375297777777");
        // Проверка незаполненных полей платежного фрейма.
        // Поле "Номер карты".
        WebElement labelCartNumberFrame = driver.findElement(By.xpath("//app-input/div/div/div[1]/label"));
        Assert.assertEquals(deleteWhitespace(labelCartNumberFrame.getAttribute("textContent")), "Номеркарты");
        // Поле "Срок действия карты".
        WebElement labelValidityPeriodFrame = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]//div[1]/label"));
        Assert.assertEquals(deleteWhitespace(labelValidityPeriodFrame.getAttribute("textContent")), "Срокдействия");
        // Поле "CVC код".
        WebElement labelCvccodeFrame = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[3]//div[1]/label"));
        Assert.assertEquals(deleteWhitespace(labelCvccodeFrame.getAttribute("textContent")), "CVC");
        // Поле "Имя держателя карты".
        WebElement labelHolderNameFrame = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[3]//div[1]/label"));
        Assert.assertEquals(deleteWhitespace(labelHolderNameFrame.getAttribute("textContent")), "Имядержателя(какнакарте)");
    }

    @DataProvider(name = "paymentSystems")
    public Object[] paymentSystems() {
        return new Object[] {"visa", "mastercard", "belkart", "mir", "maestro" };
    }

    @Test(dataProvider = "paymentSystems") // Проверка логотипов платежных систем в платежном фрейме через модуль "Услуги связи"
    public void testPaymentSysLogos(String paymentSystemName) {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        connectionPhoneInput.sendKeys("297777777");
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        connectionPaymentSumInput.sendKeys("150");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement paymentSystemLogo = driver.findElement(By.xpath("//img[contains(@src, 'system')]"));
        Assert.assertFalse(paymentSystemLogo.isDisplayed(), "Отсутствует логотип " + paymentSystemName);
    }

    @Test (dependsOnMethods = {"testConnectionServiceModule"})
    public void testConnectionServiceModuleEmpty() {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        // Поиск элементов на странице
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        WebElement internetEmailInputField = driver.findElement(By.id("connection-email"));
        // Проверка найденных элементов
        Assert.assertEquals(connectionPhoneInput.getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(connectionPaymentSumInput.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(internetEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test (dependsOnMethods = {"testConnectionServiceModuleEmpty"}) // Проверка незаполненных в модуле "Домашний интернет".
    public void testHomeInternetModule() {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Домашний интернет']")).click();
        WebElement internetPhoneInputField = driver.findElement(By.id("internet-phone"));
        Assert.assertEquals(internetPhoneInputField.getAttribute("placeholder"), "Номер абонента");
        WebElement internetSumInputField = driver.findElement(By.id("internet-sum"));
        Assert.assertEquals(internetSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement internetEmailInputField = driver.findElement(By.id("internet-email"));
        Assert.assertEquals(internetEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test (dependsOnMethods = {"testHomeInternetModule"}) // Проверка незаполненных в модуле "Рассрочка".
    public void testInstallmentModule() {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Рассрочка']")).click();
        WebElement installmentScoreNumberField = driver.findElement(By.id("score-instalment"));
        Assert.assertEquals(installmentScoreNumberField.getAttribute("placeholder"), "Номер счета на 44");
        WebElement installmentSumInputField = driver.findElement(By.id("instalment-sum"));
        Assert.assertEquals(installmentSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement installmentEmailInputField = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals(installmentEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test (dependsOnMethods = {"testInstallmentModule"}) // Проверка незаполненных в модуле "Задолженность".
    public void testArrearsModule() {
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class='select__header']")).click();
        driver.findElement(By.xpath("//p[text()='Задолженность']")).click();
        WebElement arrearsScoreNumberField = driver.findElement(By.id("score-arrears"));
        Assert.assertEquals(arrearsScoreNumberField.getAttribute("placeholder"), "Номер счета на 2073");
        WebElement arrearsSumInputField = driver.findElement(By.id("arrears-sum"));
        Assert.assertEquals(arrearsSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement arrearsEmailInputField = driver.findElement(By.id("arrears-email"));
        Assert.assertEquals(arrearsEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}