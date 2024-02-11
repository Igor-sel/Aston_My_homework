package org.MtsWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.*;

public class MtsWebsiteTest extends BaseTest{
    final String PHONE_NUMBER = "297777777";
    final double SUM_PAYMENT_DOUBLE = 150.00;
    final String SUM_PAYMENT_STRING = decimalFormat.format(SUM_PAYMENT_DOUBLE);
    final String EMAIL = "gmail@gmail.com";

    @Test
    public void testConnectionServiceModule() {
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click(); // Выбираем модуль "Услуги связи"
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        connectionPhoneInput.sendKeys(PHONE_NUMBER); // Заполняем поле "connection-phone"
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        connectionPaymentSumInput.sendKeys(SUM_PAYMENT_STRING);  // Заполняем поле "connection-sum"
        WebElement connectionEmailInput = driver.findElement(By.id("connection-email"));
        connectionEmailInput.sendKeys(EMAIL);  // Заполняем поле "connection-email"
        WebElement connectionContinueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        Assert.assertEquals(connectionContinueButton.getText(), "Продолжить"); // Проверяем надпись на кнопке "Продолжить"
        connectionContinueButton.click(); // Переходим к Frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        // Проверка заполненных полей платежного фрейма.
        // Поле "Сумма к оплате".
        WebElement headerPaymentAmountFrame = driver.findElement(By.xpath("//p[@class='header__payment-amount']"));
        Assert.assertEquals(deleteWhitespace(headerPaymentAmountFrame.getAttribute("textContent")), SUM_PAYMENT_STRING + "BYN");
        // Кнопка "Сумма к оплате".
        WebElement paymentButtonFrame = driver.findElement(By.xpath("//app-card-page/div/div[1]/button"));
        Assert.assertEquals(deleteWhitespace(paymentButtonFrame.getAttribute("textContent")), "Оплатить" + SUM_PAYMENT_STRING + "BYN");
        // Общее поле "Услуги связи и номер телефона".
        WebElement headerPaymentInfoFrame = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        Assert.assertEquals(deleteWhitespace(headerPaymentInfoFrame.getAttribute("textContent")), "Оплата:УслугисвязиНомер:375" + PHONE_NUMBER);
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

    @Test // Проверка наличия 5-ти логотипов платежных систем в платежном фрейме через модуль "Услуги связи"
    public void testPaymentSysLogos() { // Снова заполняем форму, чтобы открыть фрейм
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        connectionPhoneInput.sendKeys(PHONE_NUMBER);
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        connectionPaymentSumInput.sendKeys(SUM_PAYMENT_STRING);
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
                (By.xpath("//input[@id='cc-number']/../following-sibling::div/.//img")));
        Assert.assertEquals(logos.size(), 5, "Five logos are not displayed");

        for (WebElement logo : logos) {
            Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
        }
    }

    @Test (dependsOnMethods = {"testConnectionServiceModule"}) // Проверка незаполненных полей в модуле "Услуги связи".
    public void testConnectionServiceModuleEmpty() {
        // Поиск элементов на странице
        driver.findElement(By.xpath("//p[text()='Услуги связи']")).click();
        WebElement connectionPhoneInput = driver.findElement(By.id("connection-phone"));
        WebElement connectionPaymentSumInput = driver.findElement(By.id("connection-sum"));
        WebElement connectionEmailInputField = driver.findElement(By.id("connection-email"));
        // Проверка найденных элементов
        Assert.assertEquals(connectionPhoneInput.getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(connectionPaymentSumInput.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(connectionEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
        // Здесь попробовал "разделить" метод (findElement - отдельно, assertEquals - отдельно). С точки зрения наглядности, так лучше,
        // как правильно - не знаю, поэтому далее пока использую обычную последовательность (нашел элемент >>> сразу провел проверку).
    }

    @Test (dependsOnMethods = {"testConnectionServiceModuleEmpty"}) // Проверка незаполненных полей в модуле "Домашний интернет".
    public void testHomeInternetModule() {
        driver.findElement(By.xpath("//p[text()='Домашний интернет']")).click();
        WebElement internetPhoneInputField = driver.findElement(By.id("internet-phone"));
        Assert.assertEquals(internetPhoneInputField.getAttribute("placeholder"), "Номер абонента");
        WebElement internetSumInputField = driver.findElement(By.id("internet-sum"));
        Assert.assertEquals(internetSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement internetEmailInputField = driver.findElement(By.id("internet-email"));
        Assert.assertEquals(internetEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test (dependsOnMethods = {"testHomeInternetModule"}) // Проверка незаполненных полей в модуле "Рассрочка".
    public void testInstallmentModule() {
        driver.findElement(By.xpath("//p[text()='Рассрочка']")).click();
        WebElement installmentScoreNumberField = driver.findElement(By.id("score-instalment"));
        Assert.assertEquals(installmentScoreNumberField.getAttribute("placeholder"), "Номер счета на 44");
        WebElement installmentSumInputField = driver.findElement(By.id("instalment-sum"));
        Assert.assertEquals(installmentSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement installmentEmailInputField = driver.findElement(By.id("instalment-email"));
        Assert.assertEquals(installmentEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test (dependsOnMethods = {"testInstallmentModule"}) // Проверка незаполненных полей в модуле "Задолженность".
    public void testArrearsModule() {
        driver.findElement(By.xpath("//p[text()='Задолженность']")).click();
        WebElement arrearsScoreNumberField = driver.findElement(By.id("score-arrears"));
        Assert.assertEquals(arrearsScoreNumberField.getAttribute("placeholder"), "Номер счета на 2073");
        WebElement arrearsSumInputField = driver.findElement(By.id("arrears-sum"));
        Assert.assertEquals(arrearsSumInputField.getAttribute("placeholder"), "Сумма");
        WebElement arrearsEmailInputField = driver.findElement(By.id("arrears-email"));
        Assert.assertEquals(arrearsEmailInputField.getAttribute("placeholder"), "E-mail для отправки чека");
    }
}